<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2019/7/12
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网页聊天室</title>
    <link rel="stylesheet" type="text/css" href="static/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/css/themes/icon.css">
    <script type="text/javascript" charset="utf-8" src="/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/ajaxFileUpload.js"></script>

    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #ddd;
        }

        li a.active {
            /*color: white;*/
            /*background-color: #4CAF50;*/
        }

    </style>
</head>

<body class="easyui-layout">
<%--顶部--%>
<div data-options="region:'north',split:true" style="height:56px;">
    <ul>
        <li><a class="active" href="#home">网页聊天室</a></li>
        <li  style="float:right">
            <a href="#about">${ sessionScope.USER_NAME}</a>
        </li>
    </ul>
</div>
<%--右边--%>
<div data-options="region:'east',title:'好友列表',split:false" style="width:180px;">
    <ul id="friendList" class="easyui-tree"></ul>
    <div id="friendListTools" class="easyui-menu" style="width:120px;">
        <div onclick="append()" data-options="iconCls:'icon-add'">移动分组</div>
        <div onclick="rename()" data-options="iconCls:'icon-add'">修改备注</div>
        <div onclick="remove()" data-options="iconCls:'icon-remove'">删除好友</div>
    </div>
</div>
<%--左边--%>
<div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
    <%--左边菜单栏--%>
    <div id="westMenu" class="easyui-accordion" style="width:200px;height:auto;">
        <div title="聊天" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:2px;">
            <ul  id="ezMenu" class="easyui-tree">
                <li data-options="attributes:{'url':'chat'}">
                    <span>聊天</span>
                </li>
            </ul>        </div>
        <div title="个人信息" data-options="iconCls:'icon-reload'" style="padding:2px;">
            <ul id="menu_personMsg" class="easyui-tree">
                <li data-options="attributes:{'url':'pMsg'}">
                    <span>个人信息&nbsp;&nbsp;&nbsp;</span>
                </li>
                <li >
                    <span>更改密码&nbsp;&nbsp;&nbsp;</span>
                </li>
            </ul>
        </div>
        <div title="设置" data-options="iconCls:'icon-reload'" style="padding:2px;">
            <ul id="menu_setting" class="easyui-tree">
                <li>
                    <span>个人设置</span>
                </li>
                <li><span>系统设置</span></li>
            </ul>
        </div>
        <div title="拓展功能" style="padding:2px;">
            拓展功能
        </div>
        <div title="帮助" style="padding:2px;">
            帮助
        </div>
        <div title="关于" style="padding:2px;">
            关于
        </div>
    </div>
</div>
<%--中间--%>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" >
        <div title="首页" style="padding:20px;display:none;">
            首页
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    <%--由于ueditor的原因，改为只显示一个界面；；；；或者查看ueditor--%>
    var userid='<%= session.getAttribute("USER_ID")%>';
    <%--菜单相关功能--%>
    $('#ezMenu').tree({
        onClick: function(node){
            // 获取选中的标签页面板（tab panel）
            var tabs = $('#tabs');
            var tab = tabs.tabs('getTab',node.text);

            if(tab){
                tabs.tabs("select",node.text)
            }else{
                // 添加一个新的标签页面板（tab panel）
                $('#tabs').tabs('add',{
                    title:node.text,
                    content:'Tab Body',
                    closable:true,
                    href:node.attributes.url
                });
            }
        }
    });

    $('#menu_personMsg').tree({
        onClick: function(node){
            // 获取选中的标签页面板（tab panel）
            var tabs = $('#tabs');
            var tab = tabs.tabs('getTab',node.text);

            if(tab){
                tabs.tabs("select",node.text)
            }else{
                // 添加一个新的标签页面板（tab panel）
                $('#tabs').tabs('add',{
                    title:node.text,
                    content:'Tab Body',
                    closable:true,
                    href:node.attributes.url
                });
            }
        }
    });
    <%--end--%>

    <%--好友列表相关功能--%>
    $('#friendList').tree({
        url: "friends/list?userid="+userid,//获取树状图json
        onClick: function(node){
            // alert(node.attributes);
            // 获取选中的标签页面板（tab panel）
            var tabs = $('#tabs');
            var tab = tabs.tabs('getTab',node.text);

            if(tab){
                tabs.tabs("select",node.text)
            }else{
                if(node.state=="open"){
                    // 添加一个新的标签页面板（tab panel）
                    $('#tabs').tabs('add',{
                        title:node.text,
                        content:'Tab Body',
                        closable:true,
                        href:'chat?friendId='+node.attributes,
                    });
                }
            }
        },
        onContextMenu: function(e, node){
            e.preventDefault();
            // select the node
            $('#friendList').tree('select', node.target);
            // display context menu
            $('#friendListTools').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        },
    });

    function append() {
        var tree=$('#friendList');
        var node=tree.tree('getSelected');

        tree.tree('append', {
            parent: (node?node.target:null),
            data: [{
                id:0,
                parentId:node.id,
                text:'新建分类'
            }]
        });
        //添加后选中新加项并修改
        var _node=tree.tree("find",0);
        tree.tree("select",_node.target).tree("beginEdit",_node.target);
    }

    function rename() {
        var tree = $('#friendList');
        var node = tree.tree('getSelected');

        tree.tree('beginEdit',node.target);
    }

    function remove() {
        var tree = $('#friendList');
        var node = tree.tree('getSelected');
        $.post("product_category/del",
            {parentId:node.attributes,id:node.id},
            function (data) {
                if(data.status==200){//添加成功
                    _tree.tree('remove',
                        {target:node.target})
                }else{//添加失败
                    $.messager.alert("删除失败！");
                }
            });
        tree.tree('remove',node.target)
    }
    <%--end------%>

</script>


</html>

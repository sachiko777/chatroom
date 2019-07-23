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
<div data-options="region:'north',split:true" style="height:56px;">
    <ul>
        <li><a class="active" href="#home">网页聊天室</a></li>
        <li  style="float:right">
            <a href="#about">username</a>
        </li>
    </ul>
</div>

<div data-options="region:'east',title:'好友列表',split:false" style="width:180px;">

</div>

<div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
    <%--左边菜单栏--%>
    <div id="westMenu" class="easyui-accordion" style="width:200px;height:auto;">
        <div title="聊天" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:2px;">
            <ul id="ezMenu" class="easyui-tree">
                <li data-options="attributes:{'url':'chat'}">
                    <span>个人设置</span>
                </li>
            </ul>        </div>
        <div title="个人信息" data-options="iconCls:'icon-reload'" style="padding:2px;">
            <ul id="menu_personMsg" class="easyui-tree">
                <li>
                    <span>个人信息</span>
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

<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" >
        <div title="首页" style="padding:20px;display:none;">
            首页
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
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
</script>


</html>

<%--
  Created by IntelliJ IDEA.
  User: Ochibana
  Date: 2019/7/27
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/webchat/chat.css">
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script src="js/sockjs.min.js"></script>

<title>聊天</title>

<div class="talk_con">
    <%--顶栏信息--%>
    <div class="talk_banner">
        ceshi
    </div>
    <%--聊天记录框--%>
    <div class="talk_show" id="historyMsg">
        <div class="atalk">sachiko<br/><span id="asay">吃饭了吗？</span></div>
        <div class="btalk">ochibana<br/><span id="bsay">还没呢，你呢？</span></div>
    </div>
    <div class="talk_btn">
        <form id="sendMsgForm" enctype="multipart/form-data" method="post">
            <a id="emoji" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">emoji</a>
            <a id="clearBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">清屏</a>
            <%--<a id="sendBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">发送</a>--%>
            <a id="submitBtn" href="#" class="easyui-linkbutton" onclick="submitForm()">发送</a>
            <input name="postmessage" type="hidden" />
            <input name="fromuserid" type="hidden" />
            <input name="touserid" type="hidden" />
        </form>
    </div>
    <%--富文本编辑器--%>
    <div class="talk_input">
        <textarea id="container" style="height: 180px; width: 580px;"></textarea>
    </div>
</div>

<script type="text/javascript">

    $(function () {
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor("container", {
            toolbars: [['simpleupload','insertimage','|','bold','italic']]
            //autoFloatEnabled:false
        });
        var userCd = "3";
        if( userCd != null && userCd != "null") {
            // alert("登录成功");
            // 登录成功后，建立websocket连接
            connect();
        }
    });

    function submitForm () {
        var console=$('#historyMsg')[0];
        var words=UE.getEditor('container').getContent();
        words=words.replace("<p>","");
        words=words.replace("</p>","");//去除p标签
        var str = "";
        if(words.value == ""){
            // 消息为空时弹窗
            alert("消息不能为空");
            return;
        }

        removeContent();//清空编辑器
        var friendId='<%= session.getAttribute("FRIEND_ID")%>';
        debugger
        $("#sendMsgForm").find("input[name='postmessage']").val(words);
        $("#sendMsgForm").find("input[name='touserid']").val(friendId);
        $("#sendMsgForm").find("input[name='fromuserid']").val('sachiko');
        // $.ajax({
        //     url:'/chat/message',
        //     type:'post',
        //     contentType:'application/json;charset=utf-8',
        //     data:json,
        //     dataType:'json',
        //     success:function (data) {
        //         str = '<div class="btalk">username<br/><span>' + words +'</span></div>';
        //         console.innerHTML =  $('#historyMsg')[0].innerHTML + str;
        //         //只显示25条消息记录
        //         while (console.childNodes.length > 25) {
        //             console.removeChild(console.firstChild);
        //         }
        //         console.scrollTop = console.scrollHeight;
        //     },

        //     error:function () {
        //         $.messager.alert('提示','消息发送失败！');
        //     }
        // });

        $.post("/chat/test", $("#sendMsgForm").serialize(),function (data) {
            if(data.success){
                str = '<div class="btalk">username<br/><span>' + words +'</span></div>';
                console.innerHTML =  $('#historyMsg')[0].innerHTML + str;
                //只显示25条消息记录
                while (console.childNodes.length > 25) {
                    console.removeChild(console.firstChild);
                }
                console.scrollTop = console.scrollHeight;
            }else{
                $.messager.alert('提示','消息发送失败！');
            }
        });
    }

    function removeContent(isAppendTo) {
        var arr = [];
        UE.getEditor('container').setContent('', isAppendTo);
    }

    <%--window.onload = function() {--%>
        <%--//var userCd = "<%=request.getSession().getAttribute("USER_CD") %>";--%>
        <%--var userCd = "3";--%>
        <%--if( userCd != null && userCd != "null") {--%>
            <%--// alert("登录成功");--%>
            <%--// 登录成功后，建立websocket连接--%>
            <%--connect();--%>
        <%--}--%>
    <%--}--%>

    var ws = null;
    // var target = 'ws://localhost:8080/ssm1228/myHandler';
    // var target = 'ws://localhost:8080/ws';
    // var target = 'ws://' + window.location.host + '/ws';

    // 创建WebSocket连接
    function connect() {
        var target = 'ws://' + window.location.host + '/ws';
        // WebSocket适配
        if ('WebSocket' in window) {
            ws = new WebSocket(target);
        } else if ('MozWebSocket' in window) {
            alert(11);
            ws = new MozWebSocket(target);
        } else {
            // ie10以下
            if(ws==null) {
                // target = window.location.protocol + '//' + 'localhost:8080/ssm1228/sockjs/myHandler';
                target = window.location.protocol + '//' + 'localhost:8080/ws/sockjs';
                ws = new SockJS(target);
            }
        }
        // 注入连接事件
        ws.onopen = function () {
            log('连接已建立。');
        };
        // 注入消息事件
        ws.onmessage = function (event) {
            log('新消息：' + event.data);
        };
        // 注入断开事件
        ws.onclose = function (event) {
            log('连接已断开。');
        };
    }

    // 断开连接
    function disconnect() {
        if (ws != null) {
            ws.close();
            ws = null;
        }
    }

    // 发送消息
    function echo() {
        if (ws != null) {
            log('Sent: ' + message);
            ws.send(message);
        } else {
            alert('connection not established, please connect.');
        }
    }

    // 打印消息
    function log(message) {
        // debugger
        var console =$('#historyMsg')[0];
        //var console = window.frames['main'].contentWindow.document.getElementById('console');
        str = '<div class="atalk">username<br/><span>' + message +'</span></div>';
        console.innerHTML = console.innerHTML + str;

        while (console.childNodes.length > 25) {
            console.removeChild(console.firstChild);
        }
        console.scrollTop = console.scrollHeight;
    }

    //使用正则表达式获取url中的参数
    function getUrlParam(name) {
        //构造一个含有目标参数的正则表达式对象
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        //匹配目标参数
        var r = window.location.search.substr(1).match(reg);
        //返回参数值
        if (r != null) return unescape(r[2]);
        return null;
    }


</script>





<%--
  Created by IntelliJ IDEA.
  User: Ochibana
  Date: 2019/7/31
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/css/themes/icon.css">
    <script type="text/javascript" charset="utf-8" src="/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/jquery/jquery.easyui.min.js"></script>
</head>
<body>

<form id="sendMsgForm" enctype="multipart/form-data" method="post">
    <input name="userid" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:300px">
    <input name="password" class="easyui-passwordbox" prompt="请输入密码" iconWidth="28" data-options="iconCls:'icon-lock'"
           style="width:300px;height:34px;padding:10px">
</form>
<a id="submitBtn" href="#" class="easyui-linkbutton" onclick="submitForm()">发送</a>
</body>

<script type="text/javascript">
    function submitForm () {
        $.post("/chat/login", $("#sendMsgForm").serialize(),function (data) {
            if(data.success){
                // $.messager.alert('提示','成功添加商品');
                window.location.href='index.jsp';
            }
        });
    }

</script>

</html>

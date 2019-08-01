<%--
  Created by IntelliJ IDEA.
  User: Ochibana
  Date: 2019/7/23
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>个人设置</title>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

<div style="padding: 10px 10px 10px 10px;">
    <form id="productAddForm" method="post">

        <input type="hidden" name="categoryId">
        <input type="hidden" name="image">
        <input type="hidden" name="description">

        <table cellpadding="10px">
            <tr>
                <td>商品名称:</td>
                <td><input class="easyui-textbox" name="name" data-options="required:true" style="width:300px"></td>
            </tr>
            <tr>
                <td>商品分类:</td>
                <td><select id="cc" class="easyui-combobox" name="cid" style="width:200px;">
                    <option value="0">请选择</option>

                </select>
                    <p id="cbox" style="display: none;"></p>
                </td>
            </tr>
            <tr>
                <td>商品价格:</td>
                <td>
                    <input type="text" class="easyui-numberbox" value="100" name="maketPricePreview"
                           data-options="min:0,max:9999999,required:true,precision:2">
                    <input type="hidden" name="maketPrice">
                </td>
            </tr>
            <tr>
                <td>市场价格:</td>
                <td>
                    <input type="text" class="easyui-numberbox" value="100" name="pricePreview"
                           data-options="min:0,max:9999999,required:true,precision:2">
                    <input type="hidden" name="price">
                </td>
            </tr>
            <tr>
                <td>商品编号:</td>
                <td>
                    <input name="productNumber" type="text" class="easyui-numberbox" value="100" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td>商品图片:</td>
                <td>
                    <input id="fileName" name="uploadfile" />
                    <a id="btn" href="#" class="easyui-linkbutton uploadPic">上传图片</a>
                </td>
            </tr>
            <tr>
                <td>商品预览:</td>
                <td>
                    <img src="" id="product_img" width="376" height="190">
                </td>
            </tr>
            <tr>
                <td>商品描述:</td>
                <td><script id="editor" type="text/plain" style="width:600px;height:300px;">测试 test</script></td>
            </tr>
        </table>
    </form>

    <div align="center">
        <a id="submitBtn" href="#" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a id="resetBtn" href="#" class="easyui-linkbutton">重置</a>
    </div>
</div>

<script type="text/javascript">

    $(function () {
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor("editor", {
            toolbars: [['simpleupload','insertimage','|','bold','italic']]
        });
        // MALL.init();
    });

    // function submitForm () {
    //     //UE.getEditor('editor').getContent();//获得ueditor内容
    //     $("#productAddForm").find("input[name='description']").val(UE.getEditor('editor').getContent());
    //     $("#productAddForm").find("input[name='price']").val(eval($("#productAddForm").find("input[name='pricePreview']").val())*100);
    //     $("#productAddForm").find("input[name='maketPrice']").val(eval($("#productAddForm").find("input[name='maketPricePreview']").val())*100);
    //
    //     $.post("/product_save", $("#productAddForm").serialize(),function (data) {
    //         if(data.status == 200){
    //             $.messager.alert('提示','成功添加商品');
    //         }
    //     });
    // }


</script>
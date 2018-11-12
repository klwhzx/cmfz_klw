<%@ page pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align: center">
    <form method="post" class="easyui-form" id="inputForm" enctype="multipart/form-data">
        <div style="margin-top: 70px">
            <input type="hidden" name="id" value="${param.id}"  >
        </div>
        <div style="margin-top: 20px">
            选择封面图片: <input id="coverImg" type="text" class="easyui-filebox" name="imgs" >
        </div>
        <div style="margin-top: 20px">
            专辑名称: <input type="text" class="easyui-textbox" name="title">
        </div>
        <div style="margin-top: 20px">
            作者: <input type="text" class="easyui-textbox" name="author">
        </div>
        <div style="margin-top: 20px">
            播音: <input type="text" class="easyui-textbox" name="broadCast">
        </div>
        <div style="margin-top: 20px">
            内容简介: <input type="text" class="easyui-textbox" name="brief">
        </div>
    </form>
</div>
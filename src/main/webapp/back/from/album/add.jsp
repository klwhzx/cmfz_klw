<%@ page pageEncoding="utf-8" isELIgnored="false"  %>

<div style="text-align: center">
    <form method="post" class="easyui-form" id="addAlbumInputForm" enctype="multipart/form-data">
        <div style="margin-top: 20px">
            选择封面图片: <input id="coverImg" type="text" class="easyui-filebox" data-options="required:true,validType:'image'" name="imgs">
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

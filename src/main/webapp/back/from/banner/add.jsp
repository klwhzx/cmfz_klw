<%@ page pageEncoding="utf-8" %>

<div style="text-align: center">

    <form  class="easyui-form" id="addInputForm" enctype="multipart/form-data" method="post" >
        <div style="margin-top: 70px">
            选择图片: <input id="imgPath" type="text" class="easyui-filebox" data-options="required:true,validType:'image'" name="imgs">
        </div>
        <div style="margin-top: 20px">
            图片名称: <input id="title" type="text" class="easyui-textbox" name="title">
        </div>
        <div style="margin-top: 20px">
            图片状态: <select id="status" class="easyui-combobox" name="status" style="width:175px;">
            <option value="正常">正常</option>
            <option value="冻结">冻结</option>
        </select>
        </div>
    </form>

</div>

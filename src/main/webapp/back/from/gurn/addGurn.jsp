<%@ page pageEncoding="utf-8" %>

<div style="text-align: center">

    <form  class="easyui-form" id="addGurnInputForm" enctype="multipart/form-data" method="post" >
        <div style="margin-top: 70px">
            选择头像: <input id="headPic" type="text" class="easyui-filebox" data-options="required:true,validType:'image'" name="imgs">
        </div>
        <div style="margin-top: 20px">
            用户名: <input id="name" type="text" class="easyui-textbox" name="name">
        </div>
        <div style="margin-top: 20px">
            性别: <select id="sex" class="easyui-combobox" name="sex" style="width:175px;">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        </div>
    </form>

</div>

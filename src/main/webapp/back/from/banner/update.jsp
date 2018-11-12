<%@ page pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align: center">
    <form method="post" class="easyui-form" id="inputForm" enctype="multipart/form-data">
        <div style="margin-top: 70px">
            <input type="hidden" name="id" value="${param.id}"  >
        </div>
        <div style="margin-top: 20px">
            图片名称: <input type="text" class="easyui-textbox" name="title">
        </div>
        <div style="margin-top: 20px">
            图片状态: <select id="cc" class="easyui-combobox" name="status" style="width:175px;">
                         <option value="正常">正常</option>
                         <option value="冻结">冻结</option>
        </select>
        </div>
    </form>
</div>

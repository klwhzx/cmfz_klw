    <%@ page pageEncoding="utf-8" isELIgnored="false" %>

    <script>

        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '输入的两次密码不一致'
            }
        });
        $.extend($.fn.validatebox.defaults.rules, {
            aquals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '请输入正确的原密码'
            }
        });

    </script>
    <div style="text-align: center">
        <form method="post" class="easyui-form" id="inputForm">
            <div style="margin-top: 70px">
                <input type="hidden"  value="${param.id}" name="id"  >
            </div>
            <div style="margin-top: 70px">
                <input type="hidden" value="${param.password}" id="opwd"  >
            </div>

            <div style="margin-top: 20px">
                请输入原密码: <input id="pas" type="password" class="easyui-validatebox"  required="required" validType="aquals['#opwd']" name="pas">
            </div>
            <div style="margin-top: 20px">
                请输入新密码: <input type="password" class="easyui-validatebox" data-options="required:true" name="pwd" id="pwd" >
            </div>
            <div style="margin-top: 20px">
                请再次输入新密码: <input type="password" class="easyui-validatebox" required="required" validType="equals['#pwd']"  name="password" id="rpwd" >
            </div>

        </form>
    </div>


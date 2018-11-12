<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/tzimg/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/form.validator.rules.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript">
    var logins = "${sessionScope.login}";
    if (logins==""){
        location.href="${pageContext.request.contextPath}/back/login.jsp";
    }

    $(function () {
        //页面加载完成后显示菜单栏
        $.post("${pageContext.request.contextPath}/menu/findMenu",function (menu) {
            //遍历一级菜单
            $.each(menu,function (index,m) {
                var content = "<div style='text-align: center;'>";
                $.each(m.menus,function (idx,child) {
                    content += "<a onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;height:35px;margin:10px 0; border:1px #000 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                });
                content +="</div>"
                //通过accordion的添加方式追加菜单
                $("#menu").accordion('add',{
                    title:m.title,
                    iconCls:m.iconCls,
                    content:content,
                })
            });
        });
    });
    //点击菜单追加选项卡
    function addTabs(title,iconCls,href) {
        if (!$("#tabs").tabs('exists',title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,

                href:"${pageContext.request.contextPath}"+href,
                closable:true,
                fit:true
            });
        }else {
            $("#tabs").tabs('select',title);
        }
    }
    //修改密码
    function updatePassword(id){
        $("#up").dialog({
            href:"${pageContext.request.contextPath}/back/from/admin/upd.jsp?id=${sessionScope.login.id}&password=${sessionScope.login.password}",
            buttons:[
                {
                    iconCls:'icon-save',
                    text:'修改',
                    handler:function () {
                        $("#inputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/admin/updatePassword",
                            success:function(data){                         //成功响应
                                $("#up").dialog('close');
                                $.messager.show({title:'提示',msg:"用户密码修改成功!!!，下次登录请使用新密码!!!"});
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#up").dialog('close');
                    }
                }
            ]
        });
    }
</script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.name} &nbsp;<a href="javascript:;" onclick="updatePassword(${sessionScope.login.id});" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/esc" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true,iconCls:'icon-color_swatch'" style="width:230px; ">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">

		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>
    </div>
    <%--修改密码对话框--%>
    <div id="up" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改管理员密码'"></div>
</body> 
</html>
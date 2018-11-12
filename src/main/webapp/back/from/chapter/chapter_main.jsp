<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

    $(function () {
        $("#tg3").treegrid({
           url:'${pageContext.request.contextPath}/album/findTwo',
            method:'post',
            idField:'id',
            treeField:'title',
            height:500,
            fitColumns:true,
            columns:[[
                {title:'fx',field:'fx',checkbox:true,},
                {field: 'title' , title: '名称' , width: 120},
                {field: 'downPath' , title: '下载路径' , width: 120},
                {field: 'size' , title: '音频大小' , width: 120},
                {field: 'duration' , title: '音频时长' , width: 120},
           ]],
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
            toolbar: "#tb1"
       });
    });
    //添加专辑
    function addzj(){
        $("#addzj").dialog({
            href:'${pageContext.request.contextPath}/back/from/chapter/addzj.jsp',
            buttons:[{
                href:'123',
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    var coverImg = $("#coverImg").textbox('getText');
                    $("#addAlbumInputForm").form('submit',{
                        queryParams:{
                            coverImg:coverImg,
                        },
                        url:'${pageContext.request.contextPath}/album/add',
                        success:function (data) {
                            //成功响应
                            var dataObj = $.parseJSON(data);
                            if (dataObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:'图片添加成功'});
                            }else{
                                $.messager.show({title:'提示',msg:dataObj.message});
                            }

                            $("#addzj").dialog('close');
                            $("#tg3").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#addzj").dialog('close');
                }
            }]
        });
    }

    //添加音频
    function addyp(){
        var rows = $("#tg3").datagrid('getSelected');
        if (rows.hasOwnProperty('album_id')==true) {
            $.messager.show({title:'提示',msg:'请选择专辑进行添加'});
        }else{
            $("#addyp").dialog({
                href:'${pageContext.request.contextPath}/back/from/chapter/addyp.jsp',
                buttons:[{
                href:'123',
                iconCls:'icon-save',
                text:'保存',
                handler:function () {
                    var downPath = $("#downPath").textbox('getText');
                    $("#addypInputForm").form('submit',{
                        queryParams:{
                            downPath:downPath,
                            title:downPath,
                            album_id:rows.id,
                        },
                        url:'${pageContext.request.contextPath}/chapter/addyp',
                        success:function (data) {
                            //成功响应
                            var dataObj = $.parseJSON(data);
                            if (dataObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:'音频上传成功'});
                            }else{
                                $.messager.show({title:'提示',msg:dataObj.message});
                            }

                            $("#addyp").dialog('close');
                            $("#tg3").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function () {
                    $("#addyp").dialog('close');
                }
            }]
        });
    }

    }
    //专辑详情
    function findAlbum(){
        var rows = $("#tg3").datagrid('getSelected');
        if(rows.hasOwnProperty('album_id')==true){
            $.messager.show({title:'提示',msg:'请选择专辑'});
        }else {
            $.ajax({
                url:"${pageContext.request.contextPath}/album/findById",
                type:"POST",
                traditional:true,
                data:{id:rows.id},
                success:function (data) {         //成功响应
                    $("#findAlbum").dialog({
                        href:'${pageContext.request.contextPath}/back/from/chapter/findzj.jsp?title='+ data['title']+'&p_date='+data['p_date']+
                                                                                            '&coverImg='+data['coverImg']+
                                                                                            '&author='+data['author']+
                                                                                            '&broadCast='+data['broadCast']+
                                                                                            '&brief='+data['brief'],
                        buttons:[{
                            iconCls:'icon-cancel',
                            text:'关闭',
                            handler:function () {
                                $("#findAlbum").dialog('close');
                            }
                        }]
                    })
                },
            })
        }
    }
    //下载
    function downMp3(){
        var rows = $("#tg3").datagrid('getSelected');
        if(rows.hasOwnProperty('album_id')==false){
            $.messager.show({title:'提示',msg:'请选择音频'});
        }else {
            location.href="${pageContext.request.contextPath}/chapter/downMp3?title="+rows.title;
        }
    }

</script>
<table id="tg3"></table>
<%--datagrid工具栏--%>
<div id="tb1">
    <a href="javascript:;" id="zj" class="easyui-linkbutton" onclick="addzj();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
    <a href="javascript:;" id="yp" class="easyui-linkbutton" onclick="addyp();" data-options="iconCls:'icon-add',plain:true">上传音频</a>
    <a href="javascript:;" id="zjj" class="easyui-linkbutton" onclick="findAlbum();" data-options="iconCls:'icon-add',plain:true">专辑详情</a>
    <a href="javascript:;" id="ypp" class="easyui-linkbutton" onclick="downMp3();" data-options="iconCls:'icon-add',plain:true">下载音频</a>

</div>
<%--添加专辑对话框--%>
<div id="addzj" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存专辑信息'" ></div>
<%--上传音频对话框--%>
<div id="addyp" data-options="draggable:false,iconCls:'icon-save',width:500,height:300,title:'上传音频'" ></div>

<%--上传音频对话框--%>
<div id="findAlbum" data-options="draggable:false,iconCls:'icon-save',width:500,height:520,title:'专辑详情'" ></div>


    <%@ page pageEncoding="utf-8" isELIgnored="false" %>

    <script>
        $(function () {
            $("#tg2").datagrid({
                height:500,
                fitColumns:true,            //自动适应宽高
                striped:true,                  //斑马线
                loadMsg:'加载中',                  //加载文字
                rownumbers:true,                    // 行号
                url:"${pageContext.request.contextPath}/banner/findBanner",         //从json文件获取数据
                columns:[[
                    {title:'fx',field:'fx',checkbox:true,},
                    {title:'路径',field:'imgPath',width:150,},
                    {title:'名称',field:'title',width:100,sortable:'true'},
                    {title:'编号',field:'id',width:50,},
                    {title:'状态',field:'status',width:100,sortable:'true'},
                    {title:'上传时间',field:'b_date',width:100,sortable:'true'},
                    {title:'opt',field:'opt',width:100,formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='opt' onclick=\"deletes('"+row.id+"');\" data-options=\"iconCls:'icon-remove',plain:true \">删除</a>&nbsp;&nbsp;<a href='javascript:;' class='opt' onclick=\"updates('"+row.id+"');\" data-options=\"iconCls:'icon-edit',plain:true \">修改</a>"
                        }
                    }
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    console.log(rowIndex);
                    console.log(rowData);
                    return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="width:100px;height:75px;"></td>' +
                    '<td style="border:0">' +
                    '<p>title: ' + rowData.title + '</p>' +
                    '<p>status: ' + rowData.status + '</p>' +
                    '<p>status: ' + rowData.b_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
                },
                onLoadSuccess:function () {
                    $(".opt").linkbutton();
                },
                toolbar:'#tb2',

            });

        });

        //删除
        function deletes(id){
            $.post("${pageContext.request.contextPath}/banner/deleteImp",{"id":id},function (data) {
                $("#tg2").datagrid('reload');
            });
        }
        //修改
        function updates(id) {
            $("#upd").dialog({
                href:"${pageContext.request.contextPath}/back/from/banner/update.jsp?id="+id,
                buttons:[
                    {
                        iconCls:'icon-save',
                        text:'修改',
                        handler:function () {
                            $("#inputForm").form('submit',{
                                url:"${pageContext.request.contextPath}/banner/updateImp",
                                success:function(data){                         //成功响应
                                    var dataObj = $.parseJSON(data);
                                    if (dataObj.success){
                                        //提示信息
                                        $.messager.show({title:'提示',msg:'图片修改成功'});
                                    }else{
                                        $.messager.show({title:'提示',msg:dataObj.message});
                                    }

                                    $("#upd").dialog('close');
                                    $("#tg2").datagrid('reload');
                                }
                            });
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            $("#upd").dialog('close');
                        }
                    }
                ]
            });
        }
        //    增加
        function addUser(){
            $("#add").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function () {
                            var imgPath = $("#imgPath").textbox('getText');
                        $("#addInputForm").form('submit',{
                            queryParams:{
                                imgPath:imgPath,
                            },
                            url:'${pageContext.request.contextPath}/banner/addImp',
                            success:function (data) {
                                //成功响应
                                var dataObj = $.parseJSON(data);
                                if (dataObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:'图片添加成功'});
                                }else{
                                    $.messager.show({title:'提示',msg:dataObj.message});
                                }

                                $("#add").dialog('close');
                                $("#tg2").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#add").dialog('close');
                    }
                }]
            });
        }

        //删除多行
        function delByIds() {
            var rows = $("#tg2").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:'至少选中一行'});
            }else{
                var ids=[];
                for (var i = 0; i<rows.length ; i++ ){
                    ids.push(rows[i].id);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/banner/deletesImp",
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function (data) {         //成功响应
                        $.messager.show({title:'提示',msg:'删除成功'});
                        $("#tg2").datagrid('reload');
                    },
                    error:function () {
                        $.messager.show({title:'提示',msg:'删除失败'});
                        $("#tg2").datagrid('reload');
                    }
                })
            }
        }

    </script>
    <div>
        <table id="tg2"  ></table>
        <div id="tb2">
            <a href="#" class="easyui-linkbutton" onclick="addUser();"  data-options="iconCls:'icon-add',plain:true">添加</a>
            <a href="#" class="easyui-linkbutton" onclick="delByIds();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
        </div>
            <%--修改图片--%>

        <div id="upd" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新图片信息'"></div>

        <%--添加图片--%>
        <div id="add" data-options="href:'${pageContext.request.contextPath}/back/from/banner/add.jsp',draggable:false,incoCls:'icon-save',width:600,height:400,title:'添加图片'" >

    </div>


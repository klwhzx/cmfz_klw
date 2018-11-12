    <%@ page pageEncoding="utf-8" isELIgnored="false" %>

    <script>
        $(function () {
            $("#tg1").datagrid({
                height:500,
                fitColumns:true,            //自动适应宽高
                striped:true,                  //斑马线
                loadMsg:'加载中',                  //加载文字
                rownumbers:true,                    // 行号
                url:"${pageContext.request.contextPath}/album/findAll",         //从json文件获取数据
                columns:[[
                    {title:'fx',field:'fx',checkbox:true,},
                    {title:'封面地址',field:'coverImg',width:150,},
                    {title:'专辑名',field:'title',width:100,sortable:'true'},
                    {title:'编号',field:'id',width:50,},
                    {title:'集数',field:'count',width:50,},
                    {title:'热度',field:'star',width:100,sortable:'true'},
                    {title:'作者',field:'author',width:100,sortable:'true'},
                    {title:'播音',field:'broadCast',width:100,sortable:'true'},
                    {title:'发布时间',field:'p_date',width:100,sortable:'true'},
                    {title:'内容简介',field:'brief',width:100,sortable:'true'},
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
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.coverImg + '" style="width:100px;height:130px;"></td>' +
                        '<td style="border:0">' +
                        '<p>专辑名: ' + rowData.title + '</p>' +

                        '<p>热度: ' + rowData.star + '</p>' +  '<p>作者: ' + rowData.author + '</p>' +

                        '<p>播音: ' + rowData.broadCast + '</p>' +  '<p>发布时间: ' + rowData.p_date + '</p>' +

                        '<p>内容简介: ' + rowData.brief + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
                onLoadSuccess:function () {
                    $(".opt").linkbutton();
                },
                toolbar:'#tb3',

            });

        });

        //删除
        function deletes(id){
            $.post("${pageContext.request.contextPath}/album/delete",{"id":id},function (data) {
                $("#tg1").datagrid('reload');
            });
        }
        //修改
        function updates(id) {
            $("#upd").dialog({
                href:"${pageContext.request.contextPath}/back/from/album/update.jsp?id="+id,
                buttons:[
                    {
                        iconCls:'icon-save',
                        text:'修改',
                        handler:function () {
                            var coverImg = $("#coverImg").textbox('getText');
                            $("#inputForm").form('submit',{
                                queryParams:{
                                    coverImg:coverImg,
                                },
                                url:"${pageContext.request.contextPath}/album/update",
                                success:function(data){                         //成功响应
                                    var dataObj = $.parseJSON(data);
                                    if (dataObj.success){
                                        //提示信息
                                        $.messager.show({title:'提示',msg:'图片修改成功'});
                                    }else{
                                        $.messager.show({title:'提示',msg:dataObj.message});
                                    }

                                    $("#upd").dialog('close');
                                    $("#tg1").datagrid('reload');
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
                            var coverImg = $("#coverImg").textbox('getText');
                        $("#addAlbumInputForm").form('submit',{
                            queryParams:{
                                coverImg:coverImg,
                            },
                            url:'${pageContext.request.contextPath}/album/add',
                            success:function (data) {                                   //成功响应
                                var dataObj = $.parseJSON(data);
                                if (dataObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:'图片添加成功'});
                                }else{
                                    $.messager.show({title:'提示',msg:dataObj.message});
                                }
                                $("#add").dialog('close');
                                $("#tg1").datagrid('reload');
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
            var rows = $("#tg1").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:'至少选中一行'});
            }else{
                var ids=[];
                for (var i = 0; i<rows.length ; i++ ){
                    ids.push(rows[i].id);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/album/deletes",
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function (data) {         //成功响应
                        $.messager.show({title:'提示',msg:'删除成功'});
                        $("#tg1").datagrid('reload');
                    },
                    error:function () {
                        $.messager.show({title:'提示',msg:'删除失败'});
                        $("#tg1").datagrid('reload');
                    }
                })
            }
        }

    </script>
    <div>
        <table id="tg1"  ></table>
        <div id="tb3">
            <a href="#" class="easyui-linkbutton" onclick="addUser();"  data-options="iconCls:'icon-add',plain:true">添加</a>
            <a href="#" class="easyui-linkbutton" onclick="delByIds();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
        </div>
            <%--修改图片--%>

        <div id="upd" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新图片信息'"></div>

        <%--添加图片--%>
        <div id="add" data-options="href:'${pageContext.request.contextPath}/back/from/album/add.jsp',draggable:false,incoCls:'icon-save',width:600,height:400,title:'添加图片'" >

    </div>


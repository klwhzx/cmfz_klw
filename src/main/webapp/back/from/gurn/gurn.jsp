    <%@ page pageEncoding="utf-8" isELIgnored="false" %>

    <script>
        $(function () {
            $("#tg4").datagrid({
                height:500,
                fitColumns:true,            //自动适应宽高
                striped:true,                  //斑马线
                loadMsg:'加载中',                  //加载文字
                rownumbers:true,                    // 行号
                url:"${pageContext.request.contextPath}/gurn/findGurn",         //从json文件获取数据
                columns:[[
                    {title:'fx',field:'fx',checkbox:true,},

                    {title:'上师头像',field:'headPic',width:150,},
                    {title:'上师编号',field:'id',width:100,sortable:'true'},
                    {title:'上师姓名',field:'name',width:100,sortable:'true'},
                    {title:'上师性别',field:'sex',width:100,sortable:'true'},
                    {title:'上师状态',field:'status',width:100,sortable:'true'},
                    {title:'opt',field:'opt',width:100,formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='opt' onclick=\"deletes('"+row.id+"');\" data-options=\"iconCls:'icon-remove',plain:true \">删除上师</a>"
                        }
                    }
                ]],
                onLoadSuccess:function () {
                    $(".opt").linkbutton();
                },
                toolbar:'#tb4',

            });

        });

        //删除
        function deletes(id){
            $.post("${pageContext.request.contextPath}/gurn/deleteGurn",{"id":id},function (data) {
                $("#tg4").datagrid('reload');
            });
        }
        //    增加
        function addGurn(){
            $("#addGurn").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function () {
                            var headPic = $("#headPic").textbox('getText');
                        $("#addGurnInputForm").form('submit',{
                            queryParams:{
                                headPic:headPic,
                            },
                            url:'${pageContext.request.contextPath}/gurn/addGurn',
                            success:function (data) {
                                //成功响应
                                var dataObj = $.parseJSON(data);
                                if (dataObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:'上师添加成功'});
                                }else{
                                    $.messager.show({title:'提示',msg:dataObj.message});
                                }

                                $("#addGurn").dialog('close');
                                $("#tg4").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#addGurn").dialog('close');
                    }
                }]
            });
        }

        //删除多行
        function deleteGurnByIds() {
            var rows = $("#tg4").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:'至少选中一行'});
            }else{
                var ids=[];
                for (var i = 0; i<rows.length ; i++ ){
                    ids.push(rows[i].id);
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/gurn/deleteGurns",
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function (data) {         //成功响应
                        $.messager.show({title:'提示',msg:'删除成功'});
                        $("#tg4").datagrid('reload');
                    },
                    error:function () {
                        $.messager.show({title:'提示',msg:'删除失败'});
                        $("#tg4").datagrid('reload');
                    }
                })
            }
        }

    </script>
    <div>
        <table id="tg4"  ></table>
        <div id="tb4">
            <a href="#" class="easyui-linkbutton" onclick="addGurn();"  data-options="iconCls:'icon-add',plain:true">添加上师</a>
            <a href="#" class="easyui-linkbutton" onclick="deleteGurnByIds();" data-options="iconCls:'icon-remove',plain:true">批量删除上师</a>
        </div>
        <%--添加上师--%>
        <div id="addGurn" data-options="href:'${pageContext.request.contextPath}/back/from/gurn/addGurn.jsp',draggable:false,incoCls:'icon-save',width:600,height:400,title:'添加上师'" >

    </div>


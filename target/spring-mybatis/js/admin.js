function adminupdate(row){

    /*判断页面中是否存在id="dd"元素，若存在则进行删除*/

    if($("#dd") != null){

        $("#dd").remove();

    }

    /*在页面中id="tab"的元素中添加一个id="dd"的div元素*/

    $("#tab").append("<div id='dd'></div>");

    /*以页面中的id="dd"的元素作为对话框的内容*/

    $('#dd').dialog({

        title: '更新管理员信息',//对话框的标题

        width: 300,//对话框的宽度

        closed: false,

        cache: false,//不允许有缓冲

        modal: true ,//采用模式，即必须关闭对话框后才能做别的操作

        buttons:[{ //为对话框添加底部按钮

            text:'保存',

            handler:function(){

                $('#ff').form('submit', {

                    url:"../admin/updateByPrimaryKeySelective",

                    onSubmit: function(){

                        //在这里编写表单字段验证

                    },

                    success:function(data){

                        $('#dd').dialog("close");//关闭当前添加窗口

                        $('#dg').datagrid("reload");//重新装入表格的内容

                    }

                });



            }

        },{

            text:'关闭',

            handler:function(){

                $('#dd').dialog("close");

            }

        }]

    });

    //创建添加课程安排表单

    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +

        '            <tr>\n' +

        '                <td><input type="hidden" id="id" name="id" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员姓名</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员密码</td>\n' +

        '                <td><input type="password" id="pass" name="pass" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员电话</td>\n' +

        '                <td><input type="text" id="phone" name="phone" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员邮箱</td>\n' +

        '                <td><input type="text" id="email" name="email" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员qq</td>\n' +

        '                <td><input type="text" id="qq" name="qq" /></td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);

    $('#ff').form('load',row[0]);//为表单加载数据。


}

function admininsert(){

    /*判断页面中是否存在id="dd"元素，若存在则进行删除*/

    if($("#dd") != null){

        $("#dd").remove();

    }

    /*在页面中id="tab"的元素中添加一个id="dd"的div元素*/

    $("#tab").append("<div id='dd'></div>");

    /*以页面中的id="dd"的元素作为对话框的内容*/

    $('#dd').dialog({

        title: '添加管理员信息',//对话框的标题

        width: 300,//对话框的宽度

        closed: false,

        cache: false,//不允许有缓冲

        modal: true ,//采用模式，即必须关闭对话框后才能做别的操作

        buttons:[{ //为对话框添加底部按钮

            text:'保存',

            handler:function(){

                $('#ff').form('submit', {

                    url:"../admin/insertSelective",

                    onSubmit: function(){

                        //在这里编写表单字段验证

                    },

                    success:function(data){

                        $('#dd').dialog("close");//关闭当前添加窗口

                        $('#dg').datagrid("reload");//重新装入表格的内容

                    }

                });



            }

        },{

            text:'关闭',

            handler:function(){

                $('#dd').dialog("close");

            }

        }]

    });

    //创建添加管理员信息表单

    var str = ' <form id="ff" method="post">\n' +

        '        <table>\n' +

        '            <tr>\n' +

        '                <td>管理员姓名</td>\n' +

        '                <td><input type="text" id="name" name="name" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员密码</td>\n' +

        '                <td><input type="password" id="pass" name="pass" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员电话</td>\n' +

        '                <td><input type="text" id="phone" name="phone" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员邮箱</td>\n' +

        '                <td><input type="text" id="email" name="email" /> </td>\n' +

        '            </tr>\n' +

        '            <tr>\n' +

        '                <td>管理员qq</td>\n' +

        '                <td><input type="text" id="qq" name="qq" /> </td>\n' +

        '            </tr>\n' +

        '        </table>\n' +

        '    </form>';

    //把表单添加到对话框中

    $("#dd").html(str);

}

function admindelete(rows) {

    var row=$('#dg').datagrid("getSelections");//获取用户选择的数据行

    if(row && row.length>0) { //判断用户是否选择了要进行删除的数据行

        if (row.length >= 1) { //若row.length大于等于1，则表选择了要删除的数据行。

            var strid = "";

            //下面是遍历用户所选择的数据行所对应的id主关键字，

            $(row).each(function (index, item) {

                strid += item["id"] + ",";//把用户选择的数据行的id保串连起来构成如“1，2，3，”这里表示用户选择了id为1，2，3的数据行

            });

            strid = strid.substring(0, strid.length - 1);//把数据行最后的分号去掉

            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {

                if (r) { //若确认要删除，则采用异步方式把要删除的数据行对应的id串传送给后台进行处理

                    $.ajax({

                        type: "post",

                        url: "../admin/deleteall",//后台处理程序

                        data: {

                            id: strid //要删除数据行对应的id字符串

                        },

                        success: function (data) {

                            $('#dg').datagrid("reload"); //若删除成功则重新加载数据表的数据

                        }

                    });

                }

            });



        } else {

            alert("你没有选择数据行，所以不能进行删除操作");

            return false;

        }

    }



   /*
    var delid={};

    var id="";

    $.each(rows,function (i,item) {

        id+=item["id"]+",";

    })

    delid.id=id.substr(0,id.length-1);
    $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {

        $.ajax( //采用异步通讯向后台的json控制器的requestJson方法发送json数据

            {

                type:"POST", //发出请求方式

                url:"../admin/deleteByPrimaryKey", //控制器

                //指定数据格式为 json

                contentType:"application/json;charset=UTF-8",

                data:JSON.stringify(delid),//发送json数据

                dataType:"json",//后台控制器返回的数据类型

                success:function(data){ //发送成功后进行处理
                    $('#dg').datagrid("reload");//重新装入表格的内容
                }}

        )

    });*/





}

function initadmin() {

    /*判断页面中是否存在id等于dg的元素，若存在则进行删除*/

    if ($("#dg") != null) {

        $("#dg").remove(); //删除id="dg"的元素

    }

    $("#tab").empty();//把页面中id="tab"的元素内容清空

    /*在页面中id="tab"元素中添加一个id="dg"的div元素*/

    $("#tab").append("<div id='dg'></div>");

    /*下面采用jquery easyui的datagrie控制进行显示管理员的列表*/

    $('#dg').datagrid({

        //后台处理程序的地址

        url : '../admin/listAll',

        pagination : true,//显示分页工具

        pageNumber : 1,//表示显示第几页，第一页

        pageSize : 10,//表示每页显示的记录个数

        pageList : [ 10, 20, 30, 40, 50 ],//第一页显示记录个数列表
        toolbar : [ {//显示工具栏

            text : '添加',

            iconCls : 'icon-add',

            handler : function() {

                admininsert();

            }

        }, '-', {

            text : '更新',

            iconCls : 'icon-edit',

            handler : function() {

                var row=$('#dg').datagrid("getSelections");//获取用户选择的数据行

                if(row && row.length>0){

                    if(row.length>1){

                        alert("一次只能更新一条记录");

                        return false;

                    }else{

                        adminupdate(row);

                    }

                }else{

                    alert("请选择你要更新数据行，才能进行更新操作");

                }

            }

        }, '-', {

            text : '删除',

            iconCls : 'icon-remove',

            handler : function() {

                var rows = $("#dg").datagrid("getSelections");

                if(rows && rows.length > 0){

                        admindelete(rows);

                }else{

                    alert('警告', '请选择要删除数据行，才能进行删除操作');

                }

            }

        }, '-', {

            text : '导入数据',

            iconCls : 'icon-help',

            handler : function() {

                alert('导入数据按钮')

            }

        }, '-', {

            text : '导出数据',

            iconCls : 'icon-help',

            handler : function() {

                alert("导出数据");

            }

        }, '-', {

            text : '搜索',

            iconCls : 'icon-search',

            handler : function() {

                alert("搜索数据");

            }

        } ],

        columns : [ [ {

            field : 'id',

            title : '编号',

            width : 100,

            hidden:true

        }, {

            field : 'name',

            title : '管理员姓名',

            width : 200

        }, {

            field : 'pass',

            title : '管理员帐号密码',

            width : 200

        } , {

            field : 'phone',

            title : '电话',

            width : 200

        }, {

            field : 'email',

            title : '邮箱',

            width : 200

        }, {

            field : 'qq',

            title : 'qq号',

            width : 200

        }] ]

    });

}
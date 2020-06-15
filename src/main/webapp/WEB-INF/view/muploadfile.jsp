<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Title</title>

    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/default/easyui.css">

    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        function addfield(){

            //获取页面中input元素id属性值含有fb的个数

            var count=$("input[id*='fb']").length;

            //下面是构建添加文件上传的id的值，如添加第一个文件上传输入框，则id属性值为fb1,添加第二个文件上传输入框的id为fb2

            var idstr="fb"+count.toString();

            //构建一个文件上传输入框

            var field='<input id="'+idstr+'" type="text" name="up1oadfile" style="width:300px" />'

            //在id=ff的表单中添加一个文件上传输入框

            $("#ff").append(field);

            //把添加文件上传输入框转换成easyui文件上传输入框

            $("#"+idstr).filebox({

                buttonText: '选择文件',

                buttonAlign: 'left'

            });

        }

        $(function () {

            $("#ff").dialog({

                title: '上传文件',

                width: 320,

                closed: false,

                cache: false,

                modal: true,

                buttons:[{

                    text:'附加文件',

                    handler:function(){

                        addfield();

                    }

                },{

                    text:'上传',

                    handler:function(){

                        $('#ff').form('submit', {

                            url:"${pageContext.request.contextPath}/mfile",

                            onSubmit: function(){

                                //这是上传文件前可以在这里进行一些检测；

                            },

                            success:function(data){//上传成功后，后台发回的信息

                                //把后台传回的字符串{"success":true}转换成json数据格式

                                var json=$.parseJSON(data);

                                if(json["success"]){

                                    alert("上传文件成功");

                                }else{

                                    alert("上传文件失败");

                                }

                            }

                        });

                    }

                },{

                    text:'关闭',

                    handler:function(){}

                }]

            });

            //把id=fb的元素转换成文件上传输入框

            $('#fb').filebox({

                buttonText: '选择文件',

                buttonAlign: 'left'

            })

        });

    </script>

</head>

<body>

<form id="ff"  method="post" enctype="multipart/form-data">

    <input id="fb" type="text" name="up1oadfile" style="width:300px" />

</form>

</body>

</html
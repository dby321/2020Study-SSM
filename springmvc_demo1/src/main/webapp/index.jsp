<%--
  Created by IntelliJ IDEA.
  User: Dong Binyu
  Date: 2020/8/18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123","age":30}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        console.log(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<h3>入门程序</h3>
<a href="user/hello">入门程序</a>
<a href="user/testString">testString</a>
<a href="user/testVoid">testVoid</a>
<a href="user/testModelAndView">testModelAndView</a>
<a href="user/testForward">testForward</a>
<a href="user/testRedirect">testRedirect</a>
<button id="btn">发送Ajax请求</button>
<br>
<h3>文件上传</h3>
<form action="user/fileupload1" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
<br>
<h3>springmvc文件上传</h3>
<form action="user/fileupload2" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
<br>
<h3>springmvc跨服务器文件上传--未实现</h3>
<form action="user/fileupload3" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>

<a href="user/testException">异常处理</a>
<a href="user/testInterceptor">拦截器</a>

</body>
</html>

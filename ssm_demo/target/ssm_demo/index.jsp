<%--
  Created by IntelliJ IDEA.
  User: Dong Binyu
  Date: 2020/8/27
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">测试</a>


    <form action="account/saveAcoount" method="post">
        姓名:<input type="text" name="name"/>
        金钱:<input type="text" name="money"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Dong Binyu
  Date: 2020/8/27
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    findAll页面
    <c:forEach items="${list}" var="account">
        ${account.id} ${account.money}
    </c:forEach>

</body>
</html>

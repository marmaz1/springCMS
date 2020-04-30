<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="custom" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h2>Last articles</h2>

<table border="2px">
    <tr>
        <th>Nr</th>
        <th>Title</th>
        <th>Created</th>
        <th>Content</th>
    </tr>

    <c:forEach items="${articles}" var="article" varStatus="stat">

        <tr>
            <td>${stat.count}</td>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>
        </tr>

    </c:forEach>


</table>




</body>
</html>

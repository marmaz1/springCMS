<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>

<table border="2px">

    <h3><a href="/authors/add">Add new author</a> </h3>

    <tr>
        <th>Nr</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${authors}" var="author" varStatus="stat">

        <tr>
            <td>${stat.count}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="/authors/edit?id=${author.id}">Edit</a>
                <a href="/authors/delete?id=${author.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>



</table>

</body>
</html>

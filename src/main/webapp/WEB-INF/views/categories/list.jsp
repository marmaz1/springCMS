<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

<table border="2px">

    <h2><a href="/categories/add">Add new Category</a></h2>

    <tr>
        <th>Nr</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${categories}" var="category" varStatus="stat">

        <tr>
            <td>${stat.count}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
                <a href="/categories/edit?id=${category.id}">Edit</a>
                <a href="/categories/delete?id=${category.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>

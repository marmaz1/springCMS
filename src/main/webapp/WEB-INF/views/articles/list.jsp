<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 01.05.2020
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>

<table border="2px">

    <h3><a href="/articles/add">Add new article</a> </h3>

    <tr>
        <th>Nr</th>
        <th>Title</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Content</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${articles}" var="article" varStatus="stat">

        <tr>
            <td>${stat.count}</td>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td>${article.content}</td>
            <td>
                <a href="/articles/edit?id=${article.id}">Edit</a>
                <a href="/articles/delete?id=${article.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 07.05.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drafts</title>
</head>
<body>

<table border="2px">

    <tr>
        <th>Nr</th>
        <th>Title</th>
        <th>Content</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${drafts}" var="draft" varStatus="stat">

        <tr>
            <td>${stat.count}</td>
            <td>${draft.title}</td>
            <td>${draft.content}</td>
            <td>
                <a href="/drafts/edit?id=${draft.id}">Edit</a>
                <a href="/drafts/delete?id=${draft.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>

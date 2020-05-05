<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>

<h3><a href="/categories">Show all categories</a> </h3>

<form:form method="post" modelAttribute="category">

    <form:label path="name">Name: </form:label>
    <form:input path="name"/><form:errors path="name"/><br>

    <form:label path="description">Description: </form:label>
    <form:input path="description"/><form:errors path="description"/><br>

    <form:button>Add</form:button>


</form:form>

</body>
</html>

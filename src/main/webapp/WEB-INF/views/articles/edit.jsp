<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 01.05.2020
  Time: 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form:form method="post" modelAttribute="article">

    <form:label path="title">Title: </form:label>
    <form:input path="title"/><br>

    <form:label path="content">Content: </form:label>
    <form:input path="content"/><br>

    <form:label path="author">Author: </form:label>
    <form:select path="author" items="${authors}" itemValue="id" itemLabel="firstName"/><br>

    <form:label path="categories">Categories: </form:label><br>
    <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true" /><br>

    <form:hidden path="id"/>
    <form:hidden path="created"/>
    <form:button>Edit</form:button>
</form:form>


</body>
</html>

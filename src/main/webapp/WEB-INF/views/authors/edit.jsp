<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 01.05.2020
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit </title>
</head>
<body>

<form:form method="post" modelAttribute="author">

    <form:label path="firstName">New first name</form:label>
    <form:input path="firstName"/><form:errors path="firstName"/><br>

    <form:label path="lastName">New last name</form:label>
    <form:input path="lastName"/><form:errors path="lastName"/><br>

    <form:hidden path="id"/>

    <form:button>Edit</form:button>



</form:form>

</body>
</html>

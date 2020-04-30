<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>

<form:form method="post" modelAttribute="category">

    <form:label path="name">New name: </form:label>
    <form:input path="name"/>

    <form:label path="description">New description: </form:label>
    <form:input path="description"/>

    <form:hidden path="id"/>

    <form:button>Edit</form:button>



</form:form>

</body>
</html>

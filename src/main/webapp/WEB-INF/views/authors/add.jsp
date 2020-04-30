<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 30.04.2020
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>

<form:form method="post" modelAttribute="author">

    <form:label path="firstName">First name: </form:label>
    <form:input path="firstName"/>

    <form:label path="lastName">Last name: </form:label>
    <form:input path="lastName"/>

    <form:button>Add</form:button>

</form:form>

</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 07.05.2020
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form:form method="post" modelAttribute="draft">

    <form:label path="title">Title:
        <form:input path="title"/><form:errors path="title"/>
    </form:label><br>

    <form:label path="content">Content:
        <form:input path="content"/><form:errors path="content"/>
    </form:label><br>

    <form:hidden path="id"/>

    <form:button>Edit</form:button>

</form:form>

</body>
</html>

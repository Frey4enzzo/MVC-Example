<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Домой</a></br>
Departments Page
<h3>Departments List</h3>
<c:if test="${!empty listDepartments}">
    <table class="tg">
        <tr>
            <th width="80">Department ID</th>
            <th width="120">Department Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDepartments}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>
                <td><a href="<c:url value='/departments/edit/${department.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/departments/remove/${department.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h3>
    Add a Department
</h3>

<c:url var="addAction" value="/departments/add" ></c:url>

<form:form action="${addAction}" commandName="department">
    <table>
        <c:if test="${!empty department.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty department.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Department"/>" />
                </c:if>
                <c:if test="${empty department.name}">
                    <input type="submit"
                           value="<spring:message text="Add Department"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>

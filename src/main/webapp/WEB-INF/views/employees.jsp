<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<a href="/">Домой</a></br>
<h3>Employees List</h3>
<c:if test="${!empty listEmployees}">
    <table class="tg">
        <tr>
            <th width="80">Employee ID</th>
            <th width="120">Firstname</th>
            <th width="120">Lastname</th>
            <th width="120">Position</th>
            <th width="120">Department</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstname}</td>
                <td>${employee.lastname}</td>
                <td>${employee.position}</td>
                <td>${employee.department.name}</td>
                <td><a href="<c:url value='/employees/edit/${employee.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/employees/remove/${employee.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h3>
    Add a Employee
</h3>

<%--<c:url var="addAction" value="/employees/add" ></c:url>--%>

<%--<form:form action="${addAction}" commandName="employee">--%>
    <%--<table>--%>
        <%--<c:if test="${!empty employee.firstname}">--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<form:label path="id">--%>
                        <%--<spring:message text="ID"/>--%>
                    <%--</form:label>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<form:input path="id" readonly="true" size="8"  disabled="true" />--%>
                    <%--<form:hidden path="id" />--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:if>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="firstname">--%>
                    <%--<spring:message text="Firstname"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="firstname" />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="lastname">--%>
                    <%--<spring:message text="Lastname"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="lastname" />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="position">--%>
                    <%--<spring:message text="Position"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="position" />--%>
            <%--</td>--%>
        <%--</tr>--%>
            <%--<td colspan="2">--%>
                <%--<c:if test="${!empty employee.firstname}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Edit Employee"/>" />--%>
                <%--</c:if>--%>
                <%--<c:if test="${empty employee.firstname}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Add Employee"/>" />--%>
                <%--</c:if>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form:form>--%>

</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<a href="/employees">Employees List</a>
<h3>Add Employee</h3>
<form:form method="post" action="/addemployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="firstname">Firstname</form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname">Lastname</form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td><form:label path="position">Position</form:label></td>
            <td><form:input path="position" /></td>
        </tr>

        <%--Try to select department from List departments--%>
        <tr>
            <td><form:label path="department">Department</form:label></td>
            <td>
                <form:select path="department">
                    <form:option value="id" label="name"/>
                    <form:options items="${departmentsList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>

    </table>
</form:form>

</body>
</html>

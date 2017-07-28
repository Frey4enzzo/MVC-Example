<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<br>
<a href="/">HOME</a></br>
<h3>Employees Search</h3></br>

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
    <a href="/addemployee">Add Employee</a>
</h3>

</body>
</html>
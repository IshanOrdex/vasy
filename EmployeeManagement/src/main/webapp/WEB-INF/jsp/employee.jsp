<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Department</th><th>Email</th><th>Salary</th>
        <c:if test="${role eq 'ROLE_ADMIN'}"><th>Actions</th></c:if>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.empID}</td>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.email}</td>
            <td>${emp.salary}</td>
            <c:if test="${role eq 'ROLE_ADMIN'}">
                <td>
                    <form method="get" action="/employees/edit" style="display:inline;">
                        <input type="hidden" name="empID" value="${emp.empID}"/>
                        <input type="submit" value="Edit"/>
                    </form>
                    <form method="post" action="/employees/delete" style="display:inline;">
                        <input type="hidden" name="empID" value="${emp.empID}"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>


<c:if test="${role eq 'ROLE_ADMIN'}">
    <h2>${action == 'edit' ? 'Edit' : 'Add'} Employee</h2>
    <form method="post" action="/employees/${action}">
        <c:if test="${action == 'edit'}">
            <input type="hidden" name="empID" value="${employee.empID}" />
        </c:if>
        Name: <input type="text" name="name" value="${employee.name}" required /><br/>
        Department: <input type="text" name="department" value="${employee.department}" required /><br/>
        Email: <input type="email" name="email" value="${employee.email}" required /><br/>
        Salary: <input type="number" name="salary" value="${employee.salary}" required /><br/>
        <input type="submit" value="${action == 'edit' ? 'Update' : 'Add'} Employee" />
    </form>
</c:if>

</body>
</html>
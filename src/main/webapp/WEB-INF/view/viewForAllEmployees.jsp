<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h3>Information for all employees</h3>
<br/>

<security:authorize access="hasRole('HR')">
<input type="button" value="Salary" onclick="window.location.href ='hrInfo'">
Only for HR Stuff
</security:authorize>
<br/>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance" onclick="window.location.href ='managerInfo'">
Only for Managers
</security:authorize>
<br/>

</body>
</html>
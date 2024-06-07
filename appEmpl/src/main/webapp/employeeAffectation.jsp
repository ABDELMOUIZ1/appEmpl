<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Affectation</title>
</head>
<body>
<h1>Employee Affectation</h1>
<a href="${pageContext.request.contextPath}/">Back to Home</a>
<form:form method="POST" action="${pageContext.request.contextPath}/assignEmployee">
    <div>
        <%--@declare id="employee"--%><label for="employee">Employee Name:</label>
        <form:select path="employeeId" items="${employees}" itemLabel="name" itemValue="id" />
    </div>
    <div>
        <%--@declare id="project"--%><label for="project">Project Name:</label>
        <form:select path="projectId" items="${projects}" itemLabel="name" itemValue="id" />
    </div>
    <div>
        <label for="implication">Implication (%):</label>
        <form:input path="implication" type="number" min="0" max="100" required="true" />
    </div>
    <div>
        <input type="submit" value="Affecter projet" />
    </div>
</form:form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngoc Huyen
  Date: 04/03/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Search Result</h1>
<fieldset>
<%--  <legend>Employee Id ${emp.employeeId}</legend>--%>
  <p>
  <form>
    <p>
      <label>Employee Id</label> <input name="empId" type="text" value="${emp.employeeId}" readonly/>
    </p>
    <p>
      <label>Employee Name</label> <input name="empName" type="text" value="${emp.employeeName}" />
    </p>
  <c:forEach items="${emp.companies}" var="company">
    <p>
      <label>In Company Name</label> <input name="comName" type="text" value="${company.companyName}" />
    </p>
  </c:forEach>

  </form>
</fieldset>

<%--<p>Click<a href="/WEB-INF/Insert.jsp">here</a>to Add new Employee </p>--%>

</body>
</html>

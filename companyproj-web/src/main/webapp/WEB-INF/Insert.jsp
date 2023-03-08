
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngoc Huyen
  Date: 06/03/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
<h1>Insert to n-n relationship</h1>
<form action="employee" method="post">
    <p>
        <label>Employee Id</label> <input name="empId" type="text" />
    </p>
    <p>
        <label>Employee Name</label> <input name="empName" type="text"  />
    </p>
    <p>
        <label>Course Id:</label> <input name="courseId" type="text"  />
    </p>
    <p>
        <label>Course Name:</label> <input name="courseName" type="text"  />
    </p>
    <fieldset>
        <legend>Company not exits in DB</legend>
        <p>
            <label>Company Id</label> <input name="comIdNew" type="text"  />
        </p>
        <p>
            <label>Company Name</label> <input name="comName" type="text"  />
        </p>
    </fieldset>

    <fieldset>
    <legend>Company exits in DB</legend>
        <p>
            <label>Company Id</label> <input name="comId" type="text"  />
        </p>
    </fieldset>
    <p>
        <input name="action" type="submit" value="Add" />
        <input type="reset" value="Reset">
    </p>
</form>
</body>
</html>

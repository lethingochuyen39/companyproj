<%--
  Created by IntelliJ IDEA.
  User: Ngoc Huyen
  Date: 04/03/2023
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Search</title>
  </head>
  <body>
  <h1>Search Employee Id</h1>
  <form action="employee" method="post">

      <p>
          <label>Employee Id :</label> <input name="empId" type="text" required/>
      </p>
      <p>
          <input name="action" type="submit" value="SEARCH" />
      </p>
  </form>

  </body>
</html>

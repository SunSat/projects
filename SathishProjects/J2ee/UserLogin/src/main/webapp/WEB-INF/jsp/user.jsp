<%--
  Created by IntelliJ IDEA.
  User: ssundar2
  Date: 24-02-2017
  Time: 06:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User Sign Up</title>
</head>
<body>

<form action="./newUser.sp" method="post">
  <table>
    <tr>
      <td>
        Name : <input type="text" name="name"/>
      </td>
    </tr>
    <tr>
      <td>
        UserName : <input type="text" name="userName"/>
      </td>
    </tr>
    <tr>
      <td>
        Password : <input type="password" name="password"/>
      </td>
    </tr>
    <tr>
      <td>
        Confirm Password : <input type="password" name="confirmPassword"/>
      </td>
    </tr>
    <tr>
      <td>
        Gender : <input type="text" name="gender"/>
      </td>
    </tr>
    <tr>
      <td>
        Date of Birth : <input type="date" name="dateOfBirth"/>
      </td>
    </tr>
    <tr>
      <td>
        Mobile Number1 : <input type="number1" name="mobileNo1"/>
      </td>
    </tr>
    <tr>
      <td>
        Mobile Number2 : <input type="number2" name="mobileNo2"/>
      </td>
    </tr>
    <tr>
      <td>
        Mail Id1 : <input type="email1" name="email1"/>
      </td>
    </tr>
    <tr>
      <td>
        Mail Id2 : <input type="email2" name="email2"/>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Create User"/>
      </td>
      <td>
        <input type="button" value="Reset"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>

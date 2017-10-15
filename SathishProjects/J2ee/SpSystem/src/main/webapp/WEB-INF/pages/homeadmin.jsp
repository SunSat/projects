<%@ page import="com.spsystem.dto.UserDto" %>
<%--
  Created by IntelliJ IDEA.
  User: ssundar2
  Date: 28-03-2017
  Time: 01:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    #Message {
      color: red;
    }
    </style>
    <title></title>
</head>
<body>

<form action="<%= request.getContextPath()%>/barcodereqeust/barcodecheck.sp" method="post" >
  <h1>File operation Form.</h1>
  <dev id="Message">
    <%
      if(request.getAttribute("Message") != null) {
        out.println(request.getAttribute("Message"));
      }
    %>
  </dev>
  <table>
    <tr>
      <td>
        Enter Barcode Id :
      </td>
      <td>
        <input type="text" name="barcodeId"/>
      </td>
    </tr>
    <tr>
      <td>
        File Type :
      </td>
      <td>
        <input type="radio" name="fileType" value="DE1" checked/> DE1
      </td>
      <td>
        <input type="radio" name="fileType" value="DE2"/> DE2
      </td>
    </tr>
  </table>
  <br>
  <input type="submit" name="Submit" value="Lock"/> <input type="submit" name="Submit" value="UnLock"/>
  <br>
</form>

<form name="userrequest" action="<%= request.getContextPath()%>/user.sp" method="post">
    <h1>User Operation Form.</h1>
    <br>
  <dev id="Message">
    <%
      if(request.getAttribute("UserMessage") != null) {
        out.println(request.getAttribute("UserMessage"));
      }
      UserDto userDto = (UserDto)request.getAttribute("userDto");
    %>
  </dev>
    <table>
      <tr>
        <td>
          User Id :
        </td>
        <td>
          <input type="text" name="userid" value="<%=userDto != null ? userDto.getUserId() : ""%>">
        </td>
      </tr>
      <tr>
        <td>
          Name :
        </td>
        <td>
          <input type="text" name="name" value="<%=userDto != null ? userDto.getName() : ""%>">
        </td>
      </tr>
      <tr>
        <td>
          Password
        </td>
        <td>
          <input type="text" name="password" value="<%=userDto != null ? userDto.getPassword() : ""%>">
        </td>
      </tr>
      <tr>
        <td>
          Is Admin :
        </td>
        <td>
          <input type="radio" name="isadmin" value="yes" <%=userDto != null ? !userDto.getIsAdmin().equals("no")?"checked":"":"checked"%> /> Yes
        </td>
        <td>
          <input type="radio" name="isadmin" value="no" <%=userDto != null ? userDto.getIsAdmin().equals("no")?"checked":"":""%>/> No
        </td>
      </tr>
      <tr>
        <td>
          Current Status :
        </td>
        <td>
          <input type="radio" name="status" value="current" <%=userDto != null ? !userDto.getStatus().equals("terminated")?"checked":"":"checked"%> /> Current
        </td>
        <td>
          <input type="radio" name="status" value="terminated" <%=userDto != null ? userDto.getStatus().equals("terminated")?"checked":"":""%>/> Terminated
        </td>
      </tr>
    </table>
    <table>
      <tr>
        <td>
          <input type="submit" name="submit" value="SearchUser">
        </td>
        <td>
          <input type="submit" name="submit" value="AddUser">
        </td>
        <td>
          <input type="submit" name="submit" value="UpdateUser">
        </td>
        <td>
          <input type="submit" name="submit" value="DeleteUser">
        </td>
      </tr>
    </table>
</form>

<form name="Report Generation Form" method="post" action="<%= request.getContextPath()%>/Report.sp">

  <h1>
    Generate Report Form
  </h1>
  <br>
  <%
    if(request.getAttribute("ReportMessage") != null) {
      out.println(request.getAttribute("ReportMessage"));
    }
  %>
  <table>
    <tr>
      <td>
        User Id :
      </td>
      <td>
        <input type="text" name="userid"/>
      </td>
    </tr>
    <tr>
      <td>
        name :
      </td>
      <td>
        <input type="text" name="name"/>
      </td>
    </tr>
    <tr>
      <td>
        Start Date :
      </td>
      <td>
        <input type="text" name="startdate"/> <dev style="color: red">Format : YYYY-MM-DD</dev>
      </td>
    </tr>
    <tr>
      <td>
        End Date :
      </td>
      <td>
        <input type="text" name="enddate"/> <dev style="color: red">Format : YYYY-MM-DD</dev>
      </td>
    </tr>
  </table>
  <table>
    <tr>
      <td>
        <input type="submit" name="Submit" value="By UserId">
      </td>
      <td>
        <input type="submit" name="Submit" value="By Date">
      </td>
    </tr>
  </table>
</form>
</body>
</html>

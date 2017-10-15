<%@ page import="com.spsystem.dto.BarCodeTrackerDto" %>
<%@ page import="com.spsystem.dto.CurrentUserDto" %>
<%--
  Created by IntelliJ IDEA.
  User: ssundar2
  Date: 28-03-2017
  Time: 01:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form name="barcodeInputpage" action="<%= request.getContextPath()%>/barcodereqeust/barcodesubmit.sp" method="post">
  <%
    BarCodeTrackerDto dto = (BarCodeTrackerDto)request.getAttribute("BarCodeTrackerDto");
    CurrentUserDto user = (CurrentUserDto)session.getAttribute("currentUserDto");
  %>
  <table>
    <tr>
      <td>
          Barcode Id :
      </td>
      <td>
        <input type="text" name="barcodeId" value="<%=dto.getBarcodeId()%>"  readonly="readonly"/>
      </td>
    </tr>
    <tr>
      <td>
        File Type :
      </td>
      <td>
        <input type="radio" name="type" value="DE1" <%=dto.getType().equalsIgnoreCase("DE1")?"checked" : "disabled=\"disabled\"" %>  /> DE1
      </td>
      <td>
        <input type="radio" name="type" value="DE2" <%=dto.getType().equalsIgnoreCase("DE2")?"checked" : "disabled=\"disabled\"" %> /> DE2
      </td>
    </tr>
    <tr>
      <td>
        User Id :
      </td>
      <td>
        <input type="text" name="userId" readonly="readonly" value="<%=user.getUserId()%>" />
      </td>
    </tr>
    <tr>
      <td>
        User Name :
      </td>
      <td>
        <input type="text" name="userName" readonly="readonly" value="<%=user.getName()%>"/>
      </td>
    </tr>
    <tr>
      <td>
        Is Already Rejected :
      </td>
      <td>
        <input type="text" name="isRejected" readonly="readonly" value="<%=dto.getIsRejected()%>"/>
      </td>
    </tr>
    <tr>
      <td>
        Rejected Count :
      </td>
      <td>
        <input type="text" name="rejectedcount" readonly="readonly" value="<%=dto.getCount()%>" />
      </td>
    </tr>
    <tr>
      <td>
        Message :
      </td>
      <td>
        <input type="text" name="message" value="<%= dto.getMessage()%>">
      </td>
    </tr>
  </table>
  <br>
  <table>
    <tr>
      <td>
        <input type="submit" name="Submit" value="Barcode Submit">
      </td>
      <td>
        <input type="submit" name="Submit" value="Barcode Reject">
      </td>
    </tr>
  </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ssundar2
  Date: 28-03-2017
  Time: 01:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <table>
      <tr>
        <td>
          <input type="submit" name="Submit" value="Lock"/>
        </td>
        <td>
          <input type="submit" name="Submit" value="Home"/>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>

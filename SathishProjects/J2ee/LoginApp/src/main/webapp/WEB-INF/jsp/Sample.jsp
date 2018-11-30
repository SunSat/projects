<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel.LogingFormModel" %>
<%--
  Created by IntelliJ IDEA.
  User: sathishkumar_su
  Date: 6/1/2018
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

Today's Date is : <%=(new java.util.Date())%>
<br>

<%
  out.print("The current time is : " + new java.util.Date());
%>

<table width="100%" border="1" align="center">
  <tr bgcolor="#faebd7">
    <th>
      Header Name
    </th>
    <th>
      Header Value
    </th>
  </tr>

  <%
    Enumeration enu = request.getHeaderNames();
    while(enu.hasMoreElements()) {
      String eleSt = (String)enu.nextElement();
      out.print("<tr><td>" + eleSt + "</td>\n");
      String obj = (String)request.getHeader(eleSt);
      out.print("<td>"  + obj + "</td></tr>");
    }
  %>
</table>

<%! int day = 1; %>

<h2>If .. Else </h2>

<% if(day ==1 || day ==7) { %>
  <p style="background-color: orangered"> Today is Weekend </p>
<%  } else { %>
  <p style="color: aqua"> Today is Not weekend </p>
<%  } %>

<h2>Do.. While</h2>

<%! int day1 = 7;%>

<%for(int i = 0;i< day1 ;i++) {%>
  <font color="#ff4500" size="<%=i%>">
    JSP Tutorial.
  </font> <br/>
<%}%>


<h2>Accessing the Parameters</h2>

<ul>
  <%
    Enumeration<String> en = request.getParameterNames();
    while(en.hasMoreElements()) {
      String st = en.nextElement();
      out.println(request.getParameter(st));
    }

    out.println("<h2>Accessing Attributes</h2>");
  %>

  <table style="border: solid 1px red" width="100%">
    <tr style="background-color: aquamarine" >
      <td style="width: 30%">
         Attribute Name :
      </td>
      <td style="width: 70%;">
        Attribute Values :
      </td>
    </tr>
    <% Enumeration<String> attEn = request.getAttributeNames(); %>

      <% while(attEn.hasMoreElements()) {
         String st = attEn.nextElement(); %>
    <tr>
      <td>
        <%=st%>
      </td>
      <td>
        <%=request.getAttribute(st)%>
      </td>
      <%}%>
    </tr>
  </table>
</ul>

<h2>The logged User Details were </h2>

Hello Mr.<%=((LogingFormModel)request.getAttribute("user")).getUserName()%> Welcome
</body>
</html>

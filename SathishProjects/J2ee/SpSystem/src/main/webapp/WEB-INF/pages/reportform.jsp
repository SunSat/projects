<%@ page import="com.spsystem.dto.ReportResultByDateDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.spsystem.dto.ReporterDto" %>
<%@ page import="java.util.HashSet" %>
<html>

<head>
    <h1>
        Full report Form <%="Report By "+ request.getAttribute("reportBy") %>
    </h1>
</head>

<body>
    <%
        List<ReportResultByDateDto> totalSubmittedReLi = (List<ReportResultByDateDto>) request.getAttribute("totalSubmittedReLi");
        List<ReportResultByDateDto> totalRejectedReLi = (List<ReportResultByDateDto>) request.getAttribute("totalRejectedReLi");
        Map<String,Integer> userIdVsSubmittedCount = (Map<String,Integer>) request.getAttribute("userIdVsSubmittedCount");
        Map<String,Integer> userIdVsRejectedCount = (Map<String,Integer>) request.getAttribute("userIdVsRejectedCount");
        ReporterDto reporterDto = (ReporterDto) request.getAttribute("reporterDto");
        Map<Integer,Integer> rejected1To5Count = (Map<Integer,Integer>)request.getAttribute("rejected1To5Count");
    %>
    <h3>Table 1 : Total No of Submitted and Rejected Count. From '<%=reporterDto.getStartDate()%>' to '<%=reporterDto.getEndDate()%>'.</h3>
    <table border="2" cellpadding="5" width="400">
        <tr>
            <th>
                No
            </th>
            <th>
                Submitted
            </th>
            <th>
                Rejected
            </th>
            <th>
                Total
            </th>
            <th>
                Reject 1
            </th>
            <th>
                Reject 2
            </th>
            <th>
                Reject 3
            </th>
            <th>
                Reject 4
            </th>
            <th>
                Reject 5
            </th>

        </tr>
        <tr>
            <td>
                1
            </td>
            <td>
                <%=totalSubmittedReLi.size()%>
            </td>
            <td>
                <%=totalRejectedReLi.size()%>
            </td>
            <td>
                <%=totalSubmittedReLi.size() + totalRejectedReLi.size() %>
            </td>
            <td>
                <%=rejected1To5Count.getOrDefault(1, 0)%>
            </td>
            <td>
                <%=rejected1To5Count.getOrDefault(2,0)%>
            </td>
            <td>
                <%=rejected1To5Count.getOrDefault(3,0)%>
            </td>
            <td>
                <%=rejected1To5Count.getOrDefault(4,0)%>
            </td>
            <td>
                <%=rejected1To5Count.getOrDefault(5, 0)%>
            </td>
        </tr>
    </table>

    <h3>Table 2 : All Submitted File Details.</h3>
    <table border="2" cellpadding="5" width="80%">
        <tr>
            <th>
                No
            </th>
            <th>
                Barcode Id
            </th>
            <th>
                User Id
            </th>
            <th>
                User Name
            </th>
            <th>
                File Type
            </th>
            <th>
                Submitted Date
            </th>
            <th>
                Submitted Status
            </th>
            <th>
                Message
            </th>
        </tr>
        <%
            int count = 0;
            for(ReportResultByDateDto subDto : totalSubmittedReLi) {
                ++count;
                out.print("<tr>");
                out.print("<td>"+count+"</td>");
                out.print("<td>"+subDto.getBarcodeId()+"</td>");
                out.print("<td>"+subDto.getUserid()+"</td>");
                out.print("<td>"+subDto.getName()+"</td>");
                out.print("<td>"+subDto.getType()+"</td>");
                out.print("<td>"+subDto.getDate()+"</td>");
                out.print("<td>"+subDto.getStatus()+"</td>");
                out.print("<td>"+subDto.getMessage()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <h3>Table 3 : All Rejected File Details.</h3>
    <table border="2" cellpadding="5" width="80%">
        <tr>
            <th>
                No
            </th>
            <th>
                Barcode Id
            </th>
            <th>
                User Id
            </th>
            <th>
                User Name
            </th>
            <th>
                File Type
            </th>
            <th>
                Rejected Date
            </th>
            <th>
                Rejected Status
            </th>
            <th>
                Rejected Count
            </th>
            <th>
                Message
            </th>
        </tr>
        <%
            count = 0;
            for(ReportResultByDateDto subDto : totalRejectedReLi) {
                ++count;
                out.print("<tr>");
                out.print("<td>"+count+"</td>");
                out.print("<td>"+subDto.getBarcodeId()+"</td>");
                out.print("<td>"+subDto.getUserid()+"</td>");
                out.print("<td>"+subDto.getName()+"</td>");
                out.print("<td>"+subDto.getType()+"</td>");
                out.print("<td>"+subDto.getDate()+"</td>");
                out.print("<td>"+subDto.getStatus()+"</td>");
                out.print("<td>"+subDto.getCount()+"</td>");
                out.print("<td>"+subDto.getMessage()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <h3>Table 4 : Each User Submitted Count</h3>
    <table border="2" cellpadding="5" width="400">
        <tr>
            <th>
                No
            </th>
            <th>
                User Id
            </th>
            <th>
                User Name
            </th>
            <th>
                Submitted Count
            </th>
        </tr>
        <%
            count = 0;
            for(String key: userIdVsSubmittedCount.keySet()) {
                ++count;
                String[] splitAr = key.split(":");
                int totSuCo = userIdVsSubmittedCount.getOrDefault(key,0);
                out.print("<tr>");
                out.print("<td>"+count+"</td>");
                out.print("<td>"+splitAr[0]+"</td>");
                out.print("<td>"+splitAr[1]+"</td>");
                out.print("<td>"+totSuCo+"</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <h3>Table 5 : Each User Rejected Count</h3>
    <table border="2" cellpadding="5" width="400">
        <tr>
            <th>
                No
            </th>
            <th>
                User Id
            </th>
            <th>
                User Name
            </th>
            <th>
                Count
            </th>
        </tr>
        <%
            count = 0;
            for(String key: userIdVsRejectedCount.keySet()) {
                ++count;
                String[] splitAr = key.split(":");
                int totCo = userIdVsRejectedCount.getOrDefault(key,0);
                out.print("<tr>");
                out.print("<td>"+count+"</td>");
                out.print("<td>"+splitAr[0]+"</td>");
                out.print("<td>"+splitAr[1]+"</td>");
                out.print("<td>"+totCo+"</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <h3>Final Submitted Barcode Ids</h3>
    <table border="2" cellpadding="5" width="400">
        <tr>
            <th>
                Barcode Id
            </th>
        </tr>
        <%
            for(ReportResultByDateDto subDto : totalSubmittedReLi) {
                ++count;
                out.print("<tr>");
                out.print("<td>" + subDto.getBarcodeId() + "</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <h3>Final Rejected Barcode Ids</h3>
    <table border="2" cellpadding="5" width="400">
        <tr>
            <th>
                Barcode Id
            </th>
        </tr>
        <%
            HashSet<String> shownCount = new HashSet<>(totalRejectedReLi.size());
            for(ReportResultByDateDto subDto : totalRejectedReLi) {
                if(shownCount.contains(subDto.getBarcodeId())) continue;
                shownCount.add(subDto.getBarcodeId());
                ++count;
                out.print("<tr>");
                out.print("<td>" + subDto.getBarcodeId() + "</td>");
                out.print("</tr>");
            }
        %>
    </table>

</body>
</html>
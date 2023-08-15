<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
<style>
<%@include file="../../resources2/css/admin.css"%>
</style>
</head>
<body>

<table>

        <tr>
            <th>sale id</th>
            <th>product id</th>
            <th>buyer id</th>
        </tr>

        <%@ page import="models.Sale" %>

        <% java.util.List<Sale> sales = Sale.getAll(); %>

        <% for (Sale s : sales) { %>

        <tr>
            <td><%= s.getSaleId() %></td>
            <td><%= s.getProductId() %></td>
            <td><%= s.getBuyerId() %></td>
        </tr>

        <% } %>

</table>
<br>
<br>
<a href="admin.htm">Back to main menu</a>
</body>
</html>

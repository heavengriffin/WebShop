<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
<style>
<%@include file="../../resources2/css/admin.css"%>
</style>
</head>
<body>

<h3>Buyers</h3>

<table>

    <tr>
        <th>buyer_id</th>
        <th>name</th>
        <th>surname</th>
        <th>address</th>
        <th>telephone number</th>
        <th>username</th>
        <th>password</th>
        <th>number of products bought</th>
    </tr>

    <%@page import="models.Buyer" %>
    <%! Buyer buyer = new Buyer(); %>
    <% java.util.List<Buyer> buyers = Buyer.getAllBuyers(); %>
    <%  for (Buyer b : buyers) { %>

    <tr>
        <td><%= b.getBuyerId() %></td>
        <td><%= b.getName() %></td>
        <td><%= b.getSurname() %></td>
        <td><%= b.getAddress() %></td>
        <td><%= b.getTelephoneNumber() %></td>
        <td><%= b.getUsername() %></td>
        <td><%= b.getPassword() %></td>
        <td><%= b.getNumberOfProductsBought() %></td>
    </tr>

    <% } %>

</table>

<br>
<br>

<form action="UpdateBuyerServlet" method="post">
<label>Select buyer id to update buyer<label>
<input type="text" name="buyer_id" required="true">
<button type="submit" name="select" value="Update">Select</button>
</form>

<br>
<br>

<a href="insert_buyer.htm">Insert Buyer</a>

<br>
<br>

<form action="DeleteBuyerServlet" method="post">
<label>Select buyer id to delete buyer<label>
<input type="text" name="delete_buyer" required="true">
<input type="submit" name="delete" value="Delete">
</form>
<br>
<br>
<a href="admin.htm">Back to main menu</a>

</body>
</html>
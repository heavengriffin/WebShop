<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
<%@include file="../../resources2/css/table.css"%>
</style>
</head>
<body>

<table>

    <tr>
        <th class="name">name</th>
        <th class="category">category</th>
        <th class="price">price</th>
        <th class="gold">available</th>
        <th class="gold">quantity</th>
        <th class="gold">buy</th>
    </tr>
    <%@ page import="models.Product" %>
    <%! Product product = new Product(); %>
    <% java.util.List<Product> products = Product.getAll(); %>
    <% for (int i = 0; i < products.size(); i++) { %>

    <tr>
        <td class="name"><%= products.get(i).getName() %></td>
        <td class="category"><%= products.get(i).getCategory() %></td>
        <td class="price"><%= products.get(i).getPrice() %></td>
        <td class="gold"><%= products.get(i).getQuantityInStock() %></td>
        <form action="ProductServlet" method="post">
        <td class="gold"><input name="quantity" size="2"></td>
        <% String buttonValue = products.get(i).getName(); %>
        <td class="gold"><button type="submit" value="<%= buttonValue %>" name="bought">Buy</button></td>
        </form>
    </tr>

    <% } %>
</table>

<br>
<br>
<a href="login.htm">Log out</a>

</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<style>

<%@include file="../../resources2/css/admin.css"%>

</style>
</head>
<body>

<h3>Products</h3>
<table>
    <tr>
        <th>product id</th>
        <th>name</th>
        <th>category</th>
        <th>quantity in stock</th>
        <th>unit price</th>
    </tr>

    <%@ page import="models.Product" %>
    <%@ page import="placeholders.Placeholder" %>
    <%! Product product = new Product(); %>
    <%! Placeholder placeholder = new Placeholder(); %>
    <% java.util.List<Product> products = Product.getAll(); %>
    <% for(Product p : products) { %>

    <tr>
        <td> <%= p.getProductId() %> </td>
        <td> <%= p.getName() %> </td>
        <td> <%= p.getCategory() %> </td>
        <td> <%= p.getQuantityInStock() %> </td>
        <td> <%= p.getPrice() %> </td>
    </tr>

    <% } %>

    </table>
    <br>
    <br>
    <form action="UpdateProductServlet" method="post">
        <label for="p">Enter product id to update product</label>
        <input id="p" type="text" name="product_id">
        <input type="submit" value="Update">
    </form>
    <br>
    <a href="insert_product.htm">Insert Product</a>
    <br>
    <br>
    <br>
    <form action="DeleteProductServlet" method="post">
        <label for="dp">Enter product id to delete product</label>
        <input id="dp" type="text" name="delete_product">
        <input type="submit" value="Delete">
    </form>
    <br>
    <a href="admin.htm">Back to main menu</a>

</body>
</html>
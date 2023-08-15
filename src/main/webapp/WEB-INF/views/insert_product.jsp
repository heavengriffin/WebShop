<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<style>
div {
        padding: 5px;
        margin: 5px;
    }
</style>
</head>
<body>

<f:form action="insert_product.htm" method="post" commandName="product">
<div>
<f:label path="name">Name: </f:label>
<f:input path="name"/>
<f:errors path="name"></f:errors>
</div>

<div>
<f:label path="category">Category: </f:label>
<f:input path="category"/>
<f:errors path="category"></f:errors>
</div>

<div>
<f:label path="quantityInStock">Quantity in Stock: </f:label>
<f:input path="quantityInStock"/>
<f:errors path="quantityInStock"></f:errors>
</div>

<div>
<f:label path="price">Price: </f:label>
<f:input path="price"/>
<f:errors path="price"></f:errors>
</div>

<div>
<input type="submit" value="Insert" name="insert">
</div>
</f:form>
<br>
<a href="products.htm">Back to Products</a>
<br>
<br>
<a href="admin.htm">Back to main manu</a>

</body>
</html>
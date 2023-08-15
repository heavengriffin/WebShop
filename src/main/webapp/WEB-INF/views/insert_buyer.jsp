<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<f:form action="insert_buyer.htm" method="post" commandName="buyer">

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

    <div>
    <f:label path="name">Name: </f:label>
    <f:input path="name"/>
    <f:errors path="name"></f:errors>
    </div>
    <div>
    <f:label path="surname">Surname: </f:label>
    <f:input path="surname"/>
    <f:errors path="surname"></f:errors>
    </div>
    <div>
    <f:label path="address">Address: </f:label>
    <f:input path="address"/>
    <f:errors path="address"></f:errors>
    </div>
    <div>
    <f:label path="telephoneNumber">Telephone number: </f:label>
    <f:input path="telephoneNumber"/>
    <f:errors path="telephoneNumber"></f:errors>
    </div>
    <div>
    <f:label path="username">Username: </f:label>
    <f:input path="username"/>
    <f:errors path="username"></f:errors>
    </div>
    <div>
    <f:label path="password">Password: </f:label>
    <f:input path="password"/>
    <f:errors path="password"></f:errors>
    <div>

    <div>
    <input type="submit" name="insert" value="Insert">
    </div>

</f:form>
<br>
<a href="buyers.htm">Back to Products</a>
<br>
<br>
<a href="admin.htm">Back to main manu</a>

</body>
</html>
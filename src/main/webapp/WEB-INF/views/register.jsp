<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>
<style>
    div {
        padding: 5px;
        margin: 5px;
    }
</style>
</head>

<html>
<body>

<f:form action="register.htm" method="post" commandName="buyer">

    <h3>Enter your details:</h3>
    <div>
    <f:label path="name">Name: </f:label>
    <f:input path="name"></f:input>
    <f:errors path="name"></f:errors>
    </div>
    <div>
    <f:label path="surname">Surname: </f:label>
    <f:input path="surname"></f:input>
    <f:errors path="surname"></f:errors>
    </div>
    <div>
    <f:label path="address">Address: </f:label>
    <f:input path="address"></f:input>
    </div>
    <div>
    <f:label path="telephoneNumber">Telephone Number: </f:label>
    <f:input path="telephoneNumber"></f:input>
    </div>
    <div>
    <f:label path="username">Username: </f:label>
    <f:input path="username"></f:input>
    <f:errors path="username"></f:errors>
    </div>
    <div>
    <f:label path="password">Password: </f:label>
    <f:input type="password" path="password"></f:input>
    <f:errors path="password"></f:errors>
    </div>
    <div>
    <input type="submit" value="Register">
    </div>

</f:form>

</body>
</html>
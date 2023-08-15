<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<resources mapping="/resources2/**" location="/resources2/" />
<html>
<head>

<title>Royal Goods</title>

<style>
            #welcome {
                background-image: url("<c:url value="/resources2/images/crown4.jpg"/>");
                background-size: contain;
                height: 250px;
                line-height: 250px;
            }
            h1 {
                text-align: center;
                color:blueviolet;
                text-shadow: 2px 2px 2px black;
            }
            div {
                 padding:5px;
                 margin:5px;
            }
            .button {
                     float:right;
            }
            table {
                border: 2px black solid;
            }
</style>

</head>
<body>

<div id ="welcome">
     <h1><span style="color:darkorchid;">Welcome to</span> <span style="color:darkcyan;">Royal Goods</span> <span style="color:crimson;">web shop</span></h1>
</div>

<div>
<p>Please log in to continue</p>
</div>

<f:form action="login.htm" method="post" commandName="buyer">
<div>
<f:label path="username">Username: </f:label>
<f:input type="text" path="username"></f:input>
</div>
<div>
<f:label path="password">Password: </f:label>
<f:input type="password" path="password"></f:input>
</div>
<div style="width:220px;">
<input type="submit" value="log in" class="button">
</div>
</f:form>
<div style="width:280px;">
<p>If you are a new customer, please register: </p>
<button class="button" name="register" value="register" onclick="window.location.href='http://localhost:8080/Shop/register.htm';">Register</button>
</div>

</body>
</html>
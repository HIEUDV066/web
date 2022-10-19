<%--
  Created by IntelliJ IDEA.
  User: MinhHai
  Date: 08/09/2022
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
    <style>
        label {
            display: block;
        }
        div {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>This is a Register form</h1>

    <form action="register" method="post">
        <div>
            <label for="fistname">First Name</label>
            <input type="text" name="fname" id="fistname">
        </div>

        <div>
            <label for="lastname">Last Name</label>
            <input type="text" name="lname" id="lastname">
        </div>

        <div>
            <label for="username">User Name</label>
            <input type="text" name="username" id="username">
        </div>

        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password">
        </div>

        <div>
            <label for="address">Address</label>
            <input type="text" name="address" id="address">
        </div>

        <div>
            <label for="contact">Contact</label>
            <input type="text" name="contact" id="contact">
        </div>

        <div><input type="submit" value="Register"></div>
    </form>

    <div>
        <p>Already have a account? <a href="login">Click here</a> to login</p>
    </div>
</body>
</html>

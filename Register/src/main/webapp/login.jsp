<%--
  Created by IntelliJ IDEA.
  User: MinhHai
  Date: 09/09/2022
  Time: 04:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>This is a Login form</h1>

    <form action="login" method="post">
        <div>
            <label for="username">Username</label>
            <input type="text" name="username" id="username">
        </div>

        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password">
        </div>

        <div><input type="submit" value="Login"></div>
    </form>

    <div>
        <p>Don't have account? <a href="register">Click here</a> to register</p>
    </div>
</body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body>
        <h2>Login</h1>
        <form action="./authentication" method="POST">
            Username: <input type="text" name="uname"><br><br>
            Password: <input type="password"  name="pass"><br><br>
            <input type="submit" name="submit" value="Log in">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>

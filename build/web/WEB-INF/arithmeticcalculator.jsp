<%-- 
    Document   : arithmeticcalculator
    Created on : 24-Jan-2023, 10:53:07 AM
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="">
            First: <input type="text" name="firstInt"><br>
            Second: <input type="text" name="secondInt"><br>
            <input type="submit" value="+" name="submit">
            <input type="submit" value="-" name="submit">
            <input type="submit" value="*" name="submit">
            <input type="submit" value="/" name="submit">
        </form>
        <div>Result: ${result}</div>
        <a href="age">Age Calculator</a>
    </body>
</html>

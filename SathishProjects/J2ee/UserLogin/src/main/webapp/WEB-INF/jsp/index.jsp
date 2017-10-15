<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Login Screen</h1>
</head>
<body>
<form action="./login.sp" method="post">
    <table>
        <tr>
            <td>
                UserName : <input type="text" name="userName"/>
            </td>
        </tr>
        <tr>
            <td>
                Password : <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Login" value="Login"/>
            </td>
            <td>
                <input type="button" value="Reset"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="NewUser" name="NewUser"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

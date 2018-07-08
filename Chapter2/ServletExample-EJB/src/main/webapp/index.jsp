<!DOCTYPE html>
<html>

<head>
    <title>Servlet-Example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          th:href="@{/webjars/bootstrap/3.3.6/css/bootstrap.min.css}"
          rel="stylesheet" media="screen" />
    <link href="../static/css/core.css"
          th:href="@{/css/core.css}"
          rel="stylesheet" media="screen" />
    <script src="http://cdn.jsdelivr.net/webjars/jquery/2.2.1/jquery.min.js"
            th:src="@{/webjars/jquery/2.2.1/jquery.min.js}"></script>
</head>
<body>
 <div>
     <br/>
     <br/><br/><br/><br/><br/><br/><br/><br/>
     <form action="/home" method="post">
        <table align="center">

            <tbody>
            <tr>
                <td>
                    <p><a href="#">Login Id</a></p>
                </td>
                <td>
                    <input type="text" name="loginId">
                </td>
            </tr>

            <tr>
                <td>
                    <p><a href="#">Password </a></p>
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>


            <tr>

                <td>
                    <input type="submit" value="Login">
                </td>
            </tr>


            </tbody>
        </table>
     </form>
    </div>

</body>
</html>

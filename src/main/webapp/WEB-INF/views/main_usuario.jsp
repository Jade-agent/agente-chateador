<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agente Chateador - Home Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="application/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<nav class="nav navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">Agente Chateador</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>Respuesta del Agente:</h1>

            <p>${respuesta}</p>
            <hr>
            <a href="/" class="btn btn-default">Volver</a>
        </div>
    </div>
</div>

</body>
</html>
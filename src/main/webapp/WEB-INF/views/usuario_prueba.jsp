<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
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
            <h1>Ingrese datos al agente:</h1>
            <form class="form-inline" role="form" action="/usuario/validar" method="POST" enctype="application/x-www-form-urlencoded">
                <div class="form-group">
                    <label for="user">Usuario</label>
                    <input type="text" class="form-control" id="user" placeholder="Usuario">
                </div>
                <div class="form-group">
                    <label for="password">Contrase&ntilde;</label>
                    <input type="password" class="form-control" id="password" placeholder="Contrase&ntilde;a">
                </div>
                <input type="submit" class="btn btn-default" value="Validar">
            </form>
        </div>
    </div>
</div>

</body>
</html>
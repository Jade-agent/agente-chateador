<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agente Chateador - Peliculas</title>
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
            <h1>Pel&iacute;culas</h1>
            <hr>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Id.</th>
                        <th>Nombre</th>
                        <th>Anio</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${peliculas}" var="_pelicula">
                        <tr>
                            <td>${_pelicula.peliculaId}</td>
                            <td>${_pelicula.nombre}</td>
                            <td>${_pelicula.anio}</td>
                            <td>
                                <form action="/peliculas/eliminar/${_pelicula.peliculaId}" method="post">
                                    <input type="submit" class="btn btn-danger btn-mini" value="Eliminar"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
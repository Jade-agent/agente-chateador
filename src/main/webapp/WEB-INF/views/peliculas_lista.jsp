<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>
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
                                <form action="/peliculas/editar/${_pelicula.peliculaId}" method="get">
                                    <input type="submit" class="btn btn-primary btn-mini" value="Editar"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:layout>
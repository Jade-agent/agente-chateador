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
                        <th>Fecha</th>
                        <th>Descripción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${peliculas}" var="_pelicula">
                        <tr>
                            <td>${_pelicula.peliculaId}</td>
                            <td>${_pelicula.nombre}</td>
                            <td class="text-nowrap">${_pelicula.fecha}</td>
                            <td>${_pelicula.trama}</td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <div class="container">
                                    <div class="col-md-2"><h4>Personajes</h4></div>
                                    <div class="col-md-8"><ul>
                                        <c:forEach items="${_pelicula.personajes}" var="_personaje">
                                        <li><strong>${_personaje.persona.nombre}</strong> como <strong>${_personaje.nombre}</strong></li>
                                        </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-default" href="/peliculas/importar">Importar</a>
            </div>
        </div>
    </jsp:body>
</t:layout>
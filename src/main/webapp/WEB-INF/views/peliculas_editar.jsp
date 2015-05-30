<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>
        <div class="row">
            <div class="col-md-12">
                <h1>Editar '${pelicula.nombre}'</h1>
                <hr>
                <div class="col-md-6">
                    <form class="form" role="form" action="/peliculas/actualizar/${pelicula.peliculaId}" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" placeholder="Nombre de película" id="nombre" value="${pelicula.nombre}"/>
                        </div>
                        <div class="form-group">
                            <label for="anio">Año</label>
                            <input type="number" class="form-control" placeholder="Año" id="anio" value="${pelicula.anio}"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>
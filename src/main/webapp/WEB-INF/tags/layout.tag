<%@tag description="Layout Base" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
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
    <jsp:doBody/>
</div>

</body>
</html>
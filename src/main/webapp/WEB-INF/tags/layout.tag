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
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/webjars/datatables/1.10.7/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/webjars/datatables/1.10.7/css/jquery.dataTables_themeroller.css">
    <script type="application/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="application/javascript" src="/webjars/datatables/1.10.7/js/jquery.dataTables.min.js"></script>
    <script type="application/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="webjars/datatables-plugins/ca6ec50/"></script>
</head>
<body>
<div class="container">
    <nav class="nav navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Agente Chateador</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/peliculas">Pel&iacute;culas</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <jsp:doBody />
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">

        </div>
    </div>
</div>
</body>
</html>
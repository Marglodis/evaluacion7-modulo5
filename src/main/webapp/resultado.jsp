<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.evaluacion7.modelo.Departamento" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ejemplo Relaciones JSP</title>
    <!-- Importamos Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
     
        .navbar-dark .navbar-nav .nav-link {
            color: rgba(255, 255, 255, 0.85);
        }
        .navbar-dark .navbar-nav .nav-link:hover {
            color: white;
        }
    </style>
    <%
        List<Departamento> deptos = (List<Departamento>) request.getAttribute("deptoDao");
        if (deptos == null) {
            deptos = new ArrayList<>();
        }
    %>
</head>
<body>
    <!-- Encabezado -->
    <div class="jumbotron text-center mb-4">
        <h1>Ejemplo Relaciones con JSP</h1>
        <p>Para el curso de JEE</p>
    </div>

    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">Navegación</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="ProcesaDepartamento">Lista de Departamentos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ProcesaEmpleado">Lista de Empleados</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">En Construcción</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Contenido principal -->
    <div class="container mt-4">
        <h2 class="mb-4">Resultados: Departamentos</h2>
        <table class="table table-hover table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Número Departamento</th>
                    <th scope="col">Nombre Departamento</th>
                    <th scope="col">Ubicación</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (!deptos.isEmpty()) {
                        for (Departamento depto : deptos) {
                %>
                    <tr>
                        <td><%= depto.getNumDepto() %></td>
                        <td><%= depto.getNombreDepto() %></td>
                        <td><%= depto.getUbicacionDepto() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="3" class="text-center">No se encontraron departamentos.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>

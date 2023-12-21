<%-- 
    Document   : listar
    Created on : 20 dic. 2023, 21:26:57
    Author     : LUCAS
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Mascotas"%>
<%@page import="dao.MascotasDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="./css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Mascotas</title>
    </head>
    <body style="display: flex;justify-content: center; align-items: center; min-height: 100vh">

          <div style="width: 95%;margin: auto;">

        <h1  style="text-align: center; margin-top: 15px;">Mascotas</h1>

        <a class="btn btn-success" href="Controller?accion=add" style="margin: 10px 0"> Agregar Mascotas </a>

        <table  class="table table-bordered" style="width: 100%;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>RAZA</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <%

                    MascotasDao dao = new MascotasDao();
                    List<Mascotas> list = dao.listarMascotas();
                    Iterator<Mascotas> iter = list.iterator();
                    Mascotas mascotas = new Mascotas();
                    while (iter.hasNext()) {

                        mascotas = iter.next();

                %>
                <tr>
                    <td>
                        <%= mascotas.getId()%>
                    </td>
                    <td>
                        <%= mascotas.getNombre()%>
                    </td>
                    <td>
                        <%= mascotas.getRaza()%>
                    </td>
                    <td>
                        <a class="btn btn-warning" href="Controller?accion=editar&id=<%= mascotas.getId()%>"> Editar </a>

                        <!-- Abrir modal eliminar mascotas -->
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#eliminarMascotas<%= mascotas.getId()%>">
                            Eliminar mascotas
                        </button>

                        <!-- Modal eliminar usuario-->
                        <div class="modal fade" id="eliminarMascotas<%= mascotas.getId()%>" tabindex="-1" aria-labelledby="eliminarMascotaLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="eliminarMascotaLabel"> Eliminar mascota </h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Se va a eliminar la mascota con nombre:  <%= mascotas.getNombre()%>  <br>
                                        ¿Confirma acción?
                                    </div>
                                    <div class="modal-footer">
                                        <a class="btn btn-danger" href="Controller?accion=eliminar&id=<%= mascotas.getId()%>"> Eliminar </a>
                                        <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </td>
                </tr>
                <%                        }
                %>
            </tbody>
        </table>

    </div>


    <script src="./js/bootstrap.js" type="text/javascript"></script>
</body>
</html>

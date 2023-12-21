<%-- 
    Document   : editar
    Created on : 20 dic. 2023, 21:27:20
    Author     : LUCAS
--%>

<%@page import="dao.MascotasDao"%>
<%@page import="model.Mascotas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar mascotas</title>
    </head>
    <body style="display: flex;justify-content: center; align-items: center; min-height: 100vh;">

        <div style="width: 50%; min-height: 40vh; background-color: #f5f5f5; border-radius:  1rem; margin: auto;position: relative;">
            <%
                MascotasDao mascotasDao = new MascotasDao();
                int id = Integer.parseInt(request.getAttribute("idMascotas").toString());
                Mascotas mascotas = (Mascotas) mascotasDao.verMascota(id);
            %>
            <h1 style="text-align: center; margin: 15px 0;"> Editar mascotas </h1>
            <form  style="width: 95%; margin: auto;">

                <input type="hidden" name="txtId" value="<%= mascotas.getId()%>"> <br>


                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanNombre">Nombre : </span>
                    <input type="text" name="txtNombre" class="form-control" aria-label="Nombre" aria-describedby="input nombre" value="<%= mascotas.getNombre()%>">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="spanRaza">Raza : </span>
                    <input type="text" name="txtRaza" class="form-control" aria-label="raza" aria-describedby="input raza" value="<%= mascotas.getRaza()%>">
                </div>

                <div style=" width: 50%; margin: auto; display: flex; justify-content: space-between; align-items: center;height: 6rem;">
                    <input class="btn btn-warning" type="submit" name="accion" value="actualizar">
                    <a class="btn btn-success" href="Controller?accion=listar"> Regresar </a>
                </div>
            </form>
        </div>

    </body>
</html>

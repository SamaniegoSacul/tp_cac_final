package controller;

import dao.MascotasDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mascotas;


public class Controller extends HttpServlet { 
    
    String listar = "vistas/listar.jsp";
    String add = "vistas/agregar.jsp";
    String edit = "vistas/editar.jsp";
    Mascotas mascotas = new Mascotas();
    MascotasDao mascotasDao = new MascotasDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("agregar")) {

            String nombre = request.getParameter("txtNombre");
            String raza = request.getParameter("txtRaza");

            mascotas.setNombre(nombre);
            mascotas.setRaza(raza);

            mascotasDao.agregar(mascotas);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idMascotas", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("actualizar")) {

            String id = request.getParameter("txtId");
            String nombre = request.getParameter("txtNombre");
            String raza = request.getParameter("txtRaza");

            mascotas.setId(Integer.parseInt(id));
            mascotas.setNombre(nombre);
            mascotas.setRaza(raza);

            mascotasDao.editar(mascotas);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            mascotas.setId(id);
            mascotasDao.borrar(id);
            acceso=listar;
        }

        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
       
}

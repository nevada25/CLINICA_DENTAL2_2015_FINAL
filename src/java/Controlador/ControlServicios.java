/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import bean.Categoria_servicio;
import bean.Servicio;
import dao.Categoria_servicioDao;
import dao.ServicioDao;
import daoimpl.Categoria_servicioDaoImpl;
import daoimpl.ServicioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NEVADA
 */
public class ControlServicios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*SERVICIOS*/
    String id_cat_serv=request.getParameter("id_cat_serv");
   String nombreser=request.getParameter("nombreser");
   String premax=request.getParameter("premax");
   String premin=request.getParameter("premin");
   String precio=request.getParameter("precio");
   String estado=request.getParameter("estado");
   /*FIN SERVICIOS*/
       /*CATEGORIA SERVICIOS*/
        Categoria_servicio catse = new Categoria_servicio();
        String opcion = request.getParameter("opcion");
        opcion = opcion == null ? "" : opcion;
        String acciones = request.getParameter("acciones");
        acciones = acciones == null ? "" : acciones;
        String nombre = request.getParameter("servicio");
        nombre = nombre == null ? "" : nombre;
        String mensaje = "";
        String alert = "";
        String id_servicio = request.getParameter("id_servicio");
        id_servicio = id_servicio == null ? "" : id_servicio;
        /*FIN SERVICIOS*/
        switch (opcion) {
            case "CatSer":
                if (acciones.equals("Actualizar")) {
                    Categoria_servicio catser = new Categoria_servicio();
                    catser.setId_cat_serv(id_servicio);
                    catser.setNombre_cat_serv(nombre);
                    Categoria_servicioDao dao = new Categoria_servicioDaoImpl();
                    if (dao.actualizarServicio(catser)) {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=ACTUALIZADO CORRECTAMENTE&alert=success").forward(request, response);
                        request.getAttribute("alert,success");
                    } else {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=ERROR AL ACTUALIZAR&alert=danger").forward(request, response);
                        request.getAttribute("alert,danger");
                    }
                }
                if (acciones.equals("Registrar")) {
                    Categoria_servicio catser = new Categoria_servicio();
                    catser.setNombre_cat_serv(nombre);
                    Categoria_servicioDao dao = new Categoria_servicioDaoImpl();
                    if (dao.agregarServicio(catser)) {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=success").forward(request, response);
                        request.getAttribute("alert,success");
                    } else {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=ERROR AL REGISTRAR&alert=danger").forward(request, response);
                        request.getAttribute("alert,danger");
                    }
                }
                if (acciones.equals("Eliminar")) {
                    Categoria_servicioDao das = new Categoria_servicioDaoImpl();
                    if (das.eliminasercategoriaser(Integer.parseInt(id_servicio))) {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=ELIMINO correctamente&alert=success").forward(request, response);
                        request.getAttribute("alert,success");
                    } else {
                        request.getRequestDispatcher("servicios/CatSer-Principal.jsp?mensaje=ERROR AL ELIMINAR&alert=danger").forward(request, response);
                        request.getAttribute("alert,danger");
                    }
                }
                break;
            case "ForServi":
                  if (acciones.equals("Registrar")) {

                      Servicio ser = new Servicio();
        ser.setNombre_serv(nombreser);
        ser.setId_cat_serv(id_cat_serv);
        ser.setPrecio_min(premin);
        ser.setPrecio_max(premax);
        ser.setPrecio(precio);
        ser.setEstado(estado);
                      ServicioDao dao = new ServicioDaoImpl();
        if (dao.fn_crud_servicio(ser, 1)) {
             request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=info&estado=bien").forward(request, response);
            request.getAttribute("alert,info");
            request.getAttribute("estado,bien");
        } else {
             request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=ERROR AL REGISTRAR&&alert=danger&estado=mal").forward(request, response);
            request.getAttribute("alert,danger");
            request.getAttribute("alert,mal");
        }
    }
    if (acciones.equals("Eliminar")) {
        ServicioDao dao = new ServicioDaoImpl();
        Servicio ser=new Servicio();
        ser.setId_servicio(id_servicio);
        if (dao.fn_crud_servicio(ser,3)) {
            request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=ELIMINO CORRECTAMENTE&alert=success&estado=bien").forward(request, response);
            request.getAttribute("alert,success");
            request.getAttribute("estado,bien");
        } else {
             request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=ERROR AL ELIMINAR&alert=danger&estado=mal").forward(request, response);
            request.getAttribute("alert,danger");
            request.getAttribute("alert,mal");
        }
    }
    

   if (acciones.equals("Actualizar")) {
       ServicioDao dao = new ServicioDaoImpl(); 
       String nombreServicio = request.getParameter("Servicio");
            String id_categoria = request.getParameter("id_categoria");
            String precio_min = request.getParameter("precio_min");
            String precio_max = request.getParameter("precio_max");
            Servicio servicio=new Servicio();
            servicio.setId_servicio(id_servicio);
            servicio.setId_cat_serv(id_categoria);
            servicio.setNombre_serv(nombreServicio);
            servicio.setPrecio_max(precio_max);
            servicio.setPrecio_min(precio_min);
            servicio.setEstado("1");
            if (dao.fn_crud_servicio(servicio,2)) {
                 request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=Actualizo Correctamente&alert=info&estado=bien").forward(request, response);
                request.getAttribute("alert,info");
                request.getAttribute("estado,bien");
            } else {
                 request.getRequestDispatcher("servicios/Servi-Principal.jsp?mensaje=ERROR AL ACTUALIZAR&alert=danger&estado=mal").forward(request, response);
                request.getAttribute("alert,danger");
                request.getAttribute("alert,mal");
            }
    }
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

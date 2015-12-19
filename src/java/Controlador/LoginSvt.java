package Controlador;

import bean.Usuario;
import dao.UsuarioDao;
import daoimpl.UsuarioDaoImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class LoginSvt extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");usuario = usuario == null ? "" : usuario;
    String clave = request.getParameter("clave");clave = clave == null ? "" : clave;
    String claveant = request.getParameter("claveant");claveant = claveant == null ? "" : claveant;
    String clavenue = request.getParameter("clavenue");clavenue = clavenue == null ? "" : clavenue;
    String nombres = request.getParameter("nombres"); nombres = nombres == null ? "" : nombres;
    String foto = request.getParameter("foto");foto = foto == null ? "" : foto;
    String correo = request.getParameter("correo");correo = correo == null ? "" : correo;
    String tipo_rol = request.getParameter("tipo_rol");tipo_rol = tipo_rol == null ? "" : tipo_rol;
    String acciones = request.getParameter("acciones");acciones = acciones == null ? "" : acciones;
    String salir = request.getParameter("salir");salir = salir == null ? "" : salir;
    String mensaje = request.getParameter("mensaje");
    HttpSession session= request.getSession();
    if (mensaje == null) {
        mensaje = "";
    }
    String alert = request.getParameter("alert");
    if (alert == null) {
        alert = "";
    }


    String insertar_usuario_emp = request.getParameter("insertar_usuario_emp");
    insertar_usuario_emp = insertar_usuario_emp == null ? "" : insertar_usuario_emp;

    String id_usuario = request.getParameter("id_usuario");
    mensaje = mensaje == null ? "" : mensaje;
    id_usuario = id_usuario == null ? "" : id_usuario;
        Usuario user = new Usuario();
    UsuarioDao dao = new UsuarioDaoImpl();
    if (acciones.equals("Actualizar")) {
        UsuarioDao as = new UsuarioDaoImpl();
       user.setId_usuario(Integer.parseInt(id_usuario));
            user.setNombre_usuario(usuario);
            user.setPassword(clavenue);
            user.setEmail(correo);
            if (dao.updateUsuario(user)) {
                request.getRequestDispatcher("index.jsp?mensaje=SE ACTUALIZO CORRECTAMENTE").forward(request, response);

            } else {
                request.getRequestDispatcher("index.jsp?mensaje=ERROR AL ACTUALIZAR").forward(request, response);
            }
        }

    
    if (acciones.equals("registrar")) {
        
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload sfu= new ServletFileUpload(fileItemFactory);
        String foto1 = "C:\\Users\\NEVADA\\Documents\\Nueva carpeta\\CENTRO_ODONTO\\web\\imagen\\usuarios\\";
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(1024);
        factory.setRepository(new File(foto1));
        ServletFileUpload upload=new ServletFileUpload(factory);
        UsuarioDao as = new UsuarioDaoImpl();
        user.setNombre_usuario(usuario);
        user.setId_usuario(Integer.parseInt(insertar_usuario_emp));
        user.setEmail(correo);
        user.setPassword(clave);
        try {
           List<FileItem> partes=upload.parseRequest(request);
          for (FileItem items: partes) {
                File file=new File(foto1,items.getName());
                items.write(file);
                user.setFoto(items.getName());
                } 
         } catch (Exception e) {
        }
        
         if (dao.agregarUsuario(user)) {
            request.getRequestDispatcher("login-principal.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=success ").forward(request, response);
            request.getAttribute("alert,success");
        } else {
            request.getRequestDispatcher("login-principal.jsp?mensaje=ERROR AL REGISTRAR&alert=danger").forward(request, response);
            request.getAttribute("alert,danger");
        }
       
        

    }
 if (acciones.equals("validar")) {
        if (usuario != null & clave != null) {
            if (dao.validarUsuario(usuario, clave).getNombre_usuario() != null||dao.validarUsuario(usuario, clave).getEmail() != null) {
                session.setAttribute("id_usuario", dao.validarUsuario(usuario, clave).getId_usuario());
                session.setAttribute("usuario", dao.validarUsuario(usuario, clave).getNombre_usuario());
                session.setAttribute("correo", dao.validarUsuario(usuario, clave).getEmail());
                session.setAttribute("foto", dao.validarUsuario(usuario, clave).getFoto());
                response.sendRedirect("MenuSVT?opcion=Bienvenida");
            } else {
                request.getRequestDispatcher("login-principal.jsp?mensaje=USUARIO NO EXISTE INTENTE NUEVAMENTE&alert=danger").forward(request, response);
                request.getAttribute("alert,danger");
            }
        }
    }

    if (acciones.equals("Eliminar")) {
        UsuarioDao as = new UsuarioDaoImpl();
        if (as.deleteUsuario(Integer.parseInt(id_usuario))) {
            request.getRequestDispatcher("menu.jsp?mensaje=ELIMINO correctamente&alert=infor").forward(request, response);
            request.getAttribute("alert,info");
        } else {
            request.getRequestDispatcher("menu.jsp?mensaje=ERROR AL ELIMINAR&alert=danger").forward(request, response);
            request.getAttribute("alert,danger");
        }
    }
    if (salir.equals("cerrar")) {
    session.removeAttribute("usuario");
   request.getRequestDispatcher("login-principal.jsp?mensaje=SESIÓN CERRADA&alert=info").forward(request, response);
 }
 if (request.getParameter("salir")==null) {
    salir="";
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

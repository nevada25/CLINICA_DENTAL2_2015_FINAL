<%@page import="daoimpl.UsuarioDaoImpl"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="bean.Usuario"%>

<%
    String usuario = request.getParameter("usuario");
    usuario = usuario == null ? "" : usuario;
    String clave = request.getParameter("clave");
    clave = clave == null ? "" : clave;
    String claveant = request.getParameter("claveant");
    claveant = claveant == null ? "" : claveant;
    String clavenue = request.getParameter("clavenue");
    clavenue = clavenue == null ? "" : clavenue;
    String nombres = request.getParameter("nombres");
    nombres = nombres == null ? "" : nombres;
    String foto = request.getParameter("foto");
    foto = foto == null ? "" : foto;
    String correo = request.getParameter("correo");
    correo = correo == null ? "" : correo;
    String tipo_rol = request.getParameter("tipo_rol");
    tipo_rol = tipo_rol == null ? "" : tipo_rol;
    String acciones = request.getParameter("acciones");
    acciones = acciones == null ? "" : acciones;
    String salir = request.getParameter("salir");
    salir = salir == null ? "" : salir;
    String mensaje = request.getParameter("mensaje");
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
                response.sendRedirect("index.jsp?mensaje=SE ACTUALIZO CORRECTAMENTE");

            } else {
                response.sendRedirect("index.jsp?mensaje=ERROR AL ACTUALIZAR");
            }
        }

    
    if (acciones.equals("registrar")) {
        UsuarioDao as = new UsuarioDaoImpl();
        user.setId_usuario(Integer.parseInt(insertar_usuario_emp));
        user.setNombre_usuario(usuario);
        user.setPassword(clave);
        user.setNombres(nombres);
        user.setEmail(correo);

        if (dao.agregarUsuario(user)) {
            response.sendRedirect("loginprincipal.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=success ");
            request.getAttribute("alert,success");
        } else {
            response.sendRedirect("loginprincipal.jsp?mensaje=ERROR AL REGISTRAR&alert=danger");
            request.getAttribute("alert,danger");
        }

    }
 if (acciones.equals("validar")) {
        if (usuario != null & clave != null) {
            if (dao.validarUsuario(usuario, clave).getNombre_usuario() != null||dao.validarUsuario(usuario, clave).getEmail() != null) {
                 
                session.setAttribute("id_usuario", dao.validarUsuario(usuario, clave).getId_usuario());
                session.setAttribute("usuario", dao.validarUsuario(usuario, clave).getNombre_usuario());
                session.setAttribute("correo", dao.validarUsuario(usuario, clave).getEmail());
                response.sendRedirect("index.jsp?mensaje=Bienvenido "+dao.validarUsuario(usuario, clave).getNombre_usuario());
            } else {
                response.sendRedirect("loginprincipal.jsp?mensaje=USUARIO NO EXISTE INTENTE NUEVAMENTE&alert=danger");
                request.getAttribute("alert,danger");
            }
        }
    }

    if (acciones.equals("Eliminar")) {
        UsuarioDao as = new UsuarioDaoImpl();
        if (as.deleteUsuario(Integer.parseInt(id_usuario))) {
            response.sendRedirect("menu.jsp?mensaje=ELIMINO correctamente&alert=infor");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("menu.jsp?mensaje=ERROR AL ELIMINAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
%>

<%
    if (!id_usuario.equals("") && !acciones.equals("Eliminar")) {
        UsuarioDao das = new UsuarioDaoImpl();
        Usuario usera = das.DatosUsuario(Integer.parseInt(id_usuario));
%>
<%@include file="cabeza.jsp" %>
<div class="col-lg-3"></div>
<div style="background: white; padding: 50px; border-radius: 12px; text-align: center;" class="col-lg-6"  >

    <div class="lc-block " id="l-register" >
        <form name="usuario" method="post" action="login_form.jsp" autocomplete="off">
            <input type="hidden" name="id_usuario" value="<%=id_usuario%>"/>
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <label>INGRESE NUEVO USUARIO</label>
                    <input type="text" class="form-control" id="servicio" name="usuario" value="<%=usera.getNombre_usuario()%>" placeholder="">
                </div>
            </div>
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-mail"></i></span>
                <div class="fg-line">
                    <label>CONTRASE&Ntilde;A ANTERIOR</label>
                    <input type="password" class="form-control" id="servicio" name="claveant" value="<%=usera.getPassword()%>" placeholder="">
                </div>
            </div>
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-mail"></i></span>
                <div class="fg-line">
                    <label>CONTRASE&Ntilde;A NUEVA</label>
                    <input type="password" class="form-control" id="servicio" name="clavenue" value="<%=usera.getPassword()%>" placeholder="">
                </div>
            </div>
            <%
                if (!mensaje.equals("")) {
            %>
            <div class="alert   alert-<%=alert%> " role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <%=mensaje%>
            </div>
            <%}%>
            <div class="clearfix">
                <center>
                    <button  type="submit" name="acciones" value="Actualizar" class="btn btn-login btn-lg btn-success "><i class="lg ">ACTUALIZAR</i></button>
                </center>
            </div>
        </form>
    </div>

</div>      
<div class="col-lg-3"></div>
<%@include file="pie.jsp" %>
<%} else {%>

<form name="agre_usu"  id="agre_usu" action="login_form.jsp" method="POST">

    <div class="modal-body">
        <center>
            <h1><b>AGREGAR USUARIO</b></h1>
        </center>
        <div class="form-group">
            <div class="col-lg-2"><div class="resuls"></div></div>
            <div class="col-lg-8">
                <div class="form-group">
                    <input type="email" class="form-control" id="servicio" name="correo" placeholder="INGRESE CORREO">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="servicio" name="usuario"  placeholder="INGRESE USUARIO">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="servicio" name="clave"  placeholder="INGRESE CLAVE O CONTRASE&Ntilde;A">
                </div>
                <div class="form-group">
                    <select name="tipo_rol" style="color: black;" class="form-control">
                        <option>SELECCIONAR TIPO DE ROL</option>
                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                        <option value="USUARIO">USUARIO</option>
                    </select>    </div>

            </div>
            <div class="col-lg-2"></div>
            <center>
                <button value="Registrar" name="acciones" class="btn-lg btn-success" ><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success " ></span>GUARDAR</button>
            </center>
        </div>
    </div>
</form>

<%}%>
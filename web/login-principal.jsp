<%@page import="bean.Empleado"%>
<%@page import="daoimpl.EmpleadoDaoImpl"%>
<%@page import="dao.EmpleadoDao"%>
<%@page import="daoimpl.personadaoimpl"%>
<%@page import="dao.personadao"%>
<%@include file="login-top.jsp" %>

<%            String mensaje = request.getParameter("mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
    String alert = request.getParameter("alert");
    if (alert == null) {
        alert = "";
    }


%>
<div class="block toggled" style="margin-top: 230px;">
    <!-- Login -->
    <div class="lc-block toggled" id="l-login">

        <form method="post" action="LoginSvt">
            <div class="input-group m-b-20">

                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <input type="text" class="form-control" name="usuario" placeholder="INGRESE SU USUARIO">
                </div>
            </div>

            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-accessibility"></i></span>
                <div class="fg-line">
                    <input type="password" name="clave" class="form-control" placeholder="INGRESE CONTRASE&Ntilde;A">
                </div>
            </div>
<div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <%=mensaje%>
            </div>
            <div class="clearfix"></div>
            <button type="submit" name="acciones" value="validar" class="btn btn-login btn-danger btn-float"><i  class="md md-arrow-forward"></i></button>
            <ul class="login-navigation">
                <li data-block="#l-register" class="bgm-red">Registro</li>
            </ul>
        </form> 
    </div>

    <!-- Register -->
    <div class="lc-block" id="l-register">
        <form method="post" action="LoginSvt?acciones=registrar">
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <input type="text" class="form-control" name="usuario" placeholder="INGRESE SU USUARIO">
                </div>
            </div>
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <select name="insertar_usuario_emp" class="form-control">
                        <option>SELECCIONES NOMBRE</option>
                        <%  EmpleadoDao dao = new EmpleadoDaoImpl();
                            for (Empleado asd : dao.mostrarempleado()) {
                        %>
                        <option value="<%=asd.getId_empleado()%>" class="text-black"><%=asd.getNombres()%></option>
                        <%}%>
                    </select>
                </div>
            </div>  
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-mail"></i></span>
                <div class="fg-line">
                    <input type="text" name="correo" class="form-control" placeholder="INGRESE SU CORREO">
                </div>
            </div>

            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-accessibility"></i></span>
                <div class="fg-line">
                    <input type="password" name="clave" class="form-control" placeholder="INGRESE CONTRASE&Ntilde;A">
                </div>
            </div>
            <div class="input-group m-b-20">
                  <input type="file" name="file" class="form-control">
             </div>
            <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <%=mensaje%>
            </div>

            <div class="clearfix"></div>
            <button  type="submit" name="acciones" value="registrar" class="btn btn-login btn-danger btn-float"><i class="md md-arrow-forward"></i></button>

            <ul class="login-navigation">
                <li data-block="#l-login" class="bgm-green">Iniciar sesión</li>
            </ul>
        </form>
    </div>
</div>


<%@include file="login-botton.jsp" %>
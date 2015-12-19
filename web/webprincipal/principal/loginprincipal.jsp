<%@page import="bean.Empleado"%>
<%@page import="daoimpl.EmpleadoDaoImpl"%>
<%@page import="dao.EmpleadoDao"%>
<%@page import="daoimpl.personadaoimpl"%>
<%@page import="dao.personadao"%>
<%@include file="top_login.jsp" %>
 <%            String mensaje = request.getParameter("mensaje");
                if (mensaje == null) {
                    mensaje = "";
                }
                String alert = request.getParameter("alert");
                if (alert == null) {
                    alert = "";
                }
                   String salir = request.getParameter("salir");salir = salir == null ? "" : salir;
            %>
 <!-- Login -->
        <div class="lc-block toggled" id="l-login">
            
            <form method="post" action="login_form.jsp?acciones=validar">
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
                <% 
                if(!mensaje.equals("")){
                %>
                <meta http-equiv="refresh" content="2,url=loginprincipal.jsp">
             <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <%=mensaje%>
                            </div>
                            <%}%>
            <div class="clearfix"></div>
            <button type="submit" class="btn btn-login btn-danger btn-float"><i  class="md md-arrow-forward"></i></button>
            <ul class="login-navigation">
                <li data-block="#l-register" class="bgm-red">Registro</li>
            </ul>
</form> 
        </div>
           
        <!-- Register -->
        <div class="lc-block" id="l-register">
            <form method="post" action="login_form.jsp?acciones=registrar">
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
                        <%
                            EmpleadoDao dao=new EmpleadoDaoImpl();
                        for(Empleado asd:dao.mostrarempleado()){
                        %>
                        <option value="<%=asd.getId_empleado()%>"></option>
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
                <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <%=mensaje%>
                            </div>
               
            <div class="clearfix"></div>
            <button  type="submit" class="btn btn-login btn-danger btn-float"><i class="md md-arrow-forward"></i></button>>
            
            <ul class="login-navigation">
                <li data-block="#l-login" class="bgm-green">Iniciar sesión</li>
            </ul>
             </form>
        </div>
                                <%
                                  
 if (salir.equals("cerrar")) {
    session.removeAttribute("usuario");
   
 }
 if (request.getParameter("salir")==null) {
    salir="";
 }
%>
        
        <%@include file="botton_login.jsp" %>
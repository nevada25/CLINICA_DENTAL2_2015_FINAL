
<%@page import="daoimpl.UsuarioDaoImpl"%>
<%@page import="dao.UsuarioDao"%>

<%@include file="top_login.jsp" %>
<!-- Begin # Login Form -->
<form id="login-form" method="post" action="login_form.jsp?acciones=validar">

    <div class="modal-body">
        <div id="div-login-msg">
            <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
            <%                                    String mensaje = request.getParameter("mensaje");
                if (mensaje == null) {
                    mensaje = "";
                }
                String alert = request.getParameter("alert");
                if (alert == null) {
                    alert = "";
                }
                   String salir = request.getParameter("salir");salir = salir == null ? "" : salir;
            %>

            <div ></div>


        </div>
        <input id="login_username" name="usuario" class="form-control" type="text" placeholder="usuario" >
        <input id="login_username" name="tipo" type="hidden" value="1">
        <input id="login_password" name="clave" class="form-control" type="password" placeholder="Clave" >

    </div>
    <div class="modal-footer">
        <div>
            <button type="submit" class="btn btn-primary btn-lg btn-block">Iniciar sesión</button>
        </div>
        <div>
            <a href="login_form.jsp"  data-toggle="modal" data-target="#agre_usu"> <button id="login_register_btn" type="button" class="btn btn-link" >REGISTRATE</button></a>
        </div>

    </div>
</form>

<%@include file="bottonlogin.jsp" %>

<!-- End # Login Form -->

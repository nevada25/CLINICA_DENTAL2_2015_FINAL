<%@page import="daoimpl.UsuarioDaoImpl"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="bean.Usuario"%>


    

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
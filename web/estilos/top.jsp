
<%@page import="daoimpl.Tipo_docDaoImpl"%>
<%@page import="dao.Tipo_docDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>BIENVENIDOS</title>
  <meta charset="utf-8">
  <meta charset="iso-8859-2">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon"  href="img/home.ico"/>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="jquery/jquery-2.1.4.min.js"></script>
  <link rel="stylesheet" href="estilos/loginnuevo.css">
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="jquery/registrar.js"></script>
  <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  label{
      text-align: left;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background:#000000 ; /* Green */
      color: #ffffff;
  }
  .bg-2 { 
      background-color: #474e5d; /* Dark Blue */
      color: #ffffff;
  }
  .bg-3 { 
      background-color: #ffffff; /* White */
      color: #555555;
  }
  .bg-4 { 
      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 14px;
      letter-spacing: 3px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
  </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top" style="height: 80px;">
  <div class="container">
      <form action="menuloginSVT" method="POST" >
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
        <a class="navbar-brand" href="login2.jsp">PERUANO JAPONES</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="padding-right: -10px;">
        <ul class="nav navbar-nav navbar-right" >
            <li><a href="galeria.jsp">GALERIA</a></li>
            <li><a role="button" data-toggle="modal" data-target="#myModal">REGISTRATE</a></li>
        <li><a role="button" data-toggle="modal" data-target="#login-modal">INICIAR SESSI&Oacute;N</a></li>
      </ul>
    </div>
      </form>
  </div>
</nav>
<!-- BEGIN # BOOTSNIP INFO -->

<!-- BEGIN # MODAL LOGIN -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" align="center">
					<img class="img-circle" id="img_logo" src="http://bootsnipp.com/img/logo.jpg">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <form id="login-form" action="inicio.jsp">
		                <div class="modal-body">
				    		<div id="div-login-msg">
                                <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-login-msg">Escriba su nombre de usuario y contraseña.</span>
                            </div>
				    		<input id="login_username" class="form-control" type="text" placeholder="USUARIO" required>
				    		<input id="login_password" class="form-control" type="password" placeholder="CONTRASE&Ntilde;A" required>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Acuérdate de mí
                                </label>
                            </div>
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Iniciar sesión</button>
                            </div>
				    	    <div>
                                <button id="login_lost_btn" type="button" class="btn btn-link">¿Contraseña perdida?</button>
                                <button id="login_register_btn" type="button" class="btn btn-link">Registro</button>
                            </div>
				        </div>
                    </form>
                    <!-- End # Login Form -->
                    
                    <!-- Begin | Lost Password Form -->
                    <form id="lost-form" style="display:none;">
    	    		    <div class="modal-body">
		    				<div id="div-lost-msg">
                                <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-lost-msg">Escriba su dirección de e-mail.</span>
                            </div>
		    				<input id="lost_email" class="form-control" type="text" placeholder="CORREO" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">ACEPTAR</button>
                            </div>
                            <div>
                                <button id="lost_login_btn" type="button" class="btn btn-link">Iniciar sesión</button>
                                <button id="lost_register_btn" type="button" class="btn btn-link">Registro</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Lost Password Form -->
                    
                    <!-- Begin | Register Form -->
                    <form id="register-form" style="display:none;">
            		    <div class="modal-body">
		    				<div id="div-register-msg">
                                <div id="icon-register-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-register-msg">REGISTRAR USUARIO</span>
                            </div>
		    				<input id="register_username" class="form-control" type="text" placeholder="USUARIO" required>
                            <input id="register_email" class="form-control" type="text" placeholder="CORREO" required>
                            <input id="register_password" class="form-control" type="password" placeholder="CONTRASE&Ntilde;A" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">REGISTRO</button>
                            </div>
                            <div>
                                <button id="register_login_btn" type="button" class="btn btn-link">Iniciar sesión</button>
                                <button id="register_lost_btn" type="button" class="btn btn-link">¿Contraseña perdida?</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Register Form -->
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    <!-- END # MODAL LOGIN -->
    
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #101010;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       <h1 class="modal-title " id="myModalLabel" style="margin: 20px; "><b><center>REGISTRO</center></b></h1>
      </div>
      <div class="modal-body">
      <form class="form-horizontal " style=" color: #000000;padding:1.5px;">
            
            <%--separador--%>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">USUARIO</label>
            <div class="col-sm-8">
                <input type="text" class="form-control"  name="usuario" id="usuario" placeholder="USUARIO">
            </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">CONTRASE&Nacute;A</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="CONTRASE&Nacute;A">
            </div>
            </div>
            <%--separador--%>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">NOMBRE</label>
            <div class="col-sm-8">
                <input type="text" class="form-control"  name="nombre" id="nombre" placeholder="NOMBRE">
            </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-5 control-label" style="text-align: justify;">APELLIDO PATERNO</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" name="ape_pat" id="ape_pat" placeholder="APELLIDO PATERNO">
            </div>
            </div>
             <%--separador--%>
            <div class="form-group">
                <label  class="col-sm-5 control-label" style="text-align: justify;">APELLIDO MATERNO</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" name="ape_mat" id="ape_mat" placeholder="APELLIDO MATERNO">
            </div>
            </div>
             <div class="form-group">
                <label  class="col-sm-5 control-label" style="text-align: justify;">FECHA NACIMIENTO</label>
            <div class="col-sm-7">
                <input type="date">
            </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-5 control-label" style="text-align: justify;">TIPO DOCUMENTO</label>
            <div class="col-sm-7">
             
            </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">NRO.DOCUMENTO</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="dni" id="dni" placeholder="NRO.DOCUMENTO">
            </div>
            </div>
            <%--separador--%>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">CORREO</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="correo" id="correo" placeholder="CORREO">
            </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">CELULAR</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="celular" id="celular" placeholder="CELULAR">
            </div>
            </div>
            <%--separador--%>
            <div class="form-group">
                <div class="col-lg-2"></div>
                <div class="col-lg-4">
             <label class="col-lg-2 control-label" for="radios">SEXO</label>
  <div class="col-lg-2">
  
  
  </div>
</div>
                <div class="form-group col-lg-4">
                    <div class="radio ">
    <label for="radios-1">
      <input type="radio" name="radios" id="radios-1" value="2">
      <b>MASCULINO</b>
    </label>
	</div>
                
                <div class="radio col-lg-4">
    <label for="radios-0">
      <input type="radio" name="radios" id="radios-0" value="1" checked="checked">
      <b>FEMENINO</b>
    </label>
	</div>
                    </div>
                <div class="col-lg-2"></div>
            </div>  
            <div class="form-group">
                <label  class="col-sm-4 control-label" style="text-align: justify;">DIRECCI&Oacute;N</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="direccion" id="direccion" placeholder="DIRECCI&Oacute;N">
            </div>
            </div>
            
            
          </form>
      </div>
      <div class="modal-footer">
        <div class="col-lg-4 col-md-2 col-sm-1 col-xs-0"></div>
                    <button type="button" class="btn btn-primary glyphicon glyphicon-ok col-lg-4 col-md-8 col-sm-10 col-xs-12"></button>
                <div class="col-lg-4 col-md-2 col-sm-1 col-xs-0"></div>
      </div>
    </div>
  </div>
</div>
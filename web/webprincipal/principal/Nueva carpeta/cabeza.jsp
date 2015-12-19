<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BIENVENIDO</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">

    <link rel="shortcut icon"  href="../../img/1447842109_user-admin.ico" />
    <!-- Font Awesome -->
    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js_ajaxper/funcionajax.js"></script>
    <script type="text/javascript" src="../../js_ajaxper/jquery-1.2.1.pack.js"></script>
    <script type="text/javascript" src="../../js_ajaxper/eventos.js"></script>
    <script type="text/javascript" src="../../js_ajaxper/funciones.js"></script>
    <script  src="../../js/menu.js"></script>
    <script src="../../js/menuprincipal.js"></script>
     <!-- Vendor CSS -->
        <link href="vendors/animate-css/animate.min.css" rel="stylesheet">
        <link href="vendors/sweet-alert/sweet-alert.min.css" rel="stylesheet">
        <link href="vendors/material-icons/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="vendors/socicon/socicon.min.css" rel="stylesheet">
   
        <!-- CSS -->
        <link href="css/app.min.1.css" rel="stylesheet">
        <link href="css/app.min.2.css" rel="stylesheet">
        <link href="../../img/Nueva carpeta (2)/LOGOCD.jpg">
   <style>
       .navbar-login
{
    width: 305px;
    padding: 10px;
    padding-bottom: 0px;
}

.navbar-login-session
{
    padding: 10px;
    padding-bottom: 0px;
    padding-top: 0px;
}

.icon-size
{
    font-size: 87px;
}
.page-header {
    margin-top: -5px;
}

.sidebar {
    padding-left: 0;
}

.main-container { 
    background: #FFF;
    padding-top: 15px;
    margin-top: -20px;
}

.footer {
    width: 100%;
}  

:focus {
    outline: none;
}

.side-menu {
    position: relative;
    width: 100%;
    height: 100%;
    background-color: #f8f8f8;
    border-right: 1px solid #e7e7e7;
}
.side-menu .navbar {
    border: none;
}
.side-menu .navbar-header {
    width: 100%;
    border-bottom: 1px solid #e7e7e7;
}
.side-menu .navbar-nav .active a {
    background-color: transparent;
    margin-right: -1px;
    border-right: 5px solid #e7e7e7;
}
.side-menu .navbar-nav li {
    display: block;
    width: 100%;
    border-bottom: 1px solid #e7e7e7;
}
.side-menu .navbar-nav li a {
    padding: 15px;
}
.side-menu .navbar-nav li a .glyphicon {
    padding-right: 10px;
}
.side-menu #dropdown {
    border: 0;
    margin-bottom: 0;
    border-radius: 0;
    background-color: transparent;
    box-shadow: none;
}
.side-menu #dropdown .caret {
    float: right;
    margin: 9px 5px 0;
}
.side-menu #dropdown .indicator {
    float: right;
}
.side-menu #dropdown > a {
    border-bottom: 1px solid #e7e7e7;
}
.side-menu #dropdown .panel-body {
    padding: 0;
    background-color: #f3f3f3;
}
.side-menu #dropdown .panel-body .navbar-nav {
    width: 100%;
}
.side-menu #dropdown .panel-body .navbar-nav li {
    padding-left: 15px;
    border-bottom: 1px solid #e7e7e7;
}
.side-menu #dropdown .panel-body .navbar-nav li:last-child {
    border-bottom: none;
}
.side-menu #dropdown .panel-body .panel > a {
    margin-left: -20px;
    padding-left: 35px;
}
.side-menu #dropdown .panel-body .panel-body {
    margin-left: -15px;
}
.side-menu #dropdown .panel-body .panel-body li {
    padding-left: 30px;
}
.side-menu #dropdown .panel-body .panel-body li:last-child {
    border-bottom: 1px solid #e7e7e7;
}
.side-menu #search-trigger {
    background-color: #f3f3f3;
    border: 0;
    border-radius: 0;
    position: absolute;
    top: 0;
    right: 0;
    padding: 15px 18px;
}
.side-menu .brand-name-wrapper {
    min-height: 50px;
}
.side-menu .brand-name-wrapper .navbar-brand {
    display: block;
}
.side-menu #search {
    position: relative;
    z-index: 1000;
}
.side-menu #search .panel-body {
    padding: 0;
}
.side-menu #search .panel-body .navbar-form {
    padding: 0;
    padding-right: 50px;
    width: 100%;
    margin: 0;
    position: relative;
    border-top: 1px solid #e7e7e7;
}
.side-menu #search .panel-body .navbar-form .form-group {
    width: 100%;
    position: relative;
}
.side-menu #search .panel-body .navbar-form input {
    border: 0;
    border-radius: 0;
    box-shadow: none;
    width: 100%;
    height: 50px;
}
.side-menu #search .panel-body .navbar-form .btn {
    position: absolute;
    right: 0;
    top: 0;
    border: 0;
    border-radius: 0;
    background-color: #f3f3f3;
    padding: 15px 18px;
}
/* Main body section */
.side-body {
    margin-left: 310px;
}
/* small screen */
@media (max-width: 768px) {
    .side-menu {
        position: relative;
        width: 100%;
        height: 0;
        border-right: 0;
    }

    .side-menu .navbar {
        z-index: 999;
        position: relative;
        height: 0;
        min-height: 0;
        background-color:none !important;
        border-color: none !important;
    }
    .side-menu .brand-name-wrapper .navbar-brand {
        display: inline-block;
    }
    /* Slide in animation */
    @-moz-keyframes slidein {
        0% {
            left: -300px;
        }
        100% {
            left: 10px;
        }
    }
    @-webkit-keyframes slidein {
        0% {
            left: -300px;
        }
        100% {
            left: 10px;
        }
    }
    @keyframes slidein {
        0% {
            left: -300px;
        }
        100% {
            left: 10px;
        }
    }
    @-moz-keyframes slideout {
        0% {
            left: 0;
        }
        100% {
            left: -300px;
        }
    }
    @-webkit-keyframes slideout {
        0% {
            left: 0;
        }
        100% {
            left: -300px;
        }
    }
    @keyframes slideout {
        0% {
            left: 0;
        }
        100% {
            left: -300px;
        }
    }
    /* Slide side menu*/
    /* Add .absolute-wrapper.slide-in for scrollable menu -> see top comment */
    .side-menu-container > .navbar-nav.slide-in {
        -moz-animation: slidein 300ms forwards;
        -o-animation: slidein 300ms forwards;
        -webkit-animation: slidein 300ms forwards;
        animation: slidein 300ms forwards;
        -webkit-transform-style: preserve-3d;
        transform-style: preserve-3d;
    }
    .side-menu-container > .navbar-nav {
        /* Add position:absolute for scrollable menu -> see top comment */
        position: fixed;
        left: -300px;
        width: 100px;
        top: 43px;
        height: 100%;
        border-right: 1px solid #e7e7e7;
        background-color: #ffffff;
        overflow: auto;
        -moz-animation: slideout 300ms forwards;
        -o-animation: slideout 300ms forwards;
        -webkit-animation: slideout 300ms forwards;
        animation: slideout 300ms forwards;
        -webkit-transform-style: preserve-3d;
        transform-style: preserve-3d;
    }
    @-moz-keyframes bodyslidein {
        0% {
            left: 0;
        }
        100% {
            left: 300px;
        }
    }
    @-webkit-keyframes bodyslidein {
        0% {
            left: 0;
        }
        100% {
            left: 300px;
        }
    }
    @keyframes bodyslidein {
        0% {
            left: 0;
        }
        100% {
            left: 300px;
        }
    }
    @-moz-keyframes bodyslideout {
        0% {
            left: 300px;
        }
        100% {
            left: 0;
        }
    }
    @-webkit-keyframes bodyslideout {
        0% {
            left: 300px;
        }
        100% {
            left: 0;
        }
    }
    @keyframes bodyslideout {
        0% {
            left: 300px;
        }
        100% {
            left: 0;
        }
    }
    /* Slide side body*/
    .side-body {
        margin-left: 5px;
        margin-top: 30px;
        position: relative;
        -moz-animation: bodyslideout 300ms forwards;
        -o-animation: bodyslideout 300ms forwards;
        -webkit-animation: bodyslideout 300ms forwards;
        animation: bodyslideout 300ms forwards;
        -webkit-transform-style: preserve-3d;
        transform-style: preserve-3d;
    }
    .body-slide-in {
        -moz-animation: bodyslidein 300ms forwards;
        -o-animation: bodyslidein 300ms forwards;
        -webkit-animation: bodyslidein 300ms forwards;
        animation: bodyslidein 300ms forwards;
        -webkit-transform-style: preserve-3d;
        transform-style: preserve-3d;
    }
    /* Hamburger */
    .navbar-toggle-sidebar {
        border: 0;
        float: left;
        padding: 18px;
        margin: 0;
        border-radius: 0;
        background-color: #f3f3f3;
    }
    /* Search */
    #search .panel-body .navbar-form {
        border-bottom: 0;
    }
    #search .panel-body .navbar-form .form-group {
        margin: 0;
    }
    .side-menu .navbar-header {
        /* this is probably redundant */
        position: fixed;
        z-index: 3;
        background-color: #f8f8f8;
    }
    /* Dropdown tweek */
    #dropdown .panel-body .navbar-nav {
        margin: 0;
    }
}

        </style>
        <script type="text/javascript">
            $(function () {
  	$('.navbar-toggle-sidebar').click(function () {
  		$('.navbar-nav').toggleClass('slide-in');
  		$('.side-body').toggleClass('body-slide-in');
  		$('#search').removeClass('in').addClass('collapse').slideUp(200);
  	});

  	$('#search-trigger').click(function () {
  		$('.navbar-nav').removeClass('slide-in');
  		$('.side-body').removeClass('body-slide-in');
  		$('.search-input').focus();
  	});
  });
   
        </script>
  </head>

  <body style="background: url(../../img/dsa/green_cup.png)" >
         <%
        if(session.getAttribute("usuario")==null||session.getAttribute("correo")==null ){
        response.sendRedirect("../principal/loginprincipal.jsp");
        }
        
        %>   
      <header>  
          <div class="container" >
            <div class="row">
                <div class="col-sm-12 col-md-12">      
<nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
                        MENU
                    </button>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../servletJSP/controlBienvenida.jsp?opcion=INICIO">
                        CENTRO ODONTOLOGICO
                    </a>
                    
                </div><!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
          <li class="active"><a href="../principal/index.jsp" class="glyphicon glyphicon-home"> INICIO <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle glyphicon glyphicon-folder-open" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> REGISTROS<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="../servletJSP/controlBienvenida.jsp?opcion=Servicios">SERVICIOS</a></li>
              <li><a href="../cate_ser/index.jsp">CATEGORIA</a></li>
            <%---INICIO SEGUNDA---%>
            <li class="dropdown"><a href="../servletJSP/controlBienvenida.jsp?opcion=regis_histo">HISTORIA CLINICA</a></li>
            <li role="separator" class="divider"></li>
            
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle glyphicon glyphicon-th-list" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> CONSULTAS<span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="../servletJSP/controlBienvenida.jsp?opcion=busca_cliente"><span class="glyphicon glyphicon-search"></span>BUSCAR CLIENTES</a></li>
            <li><a href="../servletJSP/controlBienvenida.jsp?opcion=cliente_fecha"><span class="glyphicon glyphicon-search"></span>CLIENTE-FECHA</a></li>
          </ul>
        </li>
      </ul>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
                    
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="" target="_blank"></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-cog"></span> 
                                <strong><%=session.getAttribute("usuario")%></strong>
                                <span class="glyphicon glyphicon-chevron-down"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="navbar-login">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <p class="text-center">
                                                    <span class="glyphicon glyphicon-user icon-size"></span>
                                                </p>
                                            </div>
                                            <div class="col-lg-8">


                                                <p class="text-left"><strong><%=session.getAttribute("usuario")%></strong></p>

                                                <p class="text-left small"><%=session.getAttribute("correo")%></p>

                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="navbar-login navbar-login-session">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <p>
                                                    <a href="../principal/loginprincipal.jsp?salir=cerrar" class="btn btn-danger btn-block">Cerrar Sesion</a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
         </div>
                </div></div>
      </header>
              <div class="container" style=" background: white; padding: 15px; margin-top: -15px; padding-top: 60px;">                
                  
                 
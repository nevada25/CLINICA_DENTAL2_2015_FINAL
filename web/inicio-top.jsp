<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BIENVENIDOS</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="admin/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="admin/ionicons.min.css">
    <!-- Theme style -->
      <link rel="stylesheet" href="admin/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="admin/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="admin/plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="admin/plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="admin/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="admin/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <!-- Vendor CSS -->
    <link href="login/vendors/animate-css/animate.min.css" rel="stylesheet">
        <link href="login/vendors/sweet-alert/sweet-alert.min.css" rel="stylesheet">
        <link href="login/vendors/material-icons/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="login/vendors/socicon/socicon.min.css" rel="stylesheet">
   <link rel="shortcut icon"  href="img/1447842109_user-admin.ico" />
   <script src="alertify/dist/js/alertify.min.js"></script>
        <link rel="stylesheet" href="alertify/dist/css/alertify.css" />
        <link rel="stylesheet" href="alertify/styles.css" />
        <link rel="stylesheet" href="alertify/dist/css/alertify.default.css" />
        <script>
    $(function (){
    var availableTags= new Array();
    $("#tags").bind("keydown",function(event){
        var data={nombre:$("#tags").val()};
        $.getJSON("buscar",data,function (res,est,jqXHR){
            availableTags.length=0;
            $.each();
        });
    
    });        
    
            
            
            </script>
  </head>
     <%
        if(session.getAttribute("usuario")==null||session.getAttribute("correo")==null ){
        response.sendRedirect("login-principal.jsp");
        }
        
        %>   
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

      <header class="main-header">
        <!-- Logo -->
        <a href="MenuSVT?opcion=Bienvenida" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>CO</b>PJ</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Centro</b>Odonto</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Navegación de palanca</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">Usted tiene 4 mensajes</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                          </div>
                          <h4>
                           Equipo de apoyo
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <p>¿Por qué no comprar un nuevo tema impresionante?</p>
                        </a>
                      </li><!-- end message -->
                      
                      
                    </ul>
                  </li>
                  <li class="footer"><a href="#">Ver todos los mensajes</a></li>
                </ul>
              </li>
              <li class="dropdown tasks-menu">
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="img/<%=session.getAttribute("foto")%>" class="user-image" alt="User Image">
                  <span class="hidden-xs"><%=session.getAttribute("usuario")%></span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                      <img src="img/<%=session.getAttribute("foto")%>" class="img-circle" alt="User Image">
                    <p>
                      <%=session.getAttribute("usuario")%>
                      <small><%=session.getAttribute("correo")%></small>
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">seguidores</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Ventas</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Amigos</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Perfil</a>
                    </div>
                    <div class="pull-right">
                      <a href="LoginSvt?salir=cerrar" class="btn btn-default btn-flat">desconectar</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="img/<%=session.getAttribute("foto")%>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p><%=session.getAttribute("usuario")%></p>
              <a href="#"><i class="fa fa-circle text-success"></i> En línea</a>
            <br>
            </div>
              <br><br><br>
          </div>
              
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">NAVEGACIÓN PRINCIPAL</li>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i><span>REGISTROS</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="MenuSVT?opcion=PriCatSer"><i class="fa fa-circle-o"></i>CATE_SERVICIOS</a></li>
                <li><a href="MenuSVT?opcion=PrinServi"><i class="fa fa-circle-o"></i>SERVICIOS</a></li>
                <li class="active"><a href="MenuSVT?opcion=PrinClien"><i class="fa fa-circle-o"></i>HISTO_CLINICA</a></li>
                <li><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
                <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
                <li><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
              </ul>
            </li>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i><span>VENTAS</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
                <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i>VENTAS</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>CLIENTE</a></li>
              </ul>
            </li>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i><span>COMPRAS</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
                 <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i>COMPRAS</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>PROVEEDOR</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>CONSULTAS VENTAS</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i>POR FECHA</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>POR DETALLE</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>MENSUAL</a></li>
              </ul>
            </li>
            <li>
             <a href="#">
                <i class="fa fa-files-o"></i>
                <span>CONSULTAS VENTAS</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i>POR FECHA</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>POR DETALLE</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>MENSUAL</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>Charts</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> ChartJS</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Morris</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Flot</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Inline charts</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-laptop"></i>
                <span>UI Elements</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> General</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Icons</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Buttons</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Sliders</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Timeline</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Modals</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-edit"></i> <span>Forms</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> General Elements</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Advanced Elements</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Editors</a></li>
              </ul>
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        
        <!-- Main content -->
        <section class="content container ">

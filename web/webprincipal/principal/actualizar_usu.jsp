<%@page import="bean.Usuario"%>
<%@page import="daoimpl.UsuarioDaoImpl"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@page import="bean.Categoria_servicio"%>
<%@page import="dao.ServicioDao"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@page import="bean.Servicio"%>

<%
    String id_usuario = request.getParameter("id_usuario");
    String opcion = request.getParameter("opcion");
    int id = Integer.parseInt(id_usuario);
%>
<%@include file="../principal/cabeza.jsp" %>
<style>
            div.controltotal{

              
                padding: 20px;
                width: 500px;
              
                margin: 50px;
                border-radius:0px 50px 0px 50px ;

            }
            input.form-control{
                color: white; 
                background: #03a9f4;
            }
option.form-control{
                color: white; 
                background: #03a9f4;
            }
            select.form-control{
                color: white; 
                background: #03a9f4;
            }
        </style>
        <link  rel="stylesheet" href="bootstrap/css/bootstrap.css" >
    </head>
    <body>
    <center>
        <%
            UsuarioDao daousu= new UsuarioDaoImpl();
           Usuario ser=daousu.DatosUsuario(id);
        %>
        <div class="controltotal" style="color: black;">
            <div style="text-align: center;"><h1>DATOS SERVICIOS</h1></div>
            <br><br>
            <form name="servicio" method="post" action="login_form.jsp?opcion=Actualizar">
                <div  class="form-group">
                    <label for="ususario"> NOMBRE DE USUARIO</label>
                    <input type="hidden" class="form-control" name="id_usuario" value="<%=id_usuario%>" style='width:213px; height:35px' id="serv" placeholder="USUARIO">
                    <input type="hidden" name="opcion" value="actualizar" style='width:213px; height:35px' id="serv" placeholder="USUARIO">
                    <input type="text" class="form-control" name="username" value="<%=ser.getNombre_usuario()%>" style='width:213px; height:35px' id="usuario" placeholder="NOMBRE USUARIO">
                </div>
                <div class="form-group">
                    <label class="control-label">CONTRASE&Ntilde;A</label>
                    <input class="form-control"  type="text" name="clave" value="<%=ser.getPassword()%>" style='width:213px; color: white; background: #03a9f4; height:35px' placeholder="Precio_min.">
                </div>
                <button type="submit" class="btn btn-success glyphicon glyphicon-refresh" style='width:100px; height:35px'>Actualizar</button>
            </form>
                    <script type="text/javascript">
                        document.servicio.nombre_usuario.value='<%=ser.getNombre_usuario()%>';
                        document.servicio.password.value='<%=ser.getPassword()%>';
                    </script>    
        </div>
                 
    </center>
                    <%@include file="../principal/pie.jsp" %>
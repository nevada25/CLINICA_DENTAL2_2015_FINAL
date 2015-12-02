<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@page import="bean.Categoria_servicio"%>
<%@page import="dao.ServicioDao"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@page import="bean.Servicio"%>

<%
    String id_servicio = request.getParameter("id_servicio");
    String opcion = request.getParameter("opcion");
    int id = Integer.parseInt(id_servicio);
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
            ServicioDao daoser = new ServicioDaoImpl();
           Servicio ser=daoser.BuscarServicio(id);
        %>
        <div class="controltotal" style="color: black;">
            <div style="text-align: center;"><h1>DATOS SERVICIOS</h1></div>
            <br><br>
            <form name="servicio" method="post" action="serv_form.jsp?opcion=Actualizar">
                <div  class="form-group">
                    <label for="serv">Servicio:</label>
                    <input type="hidden" class="form-control" name="id_servicio" value="<%=id_servicio%>" style='width:213px; height:35px' id="serv" placeholder="Servicio">
                    <input type="hidden" name="opcion" value="actualizar" style='width:213px; height:35px' id="serv" placeholder="Servicio">
                    <input type="text" class="form-control" name="Servicio" value="<%=ser.getNombre_serv()%>" style='width:213px; height:35px' id="serv" placeholder="Servicio">
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-12">Categoria:</label>
                    <select name="id_categoria" class="form-control" style='width:213px; height:35px'>   <%--un combobox con el nombre operaciones--%>
                        <%
                        Categoria_servicioDao daocatser = new Categoria_servicioDaoImpl();
                            for (Categoria_servicio catser : daocatser.listarServicio()) {
                        %>
                        <option  value="<%=catser.getId_cat_serv()%>"><%=catser.getNombre_cat_serv()%></option> <%--opciones para el combox--%>
                        <%}%>
                    </select>
                </div>

                <div class="form-group">
                    Precio min.:<input class="form-control"  type="text" name="precio_min" value="<%=ser.getPrecio_min()%>" style='width:213px; color: white; background: #03a9f4; height:35px' placeholder="Precio_min.">
                </div>
                <div class="form-group">
                    Precio max.:<input class="form-control" type="text" name="precio_max" value="<%=ser.getPrecio_max()%>" style='width:213px; height:35px' placeholder="Precio_max.">
                </div>
                <a class="btn btn-danger glyphicon glyphicon-chevron-left" href="index.jsp" role="button">VOLVER</a>
                <button type="submit" class="btn btn-success glyphicon glyphicon-refresh" style='width:100px; height:35px'>Actualizar</button>
            </form>
                    <script type="text/javascript">
                        document.servicio.id_categoria.value='<%=ser.getId_cat_serv()%>';
                    </script>    
        </div>
                 
    </center>
                    <%@include file="../principal/pie.jsp" %>
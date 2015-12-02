<%@page import="daoimpl.ServicioDaoImpl"%>
<%@page import="dao.ServicioDao"%>
<%@page import="bean.Servicio"%>
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
<%
    ServicioDao dao = new ServicioDaoImpl();
%>
<%!
    String buscar, limit;
%>
<%
    buscar = request.getParameter("buscar");
    if (buscar == null) {
        buscar = "";
    }
    limit = request.getParameter("limit");
    if (limit == null) {
        limit = "";
    }
    if (limit.equals("")) {
        limit = "10";
    }

%>
    <link rel="shortcut icon"  href="../../img/1447842109_user-admin.ico" />
    <!-- Font Awesome -->
    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    <body >
<center>
    <div style="margin: 50px;">
         <div class="form-control" style="border: none;">
             <form name="buscar" method="post" action="reporte_serv.jsp">
                    <input class="col-lg-6" name="buscar" value="<%=buscar%>" placeholder="BUSCAR..." style="border-radius: 0.5em;">
                    <select name="limit"  class="control-label col-lg-2" onchange="document.buscar.submit()">
                        <option value="10">10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                        <option value="200">200</option>
                        <option value="500">500</option>
                    </select>
                    <input type="submit" class="col-lg-2" name="Buscar" value="Buscar" class="btn btn-default"/>
                    <a href="" onclick="print()" target="_blank" class="btn btn-info col-lg-2">Imprimir</a>
                </form>
        <center><h1><b >REPORTE SERVICIOS</b></h1></center>
         <table class="table table-bordered text-bold text-info table-striped">
                    <div class="modal fade" id="editar2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header" >
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>ACTUALIZAR CATEGORIA</b></h3>
                                </div>
                                <div class="modal-body" style="padding:40px 50px;">  
                                    <div id="resul"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <thead>
                        <tr>
                            <td>#</td>
                            <th>Categoria</th>
                            <th>Nombre servicio</th>
                            <th>Precio Max</th>
                            <th>Precio Min</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int x = 0;
                           
                            for (Servicio ser : dao.listarServicioedi(buscar, limit)) {
                                x = x + 1;
                        %>
                        <tr>

                            <td><%=x%></td>
                            <td><%=ser.getNombre_cat_serv()%></td>
                            <td><%=ser.getNombre_serv()%></td>
                            <td><%=ser.getPrecio_max()%></td>
                            <td><%=ser.getPrecio_min()%></td>
                            

                        </tr>
                        <%}%>


                        </tr>

                </table>
</div>
</center>
                        <script type="text/javascript">
                    document.buscar.limit.value = '<%=limit%>';
</script>
</body>
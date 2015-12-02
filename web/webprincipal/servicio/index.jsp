
<%@page import="dao.ServicioDao"%>
<%@page import="bean.Servicio"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@include file="../principal/cabeza.jsp" %>
<div class="container form-group">
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
        limit = "5";
    }
 String mensaje,alert ,estado;
    mensaje = request.getParameter("mensaje");  if (mensaje == null) {mensaje = "";}
            alert=request.getParameter("alert");if(alert==null){alert="";}
estado=request.getParameter("estado");if(estado==null){estado="";}
%>
<div class="col-lg-2"></div>
<div class="col-lg-8 form-group">
    
    <%----------%>
    
    <div class="card " >
                        <div class="card-header">
                            <h2>Lista de servicios</h2><% 
                if(!mensaje.equals("")){
                %>
                <meta http-equiv="refresh" content="2,url=index.jsp">
             <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <%=mensaje%> <img src="../../img/<%=estado%>.png"/>
                            </div>
                            <%}%>
                        </div>
                        
                        <div class="table-responsive">
                            <table class="table table-striped">
                                 <div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header" >
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>ACTUALIZAR CATEGORIA</b></h3>
                                </div>
                                <div class="modal-body" >  
                                    <div id="catego_resul"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                                <div class="modal fade" id="agregarser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content" >
                                <div class="modal-header" >
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR CATEGORIA</b></h3>
                                </div>
                                <div class="modal-body">  
                                    <div id="agregar_resul"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                                <thead>
                                    <form name="buscar" method="post" action="index.jsp">
                                    <tr>
                                        
                                    <input class="col-lg-6" name="buscar" value="<%=buscar%>" placeholder="BUSCAR..." style="border-radius: 0.5em;">
                                       <select name="limit"  class="control-label col-lg-2" onchange="document.buscar.submit()">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                        <option value="200">200</option>
                                        <option value="500">500</option>
                                            </select>
                                    <input type="submit" class="col-lg-2" name="Buscar" value="Buscar" class="btn btn-default"/>
                                    <a href="reporte_serv.jsp" target="_blank" class="btn btn-info col-lg-2">Imprimir</a>
                                       
                                    </tr>
                                     </form>
                                </thead>
                                <tbody>
                                    <tr>
                                        <tr>
                                            <td class="col-lg-1">#</td>
                                        <th class="col-lg-2">Categoria</th>
                                        <th class="col-lg-7">Nombre servicio</th>
                                        <th class="col-lg-1">Precio Min</th>
                                        <th class="col-lg-1">Precio Max</th>
                                        <th colspan="2" class="col-lg-2"><a class="btn icon-btn btn-success"  href="javascrip:void(0)" onclick="javascrip:agregar_servicio()" type="button"  data-toggle="modal" data-target="#agregarser"><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>AGREGAR</a></th>
                                        </tr>
                                    </tr>
                                       <%
                                            int x = 0;
                                            ServicioDao daoserv = new ServicioDaoImpl();
                                            for (Servicio servicio : daoserv.listarServicioedi(buscar, limit)) {
                                                x = x + 1;
                                        %> 
                                    <tr>
                                     
                                    <td class="col-lg-1"><%=x%></td>
                                    <td class="col-lg-2"><%=servicio.getNombre_cat_serv()%></td>
                                    <td class="col-lg-3"><%=servicio.getNombre_serv()%></td>
                                    <td class="col-lg-1"><%=servicio.getPrecio_min()%></td>
                                    <td class="col-lg-2"><%=servicio.getPrecio_max()%></td>
                                    <td class="col-lg-1" ><a  href="servicioform.jsp?id_servicio=<%=servicio.getId_servicio()%>"><center><button type="button" class="btn  btn-success" type="button"><i class="glyphicon glyphicon-edit"></i></button></center></a></td>
                                    <td  class="col-lg-1"><a href="serv_form.jsp?opcion=Eliminar&id_servicio=<%=servicio.getId_servicio()%>"><center><button type="button" class="btn  btn-danger "><i class="glyphicon glyphicon-remove"></i></button></center></a></td>
                                    
                                      </tr>
                        <%}%>
                                   </tbody>
                            </table>
                        </div>
                    </div>
</div>
                           <div class="col-lg-2"></div>
<script type="text/javascript">
                    document.buscar.limit.value = '<%=limit%>';
</script>

<script type="text/javascript">
    function editar_servicio(id_servicio)
    {
        $("#catego_resul").hide("slow");
        $("#catego_resul").load("serv_form.jsp?id_servicio=" + id_servicio, "", function () {
            $("#catego_resul").show("slow");
        });
    }
    function agregar_servicio()
    {
        $("#agregar_resul").hide("slow");
        $("#agregar_resul").load("serv_form.jsp", function () {
            $("#agregar_resul").show("slow");
        });
    }
</script>
</div>
<%@include file="../principal/pie.jsp" %>
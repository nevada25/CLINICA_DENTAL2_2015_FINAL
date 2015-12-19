<%@page import="dao.ServicioDao"%>
<%@page import="bean.Servicio"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@include file="../inicio-top.jsp" %>
<div class="form-group" style="margin: -30px;">
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

<div class="box">
  <div class="box-header with-border">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
      <center><h2 class="box-title text-blue"><b>LISTA DE  SERVICIOS</b></h2></center>
      </div>
      <div class="col-lg-4">
          
<% 
                if(!mensaje.equals("")){
                %>
                <meta http-equiv="refresh" content="2,url=MenuSVT?opcion=PrinServi">
                <div class="alert alert-<%=alert%> alert-dismissible form-control" role="alert" style="margin: -15px; height: 50px;">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <%=mensaje%>
                            </div>
                            <%}%>
      </div>
  </div>
  <div class="box-body">
    
<div class="col-lg-2"></div>
<div class="col-lg-8 form-group">
    
    <%----------%>
    
    <div class="card " >
                        <div class="card-header">
                            
                        </div>
                        
                        <div class="table-responsive">
                            <table class="table table-striped">
                                
                                <thead >
                                 <form name="buscar" action="MenuSVT?opcion=PrinServi" method="POST" style="margin: 15px;">
                                    <tr >
                                   <input class="col-lg-3 form-control" style="width: 350px; margin-right: 5px;" name="buscar" value="<%=buscar%>" placeholder="BUSCAR..." style="border-radius: 0.5em;">
                                       <select name="limit"  class="form-control col-lg-2" style="width: 60px; margin-right: 5px;" onchange="document.buscar.submit()">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                        <option value="200">200</option>
                                        <option value="500">500</option>
                                            </select>
                                    <input type="submit" class="col-lg-2 btn-primary form-control" style="width: 100px; margin-right: 5px;" name="buscar" value="buscar" class="btn btn-default"/>
                                    <a href="javascript:void(0)"  onclick="javascript:reporte_cate()" type="button"   data-toggle="modal" data-target="#reporte" class="btn btn-info"><i class="fa-paste" style="width: 200px;"></i></a>
                                    </tr>
                                     </form>
                                </thead>
                                <tbody>
                                    <tr>
                                        <tr>
                                            <td class="col-lg-1">#</td>
                                        <th class="col-lg-3">Categoria</th>
                                        <th class="col-lg-3">Nombre servicio</th>
                                        <th class="col-lg-1">Precio Min</th>
                                        <th class="col-lg-1">Precio Max</th>
                                        <th colspan="2" class="col-lg-2"><a class="btn icon-btn btn-success" href="javascrip:void(0)" onclick="javascrip:agregar_servicio()" type="button"  data-toggle="modal" data-target="#agregarser" ><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>AGREGAR</a></th>
                                        </tr><%---------%>
                                    </tr>
                                       <%
                                            int x = 0;
                                            ServicioDao daoserv = new ServicioDaoImpl();
                                            for (Servicio servicio : daoserv.listarServicioedi(buscar, limit)) {
                                                x = x + 1;
                                        %> 
                                    <tr>
                                     
                                    <td class="col-lg-1"><%=x%></td>
                                    <td class="col-lg-3"><%=servicio.getNombre_cat_serv()%></td>
                                    <td class="col-lg-3"><%=servicio.getNombre_serv()%></td>
                                    <td class="col-lg-1"><%=servicio.getPrecio_min()%></td>
                                    <td class="col-lg-1"><%=servicio.getPrecio_max()%></td>
                                    <td class="col-lg-1" ><a href="javascript:void(0)" onclick="javascript:editar_servicio('<%=servicio.getId_servicio()%>') "  data-toggle="modal" data-target="#editarser"><center><button type="button" class="btn  btn-success" type="button"><i class="glyphicon glyphicon-edit"></i></button></center></a></td>
                                    <td  class="col-lg-1"><a href="ControlServicios?opcion=ForServi&acciones=Eliminar&id_servicio=<%=servicio.getId_servicio()%>"><center><button type="button" class="btn  btn-danger "><i class="glyphicon glyphicon-remove"></i></button></center></a></td>
                                    <%--------%>
                                      </tr>
                        <%}%>
                                   </tbody>
                            </table>
                        </div>
                    </div>
</div>
                           <div class="col-lg-2"></div>
  </div>
</div>
<script type="text/javascript">
                    document.buscar.limit.value = '<%=limit%>';
</script>

<script type="text/javascript">
    function editar_servicio(id_servicio)
    {
        $("#catego_resul").hide("slow");
        $("#catego_resul").load("servicios/Servi-Form.jsp?opcion=update&id_servicio=" + id_servicio, "", function () {
            $("#catego_resul").show("slow");
        });
    }
    function agregar_servicio()
    {
        $("#agregar_resul").hide("slow");
        $("#agregar_resul").load("servicios/Servi-Form.jsp?opcion=insert", function () {
            $("#agregar_resul").show("slow");
        });
    }
</script>
</div>
<%@include file="../inicio-botton.jsp" %>
<%---INICIO MODALES---%>
 <div class="modal fade modal-success" id="editarser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

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
                                <div class="modal fade modal-primary" id="agregarser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

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
 <%---FIN MODALES---%>
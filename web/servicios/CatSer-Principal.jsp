<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@include file="../inicio-top.jsp" %>
<%
    Categoria_servicioDao dao = new Categoria_servicioDaoImpl();
%>
<%!
    String buscar, limit;
%>
  <%            String mensaje = request.getParameter("mensaje");
                if (mensaje == null) {
                    mensaje = "";
                }
                String alert = request.getParameter("alert");
                if (alert == null) {
                    alert = "";
                }

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

%>
<%-------%>

<div class="box" style="margin: -30px;">
  <div class="box-header with-border">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
      <center><h2 class="box-title text-blue"><b>LISTA DE  CATEGORIA</b></h2></center>
      </div>
      <div class="col-lg-4">
          
<% 
                if(!mensaje.equals("")){
                %>
                <meta http-equiv="refresh" content="2,url=MenuSVT?opcion=PriCatSer">
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
    <div class="card " >
                        <div class="card-header">
                        
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead >
                                 <form name="buscar" action="MenuSVT?opcion=PriCatSer" method="POST" style="margin: 15px;">
                                    <tr >
                                   <input class="col-lg-3 form-control" style="width: 450px; margin-right: 5px;" name="buscar" value="<%=buscar%>" placeholder="BUSCAR..." style="border-radius: 0.5em;">
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
                                    <tr style="margin-top: 10px;">
                                    <tr class="info" >
                                            <td class="col-lg-1">#</td>
                                        <th class="col-lg-2">Categoria</th>
                                        <th class="col-lg-7" colspan="2"><a class="btn icon-btn btn-success"  href="javascript:void(0)"  onclick="javascript:agregar_categoria()" type="button"   data-toggle="modal" data-target="#agregar"><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>AGREGAR</a></th>
                                       
                                        </tr>
                                    </tr>
                                     <%
                            int x = 0;
                            for (Categoria_servicio daa : dao.listarServicios(buscar, limit)) {
                                x = x + 1;
                        %>
                        <tr>
                            <td class="col-lg-1"><%=x%></td>
                            <td class="col-lg-9"><%=daa.getNombre_cat_serv()%></td>

                            <td class="col-lg-1"><center>
                        <a href="javascript:void(0)" onclick="javascript:editar_categoria('<%=daa.getId_cat_serv()%>')" class="btn btn-info btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editar"></a></center>


                    </td>
                    <td class="col-lg-1"><a href="ControlServicios?opcion=CatSer&acciones=Eliminar&id_servicio=<%=daa.getId_cat_serv()%>"><center><button type="button" class="btn  btn-danger "><i class="glyphicon glyphicon-trash"></i></button></center></a></td>

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
    function editar_categoria(id_servicio)
    {
        $("#catego_resul").hide("slow");
        $("#catego_resul").load("servicios/CatSe-Form.jsp?id_servicio=" + id_servicio, "", function () {
            $("#catego_resul").show("slow");
        });
    }
     function agregar_categoria()
    {
        $("#agregar_resul").hide("slow");
        $("#agregar_resul").load("servicios/CatSe-Form.jsp", function () {
            $("#agregar_resul").show("slow");
        });
    }
     function reporte_cate()
    {
        $("#report_resul").hide("slow");
        $("#report_resul").load("servicios/CatSe-Form.jsp", function () {
            $("#report_resul").show("slow");
        });
    }
</script>
<%-----INICIO MODALDES---%>
                                <%-----INICIO MODAL EDITAR---%>
                                <div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content" >
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
                                <%-----FIN MODAL EDITAR---%>
                                <%-----INICIO MODAL REPORTE---%>
                                <div class="modal fade" id="reporte" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content" >
                                <div class="modal-header" >
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR CATEGORIA</b></h3>
                                </div>
                                <div class="modal-body" >  
                                    <div id="report_resul"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                                <%-----FIN MODAL REPORTE---%>
                                <%-----INICIO MODAL AGREGAR---%>
                                <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

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
                                <%-----FIN MODAL AGREGAR---%>
                                <%-----FIN MODALDES---%>
<%@include file="../inicio-botton.jsp" %>


<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>


<%@include file="../principal/cabeza.jsp" %>
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
<div class="col-lg-2"></div>
<div class="col-lg-8 form-group">
    
    <%----------%>
    
    <div class="card " >
                        <div class="card-header">
                            <h2>LISTA DE  CATEGORIA</h2>
                <% 
                if(!mensaje.equals("")){
                %>
                <meta http-equiv="refresh" content="2,url=index.jsp">
             <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                <%=mensaje%><img src="../../img/bien.png"/>
                            </div>
                            <%}%>
                        </div>
                        
                        <div class="table-responsive">
                            <table class="table table-striped">
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
                                <thead>
                                    
                                    <tr>
                                <form name="buscar" action="index.jsp" method="POST" >
                                    
                                
                                        
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
                                    <input type="submit" class="col-lg-2" name="buscar" value="buscar" class="btn btn-default"/>
                                    <a href="javascript:void(0)"  onclick="javascript:reporte_cate()" type="button"   data-toggle="modal" data-target="#reporte" class="btn btn-info col-lg-2">Imprimir</a>
                                    </form>
                                    </tr>
                                    
                                </thead>
                                <tbody>
                                    <tr>
                                        <tr>
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
                    <td class="col-lg-1"><a href="cat_ser_form.jsp?acciones=Eliminar&id_servicio=<%=daa.getId_cat_serv()%>"><center><button type="button" class="btn  btn-danger "><i class="glyphicon glyphicon-trash"></i></button></center></a></td>

                    </tr>
                
                    <%}%>
                                   </tbody>
                            </table>
                        </div>
                    </div>
</div>
 <div class="col-lg-2"></div>

<script type="text/javascript">
    function editar_categoria(id_servicio)
    {
        $("#catego_resul").hide("slow");
        $("#catego_resul").load("cat_ser_form.jsp?id_servicio=" + id_servicio, "", function () {
            $("#catego_resul").show("slow");
        });
    }
     function agregar_categoria()
    {
        $("#agregar_resul").hide("slow");
        $("#agregar_resul").load("cat_ser_form.jsp", function () {
            $("#agregar_resul").show("slow");
        });
    }
     function reporte_cate()
    {
        $("#report_resul").hide("slow");
        $("#report_resul").load("reporte_cat_serv.jsp", function () {
            $("#report_resul").show("slow");
        });
    }
</script>

<%@include file="../principal/pie.jsp" %>


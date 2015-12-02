<%@page import="daoimpl.ProductoDaoImpl"%>
<%@page import="dao.ProductoDao"%>
<%@page import="bean.Producto"%>
<%@include file="../principal/cabeza.jsp" %>
<%
   ProductoDao dao = new ProductoDaoImpl();
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
<%-------%>
<div class="col-lg-2"></div>
<div class="col-lg-8 form-group">
    
    <%----------%>
    
    <div class="card " >
                        <div class="card-header">
                            <h2>LISTA DE PRODUCTO</h2>
            <% 
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
                                    <a href="reporte_serv.jsp" target="_blank" class="btn btn-info col-lg-2">Imprimir</a>
                                    </form>
                                    </tr>
                                    
                                </thead>
                                <tbody>
                                    <tr>
                                        <tr>
                                            <td class="col-lg-1">#</td>
                                        <th class="col-lg-4">PRODUCTOS</th>
                                        <th class="col-lg-4">UNIDAD DE MEDIDA</th>
                                        <th class="col-lg-3" colspan="2"><a class="btn icon-btn btn-success"  href="javascript:void(0)"  onclick="javascript:agregar_categoria()" type="button"   data-toggle="modal" data-target="#agregar"><span  class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success" ></span>AGREGAR</a></th>
                                       
                                        </tr>
                                    </tr>
                                     <%
                            int x = 0;
                            for (Producto daa : dao.mostrarproductosaedidar(buscar, limit)) {
                                x = x + 1;
                        %>
                        <tr>
                            <td class="col-lg-1"><%=x%></td>
                           <td class="col-lg-2"><%=daa.getNombre_producto()%></td>
                          <td class="col-lg-2"><%=daa.getId_unidad_medida()%></td>
                            <td class="col-lg-2"><center>
                        <a href="javascript:void(0)" onclick="javascript:editar_categoria('<%=daa.getId_producto()%>')" class="btn btn-info btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editar"></a></center>


                    </td>
                    <td class="col-lg-1"><a href="Pro_form.jsp?acciones=Eliminar&id_producto=<%=daa.getId_producto()%>"><center><button type="button" class="btn  btn-danger "><i class=" glyphicon glyphicon-trash"></i></button></center></a></td>

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
</script>

<%@include file="../principal/pie.jsp" %>


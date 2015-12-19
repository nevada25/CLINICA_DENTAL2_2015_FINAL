<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%
    Categoria_servicio catse = new Categoria_servicio();
    String acciones = request.getParameter("acciones");
    acciones = acciones == null ? "" : acciones;
    String nombre = request.getParameter("servicio");
    nombre = nombre == null ? "" : nombre;
    String mensaje = "";
    String alert = "";
    String id_servicio = request.getParameter("id_servicio");
    id_servicio = id_servicio == null ? "" : id_servicio;
%>
<style>
    input{
        text-align: center;
    }
</style>
<%      
%>
<%
    if (!id_servicio.equals("") && !acciones.equals("Eliminar")) {
        Categoria_servicioDao das = new Categoria_servicioDaoImpl();
        Categoria_servicio catsers = das.datosServicio(Integer.parseInt(id_servicio));
%>
<form name="Categoria_servicio" method="post" action="ControlServicios?opcion=CatSer" autocomplete="off">
    <input type="hidden" name="id_servicio" value="<%=id_servicio%>"/>
    <div class="form-group">
            <input type="text" class="form-control" id="servicio" name="servicio" value="<%=catsers.getNombre_cat_serv()%>" placeholder="">
        </div>
        <div class="form-group">
            <center>
             <button  type="submit" name="acciones" value="Actualizar" class="btn btn-primary glyphicon glyphicon-saved"></button>
            <button type="button" class="btn btn-default glyphicon glyphicon-remove" data-dismiss="modal"></button>
            </center>
        </div>
    </form>
<%} else {%>

<form name="categoria_servicio" action="ControlServicios?opcion=CatSer" method="POST">
    
        <div class="form-group">
             <div class="form-group">
                <input type="text" class="form-control" id="servicio" name="servicio" placeholder="AGREGAR CATEGORIA">
            </div>
             <div class="form-group">
            <center>
            <button type="submit" name="acciones" value="Registrar" class="btn btn-primary glyphicon glyphicon-saved"></button>
            <button type="button" class="btn btn-default glyphicon glyphicon-remove" data-dismiss="modal"></button>
            </center>
             </div>
        </div>
    </form>

<%}%>


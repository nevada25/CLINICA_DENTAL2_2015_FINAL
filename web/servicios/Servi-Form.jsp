<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@page import="dao.ServicioDao"%>
<%@page import="bean.Servicio"%>

<%
    String id_servicio = request.getParameter("id_servicio");
    String opcion = request.getParameter("opcion");

%>


<%    if (opcion.equals("update")) {
        ServicioDao daoser = new ServicioDaoImpl();

        Servicio ser = daoser.BuscarServicio(Integer.parseInt(id_servicio));
%>
<form name="servicios" method="post" action="ControlServicios?opcion=ForServi&id_servicio=<%=id_servicio%>">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <div class="form-group">
            <label class="control-label col-lg-12">Categoria:</label>
            <select name="id_categoria" class="form-control"    <%--un combobox con el nombre operaciones--%>
                    <%
                        Categoria_servicioDao daocatser = new Categoria_servicioDaoImpl();
                        for (Categoria_servicio catser : daocatser.listarServicio()) {
                    %>
                    <option  value="<%=catser.getId_cat_serv()%>"><%=catser.getNombre_cat_serv()%></option> <%--opciones para el combox--%>
                <%}%>
            </select>
        </div>
        <div  class="form-group">
            <label for="serv">Servicio:</label>
            <input type="hidden" class="form-control" name="id_servicio" value="<%=id_servicio%>"  id="serv" placeholder="Servicio">
            <input type="hidden" name="opcion" value="actualizar"  id="serv" placeholder="Servicio">
            <input type="text" class="form-control" name="Servicio" value="<%=ser.getNombre_serv()%>"  id="serv" placeholder="Servicio">
        </div>
        <div class="form-group">
            Precio min.:<input class="form-control"  type="text" name="precio_min" value="<%=ser.getPrecio_min()%>"  placeholder="Precio_min.">
        </div>
        <div class="form-group">
            Precio max.:<input class="form-control" type="text" name="precio_max" value="<%=ser.getPrecio_max()%>"  placeholder="Precio_max.">
        </div>

    </div>
    <div class="col-lg-2"></div>
    <center>
        <button type="submit" class="btn btn-success glyphicon glyphicon-refresh " name="acciones" value="Actualizar">Actualizar</button>
        <button class="btn btn-danger glyphicon glyphicon-chevron-left" data-dismiss="modal" role="button">VOLVER</button>
    </center>
</form>

<script type="text/javascript">
    document.servicios.id_categoria.value = '<%=ser.getId_cat_serv()%>';
</script>       
<%}
    if (opcion.equals("insert")) {%>

<form name="servicios" action="ControlServicios?opcion=ForServi" method="POST">

    <div class="col-lg-2"><div class="resuls"></div></div>
    <div class="col-lg-8">
        <div class="form-group">
            <select name="id_cat_serv"    class="form-control"> 
                <option >SELECCIONAR CATEGORIA</option>
                <%
                    Categoria_servicioDao dse = new Categoria_servicioDaoImpl();
                    for (Categoria_servicio cats : dse.listarServicio()) {
                %>
                <option value="<%=cats.getId_cat_serv()%>"><%=cats.getNombre_cat_serv()%></option>
                <%}%>
            </select>
        </div>
        <style> input{margin: 4px;}</style>
        <div class="form-group">
            <input type="text" class="form-control" id="names" name="nombreser" placeholder="INGRESE SERVICIO" >
        </div>
        <div class="form-group">
            <input type="number" class="form-control" id="precio_min" name="premin" placeholder="INGRESE VALOR MINIMO" >
        </div>
        <div class="form-group">
            <input type="number" class="form-control" id="precio_min" name="premax" placeholder="INGRESE PRECIO MAXIMO" maxlength=2" >
        </div>


    </div>
    <div class="col-lg-2"></div>
    <center>
        <button type="submit" class="btn btn-success glyphicon glyphicon-refresh " >AGREGAR</button>
        <a class="btn btn-danger glyphicon glyphicon-chevron-left" data-dismiss="modal" role="button">VOLVER</a>

    </center>


</form>

<%}%>


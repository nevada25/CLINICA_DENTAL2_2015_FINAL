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

<%      if (acciones.equals("Actualizar")) {
        Categoria_servicio catser = new Categoria_servicio();
        catser.setId_cat_serv(id_servicio);
        catser.setNombre_cat_serv(nombre);
        Categoria_servicioDao dao = new Categoria_servicioDaoImpl();
        if (dao.actualizarServicio(catser)) {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ACTUALIZADO CORRECTAMENTE&alert=info");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ERROR AL ACTUALIZAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
    if (acciones.equals("Registrar")) {
        Categoria_servicio catser = new Categoria_servicio();
        catser.setNombre_cat_serv(nombre);
        Categoria_servicioDao dao = new Categoria_servicioDaoImpl();
        if (dao.agregarServicio(catser)) {
            response.sendRedirect("cat_ser_result.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=success");
            request.getAttribute("alert,success");
        } else {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ERROR AL REGISTRAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
    if (acciones.equals("Eliminar")) {
        Categoria_servicioDao das = new Categoria_servicioDaoImpl();
        if (das.eliminasercategoriaser(Integer.parseInt(id_servicio))) {
            response.sendRedirect("index.jsp?mensaje=ELIMINO correctamente&alert=infor");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("index.jsp?mensaje=ERROR AL ELIMINAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
%>
<%
    if (!id_servicio.equals("") && !acciones.equals("Eliminar")) {
        Categoria_servicioDao das = new Categoria_servicioDaoImpl();
        Categoria_servicio catsers = das.datosServicio(Integer.parseInt(id_servicio));
%>
<form name="Categoria_servicio" method="post" action="cat_ser_form.jsp" autocomplete="off">
    <input type="hidden" name="id_servicio" value="<%=id_servicio%>"/>
    <div class="form-group">
            <input type="text" style="color: white;"   class="form-control" id="servicio" name="servicio" value="<%=catsers.getNombre_cat_serv()%>" placeholder="">
        </div>
        <div class="form-group">
            <center>
             <button  type="submit" name="acciones" value="Actualizar" class="btn btn-primary glyphicon glyphicon-saved"></button>
            <button type="button" class="btn btn-default glyphicon glyphicon-remove" data-dismiss="modal"></button>
            </center>
        </div>
    </form>
<%} else {%>

<form name="categoria_servicio" action="cat_ser_form.jsp" method="POST">
    
        <div class="form-group">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <input style="color: white;" type="text" class="form-control" id="servicio" name="servicio" placeholder="SERVICIO">
            </div>
            <div class="col-lg-2"></div>
            <button type="submit" name="acciones" value="Registrar" class="btn btn-primary glyphicon glyphicon-saved"></button>
        </div>
    </form>

<%}%>


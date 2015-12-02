<%@page import="bean.Producto"%>
<%@page import="daoimpl.ProductoDaoImpl"%>
<%@page import="dao.ProductoDao"%>
<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%
    Categoria_servicio catse = new Categoria_servicio();
    String acciones = request.getParameter("acciones");
    acciones = acciones == null ? "" : acciones;
    String nombre = request.getParameter("nombre");
    nombre = nombre == null ? "" : nombre;
    String id_uni_me = request.getParameter("id_uni_me");
    id_uni_me = id_uni_me == null ? "" : id_uni_me;
    String mensaje = "";
    String alert = "";
    String id_producto = request.getParameter("id_producto");
    id_producto = id_producto == null ? "" : id_producto;
%>

<%      if (acciones.equals("Actualizar")) {
        Producto pro=new Producto();
        pro.setId_producto(id_producto);
        pro.setId_unidad_medida(id_uni_me);
        pro.setNombre_producto(nombre);
     ProductoDao dao=new ProductoDaoImpl();
        if (dao.actualizarProducto(pro)) {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ACTUALIZADO CORRECTAMENTE&alert=info");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ERROR AL ACTUALIZAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
    if (acciones.equals("Registrar")) {
       Producto pro=new Producto();
     ProductoDao dao=new ProductoDaoImpl();
      pro.setNombre_producto(nombre);
      pro.setId_unidad_medida(id_uni_me);
        if (dao.agregarProducto(pro)) {
            response.sendRedirect("cat_ser_result.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=info");
            request.getAttribute("alert,info");
        } else {
            response.sendRedirect("cat_ser_result.jsp?mensaje=ERROR AL REGISTRAR&alert=danger");
            request.getAttribute("alert,danger");
        }
    }
    if (acciones.equals("Eliminar")) {
     ProductoDao dao=new ProductoDaoImpl();
        if (dao.eliminarProducto(Integer.parseInt(id_producto))) {
            response.sendRedirect("index.jsp?mensaje=SE ELIMINO CORRECTAMENTE&alert=success&estado=bien");
            request.getAttribute("alert,success");
            request.getAttribute("estado,bien");
        } else {
            response.sendRedirect("index.jsp?mensaje=ERROR AL ELIMINAR&alert=danger&estado=mal");
            request.getAttribute("alert,danger");
            request.getAttribute("estado,mal");
        }
    }
%>
<%
    if (!id_producto.equals("") && !acciones.equals("Eliminar")) {
        Categoria_servicioDao das = new Categoria_servicioDaoImpl();
        Categoria_servicio catsers = das.datosServicio(Integer.parseInt(id_producto));
%>
<form name="Categoria_servicio" method="post" action="cat_ser_form.jsp" autocomplete="off">
    <input type="hidden" name="id_servicio" value="<%=id_producto%>"/>
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


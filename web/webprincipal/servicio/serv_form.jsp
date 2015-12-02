<%@page import="bean.Categoria_servicio"%>
<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@page import="daoimpl.ServicioDaoImpl"%>
<%@page import="dao.ServicioDao"%>
<%@page import="bean.Servicio"%>
<%
    String id_servicio = request.getParameter("id_servicio");
    String opcion = request.getParameter("opcion");
    
    String mensaje="";
    String alert="";
    String id_cat_serv=request.getParameter("id_cat_serv");
   String nombreser=request.getParameter("nombreser");
   String premax=request.getParameter("premax");
   String premin=request.getParameter("premin");
   String precio=request.getParameter("precio");
   String estado=request.getParameter("estado");
   if(opcion==null)
   {
       opcion="";
   }
   if(id_servicio==null)
   {
       id_servicio="";
   }
%>
<%
    if (opcion.equals("Registrar")) {

        Servicio ser = new Servicio();
        ser.setNombre_serv(nombreser);
        ser.setId_cat_serv(id_cat_serv);
        ser.setPrecio_min(premin);
        ser.setPrecio_max(premax);
        ser.setPrecio(precio);
        ser.setEstado(estado);
        ServicioDao dao = new ServicioDaoImpl();
        if (dao.fn_crud_servicio(ser, 1)) {
            response.sendRedirect("index.jsp?mensaje=SE REGISTRO CORRECTAMENTE&alert=info&estado=bien");
            request.getAttribute("alert,info");
            request.getAttribute("estado,bien");
        } else {
            response.sendRedirect("index.jsp?mensaje=ERROR AL REGISTRAR&&alert=danger&estado=mal");
            request.getAttribute("alert,danger");
            request.getAttribute("alert,mal");
        }
    }
    if (opcion.equals("Eliminar")) {
        ServicioDao dao = new ServicioDaoImpl();
        Servicio ser=new Servicio();
        ser.setId_cat_serv(id_servicio);
        if (dao.fn_crud_servicio(ser,3)) {
            response.sendRedirect("index.jsp?mensaje=ELIMINO CORRECTAMENTE&alert=info&estado=bien");
            request.getAttribute("alert,info");
            request.getAttribute("estado,bien");
        } else {
            response.sendRedirect("index.jsp?mensaje=ERROR AL ELIMINAR&alert=danger&estado=mal");
            request.getAttribute("alert,danger");
            request.getAttribute("alert,mal");
        }
    }
    

   if (opcion.equals("Actualizar")) {
       ServicioDao dao = new ServicioDaoImpl(); 
       String nombreServicio = request.getParameter("Servicio");
            String id_categoria = request.getParameter("id_categoria");
            String precio_min = request.getParameter("precio_min");
            String precio_max = request.getParameter("precio_max");
            Servicio servicio=new Servicio();
            servicio.setId_servicio(id_servicio);
            servicio.setId_cat_serv(id_categoria);
            servicio.setNombre_serv(nombreServicio);
            servicio.setPrecio_max(precio_max);
            servicio.setPrecio_min(precio_min);
            servicio.setEstado("1");
            if (dao.fn_crud_servicio(servicio,2)) {
                response.sendRedirect("index.jsp?mensaje=Actualizo Correctamente&alert=info&estado=bien");
                request.getAttribute("alert,info");
                request.getAttribute("estado,bien");
            } else {
                response.sendRedirect("index.jsp?mensaje=ERROR AL ACTUALIZAR&alert=danger&estado=mal");
                request.getAttribute("alert,danger");
                request.getAttribute("alert,mal");
            }
    }
%>
<style>input{color: while;} input.form-control{color: white;background: #03a9f4;}
option.form-control{color: white;background: #03a9f4;}
select.form-control{color: white;background: #03a9f4;}</style>
<%
    if (!id_servicio.equals("") && !opcion.equals("Eliminar")) {
        ServicioDao das = new ServicioDaoImpl();
        Categoria_servicioDao sar = new Categoria_servicioDaoImpl();
        Servicio caa = das.BuscarServicio(Integer.parseInt(id_servicio));
%>
<%@include file="../principal/cabeza.jsp" %>
<form name="servicios" action="serv_form.jsp" method="POST">
    <input type="hidden" name="id_serv" value="<%=id_servicio%>" >
    <div class="modal-body">
        <div class="form-group">
            <select name="id_cat_ser">
                <option>SELECCIONAR CATEGORIA</option>
              <%for(Categoria_servicio asd:sar.listarServicio()){%>
                <option value="<%=asd.getId_cat_serv()%>"><%=asd.getNombre_cat_serv()%></option>
                <%}%>
            </select>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="names" name="nombreser" value="<%=caa.getNombre_serv()%>" >
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="precio_min" name="premin" value="<%=caa.getPrecio_min()%>" >
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="precio_max" name="premax" value="<%=caa.getPrecio_max()%>" >
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="precio" name="precio" value="<%=caa.getPrecio()%>"  >
        </div>
    </div>
          
          
        <span class="alert-<%=alert%>" style="width: 450; height: 60px;"><%=mensaje%></span>
        
    <div class="modal-footer">
        <center>
            <button  type="submit" name="opcion" value="Actualizar" class="btn btn-primary glyphicon glyphicon-saved"></button>
            <button type="button" class="btn btn-default glyphicon glyphicon-remove" data-dismiss="modal"></button>
        </center>
    </div>
</form>
   
        <script type="text/javascript"> 
            document.servicios.id_cat_serv.value='<%=caa.getId_cat_serv()%>';
            document.servicios.getNombre_cat_serv.value='<%=caa.getNombre_cat_serv()%>';
        </script>
             <%@include file="../principal/pie.jsp" %>
<%}else{%>
<form name="servicios" action="serv_form.jsp" method="POST">

            <div class="col-lg-2"><div class="resuls"></div></div>
            <div class="col-lg-8">
                <div class="form-group">
                    <select name="id_cat_serv"    class="form-control"> 
                        <option >SELECCIONAR CATEGORIA</option>
                        <%
                            Categoria_servicioDao dse=new Categoria_servicioDaoImpl();
                            for (Categoria_servicio cats: dse.listarServicio()) {
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
                    <input type="number" class="form-control" id="precio_min" name="premax" placeholder="INGRESE PRECIO MAXIMO" max="2" >
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" id="precio" name="precio" placeholder="INGRESE PRECIO"  >
                </div>
               
                 
            </div>
            <div class="col-lg-2"></div>
            <center>
                <button value="Registrar" name="opcion" ><span  class="glyphicon btn-success btn-glyphicon glyphicon-plus img-circle text-success" ></span>GUARDAR</button>
            </center>
     
  
</form>
<%}%>
       

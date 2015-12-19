<%@page import="bean.Cliente"%>
<%@page import="daoimpl.ClienteDaoImpl"%>
<%@page import="dao.ClienteDao"%>
<%@include file="../principal/cabeza.jsp" %>
<%
String fecha_ini,fecha_fin;
    
    fecha_ini = request.getParameter("fecha_ini");
    if (fecha_ini == null) {
        fecha_ini = "";
    }
    fecha_fin = request.getParameter("fecha_fin");
    if (fecha_fin == null) {
        fecha_fin = "";
    }



%>
<style>
    input.form-control{background: #1ec01e;}
</style>
<div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-10"><h1>LISTA DE CLIENTE REGISTADOS ENTRE DOS FECHAS</h1></div>
    <div class="col-lg-1"></div>
</div>
<div class="col-lg-12">
    <div class="col-lg-2"></div>
    <form name="buscar" action="cliente_fechas.jsp" method="POST">
    
        <div class="col-lg-4"><input type="date" class="form-control" name="fecha_ini"></div>
        <div class="col-lg-4"><input type="date" name="fecha_fin" class="form-control"></div>
    <input type="submit" class="col-lg-2 btn btn-info" name="buscar" value="buscar"  />
    </form>
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
    <table style="margin: 2.5px;">
        <thead>
            <tr class="col-lg-12">
                <th class="col-lg-1">#</th>
                <th class="col-lg-4">NOMBRES</th>
                <th class="col-lg-3">FECHA_NACIMIENTO</th>
                <th class="col-lg-3">TELEFONO</th>
                <th class="col-lg-1">SEXO</th>
                
            </tr>
        </thead>
        <tbody>
            <%
                int x = 0;
            ClienteDao clienteDao=new ClienteDaoImpl();
            for(Cliente cli:clienteDao.listarclientesfecha(fecha_ini, fecha_fin)){
                x = x + 1 ;
            
            %>
            <tr class="col-lg-12">
                <td class="col-lg-1"><%=x%></td>
                <td class="col-lg-4"><%=cli.getNombres()%></td>
                <td class="col-lg-3"><%=cli.getFecha_nac()%></td>
                <td class="col-lg-3"><%=cli.getTelefono()%></td>
                <td class="col-lg-1"><%=cli.getSexo()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>

</div>

<%@include file="../principal/pie.jsp" %>
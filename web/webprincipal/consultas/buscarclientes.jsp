<%@page import="bean.Cliente"%>
<%@page import="daoimpl.ClienteDaoImpl"%>
<%@page import="dao.ClienteDao"%>
<%@include file="../principal/cabeza.jsp" %>
<%    ClienteDao dao = new ClienteDaoImpl();
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
<style>input.form-control{
                color: white; 
                background: #03a9f4;
            }
option.form-control{
                color: white; 
                background: #03a9f4;
            }
            select.form-control{
                color: white; 
                background: #03a9f4;
            }</style>
<div class="col-lg-2"></div>
<div class="col-lg-8 form-group">

    <%----------%>

    <div class="card " >
        <div class="card-header">
            <center><h1><b>LISTA DE  CLIENTES</b></h1></center>
            <%                    if (!mensaje.equals("")) {
            %>
            <meta http-equiv="refresh" content="2,url=index.jsp">
            <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <%=mensaje%><img src="../../img/bien.png"/>
            </div>
            <%}%>
        </div>

        <div class="table-responsive" class="col-lg-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                <form name="buscar" action="buscarclientes.jsp" method="POST" >
                    <input class="col-lg-6" name="buscar" value="<%=buscar%>" placeholder="BUSCAR..." style="border-radius: 0.5em;">
                    <select name="limit"  class="form-control col-lg-2" style="width: 200px;" onchange="document.buscar.submit()">
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                        <option value="200">200</option>
                        <option value="500">500</option>
                    </select>
                    <input type="submit" class="col-lg-2 btn btn-success" name="buscar" value="buscar" />
                </form>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    <tr>
                        <td class="col-lg-1">#</td>
                        <th class="col-lg-2">NOMBRES</th>
                        <th class="col-lg-2">FECHA NACIMIENTO</th>
                        <th class="col-lg-2">SEXO</th>
                        <th class="col-lg-2">DIRECCI&Oacute;N</th>
                        <th class="col-lg-2">DNI</th>
                        <th class="col-lg-2">CELULAR</th>
                        <th class="col-lg-2">HISTORIA CLINICA</th>
                    </tr>
                    </tr>
                    <%
                        int x = 0;
                        for (Cliente daa : dao.buscarclientes(buscar, limit)) {
                            x = x + 1;
                    %>
                    <tr>
                        <td class="col-lg-1"><%=x%></td>
                        <td class="col-lg-9"><%=daa.getNombres()%></td>
                        <td class="col-lg-9"><%=daa.getFecha_nac()%></td>
                        <td class="col-lg-9"><%=daa.getSexo()%></td>
                        <td class="col-lg-9"><%=daa.getDireccion()%></td>
                        <td class="col-lg-9"><%=daa.getNro_doc()%></td>
                        <td class="col-lg-9"><%=daa.getTelefono()%></td>
                        <td class="col-lg-9"><center><a href="../vistas/historia_clinica.jsp?acciones=buscar&id_cliente=<%=daa.getId_cliente()%>"><span class="glyphicon glyphicon-tasks"></span></a></center></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="col-lg-2"></div>


<%@include file="../principal/pie.jsp" %>
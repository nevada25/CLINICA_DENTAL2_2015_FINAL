<%@page import="daoimpl.Categoria_servicioDaoImpl"%>
<%@page import="dao.Categoria_servicioDao"%>
<%@page import="bean.Categoria_servicio"%>
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">

    <link rel="shortcut icon"  href="../../img/1447842109_user-admin.ico" />
    <!-- Font Awesome -->
    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    <body onload="print()" style="padding: 80px;">
        
        <table class="table table-bordered text-bold text-info table-striped" >
                    
                    <thead>
                        <tr>
                            <td>#</td>
                            <th>Categoria</th>
                               
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Categoria_servicioDao dao=new Categoria_servicioDaoImpl();
                            int x = 0;
                            for (Categoria_servicio daa : dao.listarServicio()) {
                                x = x + 1;
                        %>
                        <tr>
                            <td class="col-lg-1"><%=x%></td>
                            <td class="col-lg-9"><%=daa.getNombre_cat_serv()%></td>
                        </tr>
                    <%}%>
                </table>
    </body>

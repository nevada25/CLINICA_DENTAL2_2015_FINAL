
<%@page import="bean.Hist_ante_personal"%>
<%@page import="bean.Historia_clinica"%>
<%@page import="daoimpl.Historia_clinicaDaoImpl"%>
<%@page import="dao.Historia_clinicaDao"%>
<%@include file="../principal/cabeza.jsp" %>
<%
    String acciones = request.getParameter("acciones");acciones = acciones == null ? "" : acciones;

String id_cliente=request.getParameter("id_cliente");


if (acciones.equals("buscar")) {
    Historia_clinicaDao dao= new Historia_clinicaDaoImpl();
    for(Historia_clinica caa: dao.listarHistCla(Integer.parseInt(id_cliente))){
        
        
%>
<style>
    div{ margin: 3.5px;}
    div#lista{height: 300px; border: 3px #006f7d solid;}
    div#pala_lar{height: 150px; border: 3px #006f7d solid;}
</style>
<div class="col-lg-12" style="margin-top: 50px;">
    <div class="col-lg-1"></div>
    <div class="col-lg-5"><img src="../../img/back.png" style="height: 50px;width: 100px;"></div>
    <div class="col-lg-2"></div>
    <div class="col-lg-2"><br>H.C:<%=caa.getNro_historia()%></div>
    <div class="col-lg-2"></div>
</div>
<center><h1>HISTORIA CLINICA</h1></center>
<div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-5"><label class="control-label">NOMBRES Y APELLIDOS:</label><%=caa.getNombres()%></div>
    <div class="col-lg-2"><label class="control-label">EDAD:</label><%=caa.getApepat()%></div>
    <div class="col-lg-2"><label class="control-label">SEXO:</label><%=caa.getSexo()%></div>
<div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-5"><label class="control-label">DOMILICIO:</label><%=caa.getDireccion()%></div>
        <div class="col-lg-2"><label class="control-label">DNI:</label><%=caa.getNro_doc()%></div>
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-5"><label class="control-label">TELEFONO:</label><%=caa.getTelefono()%></div>
        <div class="col-lg-2"><label class="control-label">FECHA:</label><%=caa.getFecha_reg()%></div>
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-9"><label class="control-label">NOMBRE DEL RESPONSABLE O APODERADO:</label><%=caa.getResponsable_apoderado()%></div>
        
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-9"><label class="control-label">MOTIVO DE CONSULTA:</label>
            <%=caa.getMotivo_consulta()%></div>
        
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-2"></div>
        <div class="col-lg-4"><label class="control-label">ANTECEDENTES PERSONALES:</label></div>
        <div class="col-lg-4"><label class="control-label">FECHA DE NACIMIENTO:</label><%=caa.getFecha_nac()%></div>
    <div class="col-lg-2"></div>
</div>

<div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-5" id="lista"></div>
        <div class="col-lg-4" id="lista"></div>
    
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-9" id="pala_lar"><label class="control-label">COMENTARIOS:</label><%=caa.getComentario()%></div>
        
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-9" id="pala_lar"><label class="control-label">ANTECEDENTES FAMILIARES:</label><%=caa.getAntecedentes_familiar()%></div>
        
    <div class="col-lg-2"></div>
</div>
<div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-9" id="pala_lar"><label class="control-label">HABITOS NOCIVOS:</label></div>
        
    <div class="col-lg-2"></div>
</div><div class="col-lg-12">
    <div class="col-lg-1"></div>
    <div class="col-lg-3"><label class="control-label">PESO:</label><%=caa.getPeso()%></div>
    <div class="col-lg-3"><label class="control-label">TALLA:</label><%=caa.getTalla()%></div>
    <div class="col-lg-3"><label class="control-label">PA:</label><%=caa.getPa()%></div>
<div class="col-lg-1"></div>
</div>

<%}}%>
<%@include file="../principal/pie.jsp" %>
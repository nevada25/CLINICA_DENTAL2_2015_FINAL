<%@page import="bean.Diagnostico_def"%>
<%@page import="daoimpl.Diagnostico_defDaoImpl"%>
<%@page import="dao.Diagnostico_defDao"%>
<%@page import="bean.Habito_nocivo"%>
<%@page import="daoimpl.Habito_nocivoDaoImpl"%>
<%@page import="dao.Habito_nocivoDao"%>
<%@page import="bean.Antecente_personal"%>
<%@page import="daoimpl.Antecente_personalDaoImpl"%>
<%@page import="dao.Antecente_personalDao"%>
<%
    String mensaje, alert, estado;
    mensaje = request.getParameter("mensaje");
    if (mensaje == null) {
        mensaje = "";
    }
    alert = request.getParameter("alert");
    if (alert == null) {
        alert = "";
    }
    estado = request.getParameter("estado");
    if (estado == null) {
        estado = "";
    }
%>

<%@include file="../inicio-top.jsp" %>

<form name="form_cliente" action="ControlClienteSVT" method="post" class="col-lg-12">
    <div style="text-align: center;" ><h2><b>HISTORIA CLINICA</b></h2></div>
    <div class="form-group col-lg-12">
        <div class="col-lg-6">
            <center>
                <label for="Nro_historia">N° Historia Clinica:</label>
                <input type="text" size="10" name="Nro_historia" class="form-control" id="Nro_historia" placeholder="N° Historia">
            </center>
        </div>

        <div class="col-lg-6">
            <center>
                <label for="Fecha_historia">Fecha de Historia:</label>
                <input type="date" name="Fecha_historia" class="form-control" id="" placeholder="">
            </center>
        </div>

    </div>


    <%         if (!mensaje.equals("")) {
    %>
    <meta http-equiv="refresh" content="2,url=../MenuSVT?opcion=PrinClien">
    <div class="alert alert-<%=alert%> alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
        <%=mensaje%> <img src="../../img/<%=estado%>.png"/>
    </div>
    <%}%>
    <div class="col-lg-12"> 
        <%----DATOS CLIENTES---%>
        <div class="col-lg-6">
            <div class="box col-lg-12">
                <div class="box-header with-border">
                    <h3 class="box-title "><b class="text-center"><center>DATOS CLIENTE</center></b></h3>
                    <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
                </div>
                <div class="box-body">
                    <div  class="form-group col-lg-12">
                        <label class="control-label col-lg-12 text-center" for="Nombres">Nombres:</label>
                        <input type="text"  name="Nombres" class="form-control col-lg-12" id="" placeholder="Nombres">

                        <label class="control-label col-lg-12 text-center" for="Apepat">Apellido Paterno:</label>
                        <input type="text" name="Apepat"  class="form-control col-lg-12" id="" placeholder="Apellido Paterno">

                        <label for="Apemat" class="control-label col-lg-12 text-center">Apellido Materno:</label>
                        <input type="text" name="Apemat"  class="form-control col-lg-6" id="" placeholder="Apellido Materno">

                        <label for="Dni" class="control-label col-lg-12 text-center">DNI:</label>
                        <input type="number" name="Dni"  class="form-control col-lg-6" id="" placeholder="DNI">

                        <label for="Sexo" class="control-label col-lg-12 text-center">Sexo:</label>
                        <input type="text" name="Sexo" maxlengt="1"  class="form-control col-lg-6" id="" placeholder="'M' o 'F'">

                        <label for="Apoderado" class="control-label col-lg-12 text-center"><br>Nombre del Responsable o Apoderado:</label>
                        <input type="text" name="Apoderado"  class="form-control col-lg-12" id="" placeholder="Nombre del Responsable o Apoderado">

                        <label for="Mot_consulta" class="control-label col-lg-12 text-center"><br>Motivo de consulta:</label>
                        <input type="text" name="Mot_consulta" class="form-control col-lg-12" id="" placeholder="Motivo de consulta">

                        <label for="Domicilio" class="control-label col-lg-12 text-center"><br>Domicilio:</label>
                        <input type="text" name="Domicilio"  class="form-control col-lg-12" id="" placeholder="Domicilio:">

                        <label for="Telefono" class="control-label col-lg-6 text-center"><br>Telefono:</label>
                        <input type="text" name="Telefono"  maxlength="9" class="form-control col-lg-6" id="" placeholder="Telefono">
                        <label for="Fecha_nac" class="control-label col-lg-12 text-center"><br>Fecha de Nacimiento:</label>
                        <input type="date" name="Fecha_nac" class="form-control col-lg-12" id="" placeholder="Fecha de Nacimiento">
                    </div>
                </div>
            </div>
        </div>

        <%----FIN DATOS CLIENTES---%>
        <%----ANTECEDENTES PERSONALES---%>
        <div class="col-lg-6">
            <div class="box col-lg-12">
                <div class="box-header with-border"> 
                    <h3 class="box-title "><div style="text-align: center;"><label for="Ante_personales" class="text-primary text-bold"><h1>ANTECEDENTES PRESONALES</h1></label></div></h3>
                    <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
                </div>
                <div class="box-body">
                    <div class="col-lg-12">
                        El paciente ha tenido o tiene:
                        <div class="form-group  col-lg-12"></div><div class="form-group  col-lg-0"></div>
                        <div class="form-group col-lg-6">
                            <%            Antecente_personalDao apdao = new Antecente_personalDaoImpl();
                                for (Antecente_personal antper : apdao.listarAntedente_personal1()) {
                            %>
                            <br>
                            <label>
                                <input type="checkbox" name="id_ante_personal" value="<%=antper.getId_ante_personal()%>"><%=antper.getNombre_antecedente()%>
                            </label>
                            <%}%>
                        </div>
                        <div class="form-group col-lg-6">
                            <%for (Antecente_personal antper : apdao.listarAntedente_personal2()) {%>
                            <br>
                            <label>
                                <input type="checkbox" name="id_ante_personal" value="<%=antper.getId_ante_personal()%>"> <%=antper.getNombre_antecedente()%>
                            </label>
                            <%}%>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <%----COMENTARIO---%>
        <div class="col-lg-6">
            <div class="box col-lg-12">  
                <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
                <div class="box-body">
                    <div class="form-group col-lg-12">
                        <label for="Comentario" class="col-lg-12"><br>Comentario:<br></label>
                        <textarea class="col-lg-12" rows="2" id="comment"></textarea>
                    </div>
                    <div class="form-group col-lg-12">
                        <label for="Ante_familiar" class="col-lg-12"><br>Antecedentes familiares:</label>
                        <textarea class="col-lg-12" rows="2"  id="comment"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <%----fin COMENTARIO---%>
    </div>
    <%----FIN ANTECEDENTES PERSONALES---%>

    <%-----fin de checkbox---%>
<div class="col-lg-12">
<div class="col-lg-6">
    <div class="box">
        <div class="box-header with-border">
          <div class="form-group  col-lg-12">
        <h1 class="box-title"><label for="hab_noc">Hábitos Nocivos:</label></h1>
    </div>
            <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
        </div>
        <div class="box-body">
            <div class=" form-group col-lg-12">
        <div class="form-group col-lg-6">
        <%
            Habito_nocivoDao hndao = new Habito_nocivoDaoImpl();
            for (Habito_nocivo hn : hndao.listarHabitoNocivo1()) {
        %>
        <br>
        <label>
            <input type="checkbox" name="id_hab_noc" value="<%=hn.getId_habito_nocivo()%>"><%=hn.getNombre_hab_noc()%>
        </label>
        <%}%>
    </div>
    <div class="form-group col-lg-6">
        <%for (Habito_nocivo hn : hndao.listarHabitoNocivo2()) {%>
        <br>
        <label>
            <input type="checkbox"  name="id_hab_noc" value="<%=hn.getId_habito_nocivo()%>"> <%=hn.getNombre_hab_noc()%>
        </label>
        <%}%>
    </div>
    <div class="form-group col-lg-12">
        <div class="form-group col-lg-4">
        <label for="Peso"><br>Peso:</label>
        <input type="number" name="Peso" class="form-control" size="10" id="" placeholder="Peso">
        </div>
        <div class="form-group col-lg-4">
        <label for="Talla"><br>Talla:</label>
        <input type="number" name="Talla" class="form-control" size="10" id="" placeholder="Talla">
        </div>
        <div class="form-group col-lg-4">
            <label for="PA"><br>PA:<tt>..</tt></label>
            <input type="number" name="PA" class="form-control"size="10" id="" placeholder="PA"><br>
        </div>
    </div>
        </div>
    </div>
</div>
    </div>
<div class="col-lg-6">
    <div class="box">
        <div class="box-header with-border">
            <h1 class="box-title"><b>ODONTOGRAMA</b></h1>
        <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
        </div>
        <div class="box-body">
           <div class="form-group col-lg-12">
        <div class="col-lg-6">
            <label for="Especificaciones"><br>ESPECIFICACIONES:</label>
            <input type="text" name="Especificaciones" class="form-control" id="" placeholder="ESPECIFICACIONES">
        </div>
        <div class="col-lg-6">
            <label for="Observaciones"><br>OBSERVACIONES:</label>
            <input type="text" name="Observaciones" class="form-control" id="" placeholder="OBSERVACIONES"><br>
        </div>
        
    </div>
            
            <div class="form-group col-lg-12 text-center">
                <br>
            <b>DIAGNOSTICO PRESUNTIVO:</b>
             <center>
        <div class="form-group  col-lg-12">
            <label for="" class="col-lg-2">1.</label>
            <div class="col-lg-10">
            <input type="text" class="form-control"  id="" placeholder="">
            </div>
        </div>
        <div class="form-group  col-lg-12">
            <label for="" class="col-lg-2">2.</label>
            <div class="col-lg-10">
            <input type="text" class="form-control"  id="" placeholder="">
            </div>
        </div>
        <div class="form-group  col-lg-12">
            <label for="" class=" control-label col-lg-2">3.</label>
            <div class="col-lg-10">
            <input type="text" class="form-control" id="" placeholder="">
            </div>
        </div>
    </center>
            </div>
            
        </div>
    </div>
</div>
</div>
    <div class="form-group col-lg-12 text-center">
     <div class="box">
  <div class="box-header with-border">
    <h1 class="box-title"><b>DIAGNOSTICO DEFINITIVO:</b></h1>
  </div>
  <div class="box-body">
   <center>
        <div class="form-group col-lg-12" >

            <select class="form-control  col-lg-12 text-center"  id="sel1">
                <%
                    Diagnostico_defDao daodiad = new Diagnostico_defDaoImpl();
                    for (Diagnostico_def diag : daodiad.listarDiagnosticoPor()) {
                %>
                <option class="form-control text-center" value="<%=diag.getId_diagnostico_def()%>"><%=diag.getDescripcion()%></option> <%--opciones para el combox--%>
                <%}%>
            </select>
            <label for="Pronostico" class="col-lg-12"><br>PRONOSTICO:</label>
            <input type="text" name="Pronostico"  class="form-control col-lg-12" id="" placeholder="">
        </div>
    </center>

  </div>
</div>
    </div>
            <div class=" text-center ">
            <center>
                <div class="col-lg-4"></div>
 <button type="submit" class="btn btn-success btn-lg col-lg-4" >Registrar</button>   
 <div class="col-lg-4"></div>
            </center>
            </div>
</form>

<%@include file="../inicio-botton.jsp" %>
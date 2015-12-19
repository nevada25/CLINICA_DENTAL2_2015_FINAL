SELECT   cli.id_cliente, his_cli.id_historia_clinica, per.nombres,per.apepat,per.apemat,his_cli.nro_historia, his_cli.comentario, 
  his_cli.antecedentes_familiar,his_cli.fecha_reg_hist,his_cli.responsable_apoderado,his_cli.hora_reg,his_cli.motivo_consulta, 
  his_cli.peso, his_cli.talla, his_cli.pa,  his_cli.estado, his_cli.especificaciones,his_cli.observaciones,  his_cli.pronostico, 
  per.sexo,  per.telefono, per.nro_doc, per.hora_registro, per.fecha_reg_per, 
  (select (to_date(to_char(now(),'yyyy'),'yy')-(select to_date(to_char(per.fecha_nac,'yy'),'yy')))/360) edad,
  per.fecha_nac
FROM   public.cliente cli,  public.persona per, public.historia_clinica his_cli 
WHERE   cli.id_cliente = per.id_persona AND  cli.id_cliente = his_cli.id_cliente ;

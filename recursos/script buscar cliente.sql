SELECT upper(per.nombres||' '|| per.apepat||' '||per.apemat) Nombres, 
  per.fecha_nac,CASE sexo WHEN 'M' THEN 'MASCULINO' WHEN 'F' THEN 'FEMENINO' END
  sexo,  upper(per.direccion)as dirección, per.nro_doc as dni,per.telefono as celular 
FROM   public.persona per, public.cliente cl WHERE  per.id_persona = cl.id_cliente

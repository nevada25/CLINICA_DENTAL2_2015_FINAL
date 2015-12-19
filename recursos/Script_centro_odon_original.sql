
Create table "proveedor"
(
	"id_proveedor" Integer NOT NULL,
	"estado" Varchar(1),
 primary key ("id_proveedor")
);


Create table "persona"
(
	"id_persona" Integer NOT NULL,
	"id_grado_instruccion" Integer NOT NULL,
	"id_ocupacion" Integer NOT NULL,
	"id_ubigeo_nac" Integer NOT NULL,
	"id_ubigeo_act" Integer NOT NULL,
	"nombre" Varchar(100),
	"nombres" Varchar(200),
	"apepat" Varchar(60),
	"apemat" Varchar(60),
	"fecha_nac" Date,
	"correo_gmail" Varchar(150) UNIQUE,
	"correo_hotmail" Varchar(150),
	"correo_otros" Varchar(150),
	"celular" Varchar(9),
	"telefono" Varchar(9),
	"sexo" Varchar(1),
	"direccion" Varchar(200),
	"pagina_web" Varchar(200),
	"foto_persona" Varchar(200),
	"estado" Varchar(1),
	"id_tipo_doc" Integer NOT NULL,
 primary key ("id_persona")
);


Create table "ocupacion"
(
	"id_ocupacion" Integer NOT NULL,
	"nombre_ocupacion" Varchar(100) NOT NULL UNIQUE,
	"estado" Varchar(1) NOT NULL,
 primary key ("id_ocupacion")
);


Create table "cliente"
(
	"id_cliente" Integer NOT NULL,
 primary key ("id_cliente")
);


Create table "empleado"
(
	"id_empleado" Integer NOT NULL,
 primary key ("id_empleado")
);


Create table "tipo_doc"
(
	"id_tipo_doc" Integer NOT NULL,
	"nombre_tipo_doc" Varchar(30) NOT NULL UNIQUE,
	"estado" Varchar(1) NOT NULL,
 primary key ("id_tipo_doc")
);


Create table "ubigeo"
(
	"id_ubigeo" Integer NOT NULL,
	"departamento" Varchar(100),
	"provincia" Varchar(100),
	"distrito" Varchar(100),
	"estado" Varchar(1),
 primary key ("id_ubigeo")
);


Create table "grado_instruccion"
(
	"id_grado_instruccion" Integer NOT NULL,
	"nombre_grad_inst" Varchar(100) NOT NULL UNIQUE,
	"estado" Varchar(1),
 primary key ("id_grado_instruccion")
);


Create table "laboratorios_externos"
(
	"id_lab_externo" Integer NOT NULL,
	"nombre_lab_ext" Varchar(300) NOT NULL,
	"descripcion" Varchar(300),
	"estado" Varchar(20) NOT NULL,
 primary key ("id_lab_externo")
);


Create table "contrato"
(
	"id_contrato" Integer NOT NULL,
	"id_consulta" Char(20) NOT NULL,
	"fecha_consult" Date NOT NULL,
	"fecha_registro" Date NOT NULL,
 primary key ("id_contrato")
);


Create table "det_consulta_serv"
(
	"id_servicio" Integer NOT NULL,
	"id_cita" Varchar(30) NOT NULL,
	"cantidad" Numeric(7,2),
	"total" Numeric(8,2) NOT NULL,
	"nro_laboratorio_int" Varchar(30),
	"motivo_consul" Varchar(300),
	"id_empleado" Integer NOT NULL,
 primary key ("id_servicio")
);


Create table "servicio"
(
	"id_servicio" Integer NOT NULL,
	"id_cat_serv" Integer NOT NULL,
	"nombre_serv" Varchar(200) NOT NULL UNIQUE,
	"precio_max" Numeric(7,2),
	"precio_min" Numeric(7,2),
	"estado" Varchar(1),
 primary key ("id_servicio")
);


Create table "categoria_servicio"
(
	"id_cat_serv" Integer NOT NULL,
	"nombre_cat_serv" Varchar(20) UNIQUE,
 primary key ("id_cat_serv")
);


Create table "cita"
(
	"id_cita" Varchar(30) NOT NULL,
	"id_contrato" Integer NOT NULL,
	"fecha_cita" Date NOT NULL,
	"hora" Time NOT NULL,
	"estado" Varchar(1) NOT NULL,
	"condicion" Varchar(10) NOT NULL,
	"id_empleado" Integer NOT NULL,
 primary key ("id_cita")
);


Create table "compra"
(
	"id_compra" Integer NOT NULL,
	"fecha" Date NOT NULL,
	"serie_fac" Varchar(20),
	"subtotal" Double precision NOT NULL,
	"descuento" Double precision,
	"igv" Double precision,
	"total" Double precision,
	"id_persona" Integer NOT NULL,
 primary key ("id_compra")
);


Create table "detalle_compra"
(
	"id_compra" Integer NOT NULL,
	"descripcion" Varchar(20),
	"cantidad" Double precision,
	"precio_unitario" Double precision,
	"importe" Double precision,
	"id_producto" Char(20) NOT NULL,
	"id_compra" Integer NOT NULL,
 primary key ("id_compra")
);


Create table "unidad_medida"
(
	"id_unidad_medida" Char(20) NOT NULL,
	"nombre_uni_med" Varchar(100) NOT NULL,
	"estado" Varchar(1),
 primary key ("id_unidad_medida")
);


Create table "producto"
(
	"id_producto" Char(20) NOT NULL,
	"id_unidad_medida" Char(20) NOT NULL,
 primary key ("id_producto")
);


Create table "usuario"
(
	"id_usuario" Integer NOT NULL,
	"nombre_usuario" Varchar(20) NOT NULL UNIQUE,
	"password" Char(20) NOT NULL,
	"estado" Varchar(1),
 primary key ("id_usuario")
);


Create table "consulta"
(
	"id_cliente" Integer NOT NULL,
	"id_empleado" Integer NOT NULL,
	"id_consulta" Char(20) NOT NULL,
	"especificaciones" Varchar(250),
	"observaciones" Varchar(20),
	"pronostico" Varchar(20),
 primary key ("id_consulta")
);


Create table "pieza"
(
	"id_pieza" Char(20) NOT NULL,
	"nro_pieza" Char(20) NOT NULL,
 primary key ("id_pieza")
);


Create table "servicio_pieza"
(
	"id_servicio" Integer NOT NULL,
	"id_pieza" Char(20) NOT NULL
);


Create table "diagnostico_pre"
(
	"id_diagnostico_pre" Integer NOT NULL,
	"descripcion" Varchar(150) NOT NULL,
	"id_historia_clinica" Integer NOT NULL,
 primary key ("id_diagnostico_pre")
);


Create table "historia_clinica"
(
	"id_historia_clinica" Integer NOT NULL,
	"id_cliente" Integer NOT NULL,
	"nro_historia" Varchar(20) NOT NULL,
	"comentario" Varchar(300),
	"antecedentes_familiar" Varchar(300),
	"fecha_reg" Date NOT NULL,
	"hora_reg" Time with time zone NOT NULL,
	"responsable_apoderado" Varchar(150),
	"motivo_consulta" Varchar(350),
	"peso" Numeric(5,2),
	"talla" Numeric(3,2),
	"pa" Varchar(20),
	"estado" Varchar(1) NOT NULL,
 primary key ("id_historia_clinica")
);


Create table "embarazo"
(
	"id_historia_clinica" Integer NOT NULL,
	"nro_semanas" Varchar(20) NOT NULL,
	"ultimo_control" Date,
	"trata_farma" Varchar(2),
 primary key ("id_historia_clinica")
);


Create table "habito_nocivo"
(
	"id_habito_nocivo" Integer NOT NULL,
	"nombre_hab_noc" Varchar(25) NOT NULL UNIQUE,
 primary key ("id_habito_nocivo")
);


Create table "hist_hab_noc"
(
	"id_historia_clinica" Integer NOT NULL,
	"id_habito_nocivo" Integer NOT NULL,
	"estado" Varchar(2),
 primary key ("id_historia_clinica","id_habito_nocivo")
);


Create table "antecedente_personal"
(
	"id_ante_personal" Integer NOT NULL,
	"nombre_antecedente" Varchar(50) NOT NULL UNIQUE,
 primary key ("id_ante_personal")
);


Create table "diagnostico_def"
(
	"id_diagnostico_def" Integer NOT NULL,
	"cie_10" Varchar(10) NOT NULL,
	"descripci_n" Char(20) NOT NULL,
 primary key ("id_diagnostico_def")
);


Create table "hist_ante_personal"
(
	"id_historia_clinica" Integer NOT NULL,
	"id_ante_personal" Integer NOT NULL,
	"estado" Varchar(2) NOT NULL,
 primary key ("id_historia_clinica","id_ante_personal")
);


Create table "examen_clinico"
(
	"id_examen_clinico" Integer NOT NULL,
	"aplicado_en" Varchar(20) NOT NULL,
 primary key ("id_examen_clinico")
);


Create table "hist_examen_clinico"
(
	"id_historia_clinica" Integer NOT NULL,
	"id_examen_clinico" Integer NOT NULL,
	"descripcion" Varchar(200),
	"estado" Varchar(1) NOT NULL,
 primary key ("id_historia_clinica","id_examen_clinico")
);


Create table "hist_diagnost_def"
(
	"id_historia_clinica" Integer NOT NULL,
	"id_diagnostico_def" Integer NOT NULL,
 primary key ("id_historia_clinica","id_diagnostico_def")
);


/* Create Foreign Keys */

Alter table "compra" add  foreign key ("id_persona") references "proveedor" ("id_proveedor");

Alter table "empleado" add  foreign key ("id_empleado") references "persona" ("id_persona");

Alter table "cliente" add  foreign key ("id_cliente") references "persona" ("id_persona");

Alter table "usuario" add  foreign key ("id_usuario") references "persona" ("id_persona");

Alter table "proveedor" add  foreign key ("id_proveedor") references "persona" ("id_persona");

Alter table "persona" add  foreign key ("id_ocupacion") references "ocupacion" ("id_ocupacion");

Alter table "consulta" add  foreign key ("id_cliente") references "cliente" ("id_cliente");

Alter table "historia_clinica" add  foreign key ("id_cliente") references "cliente" ("id_cliente");

Alter table "consulta" add  foreign key ("id_empleado") references "empleado" ("id_empleado");

Alter table "det_consulta_serv" add  foreign key ("id_empleado") references "empleado" ("id_empleado");

Alter table "cita" add  foreign key ("id_empleado") references "empleado" ("id_empleado");

Alter table "persona" add  foreign key ("id_tipo_doc") references "tipo_doc" ("id_tipo_doc");

Alter table "persona" add  foreign key ("id_ubigeo_nac") references "ubigeo" ("id_ubigeo");

Alter table "persona" add  foreign key ("id_ubigeo_act") references "ubigeo" ("id_ubigeo");

Alter table "persona" add  foreign key ("id_grado_instruccion") references "grado_instruccion" ("id_grado_instruccion");

Alter table "cita" add  foreign key ("id_contrato") references "contrato" ("id_contrato");

Alter table "servicio_pieza" add  foreign key ("id_servicio") references "det_consulta_serv" ("id_servicio");

Alter table "det_consulta_serv" add  foreign key ("id_servicio") references "servicio" ("id_servicio");

Alter table "servicio" add  foreign key ("id_cat_serv") references "categoria_servicio" ("id_cat_serv");

Alter table "det_consulta_serv" add  foreign key ("id_cita") references "cita" ("id_cita");

Alter table "detalle_compra" add  foreign key ("id_compra") references "compra" ("id_compra");

Alter table "producto" add  foreign key ("id_unidad_medida") references "unidad_medida" ("id_unidad_medida");

Alter table "detalle_compra" add  foreign key ("id_producto") references "producto" ("id_producto");

Alter table "contrato" add  foreign key ("id_consulta") references "consulta" ("id_consulta");

Alter table "servicio_pieza" add  foreign key ("id_pieza") references "pieza" ("id_pieza");

Alter table "embarazo" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "hist_hab_noc" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "diagnostico_pre" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "hist_ante_personal" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "hist_examen_clinico" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "hist_diagnost_def" add  foreign key ("id_historia_clinica") references "historia_clinica" ("id_historia_clinica");

Alter table "hist_hab_noc" add  foreign key ("id_habito_nocivo") references "habito_nocivo" ("id_habito_nocivo");

Alter table "hist_ante_personal" add  foreign key ("id_ante_personal") references "antecedente_personal" ("id_ante_personal");

Alter table "hist_diagnost_def" add  foreign key ("id_diagnostico_def") references "diagnostico_def" ("id_diagnostico_def");

Alter table "hist_examen_clinico" add  foreign key ("id_examen_clinico") references "examen_clinico" ("id_examen_clinico");



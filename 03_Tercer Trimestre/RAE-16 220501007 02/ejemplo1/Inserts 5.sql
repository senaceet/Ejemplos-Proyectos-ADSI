-- Insertar TipoDocumento
insert into db_entry_index.TIPO_DOCUMENTO values ('TI','Tarjeta De Identidad Colombiana',1);
insert into db_entry_index.TIPO_DOCUMENTO values ('CC','Cedula De Ciudadania Colombiana',1);
insert into db_entry_index.TIPO_DOCUMENTO values ('NIT','Número de Identificación Tributaria',1);
insert into db_entry_index.TIPO_DOCUMENTO values ('CE','Cedula De Extranjeria',1);

-- Insertar Cargo
insert into db_entry_index.CARGO values('Aprendiz','Es un Aprendiz SENA',1,0);
insert into db_entry_index.CARGO values('Instructor','Es un Instructor SENA',1,0);
insert into db_entry_index.cargo values('Funcionario','Es un Funcionario SENA',1,0);
insert into db_entry_index.CARGO values('Vigilante','Es un Vigilante que tabaja en el SENA',1,0);
insert into db_entry_index.CARGO values('Psicologo','Es un Psicologo que tabaja en el SENA',1,0);
insert into db_entry_index.CARGO values('Visitante','Es un Visitante que esta en el SENA',1,1);
-- Insertar Rolles
INSERT INTO db_entry_index.ROLL VALUES ('Administrador','Es un Administrador',1);
INSERT INTO db_entry_index.ROLL VALUES ('Celador','Es un Celador',1);

-- Insertar cuentas

INSERT INTO db_entry_index.CUENTA VALUES('1019116521','CC',NULL,'Kris','Andres','Sanchez','Gutierrez','Aprendiz','2017-04-07',1);
INSERT INTO db_entry_index.CUENTA VALUES('1019116521','TI',NULL,'Kristofer','','Sanchez','','Visitante','2016-11-25',1);
INSERT INTO db_entry_index.CUENTA VALUES('1030621348','CC',NULL,'Maritza',NULL,'Ramires','Fernandez','Aprendiz','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('1030680020','CC',NULL,'Carmen','Lucia','Loaiza','Ortiz','Vigilante','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('1030680102','CC',NULL,'Kevin','Stiven','Pineda','Morales','Aprendiz','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('1030680147','CC',NULL,'Andres','Santiago','Murillo','Pinzon','Vigilante','2017-10-10',0);
INSERT INTO db_entry_index.CUENTA VALUES('1030680430','CC',NULL,'Yesid','Alejandro','Peña','Galeano','Visitante','2017-10-10',0);
INSERT INTO db_entry_index.CUENTA VALUES('1030680487','CC',NULL,'Yurieth','Patricia','Pedraza','Olarte','Visitante','2017-10-10',0);
INSERT INTO db_entry_index.CUENTA VALUES('1030684230','CC',NULL,'Josue','Francisco','Gomez','Bernal','Funcionario','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('1033781013','CC',NULL,'Oscar','Andres','Hernandez','Ariza','Aprendiz','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('123456789','CC',NULL,'Administrador','Demo','Entry','Index','Funcionario',NULL,1);
INSERT INTO db_entry_index.CUENTA VALUES('3434535','CC',NULL,'Kevin','Stiven','Pineda','Morales','Psicologo','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('80013833','CC',NULL,'Hernando','Enrique','Moreno','Moreno','Instructor',NULL,1);
INSERT INTO db_entry_index.CUENTA VALUES('97081623452','TI',NULL,'Uribe',NULL,'Moreno',NULL,'Instructor','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('97081623485','TI',NULL,'Kevin',NULL,'Pineda','Morales','Aprendiz','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('98111051089','TI',NULL,'Peter','David','Gomez','Lobo','Aprendiz','2017-10-10',1);
INSERT INTO db_entry_index.CUENTA VALUES('987654321','CC',NULL,'Vigilante','Demo','Entry','Index','Vigilante','2030-10-10',0);
INSERT INTO db_entry_index.CUENTA VALUES('EI','CC',NULL,'support','','EntyIndex','','Funcionario',NULL,1);
INSERT INTO db_entry_index.CUENTA VALUES('123','CC',NULL,'cc','cc','cc','cc','Visitante',NULL,1);
INSERT INTO db_entry_index.CUENTA VALUES('123','TI',NULL,'ti','ti','ti','ti','Aprendiz',NULL,1);


-- Insertar usuarios
INSERT INTO db_entry_index.USUARIO VALUES('admin_demo@EntryIndex.com','*ȳȊȄȆǿȯȊȔȓȀYbkt}¡ª³¼ÅÎ×àéòûĄčĖğĨıĺŃŌŕŞŧŰŹƂƋƔƝƦƯƸǁǊǓǜǥǮǷȀȉȒțȤȭ','Administrador','123456789','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('hemoreno33@misena.edu.co','(ɀɈɈɇɅɀɅɅIR[dmv£¬µ¾ÇÐÙâëôýĆďĘġĪĳļŅŎŗŠũŲŻƄƍƖƟƨƱƺǃǌǕǞǧǰǹȂȋȔȝȦȯ','Administrador','80013833','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('hulkike@gmail.com','(ɀɈɈɇɅɀɅɅIR[dmv£¬µ¾ÇÐÙâëôýĆďĘġĪĳļŅŎŗŠũŲŻƄƍƖƟƨƱƺǃǌǕǞǧǰǹȂȋȔȝȦȯ','Celador','80013833','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('kevinpinedamyg@gmail.com','+ȷȅȗȅȏȊȅɇȿȿɁajs| ©²»ÄÍÖßèñúăČĕĞħİĹłŋŔŝŦůŸƁƊƓƜƥƮƷǀǉǒǛǤǭǶǿȈȑȚȣȬ','Administrador','1030680102','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('Kevin_We@outlook.com','&ȍȓȂȏȊɇ9BKT]fox¥®·ÀÉÒÛäíöÿĈđĚģĬĵľŇŐřŢūŴŽƆƏƘơƪƳƼǅǎǗǠǩǲǻȄȍȖȟȨȱ','Celador','1030680102','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('krys@gmail.com','*ȍȆȏȅȄȉȒȓȆɆYbkt}¡ª³¼ÅÎ×àéòûĄčĖğĨıĺŃŌŕŞŧŰŹƂƋƔƝƦƯƸǁǊǓǜǥǮǷȀȉȒțȤȭ','Administrador','1019116521','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('krys_cela@gmail.com','*ȍȆȏȅȄȉȒȓȆɇYbkt}¡ª³¼ÅÎ×àéòûĄčĖğĨıĺŃŌŕŞŧŰŹƂƋƔƝƦƯƸǁǊǓǜǥǮǷȀȉȒțȤȭ','Celador','1019116521','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('oahernandez31@misena.edu.co','(ɄɈɄɅɇɈɈɆIR[dmv£¬µ¾ÇÐÙâëôýĆďĘġĪĳļŅŎŗŠũŲŻƄƍƖƟƨƱƺǃǌǕǞǧǰǹȂȋȔȝȦȯ','Celador','1033781013','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('ooscar1995@gmail.com','(ɆɄɄɅɇɁɈɄIR[dmv£¬µ¾ÇÐÙâëôýĆďĘġĪĳļŅŎŗŠũŲŻƄƍƖƟƨƱƺǃǌǕǞǧǰǹȂȋȔȝȦȯ','Administrador','1033781013','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('Peter_Devile@gmail.com',')ȈȓȄȓȆɇɈɇɈQZclu~¢«´½ÆÏØáêóüąĎėĠĩĲĻńōŖşŨűźƃƌƕƞƧưƹǂǋǔǝǦǯǸȁȊȓȜȥȮ','Administrador','98111051089','TI',1);
INSERT INTO db_entry_index.USUARIO VALUES('Peter_Devile_cela@gmail.com',')ȈȓȄȓȆɇɈɇɈQZclu~¢«´½ÆÏØáêóüąĎėĠĩĲĻńōŖşŨűźƃƌƕƞƧưƹǂǋǔǝǦǯǸȁȊȓȜȥȮ','Celador','98111051089','TI',1);
INSERT INTO db_entry_index.USUARIO VALUES('support@entryindex.com','0ȊȃȊȕȗȌȗȈȏȌȌȗȆȓȏȅ¤­¶¿ÈÑÚãìõþćĐęĢīĴĽņŏŘšŪųżƅƎƗƠƩƲƻǄǍǖǟǨǱǺȃȌȕȞȧ','Administrador','EI','CC',1);
INSERT INTO db_entry_index.USUARIO VALUES('vigilante_demo@EntryIndex.com','*ȳȊȄȆǿȯȊȔȓȀYbkt}¡ª³¼ÅÎ×àéòûĄčĖğĨıĺŃŌŕŞŧŰŹƂƋƔƝƦƯƸǁǊǓǜǥǮǷȀȉȒțȤȭ','Celador','987654321','CC',1);


-- insertar computadores(Equipos)
insert into DB_ENTRY_INDEX.EQUIPO values('112233','Una portatil DELL con i7 y 4 de RAM de color negro',false);
insert into DB_ENTRY_INDEX.EQUIPO values('212233','Una portatil COMPACT con i5 y 4 de RAM de color blanco',true);
insert into DB_ENTRY_INDEX.EQUIPO values('312233','Una portatil HP con i7 y 8 de RAM de color azul',true);
insert into DB_ENTRY_INDEX.EQUIPO values('412233','Una portatil INFINITY con i3 y 4 de RAM con estampado de una calabera',true);
insert into DB_ENTRY_INDEX.EQUIPO values('612233','Una portatil SONY con intel celeron y 3 de RAM con estampado de un auto',true);
insert into DB_ENTRY_INDEX.EQUIPO values('712233','Una portatil APPLE con intel celeron y 4 de RAM de color rosa',true);
insert into DB_ENTRY_INDEX.EQUIPO values('812233','Una portatil ASUS con amd fx y 4 de RAM de color plateado',true);
insert into DB_ENTRY_INDEX.EQUIPO values('912233','Una portatil LENOVO con i7 y 6 de RAM de color negro',true);
insert into DB_ENTRY_INDEX.EQUIPO values('102233','Una portatil ACER con i7 y 12 de RAM con estampado de mario',true);
insert into DB_ENTRY_INDEX.EQUIPO values('123','Una Portatil GENIUS Roja con i3',true);
insert into DB_ENTRY_INDEX.EQUIPO values('1234','Una Portatil GENIUS Negra con i4 y 4 Ram',false);
insert into DB_ENTRY_INDEX.EQUIPO values('12345','Una Portatil COMPUMAX Roja i5 con 8 Ram',true);
insert into DB_ENTRY_INDEX.EQUIPO values('123456','Una portatil TECNOPC con 6 ram core 2 duo de color azul',true);
insert into DB_ENTRY_INDEX.EQUIPO values('1234567','Una portatil TECNOPC con 1,4 ram pentium 4 de color verde',true);

-- resgistro
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 02:00:00','2015-12-11 16:00:00','1030680102','CC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 03:01:00','2015-12-11 16:01:00','97081623485','TI',null,'Aprendiz');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 10:02:00','2015-12-11 16:02:00','97081623452','TI',null,'Instructor');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 07:03:00','2015-12-11 16:03:00','80013833','CC',null,'Instructor');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 08:04:00','2015-12-11 16:14:00','98111051089','TI',null,'Visitante');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 09:04:00','2015-12-11 16:24:00','1033781013','CC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 09:04:00','2015-12-11 16:34:00','1030680487','CC',null,'Visitante');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 10:04:00','2015-12-11 16:54:00','1030621348','cC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 11:12:00','2015-12-11 16:14:00','1030684230','CC',null,'Funcionario ');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 10:04:00','2015-12-11 16:54:00','1030621348','cC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 22:32:00','2015-12-12 16:24:00','1030680430','CC',null,'Visitante ');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 23:12:00','2015-12-12 16:34:00', '1030680020','CC',null,'Vigilante ');
insert into DB_ENTRY_INDEX.REGISTRO values (null,'2015-12-11 12:09:00','2015-12-12 16:44:00','1030680147','CC',null,'Vigilante ');

-- propietarios

insert into DB_ENTRY_INDEX.PROPIETARIO values('112233','1030680102','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('212233','97081623485','TI');
insert into DB_ENTRY_INDEX.PROPIETARIO values('312233','97081623452','TI');
insert into DB_ENTRY_INDEX.PROPIETARIO values('412233','80013833','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('412233','1033781013','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('712233','98111051089','TI');
insert into DB_ENTRY_INDEX.PROPIETARIO values('812233','1030680487','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('102233','1030621348','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('123','1030684230','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('12345','1030680430','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('123456','1030680020','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('1234567','1030680147','CC');


-- registro equipo 
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 1,1,'112233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 2,2,'212233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 3,3,'312233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 4,4,'412233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 5,5,'712233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 6,6,'812233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 7,7,'102233');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 8,10,'123');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 11,11,'12345');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 12,12,'123456');
insert into DB_ENTRY_INDEX.REGISTRO_EQUIPO values ( 13,null,'1234567');


-- log_Auditoria prueva

INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. {putin).','usuarioGenerico3','2016-04-15 21:33:34');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. {unia).','usuarioGenerico2','2016-04-15 21:34:02');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. {unia).','usuarioGenerico2','2016-04-15 21:34:03');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. {mama).','usuarioGenerico2','2016-04-15 21:35:42');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [aafa].','usuarioGenerico1','2016-04-15 21:40:23');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [aaag].','usuarioGenerico3','2016-04-15 21:40:32');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [aaha].','usuarioGenerico1','2016-04-15 21:48:36');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [akaa].','usuarioGenerico1','2016-04-15 21:48:47');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. [apaa].','usuarioGenerico1','2016-04-15 22:00:20');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. [apaa].','usuarioGenerico1','2016-04-15 22:03:51');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. [aaaaaaaaa].','usuarioGenerico2','2016-04-15 22:05:47');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. DE [aaa] A [aa7aa]','usuarioGenerico2','2016-04-15 22:13:06');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [b].','usuarioGenerico2','2016-04-15 22:19:12');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. DE [aaaaaaaaa] A [b]','usuarioGenerico2','2016-04-15 22:21:08');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [adsada].','usuarioGenerico1','2016-04-15 22:24:11');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [aaa].','usuarioGenerico1','2016-04-15 22:33:41');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido creado con exito. [1048].','usuarioGenerico1','2016-04-15 22:48:23');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido eliminado con exito. [dasdasdasd].','usuarioGenerico2','2016-04-15 22:51:50');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CuentaController','Cuenta ha sido creado con exito. [CC:numeroga]','usuarioGenerico2',NULL);
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CargoController','Cargo ha sido actualizado con exito. [Aprendiz].','usuarioGenerico2','2016-04-16 09:55:15');
INSERT INTO DB_ENTRY_INDEX.LOG_AUDITORIA VALUES (null,'INFO','edu.co.sena.entryindex.presentacion.managerbeans.CuentaController','Cargo ha sido actualizado con exito. De [CC:1030680430] A [CE:totachi]','usuarioGenerico1','2016-04-16 11:09:23');



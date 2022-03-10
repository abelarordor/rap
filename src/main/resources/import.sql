INSERT INTO `tipousuario` (`idtipousuario`, `nombre`) VALUES (1, 'ADMIN');
INSERT INTO `tipousuario` (`idtipousuario`, `nombre`) VALUES (2, 'VENTAS');
INSERT INTO `tipousuario` (`idtipousuario`, `nombre`) VALUES (3, 'BoDEGERO');
INSERT INTO `usuario` (`contrasena`, `nombre`, `fktipousuario`) VALUES ('santiago', 'Vanegas', '1');
INSERT INTO `usuario` (`contrasena`, `nombre`, `fktipousuario`) VALUES ('damian', 'Cruz', '2');
INSERT INTO `usuario` (`contrasena`, `nombre`, `fktipousuario`) VALUES ( 'Rogelio', 'Oronez', '3');
INSERT INTO `usuario` (`contrasena`, `nombre`, `fktipousuario`) VALUES ('Damian', 'Perez', '2');
INSERT INTO `usuario` ( `contrasena`, `nombre`, `fktipousuario`) VALUES ('Alex', 'brayan', '1');

INSERT INTO `tipo_servicio` ( `nombre`) VALUES ('calidad Agua'), ( 'revision de sistema'), ( 'sistema de riesgos'), ( 'calidad y riego'),( 'calidad y caudal'),( 'paquetecompleto');
INSERT INTO `cliente` (`apellido`, `cedula`, `nombre`) VALUES ('Cabrera', '0150218956', 'Abel'), ( 'jesus', '1234567890', 'abelardo'), ( 'jesus', '1234567490', 'leonardo'), ( 'adrian', '1234554890', 'asanfass');
INSERT INTO `servicios` (`descripcion`, `imgservicos`, `nombre`, `precio`, `fktiposervicio`) VALUES ('Operacion1', 'tec.jpg', 'Agen', '100', '1'), ('afe', 'condesador.jpg', 'MXm', '500', '6');
INSERT INTO `cliente` ( `apellido`, `cedula`, `nombre`) VALUES ('scascas', '0150218956', '324tfdcdscdcsdc');
INSERT INTO `encabezadoventa` (`fechaventa`, `total`, `fkcliente`, `fkusuario`) VALUES ( '2021-09-07', '34534', '1', '3');
INSERT INTO `encabezadoventa` (`fechaventa`, `total`, `fkcliente`, `fkusuario`) VALUES ( '2021-09-07', '34534', '3', '1');
INSERT INTO `encabezadoventa` (`fechaventa`, `total`, `fkcliente`, `fkusuario`) VALUES ( '2021-05-07', '34534', '1', '2');
INSERT INTO `detalleventa` ( `cantidad`, `cantidadagua`, `numlugares`, `preciounidad`, `fkencabezado`, `fkservicios`) VALUES ('123', '3234.3', '13', '10.0', '2', '1');
INSERT INTO `detalleventa` ( `cantidad`, `cantidadagua`, `numlugares`, `preciounidad`, `fkencabezado`, `fkservicios`) VALUES ('123', '3544.3', '13', '1.00', '1', '2');
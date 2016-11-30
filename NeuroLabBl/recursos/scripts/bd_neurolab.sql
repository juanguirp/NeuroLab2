-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Linux (x86_64)
 --
 -- Host: localhost    Database: bd_neurolab
 -- ------------------------------------------------------
 -- Server version	10.1.16-MariaDB
 
 
 -- Base de datos: bd_neurolab
 -- Para crearla:
 -- create database bd_neurolab;
 -- use bd_neurolab;
 
 
 --
 -- Table structure for table `tab_administradores`
 --
 DROP
	TABLE
		IF EXISTS `tab_administradores`;

CREATE TABLE `tab_administradores` (
  `adm_id` varchar(15) NOT NULL COMMENT 'Nombre de usuario que identifica a un administrador',
  `adm_nombre` varchar(30) NOT NULL COMMENT 'Nombre real de un administrador',
  `adm_apellidos` varchar(30) NOT NULL COMMENT 'Apellidos de un administrador',
  `adm_correo` varchar(120) NOT NULL COMMENT 'Correo electronico de un administrador',
  `adm_contrasena` varchar(150) NOT NULL COMMENT 'Contrasena de un administrador',
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena la infomacion de los administradores de solicitudes de prestamo y dispositivos';

--
 -- Table structure for table `tab_investigadores`
 --
 DROP
	TABLE
		IF EXISTS `tab_investigadores`;

CREATE TABLE `tab_investigadores` (
  `inv_id` varchar(15) NOT NULL COMMENT 'Nombre de usuario que identifica a un investigador',
  `inv_nombre` varchar(30) NOT NULL COMMENT 'Nombre real de un investigador',
  `inv_apellidos` varchar(30) NOT NULL COMMENT 'Apellidos de un investigador',
  `inv_correo` varchar(120) NOT NULL COMMENT 'Correo electronico de un investigador',
  `inv_contrasena` varchar(150) NOT NULL COMMENT 'Contrasena de un investigador',
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena la informacion de los investigadores que hacen solicitudes de prestamo';

--
 -- Table structure for table `tab_dispositivos`
 --
 DROP
	TABLE
		IF EXISTS `tab_dispositivos`;

CREATE TABLE `tab_dispositivos` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero que identifica a un dispositivo',
  `dis_disponible` tinyint(4) NOT NULL COMMENT 'Determina si un dispositivo puede o no ser solicitado',
  `dis_especificaciones` varchar(250) NOT NULL COMMENT 'Informacion sobre el dispositivo',
  `dis_registrado_por` varchar(15) NOT NULL COMMENT 'Identifiacion del administrador que registro el dispositivo en la base de datos',
  `dis_fecha_registro` date NOT NULL COMMENT 'Fecha en la que se registro el dispositivo en la base de datos',
  `dis_tipo_dispositivo` varchar(20) NOT NULL COMMENT 'Determina el tipo de dispositivo',
  PRIMARY KEY (`dis_id`),
  KEY `tab_dispositivos_tab_administradores_FK` (`dis_registrado_por`),
  CONSTRAINT `tab_dispositivos_tab_administradores_FK` FOREIGN KEY (`dis_registrado_por`) REFERENCES `tab_administradores` (`adm_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena los dispositivos del laboratorio';

--
 -- Table structure for table `tab_solicitudes_prestamo`
 --
 DROP
	TABLE
		IF EXISTS `tab_solicitudes_prestamo`;

CREATE TABLE `tab_solicitudes_prestamo` (
  `sol_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero que identifica una solicitud de prestamo',
  `sol_fecha_solicitud` date NOT NULL COMMENT 'Fecha en la que se realizo una solicitud de prestamo',
  `sol_solicitante` varchar(15) NOT NULL COMMENT 'Identificacion del investigador que realizo la solicitud de prestamo',
  `sol_procesada_por` varchar(15) NOT NULL COMMENT 'Identificacion del administrador que proceso la solicitud de prestamo',
  `sol_respuesta` tinyint(4) NOT NULL COMMENT 'Respuesta dada por un administrador a la solicitud de un investigador',
  `sol_dispositivo_solicitado` int(11) NOT NULL COMMENT 'Identificacion del dispositivo que se esta solicitando',
  PRIMARY KEY (`sol_id`),
  KEY `tab_solicitudes_prestamo_tab_administradores_FK` (`sol_procesada_por`),
  KEY `tab_solicitudes_prestamo_tab_investigadores_FK` (`sol_solicitante`),
  KEY `tab_solicitudes_prestamo_tab_dispositivos_FK` (`sol_dispositivo_solicitado`),
  CONSTRAINT `tab_solicitudes_prestamo_tab_administradores_FK` FOREIGN KEY (`sol_procesada_por`) REFERENCES `tab_administradores` (`adm_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tab_solicitudes_prestamo_tab_dispositivos_FK` FOREIGN KEY (`sol_dispositivo_solicitado`) REFERENCES `tab_dispositivos` (`dis_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tab_solicitudes_prestamo_tab_investigadores_FK` FOREIGN KEY (`sol_solicitante`) REFERENCES `tab_investigadores` (`inv_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena las solicitudes de prestamo realizadas por los investigadores';

--
 -- Table structure for table `tab_prestamos`
 --
 DROP
	TABLE
		IF EXISTS `tab_prestamos`;

CREATE TABLE `tab_prestamos` (
  `pre_solicitud_asociada` int(11) NOT NULL COMMENT 'Identificacion de la solicitud que se esta detallando',
  `pre_hora_entrega` datetime NOT NULL COMMENT 'Hora de entrega del dispositivo',
  `pre_hora_devolucion` datetime NOT NULL COMMENT 'Hora de devolucion del dispositivo',
  `pre_horas_solicitadas` int(11) NOT NULL COMMENT 'Horas reservadas de un dispositivo',
  `pre_id` int(11) NOT NULL COMMENT 'Identificacion de detalle',
  PRIMARY KEY (`pre_id`),
  KEY `tab_detalles_solicitud_tab_solicitudes_prestamo_FK` (`pre_solicitud_asociada`),
  CONSTRAINT `tab_detalles_solicitud_tab_solicitudes_prestamo_FK` FOREIGN KEY (`pre_solicitud_asociada`) REFERENCES `tab_solicitudes_prestamo` (`sol_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla almacena los detalles de una solicitud de prestamo';

INSERT INTO bd_neurolab.tab_administradores (adm_id,adm_nombre,adm_apellidos,adm_correo,adm_contrasena) VALUES 
('guille','Guillermo','Pineda','guille@pineda.com','uPACVZ9M/HQNst42U1ysaw==')
,('juangui','Juan','Restrepo','juan@restrepo.com','OrUDN5y9HVi1hEDDO2uvkw==')
;

INSERT INTO bd_neurolab.tab_investigadores (inv_id,inv_nombre,inv_apellidos,inv_correo,inv_contrasena) VALUES 
('dani01','Daniel','Ocampo','dani1@invest.com','yesdixUnBMnr7M+M2HBtrQ==')
,('dani02','Daniela','Arboleda','dani@invest.com','G0RAsfLc2zcup69KzeVGsA==')
,('dani03','Danielo','Tercero','eltercero@correo.com','512LSa9TOpy67sWiPlBbYA==')
;

INSERT INTO bd_neurolab.tab_dispositivos (dis_id,dis_disponible,dis_especificaciones,dis_registrado_por,dis_fecha_registro,dis_tipo_dispositivo) VALUES 
(1,0,'Laptop de 12 pulgadas marca Eicer','juangui',STR_TO_DATE('2016-09-01','%Y-%m-%d'),'Portatil')
,(2,0,'Laptop de 14 pulgadas marca Tochiba','juangui',STR_TO_DATE('2016-09-02','%Y-%m-%d'),'Portatil')
,(3,1,'Microscopio optico','guille',STR_TO_DATE('2016-09-03','%Y-%m-%d'),'Microscopio')
;

INSERT INTO bd_neurolab.tab_solicitudes_prestamo (sol_id,sol_fecha_solicitud,sol_solicitante,sol_procesada_por,sol_respuesta,sol_dispositivo_solicitado) VALUES 
(1,STR_TO_DATE('2016-09-01','%Y-%m-%d'),'dani01','guille',0,1)
,(2,STR_TO_DATE('2016-09-01','%Y-%m-%d'),'dani02','juangui',0,2)
;

INSERT INTO bd_neurolab.tab_prestamos (pre_solicitud_asociada,pre_hora_entrega,pre_hora_devolucion,pre_horas_solicitadas,pre_id) VALUES 
(2,STR_TO_DATE('2016-09-01 01:02:03','%Y-%m-%d %H:%i:%s'),STR_TO_DATE('2016-09-01 03:02:03','%Y-%m-%d %H:%i:%s'),3,1)
;

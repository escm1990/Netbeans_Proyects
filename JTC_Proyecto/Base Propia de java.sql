/*
SQLyog Community Edition- MySQL GUI v5.2 RC2
Host - 5.1.36-community : Database - examenes_bd
*********************************************************************
Server version : 5.1.36-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `examenes_bd`;

USE `examenes_bd`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`usuario`,`clave`) values ('gerson','gerson');

/*Table structure for table `opcion_multiple` */

DROP TABLE IF EXISTS `opcion_multiple`;

CREATE TABLE `opcion_multiple` (
  `id_opcionM` int(11) NOT NULL AUTO_INCREMENT,
  `cod_parcial` int(11) NOT NULL,
  `preguntaO` varchar(300) NOT NULL,
  `respuesta1` varchar(150) NOT NULL,
  `respuesta2` varchar(150) NOT NULL,
  `respuesta3` varchar(150) NOT NULL,
  `respuesta4` varchar(150) DEFAULT NULL,
  `respuesta5` varchar(150) DEFAULT NULL,
  `numPregunta` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_opcionM`,`cod_parcial`),
  KEY `FK_opcion_multiple` (`cod_parcial`),
  CONSTRAINT `FK_opcion_multiple` FOREIGN KEY (`cod_parcial`) REFERENCES `parcial` (`cod_parcial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `opcion_multiple` */

/*Table structure for table `parcial` */

DROP TABLE IF EXISTS `parcial`;

CREATE TABLE `parcial` (
  `cod_parcial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_parcial` varchar(50) NOT NULL,
  `fecha_parcial` date NOT NULL,
  `materia` varchar(100) NOT NULL,
  `grupo_teorico` varchar(5) NOT NULL,
  `departamento` varchar(25) NOT NULL,
  `nombre_docente` varchar(200) NOT NULL,
  `tipo_parcial` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_parcial`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Data for the table `parcial` */

/*Table structure for table `preguntas` */

DROP TABLE IF EXISTS `preguntas`;

CREATE TABLE `preguntas` (
  `id_pregunta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cod_parcial` int(11) NOT NULL,
  `pregunta` varchar(500) NOT NULL,
  `respuesta` varchar(500) DEFAULT NULL,
  `num_pregunta` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_pregunta`,`cod_parcial`),
  KEY `FK_preguntas_1` (`cod_parcial`),
  CONSTRAINT `FK_preguntas` FOREIGN KEY (`cod_parcial`) REFERENCES `parcial` (`cod_parcial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

/*Data for the table `preguntas` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

/*
SQLyog Community Edition- MySQL GUI v5.2 RC2
Host - 5.5.17 : Database - dbsample
*********************************************************************
Server version : 5.5.17
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `dbsample`;

USE `dbsample`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_nombre` varchar(20) NOT NULL,
  `p_paterno` varchar(20) NOT NULL,
  `p_materno` varchar(20) DEFAULT NULL,
  `p_direccion` varchar(100) DEFAULT NULL,
  `p_telefono` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `persona` */

insert  into `persona`(`p_id`,`p_nombre`,`p_paterno`,`p_materno`,`p_direccion`,`p_telefono`) values (1,'Antonio','Bragueta','Suelta','Calle Imaginaria # 345','123-456-789');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

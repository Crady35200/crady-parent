/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.7.13-log : Database - crady
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crady` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crady`;


DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`name`,`password`,`age`,`sex`) values (1,'crady','password',25,'1'),(2,'zhou','pass',32,'0'),(3,'ming','a123',25,'1'),(4,'lily','bfdasi',18,'0'),(5,'nick','333',28,'1'),(6,'jack','444',30,'1'),(7,'cat','555',30,'0'),(8,'周星驰','666',54,'1'),(12,'pig','666555',NULL,'0'),(13,'batch01','password01',10,NULL),(14,'batch01','password01',10,NULL);

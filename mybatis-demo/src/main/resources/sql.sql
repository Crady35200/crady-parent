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

/*Table structure for table `t_job` */

DROP TABLE IF EXISTS `t_job`;

CREATE TABLE `t_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `start_time` datetime DEFAULT NULL COMMENT '工作起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '工作结束时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_job` */

insert  into `t_job`(`id`,`company_name`,`start_time`,`end_time`,`user_id`) values (1,'百度','2013-07-01 16:46:29','2015-08-03 16:46:36',1),(2,'阿里','2015-08-04 16:47:16','2017-11-08 16:47:31',1),(3,'金蝶','2017-11-09 16:47:56','2019-07-05 16:48:05',1),(4,'金证股份','2013-07-01 16:46:29','2017-11-08 16:47:31',3),(5,'平安科技','2015-08-04 16:47:16','2019-07-05 16:48:05',3),(6,'投哪网','2013-07-01 16:46:29','2017-11-08 16:47:31',5),(7,'长亮科技','2015-08-04 16:47:16','2019-07-05 16:48:05',5),(8,'深信服','2013-07-01 16:46:29','2015-08-03 16:46:36',6),(9,'华为','2015-08-04 16:47:16','2017-11-08 16:47:31',6),(10,'中兴通讯','2017-11-09 16:47:31','2019-07-05 16:48:05',6);

/*Table structure for table `t_user` */

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

/*Table structure for table `t_user_account` */

DROP TABLE IF EXISTS `t_user_account`;

CREATE TABLE `t_user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `account_no` varchar(32) NOT NULL COMMENT '银行账户',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf32;

/*Data for the table `t_user_account` */

insert  into `t_user_account`(`id`,`user_id`,`account_no`,`crt_time`,`upd_time`) values (1,5,'6217002870016316992','2018-02-07 11:19:32','2018-02-07 11:19:32'),(2,6,'6222621510000640095','2019-04-25 17:21:53','2019-04-25 17:21:53'),(3,1,'6225887806041238','2019-07-05 10:01:41','2019-07-05 10:01:42'),(4,2,'6222024000077695357','2019-07-05 10:01:52','2019-07-05 10:01:54'),(5,3,'6222020200034777934','2019-07-05 10:02:03','2019-07-05 10:02:05'),(6,4,'6214836552238707','2019-07-05 10:02:13','2019-07-05 10:02:16'),(7,7,'6222080602000300541','2019-07-05 10:02:36','2019-07-05 10:02:37'),(8,8,'6227000490600107003','2019-07-05 10:02:45','2019-07-05 10:02:46'),(9,9,'6222080603001098332','2019-07-05 15:18:16','2019-07-05 15:18:18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

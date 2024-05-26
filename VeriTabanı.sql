/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.36 : Database - ucak_otomasyonu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ucak_otomasyonu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ucak_otomasyonu`;

/*Table structure for table `biletler` */

DROP TABLE IF EXISTS `biletler`;

CREATE TABLE `biletler` (
  `musteri_username` varchar(255) DEFAULT NULL,
  `departure` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `seferTarihi` date DEFAULT NULL,
  `kalkisSaati` time DEFAULT NULL,
  `inisSaati` time DEFAULT NULL,
  `paket` varchar(255) DEFAULT NULL,
  `koltuk` varchar(255) DEFAULT NULL,
  `yemek` varchar(255) DEFAULT NULL,
  `bagaj` varchar(255) DEFAULT NULL,
  `hizmet` varchar(255) DEFAULT NULL,
  `fiyat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `biletler` */

insert  into `biletler`(`musteri_username`,`departure`,`destination`,`seferTarihi`,`kalkisSaati`,`inisSaati`,`paket`,`koltuk`,`yemek`,`bagaj`,`hizmet`,`fiyat`) values 
('user2','İstanbul','Roma','2024-06-03','13:10:00','14:50:00','AVANTAJ','3B','Dana Etli Sandviç','15KG','Seyahat Sigortası, Uçak İçi Eğlence, Bilet Flex','3475TL');

/*Table structure for table `kullanici` */

DROP TABLE IF EXISTS `kullanici`;

CREATE TABLE `kullanici` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ad` varchar(255) DEFAULT NULL,
  `soyad` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `dogum_tarihi` date DEFAULT NULL,
  `cinsiyet` varchar(50) DEFAULT NULL,
  `tlfno` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sifre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `kullanici` */

insert  into `kullanici`(`id`,`ad`,`soyad`,`username`,`dogum_tarihi`,`cinsiyet`,`tlfno`,`email`,`sifre`) values 
(1,'Damla','Kurt','user','2003-08-26','Kadın','5069926487','damlaku33@gmail.com','123'),
(2,'damla','kurt','admin','2003-08-26','Kadın','5069926487','damlaku33@gmail.com','123'),
(3,'Damla','Kurt','asdamlak','2003-08-26','Kadın','5069926487','damlaku33@gmail.com','123'),
(4,'Funda','Kurt','fundakurt','1975-05-07','Kadın','5059381394','damlaku33@gmail.com','123'),
(5,'Damla','Kurt','user1','2003-08-26','Kadın','5069926487','damlaku33@gmail.com','123'),
(6,'damla','kurt','user2','2007-05-16','Kadın','5069926487','akurt.mdbf22@iste.edu.tr','123'),
(7,'Damla','Kurt','user3','2012-05-09','Kadın','5048735232','damlaku33@gmail.com','123'),
(8,'damla','kurt','user4','2004-05-06','Kadın','5056983265','damlaku33@gmail.com','123');

/*Table structure for table `ucuslar` */

DROP TABLE IF EXISTS `ucuslar`;

CREATE TABLE `ucuslar` (
  `ucusNumarası` varchar(255) DEFAULT NULL,
  `departure` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `seferTarihi` date DEFAULT NULL,
  `kalkisSaati` time DEFAULT NULL,
  `inisSaati` time DEFAULT NULL,
  `fiyat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ucuslar` */

insert  into `ucuslar`(`ucusNumarası`,`departure`,`destination`,`seferTarihi`,`kalkisSaati`,`inisSaati`,`fiyat`) values 
('GU666','İstanbul','Roma','2024-06-03','13:10:00','14:50:00','2850'),
('NY642','Roma','İstanbul','2024-06-10','11:55:00','15:25:00','3500'),
('TW156','İstanbul','İzmir','2024-07-02','05:55:00','07:15:00','1600'),
('HH385','İstanbul','Ankara','2024-06-06','15:10:00','16:20:00','2000');

/*Table structure for table `yemekler` */

DROP TABLE IF EXISTS `yemekler`;

CREATE TABLE `yemekler` (
  `yemekturu` varchar(255) DEFAULT NULL,
  `yemek` varchar(255) DEFAULT NULL,
  `fiyat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `yemekler` */

insert  into `yemekler`(`yemekturu`,`yemek`,`fiyat`) values 
('sandviç','vejetaryen sandviç','190'),
('Makarna','Mantarlı Ravioli','478'),
('sandviç','Kaşarlı Hindi Fümeli','160'),
('sandviç','Kuru Domates Pesto','160'),
('sandviç','etli sandviç','100'),
('Sandviç','Dana Etli Sandviç','100'),
('salata','ton balıklı salata','160'),
('salata','mısırlı salata','100'),
('makarna','bolonez soslu makarna','150');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

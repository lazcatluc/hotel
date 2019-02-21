-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for rdbms
CREATE DATABASE IF NOT EXISTS `rdbms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `rdbms`;

-- Dumping structure for table rdbms.hotels
CREATE TABLE IF NOT EXISTS `hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table rdbms.hotels: ~8 rows (approximately)
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` (`id`, `name`) VALUES
	(1, 'Masseria'),
	(2, 'Tongabezi'),
	(3, 'Hotel Escondido'),
	(4, 'Blackberry Farm'),
	(5, 'Ritz'),
	(6, 'Longitude 131'),
	(7, 'Le Grand Bellevue'),
	(8, 'Belmond Grand Hotel');
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;

-- Dumping structure for table rdbms.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `type_id` int(11) NOT NULL,
  `floor` tinyint(4) NOT NULL DEFAULT 0,
  `hotel_id` int(11) NOT NULL,
  `capacity` tinyint(4) NOT NULL DEFAULT 2,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_ROOM_HOTEL_NAME` (`name`,`hotel_id`),
  KEY `INDEX_TYPE_ID` (`type_id`),
  KEY `INDEX_HOTEL_ID` (`hotel_id`),
  CONSTRAINT `FK_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`),
  CONSTRAINT `FK_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table rdbms.rooms: ~55 rows (approximately)
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`id`, `name`, `type_id`, `floor`, `hotel_id`, `capacity`, `price`) VALUES
	(1, '10', 1, 1, 1, 1, 81),
	(2, '11', 1, 1, 1, 1, 112),
	(3, '12', 1, 1, 1, 1, 44),
	(4, '21', 2, 2, 1, 2, 52),
	(5, '22', 2, 2, 1, 2, 56),
	(6, '23', 2, 2, 1, 2, 63),
	(7, '10', 1, 1, 2, 1, 105),
	(8, '11', 1, 1, 2, 1, 120),
	(9, '12', 2, 1, 2, 2, 46),
	(10, '13', 2, 1, 2, 2, 42),
	(11, '14', 2, 1, 2, 2, 25),
	(12, '15', 2, 1, 2, 3, 120),
	(13, '20', 3, 2, 2, 4, 119),
	(14, '21', 3, 2, 2, 4, 81),
	(15, '22', 3, 2, 2, 4, 64),
	(16, '30', 3, 3, 2, 6, 123),
	(17, 'President Ford', 4, 3, 2, 2, 78),
	(18, 'Ronald Reagan', 4, 3, 2, 4, 37),
	(19, '100', 2, 1, 3, 2, 38),
	(20, '101', 2, 1, 3, 2, 93),
	(21, '201', 2, 2, 3, 3, 96),
	(22, '202', 2, 2, 3, 3, 87),
	(23, '301', 3, 3, 3, 4, 51),
	(24, '302', 3, 3, 3, 6, 25),
	(25, '1', 2, 0, 4, 4, 72),
	(26, '2', 2, 0, 4, 8, 53),
	(27, '2001', 1, 20, 5, 1, 15),
	(28, '2002', 1, 20, 5, 1, 112),
	(29, '4001', 3, 40, 5, 4, 61),
	(30, '4002', 3, 40, 5, 4, 63),
	(31, 'Summer', 4, 40, 5, 2, 147),
	(32, '500', 2, 50, 6, 2, 126),
	(33, '501', 2, 50, 6, 2, 126),
	(34, '502', 2, 50, 6, 2, 38),
	(35, '503', 2, 50, 6, 2, 93),
	(36, '504', 3, 50, 6, 2, 54),
	(37, '505', 3, 50, 6, 2, 37),
	(38, '801', 4, 80, 6, 3, 5),
	(39, '802', 4, 80, 6, 3, 136),
	(40, '10', 1, 1, 7, 1, 82),
	(41, '11', 1, 1, 7, 1, 64),
	(42, '12', 1, 1, 7, 1, 71),
	(43, '13', 1, 1, 7, 1, 76),
	(44, 'Spring', 2, 2, 7, 2, 80),
	(45, 'Autumn', 2, 2, 7, 2, 97),
	(46, 'Winter', 2, 2, 7, 2, 84),
	(47, 'Summer', 2, 2, 7, 2, 17),
	(60, '801', 1, 80, 8, 1, 94),
	(61, '802', 1, 80, 8, 1, 67),
	(62, '901', 2, 90, 8, 2, 54),
	(63, '902', 2, 90, 8, 2, 70),
	(64, '1001', 3, 100, 8, 4, 71),
	(65, '1002', 3, 100, 8, 4, 111),
	(66, '1003', 4, 100, 8, 2, 56),
	(67, '1004', 4, 100, 8, 4, 48);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

-- Dumping structure for table rdbms.types
CREATE TABLE IF NOT EXISTS `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table rdbms.types: ~4 rows (approximately)
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` (`id`, `name`) VALUES
	(3, 'Apartment'),
	(2, 'Double'),
	(4, 'Executive'),
	(1, 'Single');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guest` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `room_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_reservation_room` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



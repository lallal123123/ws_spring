-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- article 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `article` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `article`;

-- 테이블 article.article 구조 내보내기
CREATE TABLE IF NOT EXISTS `article` (
  `ano` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `writeDate` date DEFAULT current_timestamp(),
  `update` date DEFAULT NULL,
  `uploadDate` date DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `approve` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`ano`),
  KEY `username` (`username`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`username`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 article.article:~2 rows (대략적) 내보내기
INSERT INTO `article` (`ano`, `title`, `writeDate`, `update`, `uploadDate`, `username`, `content`, `img`, `approve`) VALUES
	(2, 'sdfasdfasf', '2024-06-05', NULL, NULL, 'user1', 'asfasfasfs', 'x.jpg', 0),
	(3, 'sdfsdf', '2024-06-05', NULL, NULL, 'user1', 'gdsgdfgdf', '딸기1.jpg', 0);

-- 테이블 article.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `ROLE` enum('ROLE_EDITOR','ROLE_JOURNALIST') DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 article.member:~5 rows (대략적) 내보내기
INSERT INTO `member` (`username`, `PASSWORD`, `ROLE`) VALUES
	('editor', '$2a$10$6y6fFWHcps0SIQOdWOcBiOf0YisqqsPtx1iuTgNEKOlW/2KWmHXP.', 'ROLE_EDITOR'),
	('user1', '$2a$10$CeueAq1hbI7XowAynra31ueEn6Um6se143PTSxiqEYWsU2rZSC8oK', 'ROLE_JOURNALIST'),
	('user2', '$2a$10$6LQ81OVvTp8bi8Yb8mGNuek1VC0NzfSJ4pcrwErNCERj7lCtKW4U6', 'ROLE_JOURNALIST'),
	('user3', '$2a$10$2FdY4ggPct7osbfq2HcHcOLq7jKp903zhA0fBqWARr9eb7seOrM1m', 'ROLE_JOURNALIST'),
	('user4', '$2a$10$epKVlVhEuBoPL3FDMt92P.oQlDoWUOHUfzAyL6rUBFDNrdDHUwPXi', 'ROLE_JOURNALIST');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

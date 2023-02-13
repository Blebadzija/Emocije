-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



-- Dumping data for table db_emocije_ah.emocije: ~9 rows (approximately)
INSERT INTO `emocije` (`ID`, `Vrsta_emocije`, `Poruka`) VALUES
	(1, 'Radost', 'Prije nego što krenete tražiti sreću, provjerite - možda ste već sretni.\r\nSreća je mala, obična i neupadljiva, i mnogi ju ne znaju vidjeti.\r\n\r\nDuško Radović'),
	(2, 'Ljutnja', 'Ljutnja je – stanje duše. U suštini, mi sami donosimo odluku da li ćemo biti ljuti. I kad, sledeći put rešite da se naljutite, razmislite: da li je to zaista tako lepo sebe sažaljevati? Predator uvek oseća slabijeg, i napada baš njega. Ne kaže se džaba u narodu: „Pusti je kraju“! Pustite ljutnju, nek ide svojim putem!'),
	(3, 'Tuga', 'Tuga se naginje jače ako primijeti da mu podlegnu. \r\n\r\nWilliam Shakespeare'),
	(4, 'Strah', 'Moj strah je taj koji mi daje hrabrost. \r\n\r\nBob Marli'),
	(5, 'Ljubav', 'Samo se srcem može zaista gledati. Ono što je suštinski važno, nevidljivo je oku. – \r\n\r\nAntoan de Sent Egziperi'),
	(6, 'Nada', 'Cvet nade cveta i u najdubljoj tamnici.\r\nKineske poslovice'),
	(7, 'Zavist', 'Ako u srcu imate gorku zavist i svadljivost, ne uznosite se i ne lažite protiv istine! Nije to mudrost koja odozgor silazi, nego zemaljska, ljudska, đavolska. Ta gdje je zavist i svadljivost, ondje je nered i svako zlo djelo.  – Jakov 3,14-15\r\n8;Ljubomora;U ljubomori ima više ljubavi prema sebi nego ljubavi.\r\nFrancois de La Rochefoucauld'),
	(8, 'Ponos', ' "Isti ponos koji čini da se čovjek ponaša bahato prema podređenima, čini da se ponaša pokorno onima iznad njega. Takva je sama priroda ovog poroka, koji nije baziran na osobnoj zasluzi ni na vrlini, nego na bogatstvu, funkciji, utjecaju, beskorisnom znanju, da tjera čovjeka da bude ohol prema onima ispod njega kao i da precjenjuje one koji su iznad njega.'),
	(9, 'Smirenost', 'Pomiri se sam sa sobom i s\' tobom ce se pomiriti nebo i zemlja.\r\n-Sveti Isak Sirin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

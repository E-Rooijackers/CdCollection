-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2018 at 03:13 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cdcollection`
--
CREATE DATABASE IF NOT EXISTS `cdcollection` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cdcollection`;

-- --------------------------------------------------------

--
-- Table structure for table `albums`
--

CREATE TABLE IF NOT EXISTS `albums` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `artist` varchar(200) NOT NULL,
  `genre` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `genre` (`genre`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `albums`
--

INSERT INTO `albums` (`id`, `name`, `artist`, `genre`, `year`) VALUES
(1, 'I Remeber', 'Deadmau5', 53, 2008),
(2, 'Compton', 'Dr. Dre', 16, 2018),
(3, 'Metallica', 'Metallica', 18, 1991);

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE IF NOT EXISTS `genres` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre_name` varchar(100) NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`genre_id`, `genre_name`) VALUES
(1, 'Blues'),
(2, 'Classic Rock'),
(4, 'Dance'),
(5, 'Disco'),
(6, 'Funk'),
(7, 'Grunge'),
(8, 'Hip-Hop'),
(10, 'Metal'),
(13, 'Other'),
(14, 'Pop'),
(15, 'R&B'),
(16, 'Rap'),
(17, 'Reggae'),
(18, 'Rock'),
(19, 'Techno'),
(21, 'Alternative'),
(23, 'Death Metal'),
(24, 'Pranks'),
(25, 'Soundtrack'),
(26, 'Euro-Techno'),
(27, 'Ambient'),
(28, 'Trip-Hop'),
(29, 'Vocal'),
(30, 'Jazz+Funk'),
(31, 'Fusion'),
(32, 'Trance'),
(33, 'Classical'),
(34, 'Instrumental'),
(35, 'Acid'),
(36, 'House'),
(37, 'Game'),
(38, 'Sound Clip'),
(39, 'Gospel'),
(40, 'Noise'),
(41, 'AlternRock'),
(42, 'Bass'),
(43, 'Soul'),
(44, 'Punk'),
(45, 'Space'),
(46, 'Meditative'),
(47, 'Instrumental Pop'),
(48, 'Instrumental Rock'),
(49, 'Ethnic'),
(50, 'Gothic'),
(51, 'Darkwave'),
(52, 'Techno-Industrial'),
(53, 'Electronic'),
(54, 'Pop-Folk'),
(55, 'Eurodance'),
(56, 'Dream'),
(57, 'Southern Rock'),
(58, 'Comedy'),
(59, 'Cult'),
(60, 'Gangsta'),
(61, 'Top 40'),
(62, 'Christian Rap'),
(63, 'Pop/Funk'),
(64, 'Jungle'),
(65, 'Native American'),
(66, 'Cabaret'),
(67, 'New Wave'),
(68, 'Psychadelic'),
(69, 'Rave'),
(70, 'Showtunes'),
(71, 'Trailer'),
(72, 'Lo-Fi'),
(73, 'Tribal'),
(74, 'Acid Punk'),
(75, 'Acid Jazz'),
(76, 'Polka'),
(77, 'Retro'),
(78, 'Musical'),
(79, 'Rock & Roll'),
(80, 'Hard Rock'),
(81, 'Folk'),
(82, 'Folk-Rock'),
(83, 'National Folk'),
(84, 'Swing'),
(85, 'Fast Fusion'),
(86, 'Bebob'),
(87, 'Latin'),
(88, 'Revival'),
(89, 'Celtic'),
(90, 'Bluegrass'),
(91, 'Avantgarde'),
(92, 'Gothic Rock'),
(93, 'Progressive Rock'),
(94, 'Psychedelic Rock'),
(95, 'Symphonic Rock'),
(96, 'Slow Rock'),
(97, 'Big Band'),
(98, 'Chorus'),
(99, 'Easy Listening'),
(101, 'Humour'),
(102, 'Speech'),
(103, 'Chanson'),
(104, 'Opera'),
(105, 'Chamber Music'),
(106, 'Sonata'),
(107, 'Symphony'),
(108, 'Booty Bass'),
(109, 'Primus'),
(110, 'Porn Groove'),
(111, 'Satire'),
(112, 'Slow Jam'),
(113, 'Club'),
(114, 'Tango'),
(115, 'Samba'),
(116, 'Folklore'),
(117, 'Ballad'),
(118, 'Power Ballad'),
(119, 'Rhythmic Soul'),
(120, 'Freestyle'),
(121, 'Duet'),
(122, 'Punk Rock'),
(123, 'Drum Solo'),
(124, 'Acapella'),
(125, 'Euro-House'),
(126, 'Dance Hall'),
(127, 'Merlijnski');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `albums`
--
ALTER TABLE `albums`
  ADD CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`genre`) REFERENCES `genres` (`genre_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

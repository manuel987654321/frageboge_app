-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2013 at 10:40 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fragebogen_datenbank`
--
CREATE DATABASE IF NOT EXISTS `fragebogen_datenbank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fragebogen_datenbank`;

-- --------------------------------------------------------

--
-- Table structure for table `dritterfragebogen`
--

CREATE TABLE IF NOT EXISTS `dritterfragebogen` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `1teantwort` varchar(20) NOT NULL,
  `2teantwort` varchar(20) NOT NULL,
  `3teantwort` varchar(20) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `dritterfragebogen`
--

INSERT INTO `dritterfragebogen` (`fid`, `1teantwort`, `2teantwort`, `3teantwort`) VALUES
(4, 'ja', 'ja', 'Golf'),
(5, 'nein', 'nein', 'Bergsteigen');

-- --------------------------------------------------------

--
-- Table structure for table `ersterfragebogen`
--

CREATE TABLE IF NOT EXISTS `ersterfragebogen` (
  `f1id` int(10) NOT NULL AUTO_INCREMENT,
  `1te antwort` varchar(20) DEFAULT NULL,
  `2te antwort` varchar(20) DEFAULT NULL,
  `3te antwort` varchar(20) DEFAULT NULL,
  `4te antwort` varchar(20) DEFAULT NULL,
  `5te antwort` varchar(20) DEFAULT NULL,
  `6te antwort` varchar(20) DEFAULT NULL,
  `7te antwort` varchar(20) DEFAULT NULL,
  `8te antwort` varchar(20) DEFAULT NULL,
  `9te antwort` varchar(20) DEFAULT NULL,
  `10te antwort` varchar(20) DEFAULT NULL,
  `11te antwort` varchar(20) DEFAULT NULL,
  `12te antwort` varchar(20) DEFAULT NULL,
  `13te antwort` varchar(20) DEFAULT NULL,
  `14te antwort` varchar(20) DEFAULT NULL,
  `15te antwort` varchar(20) DEFAULT NULL,
  `16te antwort` varchar(20) DEFAULT NULL,
  `17te antwort` varchar(20) DEFAULT NULL,
  `18te antwort` varchar(20) DEFAULT NULL,
  `19te antwort` varchar(20) DEFAULT NULL,
  `20te antwort` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`f1id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `ersterfragebogen`
--

INSERT INTO `ersterfragebogen` (`f1id`, `1te antwort`, `2te antwort`, `3te antwort`, `4te antwort`, `5te antwort`, `6te antwort`, `7te antwort`, `8te antwort`, `9te antwort`, `10te antwort`, `11te antwort`, `12te antwort`, `13te antwort`, `14te antwort`, `15te antwort`, `16te antwort`, `17te antwort`, `18te antwort`, `19te antwort`, `20te antwort`) VALUES
(1, 'ja', 'ja', 'ja', 'nein', 'ja', 'nein', 'ja', 'nein', 'ja', 'nein', ' nein', 'ja', 'ja', 'ja', 'nein', 'nein', 'ja', 'ja', 'nein', 'ja'),
(2, 'nein', 'nein', 'nein', 'ja', 'ja', 'nein', 'ja', 'nein', 'ja', 'nein', ' nein', 'ja', 'ja', 'ja', 'ja', 'ja', 'ja', 'ja', 'nein', 'ja');

-- --------------------------------------------------------

--
-- Table structure for table `zweiterfragebogen`
--

CREATE TABLE IF NOT EXISTS `zweiterfragebogen` (
  `f2id` int(10) NOT NULL AUTO_INCREMENT,
  `1te antwort` varchar(20) DEFAULT NULL,
  `2te antwort` varchar(20) DEFAULT NULL,
  `3te antwort` varchar(20) DEFAULT NULL,
  `4te antwort` varchar(20) DEFAULT NULL,
  `5te antwort` varchar(20) DEFAULT NULL,
  `6te antwort` varchar(20) DEFAULT NULL,
  `7te antwort` varchar(20) DEFAULT NULL,
  `8te antwort` varchar(20) DEFAULT NULL,
  `9te antwort` varchar(20) DEFAULT NULL,
  `10te antwort` varchar(20) DEFAULT NULL,
  `11te antwort` varchar(20) DEFAULT NULL,
  `12te antwort` varchar(20) DEFAULT NULL,
  `13te antwort` varchar(20) DEFAULT NULL,
  `14te antwort` varchar(20) DEFAULT NULL,
  `15te antwort` varchar(20) DEFAULT NULL,
  `16te antwort` varchar(20) DEFAULT NULL,
  `17te antwort` varchar(20) DEFAULT NULL,
  `18te antwort` varchar(20) DEFAULT NULL,
  `19te antwort` varchar(20) DEFAULT NULL,
  `20te antwort` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`f2id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

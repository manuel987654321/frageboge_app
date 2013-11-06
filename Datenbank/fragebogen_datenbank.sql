-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 05. Nov 2013 um 12:38
-- Server Version: 5.6.11
-- PHP-Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `fragebogen_datenbank`
--
CREATE DATABASE IF NOT EXISTS `fragebogen_datenbank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fragebogen_datenbank`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `erstetabelle`
--

CREATE TABLE IF NOT EXISTS `erstetabelle` (
  `f1id` int(10) NOT NULL AUTO_INCREMENT,
  `1te antwort` varchar(20) NOT NULL,
  `2te antwort` varchar(20) NOT NULL,
  `3te antwort` varchar(20) NOT NULL,
  `4te antwort` varchar(20) NOT NULL,
  `5te antwort` varchar(20) NOT NULL,
  PRIMARY KEY (`f1id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `erstetabelle`
--

INSERT INTO `erstetabelle` (`f1id`, `1te antwort`, `2te antwort`, `3te antwort`, `4te antwort`, `5te antwort`) VALUES
(1, 'ja', 'nein', 'nein', 'ja', 'ja'),
(2, 'ja', 'ja', 'nein', 'nein', 'ja');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `zweitetabelle`
--

CREATE TABLE IF NOT EXISTS `zweitetabelle` (
  `f2id` int(10) NOT NULL AUTO_INCREMENT,
  `1teantwort` varchar(20) NOT NULL,
  `2teantwort` varchar(20) NOT NULL,
  `3teantwort` varchar(20) NOT NULL,
  `4teantwort` varchar(20) NOT NULL,
  `5teantwort` varchar(20) NOT NULL,
  PRIMARY KEY (`f2id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `zweitetabelle`
--

INSERT INTO `zweitetabelle` (`f2id`, `1teantwort`, `2teantwort`, `3teantwort`, `4teantwort`, `5teantwort`) VALUES
(1, 'ja', 'nein', 'nein', 'ja', 'ja');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 16, 2020 at 07:02 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = `NO_AUTO_VALUE_ON_ZERO`;
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = `+00:00`;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `portnet`
--
CREATE DATABASE IF NOT EXISTS `portnet`;
USE `portnet`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
(0, 'name', 'name@smu.edu.sg', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `vessel`
--

DROP TABLE IF EXISTS `vessel`;
CREATE TABLE IF NOT EXISTS `vessel` (
  `uniqueId` varchar(58) NOT NULL,
  `imoN` varchar(12) NULL,
  `fullVslM` varchar(48) NOT NULL,
  `abbrVslM` varchar(32) NOT NULL,
  `fullInVoyN` varchar(10) NULL,
  `inVoyN` varchar(8) NOT NULL,
  `fullOutVoyN` varchar(10) NULL,
  `outVoyN` varchar(8) NOT NULL,
  `shiftSeqN` varchar(5) NOT NULL,
  `bthgDt` varchar(21) NOT NULL,
  `unbthgDt` varchar(21) NOT NULL,
  `berthN` varchar(10) NULL,
  `status` varchar(12) NOT NULL,
  `abbrTerminalM` varchar(8) NULL,
  PRIMARY KEY (`uniqueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voyage_fav`
--

DROP TABLE IF EXISTS `voyage_fav`;
CREATE TABLE IF NOT EXISTS `voyage_fav` (
  `user_id` int(11) NOT NULL,
  `voyage_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`voyage_id`)
--   KEY `voyage_fav_fk2` (`voyage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voyage_sub`
--

DROP TABLE IF EXISTS `voyage_sub`;
CREATE TABLE IF NOT EXISTS `voyage_sub` (
  `user_id` int(11) NOT NULL,
  `voyage_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`voyage_id`)
--   KEY `voyage_sub_fk2` (`voyage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `voyage`
--

DROP TABLE IF EXISTS `voyage`;
CREATE TABLE IF NOT EXISTS `voyage` (
  `voyage_id` int(11) NOT NULL,
  `berth_number` varchar(3) NOT NULL,
  `status` varchar(9) NOT NULL,
  `change_count` int(2) NOT NULL,
  PRIMARY KEY (`voyage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voyage_id`
--

DROP TABLE IF EXISTS `voyage_id`;
CREATE TABLE IF NOT EXISTS `voyage_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vessel_name` varchar(32) NOT NULL,
  `voyage_num` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
--   KEY `voyage_id_fk1` (`vessel_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voyage_in`
--

DROP TABLE IF EXISTS `voyage_in`;
CREATE TABLE IF NOT EXISTS `voyage_in` (
  `id` int(11) NOT NULL,
  `berth_dt` varchar(32) NOT NULL,
  `first_berth_dt` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voyage_out`
--

DROP TABLE IF EXISTS `voyage_out`;
CREATE TABLE IF NOT EXISTS `voyage_out` (
  `id` int(11) NOT NULL,
  `depart_dt` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --
-- -- Constraints for dumped tables
-- --
-- --
-- --
-- -- Constraints for table `voyage_fav`
-- --
-- ALTER TABLE `voyage_fav`
--   ADD CONSTRAINT `voyage_fav_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
--   ADD CONSTRAINT `voyage_fav_fk2` FOREIGN KEY (`voyage_id`) REFERENCES `voyage_id` (`id`);
--
-- --
-- -- Constraints for table `voyage_sub`
-- --
-- ALTER TABLE `voyage_sub`
--   ADD CONSTRAINT `voyage_sub_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
--   ADD CONSTRAINT `voyage_sub_fk2` FOREIGN KEY (`voyage_id`) REFERENCES `voyage_id` (`id`);

-- --
-- -- Constraints for table `voyage`
-- --
-- ALTER TABLE `voyage`
--   ADD CONSTRAINT `voyage_fk1` FOREIGN KEY (`voyage_id`) REFERENCES `voyage_id` (`id`);
--
-- --
-- -- Constraints for table `voyage_id`
-- --
-- ALTER TABLE `voyage_id`
--   ADD CONSTRAINT `voyage_id_fk1` FOREIGN KEY (`vessel_name`) REFERENCES `vessel` (`uniqueId`);
--
-- --
-- -- Constraints for table `voyage_in`
-- --
-- ALTER TABLE `voyage_in`
--   ADD CONSTRAINT `voyage_in_fk1` FOREIGN KEY (`id`) REFERENCES `voyage` (`voyage_id`);
--
-- --
-- -- Constraints for table `voyage_out`
-- --
-- ALTER TABLE `voyage_out`
--   ADD CONSTRAINT `voyage_out_fk1` FOREIGN KEY (`id`) REFERENCES `voyage` (`voyage_id`);
-- COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
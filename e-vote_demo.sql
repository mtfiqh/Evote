-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2018 at 01:51 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e-vote_demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `calon`
--

CREATE TABLE `calon` (
  `NIM` varchar(8) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `keterangan` char(255) DEFAULT NULL,
  `dipilih` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calon`
--

INSERT INTO `calon` (`NIM`, `Nama`, `keterangan`, `dipilih`) VALUES
('14116162', 'calon 1', 'apaaa gitu', 0),
('14117062', 'calon 2', 'NOTHING IS IMPOSSIBLE', 260);

-- --------------------------------------------------------

--
-- Table structure for table `loginsuper`
--

CREATE TABLE `loginsuper` (
  `username` char(25) NOT NULL,
  `password` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loginsuper`
--

INSERT INTO `loginsuper` (`username`, `password`) VALUES
('jao', 'secret'),
('taufiq', 'secret');

-- --------------------------------------------------------

--
-- Table structure for table `loginvoter`
--

CREATE TABLE `loginvoter` (
  `username` char(8) NOT NULL,
  `password` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loginvoter`
--

INSERT INTO `loginvoter` (`username`, `password`) VALUES
('362515273', 'vSGyFw:s'),
('362515333', ';r}{nfNp');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` varchar(8) NOT NULL,
  `Nama` char(25) NOT NULL,
  `kd_prodi` varchar(100) NOT NULL,
  `keterangan` tinyint(1) NOT NULL,
  `vote_who` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `Nama`, `kd_prodi`, `keterangan`, `vote_who`) VALUES
('362515273', 'someone name', 'Fisika', 0, NULL),
('362515333', 'someone name 2', 'MTK', 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `calon`
--
ALTER TABLE `calon`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `loginsuper`
--
ALTER TABLE `loginsuper`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `loginvoter`
--
ALTER TABLE `loginvoter`
  ADD KEY `loginvoter_ibfk_1` (`username`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`),
  ADD KEY `mahasiswa_ibfk_1` (`vote_who`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `loginvoter`
--
ALTER TABLE `loginvoter`
  ADD CONSTRAINT `loginvoter_ibfk_1` FOREIGN KEY (`username`) REFERENCES `mahasiswa` (`NIM`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`vote_who`) REFERENCES `calon` (`NIM`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

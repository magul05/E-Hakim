-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 25, 2025 at 01:17 PM
-- Server version: 8.4.3
-- PHP Version: 8.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `admin`
--

-- --------------------------------------------------------

--
-- Table structure for table `hakim`
--

CREATE TABLE `hakim` (
  `id_hakim` bigint NOT NULL,
  `masa_kerja` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `pendidikan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hakim`
--

INSERT INTO `hakim` (`id_hakim`, `masa_kerja`, `nama`, `pendidikan`) VALUES
(31, '1 tahun', 'Ariasa', 'S3');

-- --------------------------------------------------------

--
-- Table structure for table `hasilsaw`
--

CREATE TABLE `hasilsaw` (
  `id` bigint NOT NULL,
  `skor` double DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `hakim_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hasilsaw`
--

INSERT INTO `hasilsaw` (`id`, `skor`, `tanggal`, `hakim_id`) VALUES
(108, 1, '2025-06-25', 31);

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `id` bigint NOT NULL,
  `bobot` varchar(255) DEFAULT NULL,
  `namakriteria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`id`, `bobot`, `namakriteria`) VALUES
(19, '0.3', 'integritas'),
(20, '0.3', 'pengetahuanhukum'),
(21, '0.2', 'pengalaman'),
(22, '0.2', 'komunikasi');

-- --------------------------------------------------------

--
-- Table structure for table `penilaian`
--

CREATE TABLE `penilaian` (
  `id` bigint NOT NULL,
  `integritas` double DEFAULT NULL,
  `komunikasi` double DEFAULT NULL,
  `pengalaman` double DEFAULT NULL,
  `pengetahuan_hukum` double DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `hakim_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `penilaian`
--

INSERT INTO `penilaian` (`id`, `integritas`, `komunikasi`, `pengalaman`, `pengetahuan_hukum`, `tanggal`, `hakim_id`) VALUES
(20, 80, 80, 80, 80, '2025-06-24', 31);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin'),
('admin123', 'admin321');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hakim`
--
ALTER TABLE `hakim`
  ADD PRIMARY KEY (`id_hakim`);

--
-- Indexes for table `hasilsaw`
--
ALTER TABLE `hasilsaw`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk9sutinkhp1qn2fvuubqdxq34` (`hakim_id`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_penilaian_hakim` (`hakim_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hakim`
--
ALTER TABLE `hakim`
  MODIFY `id_hakim` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `hasilsaw`
--
ALTER TABLE `hasilsaw`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `kriteria`
--
ALTER TABLE `kriteria`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `penilaian`
--
ALTER TABLE `penilaian`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hasilsaw`
--
ALTER TABLE `hasilsaw`
  ADD CONSTRAINT `FKk9sutinkhp1qn2fvuubqdxq34` FOREIGN KEY (`hakim_id`) REFERENCES `hakim` (`id_hakim`) ON DELETE CASCADE;

--
-- Constraints for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD CONSTRAINT `FK_penilaian_hakim` FOREIGN KEY (`hakim_id`) REFERENCES `hakim` (`id_hakim`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

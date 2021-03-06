-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2018 at 07:38 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_estoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_categoria`
--

CREATE TABLE `tbl_categoria` (
  `categoria_id` int(11) NOT NULL,
  `categoria_nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_categoria`
--

INSERT INTO `tbl_categoria` (`categoria_id`, `categoria_nom`) VALUES
(1, 'Ojos de buey'),
(2, 'Bombillas LED'),
(3, 'Lamparas'),
(4, 'Bombillas color LED'),
(5, 'Focos');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_comanda`
--

CREATE TABLE `tbl_comanda` (
  `comanda_id` int(11) NOT NULL,
  `comanda_quantitat` int(5) NOT NULL,
  `comanda_data` date NOT NULL,
  `prov_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detall_com`
--

CREATE TABLE `tbl_detall_com` (
  `detall_com_id` int(11) NOT NULL,
  `comanda_id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_estoc`
--

CREATE TABLE `tbl_estoc` (
  `estoc_id` int(11) NOT NULL,
  `estoc_q_max` int(5) NOT NULL,
  `estoc_q_min` int(5) NOT NULL,
  `estoc_q_actual` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `lloc_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_estoc`
--

INSERT INTO `tbl_estoc` (`estoc_id`, `estoc_q_max`, `estoc_q_min`, `estoc_q_actual`, `prod_id`, `lloc_id`) VALUES
(1, 250, 50, 75, 1, 1),
(2, 250, 50, 125, 2, 2),
(3, 250, 50, 110, 3, 3),
(4, 250, 50, 55, 4, 4),
(5, 250, 50, 81, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lloc`
--

CREATE TABLE `tbl_lloc` (
  `lloc_id` int(11) NOT NULL,
  `num_bloc` enum('Bloc 1','Bloc 2','Bloc3','Bloc 4','Bloc 5','Bloc 6','Bloc 7','Bloc 8') COLLATE utf8_unicode_ci NOT NULL,
  `num_passadis` enum('passadis 1','passadis 2','passadis 3','passadis 4','passadis 5','passadis 6','passadis 7','passadis 8','passadis 9','passadis 10','passadis 11','passadis 12') COLLATE utf8_unicode_ci NOT NULL,
  `num_lleixa` enum('lleixa 1','lleixa 2','lleixa 3','lleixa 4','lleixa 5','lleixa 6','lleixa 7','lleixa 8') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_lloc`
--

INSERT INTO `tbl_lloc` (`lloc_id`, `num_bloc`, `num_passadis`, `num_lleixa`) VALUES
(1, 'Bloc 1', 'passadis 4', 'lleixa 2'),
(2, 'Bloc3', 'passadis 9', 'lleixa 6'),
(3, 'Bloc 5', 'passadis 6', 'lleixa 7'),
(4, 'Bloc3', 'passadis 11', 'lleixa 7'),
(5, 'Bloc 4', 'passadis 9', 'lleixa 8');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_persona`
--

CREATE TABLE `tbl_persona` (
  `Persona_id` int(11) NOT NULL,
  `Persona_Nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Persona_Cognom` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Persona_Correu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Persona_Username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Persona_Contra` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_persona`
--

INSERT INTO `tbl_persona` (`Persona_id`, `Persona_Nom`, `Persona_Cognom`, `Persona_Correu`, `Persona_Username`, `Persona_Contra`) VALUES
(1, 'David', 'Aznar', 'david.aznar@gmail.com', 'daznar', '12345'),
(2, 'Juanjo', 'Monforte', 'juanjo.monforte@gmail.com', 'jmonforte', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_producte`
--

CREATE TABLE `tbl_producte` (
  `prod_id` int(11) NOT NULL,
  `prod_nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prod_foto` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `serie_id` int(11) DEFAULT NULL,
  `prod_descripcio` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prod_descompte` int(3) DEFAULT NULL,
  `prod_preu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_producte`
--

INSERT INTO `tbl_producte` (`prod_id`, `prod_nom`, `prod_foto`, `serie_id`, `prod_descripcio`, `prod_descompte`, `prod_preu`) VALUES
(1, 'Foco RONDOO 1 up blanco', 'foco-rondoo-1-up-blanco.jpg', 5, 'Tamaño Total: altura 12,5cm,diámetro 10cm // Placa de montaje en techo: diámetro 10cm //', 5, 0),
(2, 'Ojo de Buey Aluminio circular', 'OjodeBueyAluminiocircular.jpg', 1, 'Marca: Miño // Foco Empotrable aluminio extrusionado basculante y giratorio.', 0, 0),
(3, 'Bombilla LED E27 C37 5W', 'bombilla-led-e27-c37-5w.jpg', 2, 'Perfecta para sustituir a las antiguas bombillas incandescentes tipo vela de hasta 35W.', 50, 0),
(4, 'Bombilla LED E27 RGB 5W', 'bombilla-led-e27-rgb-5w.jpg', 3, 'Opción perfecta si deseamos una bombilla que nos permita variar la luz que emite en color', 25, 0),
(5, 'Lámpara de araña LED Gracia', 'lampara-arana-led-gracia-20w-schuller.jpg', 4, 'Diseño en forma de araña con cinco puntos de iluminación, fabricación en resina y metal', 30, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_proveidor`
--

CREATE TABLE `tbl_proveidor` (
  `prov_id` int(11) NOT NULL,
  `prov_nom` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prov_adre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `prov_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_serie`
--

CREATE TABLE `tbl_serie` (
  `serie_id` int(11) NOT NULL,
  `serie_nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `categoria_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_serie`
--

INSERT INTO `tbl_serie` (`serie_id`, `serie_nom`, `categoria_id`) VALUES
(1, 'GU10', 1),
(2, 'E27', 2),
(3, 'E27', 4),
(4, 'E14', 3),
(5, 'GU5', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  ADD PRIMARY KEY (`categoria_id`);

--
-- Indexes for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  ADD PRIMARY KEY (`comanda_id`),
  ADD KEY `FK_comanda_prov` (`prov_id`);

--
-- Indexes for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  ADD PRIMARY KEY (`detall_com_id`),
  ADD KEY `FK_detall_com_prod` (`prod_id`),
  ADD KEY `FK_detall_com_comanda` (`comanda_id`);

--
-- Indexes for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  ADD PRIMARY KEY (`estoc_id`),
  ADD KEY `FK_estoc_prod` (`prod_id`),
  ADD KEY `FK_estoc_lloc` (`lloc_id`);

--
-- Indexes for table `tbl_lloc`
--
ALTER TABLE `tbl_lloc`
  ADD PRIMARY KEY (`lloc_id`);

--
-- Indexes for table `tbl_persona`
--
ALTER TABLE `tbl_persona`
  ADD PRIMARY KEY (`Persona_id`);

--
-- Indexes for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  ADD PRIMARY KEY (`prod_id`),
  ADD KEY `FK_prod_serie` (`serie_id`);

--
-- Indexes for table `tbl_proveidor`
--
ALTER TABLE `tbl_proveidor`
  ADD PRIMARY KEY (`prov_id`);

--
-- Indexes for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  ADD PRIMARY KEY (`serie_id`),
  ADD KEY `FK_serie_categoria` (`categoria_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_categoria`
--
ALTER TABLE `tbl_categoria`
  MODIFY `categoria_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  MODIFY `comanda_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  MODIFY `detall_com_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  MODIFY `estoc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_lloc`
--
ALTER TABLE `tbl_lloc`
  MODIFY `lloc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_persona`
--
ALTER TABLE `tbl_persona`
  MODIFY `Persona_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_proveidor`
--
ALTER TABLE `tbl_proveidor`
  MODIFY `prov_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  MODIFY `serie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  ADD CONSTRAINT `FK_comanda_prov` FOREIGN KEY (`prov_id`) REFERENCES `tbl_proveidor` (`prov_id`);

--
-- Constraints for table `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  ADD CONSTRAINT `FK_detall_com_comanda` FOREIGN KEY (`comanda_id`) REFERENCES `tbl_comanda` (`comanda_id`),
  ADD CONSTRAINT `FK_detall_com_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

--
-- Constraints for table `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  ADD CONSTRAINT `FK_estoc_lloc` FOREIGN KEY (`lloc_id`) REFERENCES `tbl_lloc` (`lloc_id`),
  ADD CONSTRAINT `FK_estoc_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

--
-- Constraints for table `tbl_producte`
--
ALTER TABLE `tbl_producte`
  ADD CONSTRAINT `FK_prod_serie` FOREIGN KEY (`serie_id`) REFERENCES `tbl_serie` (`serie_id`);

--
-- Constraints for table `tbl_serie`
--
ALTER TABLE `tbl_serie`
  ADD CONSTRAINT `FK_serie_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `tbl_categoria` (`categoria_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 18-Abr-2018 às 09:11
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbImpresa`
--
CREATE DATABASE IF NOT EXISTS `dbImpresa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbImpresa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbCategoria`
--

CREATE TABLE IF NOT EXISTS `tbCategoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `catNome` varchar(30) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbCategoria`
--

INSERT INTO `tbCategoria` (`idCategoria`, `catNome`) VALUES
(1, 'Assalariado'),
(2, 'Comissionado'),
(3, 'Horista');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbEmpregado`
--

CREATE TABLE IF NOT EXISTS `tbEmpregado` (
  `idEmpregado` int(11) NOT NULL AUTO_INCREMENT,
  `emNome` varchar(30) DEFAULT NULL,
  `emSobrenome` varchar(30) DEFAULT NULL,
  `emCpf` varchar(20) DEFAULT NULL,
  `emSalario` double(8,2) DEFAULT NULL,
  `emTotalVenda` double(8,2) DEFAULT NULL,
  `emTotalComissao` double(8,2) DEFAULT NULL,
  `emPrecoHora` decimal(8,2) DEFAULT NULL,
  `emHoraTrabalhada` decimal(8,2) DEFAULT NULL,
  `idCatEmpregado` int(11) NOT NULL,
  PRIMARY KEY (`idEmpregado`),
  KEY `idCatEmpregado` (`idCatEmpregado`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbEmpregado`
--

INSERT INTO `tbEmpregado` (`idEmpregado`, `emNome`, `emSobrenome`, `emCpf`, `emSalario`, `emTotalVenda`, `emTotalComissao`, `emPrecoHora`, `emHoraTrabalhada`, `idCatEmpregado`) VALUES
(2, 'Mike', 'Will', 'null', 100.00, NULL, NULL, NULL, NULL, 0),
(3, 'Marcelo', 'Gilvam', '777877', NULL, NULL, NULL, '20.12', '25.00', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

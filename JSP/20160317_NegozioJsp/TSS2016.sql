-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 17, 2016 alle 10:26
-- Versione del server: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `TSS2016`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `intestazioni_ordini`
--

CREATE TABLE IF NOT EXISTS `intestazioni_ordini` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Data` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Nome` varchar(100) NOT NULL DEFAULT '',
  `Cognome` varchar(100) NOT NULL DEFAULT '',
  `Indirizzo` varchar(100) NOT NULL DEFAULT '',
  `Pagamento` varchar(100) NOT NULL DEFAULT '',
  `Consegna` varchar(100) NOT NULL DEFAULT '',
  `SpeseSpedizione` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE IF NOT EXISTS `prodotti` (
`ID` int(11) unsigned NOT NULL,
  `Prodotto` varchar(100) DEFAULT NULL,
  `Descrizione` varchar(100) DEFAULT NULL,
  `Prezzo` decimal(10,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`ID`, `Prodotto`, `Descrizione`, `Prezzo`) VALUES
(1, 'Mac Mini', 'Mac Mini processore Intel I5\r\n8GB di RAM, 500GB', '788.99'),
(2, 'Dell XPS 13 ', 'Processore Intel i7\r\n16GB RAM, 512ssd', '1249.00'),
(3, 'Mac Book', 'Mac Book processore Intel I7\r\n16GB di RAM, 1500GB', '1288.99'),
(4, 'AlePiBell dell XPS 13 ', 'Processore Intel i75\r\n160GB RAM, 2048ssd, solo per oggi', '249.99');

-- --------------------------------------------------------

--
-- Struttura della tabella `righe_ordini`
--

CREATE TABLE IF NOT EXISTS `righe_ordini` (
  `IDOrdine` int(11) NOT NULL DEFAULT '0',
  `IDProdotto` int(11) NOT NULL DEFAULT '0',
  `Prezzo` float NOT NULL DEFAULT '0',
  `Quantita` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti_backoffice`
--

CREATE TABLE IF NOT EXISTS `utenti_backoffice` (
  `Username` varchar(100) NOT NULL DEFAULT '',
  `Password` varchar(100) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `utenti_backoffice`
--

INSERT INTO `utenti_backoffice` (`Username`, `Password`) VALUES
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `intestazioni_ordini`
--
ALTER TABLE `intestazioni_ordini`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `prodotti`
--
ALTER TABLE `prodotti`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `utenti_backoffice`
--
ALTER TABLE `utenti_backoffice`
 ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prodotti`
--
ALTER TABLE `prodotti`
MODIFY `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

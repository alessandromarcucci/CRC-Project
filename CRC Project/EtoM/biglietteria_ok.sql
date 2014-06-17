-- phpMyAdmin SQL Dump
-- version 3.1.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 28 lug, 2009 at 02:24 PM
-- Versione MySQL: 5.1.30
-- Versione PHP: 5.2.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `biglietteria`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `biglietto`
--

CREATE TABLE IF NOT EXISTS `biglietto` (
  `IDpart` int(20) NOT NULL,
  `nomeset` varchar(25) NOT NULL,
  `posto` int(20) NOT NULL,
  `prezzo` float NOT NULL,
  PRIMARY KEY (`IDpart`,`nomeset`,`posto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `biglietto`
--

INSERT INTO `biglietto` (`IDpart`, `nomeset`, `posto`, `prezzo`) VALUES
(1000001, 'Primo anello', 1, 5000),
(1000001, 'Secondo anello', 1, 120),
(1000001, 'Terzo anello', 1, 140),
(1000003, 'Primo anello', 28162, 5000),
(1000003, 'Secondo anello', 2, 40),
(1000003, 'Terzo anello', 2, 50),
(1000204, 'Primo anello', 1, 5000),
(1000204, 'Secondo anello', 1, 10),
(1000204, 'Terzo anello', 1, 19),
(1234567, 'Curva Ferrovia', 1, 30),
(1234567, 'Curva Fiesole', 1, 20),
(1234567, 'Tribuna Centrale', 1, 40),
(1234567, 'Tribuna Maratona', 1, 40),
(1234568, 'Curva Ferrovia', 1, 30),
(1234568, 'Curva Fiesole', 1, 10),
(1234568, 'Tribuna Centrale', 1, 15),
(1234568, 'Tribuna Maratona', 1, 15),
(2134567, 'Curva Ferrovia', 1, 30),
(2134567, 'Curva Fiesole', 1, 30),
(2134567, 'Tribuna Centrale', 1, 40),
(2134567, 'Tribuna Maratona', 1, 40),
(2233447, 'Curva Ferrovia', 1, 30),
(2233447, 'Curva Fiesole', 1, 5),
(2233447, 'Tribuna Centrale', 1, 10),
(2233447, 'Tribuna Maratona', 1, 10),
(3112212, 'Curva Nord', 1, 5),
(3112212, 'Curva Sud', 1, 5),
(3112212, 'Distinti Nord Est', 1, 5),
(3112212, 'Distinti Nord Ovest', 1, 3),
(3112212, 'Distinti Sud Est', 1, 3),
(3112212, 'Distinti Sud Ovest', 1, 3),
(3112212, 'Tribuna Monte Mario', 1, 7),
(3112212, 'Tribuna Tevere', 1, 7),
(3132367, 'Curva Nord', 1, 10),
(3132367, 'Curva Sud', 1, 10),
(3132367, 'Distinti Nord Est', 1, 10),
(3132367, 'Distinti Nord Ovest', 1, 10),
(3132367, 'Distinti Sud Est', 1, 10),
(3132367, 'Distinti Sud Ovest', 1, 10),
(3132367, 'Tribuna Monte Mario', 1, 20),
(3132367, 'Tribuna Tevere', 1, 20),
(3214561, 'Curva Nord', 1, 20),
(3214561, 'Curva Sud', 1, 20),
(3214561, 'Distinti Nord Est', 1, 20),
(3214561, 'Distinti Nord Ovest', 1, 20),
(3214561, 'Distinti Sud Est', 1, 20),
(3214561, 'Distinti Sud Ovest', 1, 20),
(3214561, 'Tribuna Monte Mario', 1, 30),
(3214561, 'Tribuna Tevere', 1, 30),
(3421876, 'Curva Nord', 1, 18),
(3421876, 'Curva Sud', 1, 18),
(3421876, 'Distinti Nord Est', 1, 18),
(3421876, 'Distinti Nord Ovest', 1, 18),
(3421876, 'Distinti Sud Est', 1, 18),
(3421876, 'Distinti Sud Ovest', 1, 18),
(3421876, 'Tribuna Monte Mario', 1, 28),
(3421876, 'Tribuna Torre', 1, 28);

-- --------------------------------------------------------

--
-- Struttura della tabella `partita`
--

CREATE TABLE IF NOT EXISTS `partita` (
  `ID` int(15) NOT NULL,
  `IDpart` int(20) NOT NULL,
  `Casa` varchar(20) NOT NULL,
  `Fuori` varchar(20) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Data` date NOT NULL,
  `ora` time NOT NULL,
  PRIMARY KEY (`ID`,`IDpart`),
  KEY `IDpart` (`IDpart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `partita`
--

INSERT INTO `partita` (`ID`, `IDpart`, `Casa`, `Fuori`, `Tipo`, `Data`, `ora`) VALUES
(1, 1000001, 'Inter ', 'Stoccarda', 'Champions', '2009-09-21', '20:30:00'),
(1, 1000003, 'Milan', 'Real Madrid', 'Amichevole', '2009-08-12', '21:00:00'),
(1, 1000204, 'Inter ', 'Brescia', 'Coppa Italia', '2009-10-08', '20:30:00'),
(1, 2233447, 'Fiorentina', 'Perugia', 'Amichevole', '2009-07-31', '18:00:00'),
(2, 1234567, 'Fiorentina', 'Milan', 'Serie A', '2009-09-26', '21:00:00'),
(2, 1234568, 'Fiorentina', 'Roma', 'Coppa Italia', '2009-10-15', '18:00:00'),
(2, 2134567, 'Fiorentina', 'Manchester', 'Champions', '2009-09-23', '21:00:00'),
(3, 3112212, 'Roma', 'Salernitana', 'Amichevole', '2009-08-04', '21:00:00'),
(3, 3132367, 'Roma', 'Werder Brema', 'Coppa Uefa', '2009-10-29', '20:30:00'),
(3, 3214561, 'Lazio', 'Inter', 'Serie A', '2009-08-30', '15:00:00'),
(3, 3421876, 'Lazio', 'Bari', 'Coppa Italia', '2009-10-16', '20:30:00'),
(4, 4235489, 'Juventus', 'Barcellona', 'Champions', '2009-10-21', '20:45:00'),
(4, 4321999, 'Torino ', 'Mantova', 'Serie B', '2009-09-18', '17:00:00'),
(4, 4432345, 'Juventus', 'Roma', 'Serie A', '2009-08-22', '20:30:00'),
(4, 4564879, 'Juventus', 'Torino', 'Amichevole', '2009-08-13', '20:00:00'),
(5, 5124367, 'Napoli', 'Avellino', 'Amichevole', '2009-07-30', '21:00:00'),
(5, 5432167, 'Napoli', 'Siena', 'Serie A', '2009-09-05', '18:00:00'),
(5, 5987123, 'Napoli', 'Padova', 'Coppa Italia', '2009-10-29', '21:00:00'),
(6, 6345215, 'Parma', 'Roma', 'Serie A', '2009-08-23', '15:00:00'),
(6, 6784901, 'Parma', 'Mantova', 'Amichevole', '2009-08-06', '19:00:00'),
(6, 6789543, 'Parma', 'Lazio', 'Coppa Italia', '2009-10-22', '21:00:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `prenotazione`
--

CREATE TABLE IF NOT EXISTS `prenotazione` (
  `cf` varchar(20) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `casa` varchar(20) NOT NULL,
  `fuori` varchar(20) NOT NULL,
  `data` date NOT NULL,
  `posto` int(15) NOT NULL,
  `nomset` varchar(25) NOT NULL,
  PRIMARY KEY (`cf`,`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `prenotazione`
--

INSERT INTO `prenotazione` (`cf`, `nome`, `cognome`, `casa`, `fuori`, `data`, `posto`, `nomset`) VALUES
('RVRRSS84L17L117i ', 'Roberto ', 'Real Madrid ', 'Milan ', 'Real Madrid ', '2009-08-12', 28161, 'Primo anello   '),
('RVRRSS84L17L117i ', 'Roberto ', 'Siena ', 'Milan ', 'Siena ', '2009-09-05', 4, 'Primo anello   '),
('RVRRSS84L17L117i ', 'Roberto ', 'Brescia ', 'Inter  ', 'Brescia ', '2009-10-08', 1, 'secondo anello   ');

-- --------------------------------------------------------

--
-- Struttura della tabella `settore`
--

CREATE TABLE IF NOT EXISTS `settore` (
  `ID` int(15) NOT NULL,
  `nomeset` varchar(25) NOT NULL,
  `nposti` int(15) NOT NULL,
  PRIMARY KEY (`ID`,`nomeset`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `settore`
--

INSERT INTO `settore` (`ID`, `nomeset`, `nposti`) VALUES
(1, 'Primo anello', 28161),
(1, 'Secondo anello', 32368),
(1, 'Terzo anello', 19545),
(2, 'Curva Ferrovia', 8641),
(2, 'Curva Fiesole', 8641),
(2, 'Tribuna centrale', 15000),
(2, 'Tribuna maratona', 15000),
(3, 'Curva Nord', 8520),
(3, 'Curva Sud', 8486),
(3, 'Distinti Nord Est', 5597),
(3, 'Distinti Nord Ovest', 5769),
(3, 'Distinti Sud Est', 5637),
(3, 'Distinti Sud Ovest', 5747),
(3, 'Tribuna Monte Mario', 16555),
(3, 'Tribuna Tevere', 16397),
(4, 'Curva Filadelfia', 4250),
(4, 'Curva Maratona', 4250),
(4, 'Distinti Est', 10000),
(4, 'Tribuna Ovest', 10000),
(5, 'Curva Ciro ', 15500),
(5, 'Curva Maradona', 15000),
(5, 'Tribuna azzura', 23412),
(5, 'Tribuna bianca', 23412),
(6, 'Curva Nord', 3953),
(6, 'Curva Sud', 3953),
(6, 'Tribuna bianca', 10000),
(6, 'Tribuna Petitot', 10000);

-- --------------------------------------------------------

--
-- Struttura della tabella `stadio`
--

CREATE TABLE IF NOT EXISTS `stadio` (
  `ID` int(15) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `città` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `stadio`
--

INSERT INTO `stadio` (`ID`, `nome`, `città`) VALUES
(1, 'San Siro ', 'Milano'),
(2, 'Franchi', 'Firenze'),
(3, 'Olimpico R', 'Roma'),
(4, 'Olimpico T', 'Torino'),
(5, 'San Paolo', 'Verona'),
(6, 'Tardini', 'Parma'),
(7, 'Delle Alpi', 'torino');

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE IF NOT EXISTS `utenti` (
  `cf` varchar(30) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `data nascita` date NOT NULL,
  `indirizzo` varchar(30) NOT NULL,
  `e-mail` varchar(30) NOT NULL,
  `username` varchar(15) NOT NULL,
  `passw` varchar(15) NOT NULL,
  `amministratore` tinyint(1) NOT NULL,
  PRIMARY KEY (`cf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`cf`, `nome`, `cognome`, `data nascita`, `indirizzo`, `e-mail`, `username`, `passw`, `amministratore`) VALUES
('10/10/1010', '10/10/1010', '10/10/1010', '1010-10-10', '10/10/1010', '10/10/1010', '10/10/1010', '10/10/1010', 0),
('aaddasasdsad', 'goal', 'goal', '1987-11-05', 'qwe', 'rr', 'qwe', 'qwe', 0),
('adsadsa', 'dav', 'aa', '1987-10-02', 'erer', 'aaa', 'aaaaffaf', 'aaaa', 0),
('ciao', 'ciqo', 'ciqo', '1010-10-10', 'saf', 'sdaf', 'sadf', 'asf', 0),
('codice', 'cognome', 'nome', '1987-01-01', 'via', 'mail', 'user', 'pass', 0),
('KEPALLE', 'GAYMAZY', 'mazyGAY', '1987-09-14', 'DELLAFAME', 'NNCELHO', 'MAZY', 'GOL', 0),
('Mazzi', 'sda', 'rere', '1987-10-08', 'faaf', 'faaagag', 'dada', 'aaa', 1),
('Meeee', 'Mazy', 'derr', '1985-10-05', 'dsas', 'ere', 'Mazinga', 'perugia', 0),
('nnloso', 'ciqao', 'bau', '1987-12-02', 'micio', 'cacca', 'unipg', 'pg', 0),
('rqa', 'sdsdaasd', 'ddad', '1987-04-05', 'addas', 'dsads', 'dasad', 'aaaa', 0),
('RVRRSS84L17L117i', 'Roberto', 'Rossi', '1984-07-17', 'via capriolo 34', 'rossirob@libero.it', 'ciao', 'ciao', 0);

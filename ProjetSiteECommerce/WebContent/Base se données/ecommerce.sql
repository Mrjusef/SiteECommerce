-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 10 Avril 2013 à 11:29
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `ecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `nomCategorie` varchar(20) NOT NULL,
  `descriptionCategorie` text,
  PRIMARY KEY (`idCategorie`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `nomCategorie`, `descriptionCategorie`) VALUES
(1, 'Categorie 1', NULL),
(2, 'Categorie 2', NULL),
(3, 'Categorie 3', NULL),
(4, 'Categorie 4', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `dateCmd` date NOT NULL,
  `totaleCmd` double NOT NULL,
  `statutCmd` varchar(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `dateCmd`, `totaleCmd`, `statutCmd`, `idUser`) VALUES
(1, '2013-02-04', 5000000, 'statut1', 1),
(2, '2013-02-21', 10000, 'statut2', 0);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `idProduit` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(20) NOT NULL,
  `description` text,
  `prix` double DEFAULT NULL,
  `datePro` date DEFAULT NULL,
  `photo` varchar(30) DEFAULT NULL,
  `etatproduit` int(11) DEFAULT NULL,
  `quantitee` int(11) NOT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  `idCmd` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `etatproduit`, `quantitee`, `idCategorie`, `idCmd`) VALUES
(1, 'Produit1', 'description du produit 1\r\nCe diagramme appelé le diagramme de PERT,  permet  de  préciser les taches critiques  (se\r\nsont les taches qu’il ne faut pas retarder  car leur retard va influençais sur -la date de \r\nlivraisons-  la date de fin du projet),   ', 10000, '2013-02-04', 'pc1.jpg', 1, 0, 1, NULL),
(2, 'Produit2', 'description du produit 2 \r\nCe diagramme appelé le diagramme de PERT,  permet  de  préciser les taches critiques  (se\r\nsont les taches qu’il ne faut pas retarder  car leur retard va influençais sur -la date de \r\nlivraisons-  la date de fin du projet),   ', 2000, '2013-02-05', 'pcp1.jpg', 1, 0, 1, NULL),
(5, 'produit3', 'test test test ttttt tttt tttt hhht ttt hhhhh  ccc ccc ccc ', 564444, '2013-03-06', 'pcp2.jpg', 1, 0, 2, NULL),
(7, 'produittt', 'c''est un produit fait pour tester c tt', 20000, '2013-03-13', 'pcp5.jpg', 1, 0, 2, NULL),
(10, 'youssefu', 'kkkk kk kk kk kk kk kk kk kk kk ', 34444, '2013-03-06', 'pc2.jpg', 0, 0, 3, NULL),
(9, 'youssef', 'youssef zwiiiin waaa3ar', 34444, '2013-03-06', 'pc2.jpg', 0, 0, 0, NULL),
(11, 'produitdetest', 'jqsks  qsdkjds', 34444, '2013-03-06', 'pc2.jpg', 1, 0, 3, NULL),
(12, 'produittest', 'test test test', 4000, '2013-03-13', 'pc3.jpg', 1, 45, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `dn` date DEFAULT NULL,
  `adresse` varchar(40) DEFAULT NULL,
  `ville` varchar(15) DEFAULT NULL,
  `pays` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`idUser`, `identifiant`, `pwd`, `nom`, `prenom`, `dn`, `adresse`, `ville`, `pays`, `role`) VALUES
(1, 'jusef', 'youssef', 'dahani', 'youssef', '2013-01-01', '240 oulad mbarek', 'kenitra', 'maroc', 'admin'),
(2, 'med', 'mohamed', 'sellam', 'mohamed', '2013-01-09', 'lkamra', 'rabat', 'maroc', 'client'),
(4, 'fox', 'mouhssine', 'dardar', 'mouhssine', '2013-01-25', 'lbank chaabi', 'kenitra', 'maroc', 'client'),
(5, 'dar', 'wael', 'dardar', 'wael', '2013-01-10', 'N ° 11 lbank chaabi', 'kenitra', 'maroc', 'client'),
(7, 'Mr josef', 'youssef', 'dahabi', 'youssef', '2013-02-13', 'rue 30 , N° 4 ', 'lille', 'france', 'client');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

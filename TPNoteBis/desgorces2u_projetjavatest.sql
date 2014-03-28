-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Ven 28 Mars 2014 à 01:53
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `desgorces2u_projetjavatest`
--

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `code_question` int(4) NOT NULL,
  `code_quizz` int(4) NOT NULL,
  `reponse_joueur` varchar(20) NOT NULL,
  PRIMARY KEY (`code_question`,`code_quizz`,`reponse_joueur`),
  KEY `code_quizz` (`code_quizz`),
  KEY `reponse_joueur` (`reponse_joueur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `item`
--

INSERT INTO `item` (`code_question`, `code_quizz`, `reponse_joueur`) VALUES
(51, 1, 'Bastide'),
(52, 2, 'Highlander');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE IF NOT EXISTS `joueur` (
  `code_joueur` int(4) NOT NULL AUTO_INCREMENT,
  `nom_joueur` varchar(20) NOT NULL,
  `passwd_joueur` varchar(20) NOT NULL,
  `mail_joueur` varchar(20) NOT NULL,
  PRIMARY KEY (`code_joueur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `joueur`
--

INSERT INTO `joueur` (`code_joueur`, `nom_joueur`, `passwd_joueur`, `mail_joueur`) VALUES
(1, 'Baptiste', 'motdepasse', 'email@fai.com'),
(2, 'Alexandre', 'mdp', 'alex@lol.com'),
(3, 'Alex', 'sunshine', 'alex.alex@alex.fr'),
(4, 'octodad', 'blblbl', 'bl.blblblbl@bl.bl'),
(12, 'Test', 'test', 'test@test.com');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `code_question` int(4) NOT NULL AUTO_INCREMENT,
  `texte_question` text NOT NULL,
  `reponse_question` varchar(20) NOT NULL,
  PRIMARY KEY (`code_question`),
  KEY `reponse_question` (`reponse_question`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=109 ;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`code_question`, `texte_question`, `reponse_question`) VALUES
(51, 'Au Moyen-Âge, comment appelait-on les villages fortifiés ?', 'Bastide'),
(52, 'Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?', 'Calme blanc'),
(53, 'Quel acteur français avait le premier rôle dans le film de Luchino Visconti "Le Guépard" ?', 'Alain Delon'),
(54, 'Quel film à succès a réuni sur les écrans Sean Connery et Christophe Lambert ?', 'Highlander'),
(55, 'Comment appelle-t-on le fruit du plaqueminier ?', 'Kaki'),
(56, 'Qui était le compagnon de saint Paul ?', 'Saint-Luc'),
(57, 'Dans quel film John Travolta incarne-t-il un ange tombé du ciel ?', 'Michael'),
(58, 'Quel titre de noblesse est immédiatement inférieur à celui de comte ?', 'Vicomte'),
(59, 'De quelle série de six films un champion de boxe est-il la vedette ?', 'Rocky'),
(60, 'Quelle est la capitale de la Nouvelle-Zélande ?', 'Wellington');

-- --------------------------------------------------------

--
-- Structure de la table `quizz`
--

CREATE TABLE IF NOT EXISTS `quizz` (
  `code_quizz` int(4) NOT NULL AUTO_INCREMENT,
  `date_quizz` date NOT NULL,
  `nb_questions_quizz` int(11) NOT NULL,
  `code_joueur` int(11) NOT NULL,
  PRIMARY KEY (`code_quizz`),
  KEY `code_joueur` (`code_joueur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `quizz`
--

INSERT INTO `quizz` (`code_quizz`, `date_quizz`, `nb_questions_quizz`, `code_joueur`) VALUES
(1, '2014-03-12', 10, 1),
(2, '2014-03-01', 2, 2),
(3, '2014-05-09', 15, 1),
(4, '2014-02-03', 3, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`code_question`) REFERENCES `question` (`code_question`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`code_quizz`) REFERENCES `quizz` (`code_quizz`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_3` FOREIGN KEY (`reponse_joueur`) REFERENCES `question` (`reponse_question`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `quizz`
--
ALTER TABLE `quizz`
  ADD CONSTRAINT `quizz_ibfk_1` FOREIGN KEY (`code_joueur`) REFERENCES `joueur` (`code_joueur`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

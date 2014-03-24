-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 24 Mars 2014 à 20:30
-- Version du serveur: 5.5.20-log
-- Version de PHP: 5.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `desgorces2u_projetjava`
--
CREATE DATABASE IF NOT EXISTS `desgorces2u_projetjava` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `desgorces2u_projetjava`;

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `code_question` int(4) NOT NULL,
  `code_quizz` int(4) NOT NULL,
  `reponse_joueur` varchar(100) NOT NULL,
  PRIMARY KEY (`code_question`,`code_quizz`,`reponse_joueur`),
  KEY `code_quizz` (`code_quizz`),
  KEY `reponse_joueur` (`reponse_joueur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `item`
--

INSERT INTO `item` (`code_question`, `code_quizz`, `reponse_joueur`) VALUES
(58, 25, 'JE NE SAIS PAS'),
(70, 25, ''),
(71, 25, ''),
(74, 25, ''),
(80, 25, '4 ANS'),
(84, 25, 'RIEN'),
(85, 25, ''),
(87, 25, ''),
(92, 25, ''),
(94, 25, ''),
(56, 28, '\\n'),
(60, 28, 'jE ne SAIs pAs Et je Fais N''importE quoi'),
(62, 28, '?'),
(65, 28, 'Népal'),
(77, 28, ''),
(78, 28, ''),
(84, 28, 'rien'),
(90, 28, ''),
(92, 28, '12'),
(98, 28, 'séquoia'),
(51, 29, 'bastide'),
(61, 29, 'claude zidi'),
(63, 29, ''),
(64, 29, 'word'),
(67, 29, 'I don''t know'),
(76, 29, 'bit'),
(77, 29, 'toujOurs pas'),
(94, 29, ''),
(96, 29, 'fémur'),
(99, 29, 'tulipe');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE IF NOT EXISTS `joueur` (
  `code_joueur` int(4) NOT NULL AUTO_INCREMENT,
  `nom_joueur` varchar(20) CHARACTER SET latin7 COLLATE latin7_general_cs NOT NULL,
  `passwd_joueur` varchar(20) CHARACTER SET latin7 COLLATE latin7_general_cs NOT NULL,
  `mail_joueur` varchar(20) CHARACTER SET latin7 COLLATE latin7_general_cs NOT NULL,
  PRIMARY KEY (`code_joueur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `joueur`
--

INSERT INTO `joueur` (`code_joueur`, `nom_joueur`, `passwd_joueur`, `mail_joueur`) VALUES
(1, 'Baptiste', 'motdepasse', 'email@fai.com'),
(2, 'Alexandre', 'mdp', 'alex@lol.com');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `code_question` int(4) NOT NULL AUTO_INCREMENT,
  `texte_question` text NOT NULL,
  `reponse_question` varchar(100) NOT NULL,
  PRIMARY KEY (`code_question`),
  KEY `reponse_question` (`reponse_question`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=101 ;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`code_question`, `texte_question`, `reponse_question`) VALUES
(51, 'Au Moyen-Âge, comment appelait-on les villages fortifiés ?', 'Bastide'),
(52, 'Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?', 'Calme blanc'),
(54, 'Quel film à succès a réuni sur les écrans Sean Connery et Christophe Lambert ?', 'Highlander'),
(55, 'Comment appelle-t-on le fruit du plaqueminier ?', 'Kaki'),
(56, 'Qui était le compagnon de saint Paul ?', 'Saint-Luc'),
(57, 'Dans quel film John Travolta incarne-t-il un ange tombé du ciel ?', 'Michael'),
(58, 'Quel titre de noblesse est immédiatement inférieur à celui de comte ?', 'Vicomte'),
(59, 'De quelle série de six films un champion de boxe est-il la vedette ?', 'Rocky'),
(60, 'Quelle est la capitale de la Nouvelle-Zélande ?', 'Wellington'),
(61, 'À quel réalisateur français doit-on le film "Banzaï" ?', 'Claude Zidi'),
(62, 'Quel film a réuni sur les écrans Isabelle Adjani et Sharon Stone ?', 'Diabolique'),
(63, 'Comment est également appelée la « Transat Jacques Vabre » ?', 'Route du café'),
(64, 'Quel nom porte le logiciel de traitement de texte mis au point par Microsoft ?', 'Word'),
(65, 'Quel pays a pour capitale Katmandou ?', 'Népal'),
(66, 'À quel réalisateur français doit-on "Le Corniaud" ou "La Grande Vadrouille" ?', 'Gérard Oury'),
(67, 'À quel groupe musical international doit-on la bande originale du film "Flash Gordon" ?', 'Queen'),
(68, 'À quelle classe animale le scorpion appartient-il ?', 'arachnides'),
(69, 'Quel oiseau palmipède a pour particularité de construire un nid flottant ?', 'grèbe'),
(70, 'Quelle est la race du chien de Columbo ?', 'Basset'),
(71, 'Dans le langage familier, comment appelle-t-on la dent du petit enfant ?', 'Quenotte'),
(72, 'Quel peintre, né en 1844, est également appelé « le Douanier » ?', 'Henri Rousseau'),
(73, 'Dans les années 1980, quel groupe musical a chanté le titre "Shout" ?', 'Tears For Fears'),
(74, 'Comment appelle-t-on le versant de la montagne non situé au soleil ?', 'Ubac'),
(75, 'Quelle est la seule valeur à la roulette à porter la couleur verte ?', 'zéro'),
(76, 'Quelle est la plus petite unité de mémoire utilisable sur un ordinateur ?', 'bit'),
(77, 'Quel insecte appelle-t-on aussi « la bête à bon dieu » ?', 'coccinelle'),
(78, 'Qui fut le premier européen à arriver aux Philippines ?', 'Magellan'),
(79, 'Qui joua le rôle de Donna Martin dans la série télévisée "Beverly Hills 90210" ?', 'Tori Spelling'),
(80, 'Combien de temps dure le mandat du président des États-Unis ?', '4 ans'),
(81, 'Dans quel pays se trouve le circuit automobile de Zandvoort ?', 'Pays-Bas'),
(82, 'Quel roman George Orwell a-t-il écrit en 1948 ?', '1984'),
(83, 'Dans quelle ville se trouve la fontaine de Trevi ?', 'Rome'),
(84, 'En quoi un nihiliste croit-il ?', 'rien'),
(85, 'Avec quel autre animal vit généralement une oie ?', 'jars'),
(86, 'Quelle est la plus grande tortue marine connue à ce jour ?', 'tortue luth'),
(87, 'De quelle comédie musicale font partie les Pink Ladies ?', 'Grease'),
(88, 'Dans quoi vit le rat des moissons ?', 'nid'),
(89, 'Quel animal est le plus rapide à terre ?', 'guépard'),
(90, 'Avec quoi mesure-t-on la profondeur des océans ?', 'sonar'),
(91, 'Dans quelle ville sont situées les plus célèbres falaises de France?', 'Étretat'),
(92, 'Combien de paires de côtes possède-t-on ?', '12'),
(93, 'Qui joue le rôle du nettoyeur dans le film "Nikita" ?', 'Jean Reno'),
(94, 'Quelle capitale actuelle était appelée « Philadelphia » du temps des Romains ?', 'Amman'),
(95, 'De qui Warren Beatty est-il le frère ?', 'Shirley MacLaine'),
(96, 'Quel os du squelette humain est le plus long et le plus solide ?', 'Fémur'),
(97, 'Dans quelles aventures retrouve-t-on les personnages de Loïs et Clark ?', 'Superman'),
(98, 'Quel arbre est connu pour être le plus grand au monde ?', 'séquoia'),
(99, 'De quelle plante le nom signifie-t-il « turban » en perse ?', 'tulipe'),
(100, 'Quel est le prénom de Kate Winslet dans le film "Titanic" de James Cameron ?', 'Rose');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Contenu de la table `quizz`
--

INSERT INTO `quizz` (`code_quizz`, `date_quizz`, `nb_questions_quizz`, `code_joueur`) VALUES
(25, '2014-03-17', 10, 1),
(28, '2014-03-17', 10, 1),
(29, '2014-03-17', 10, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`code_question`) REFERENCES `question` (`code_question`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`code_quizz`) REFERENCES `quizz` (`code_quizz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `quizz`
--
ALTER TABLE `quizz`
  ADD CONSTRAINT `quizz_ibfk_1` FOREIGN KEY (`code_joueur`) REFERENCES `joueur` (`code_joueur`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

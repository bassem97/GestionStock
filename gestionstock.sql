-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2021 at 04:59 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionstock`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `categorie_client` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `proffesion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `categorie_client`, `date_naissance`, `email`, `nom`, `password`, `prenom`, `proffesion`) VALUES
(1, 'Premium', '1997-05-20', 'bassem.jadoui@esprit.tn', 'bassem', '123456', 'jadoui', 'Etudiant'),
(2, 'Fidele', '1998-01-12', 'karim.manai@esprit.tn', 'karim', '123456', 'manai', 'Docteur'),
(3, 'Fidele', '1997-11-03', 'mounir.hmidi@esprit.tn', 'mounir', '123456', 'hmidi', 'Commercial');

-- --------------------------------------------------------

--
-- Table structure for table `detail_facture`
--

CREATE TABLE `detail_facture` (
  `id_detail_facture` bigint(20) NOT NULL,
  `montant_remise` float NOT NULL,
  `pourcentage_remise` int(11) NOT NULL,
  `prixtotal` float NOT NULL,
  `qte` int(11) NOT NULL,
  `id_facture` bigint(20) DEFAULT NULL,
  `id_produit` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_facture`
--

INSERT INTO `detail_facture` (`id_detail_facture`, `montant_remise`, `pourcentage_remise`, `prixtotal`, `qte`, `id_facture`, `id_produit`) VALUES
(1, 15, 30, 50, 20, 1, 1),
(2, 3, 10, 30, 10, 2, 2),
(3, 10, 20, 50, 15, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `detail_produit`
--

CREATE TABLE `detail_produit` (
  `id_detail_produit` bigint(20) NOT NULL,
  `categorie_produit` varchar(255) DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_derniere_modification` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_produit`
--

INSERT INTO `detail_produit` (`id_detail_produit`, `categorie_produit`, `date_creation`, `date_derniere_modification`) VALUES
(1, 'ALIMENTAIRE', '2021-11-30 15:57:40', NULL),
(2, 'QUINCAILLERIE', '2021-11-30 15:57:40', NULL),
(3, 'ELECTROMENAGER', '2021-11-30 15:57:40', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `id_facture` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `date_facture` date DEFAULT NULL,
  `montant_facture` float NOT NULL,
  `montant_remise` float NOT NULL,
  `id_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id_facture`, `active`, `date_facture`, `montant_facture`, `montant_remise`, `id_client`) VALUES
(1, b'1', '2021-11-30', 50, 15, 1),
(2, b'1', '2021-11-30', 30, 3, 2),
(3, b'1', '2021-11-30', 50, 10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id_fournisseur` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`id_fournisseur`, `code`, `libelle`) VALUES
(1, 'F1', 'Fournisseur 1'),
(2, 'F2', 'Fournisseur 2');

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id_produit` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix_unitaire` float NOT NULL,
  `id_detail_produit` bigint(20) DEFAULT NULL,
  `id_rayon` bigint(20) DEFAULT NULL,
  `id_stock` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id_produit`, `code`, `libelle`, `prix_unitaire`, `id_detail_produit`, `id_rayon`, `id_stock`) VALUES
(1, 'P123', 'Produit 1', 2.5, 1, 1, 1),
(2, 'P456', 'Produit 2', 5, 2, 2, 2),
(3, 'P789', 'Produit 3', 3, 3, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `produit_fournisseur`
--

CREATE TABLE `produit_fournisseur` (
  `id_produit` bigint(20) NOT NULL,
  `id_fournisseur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit_fournisseur`
--

INSERT INTO `produit_fournisseur` (`id_produit`, `id_fournisseur`) VALUES
(1, 1),
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `rayon`
--

CREATE TABLE `rayon` (
  `id_rayon` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rayon`
--

INSERT INTO `rayon` (`id_rayon`, `code`, `libelle`) VALUES
(1, 'RA1', 'Rayon 1'),
(2, 'RA2', 'Rayon 2'),
(3, 'RA3', 'Rayon 3');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id_stock` bigint(20) NOT NULL,
  `libelle_stock` varchar(255) DEFAULT NULL,
  `qte` int(11) NOT NULL,
  `qte_min` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id_stock`, `libelle_stock`, `qte`, `qte_min`) VALUES
(1, 'stock 1', 10, 5),
(2, 'stock 2', 15, 2),
(3, 'stock 3', 25, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `detail_facture`
--
ALTER TABLE `detail_facture`
  ADD PRIMARY KEY (`id_detail_facture`),
  ADD KEY `FKfnn8vralvky85ep0nsrhx26gm` (`id_facture`),
  ADD KEY `FK157mikilkxp92l06tlp625vcx` (`id_produit`);

--
-- Indexes for table `detail_produit`
--
ALTER TABLE `detail_produit`
  ADD PRIMARY KEY (`id_detail_produit`);

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`),
  ADD KEY `FKf5bkipv94vydrvtgv62l1t349` (`id_client`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_fournisseur`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `FKl2t99opcwks2llukvf12n2s0e` (`id_detail_produit`),
  ADD KEY `FKo33bua3c8l0yu3npmo1xihsl5` (`id_rayon`),
  ADD KEY `FKjmywqa2ugb0g0jg9vx84a9pcr` (`id_stock`);

--
-- Indexes for table `produit_fournisseur`
--
ALTER TABLE `produit_fournisseur`
  ADD KEY `FKr9nrbyaajdkhku498s5maxwg9` (`id_fournisseur`),
  ADD KEY `FKeewkt2lc19tv39w529d3ftwk8` (`id_produit`);

--
-- Indexes for table `rayon`
--
ALTER TABLE `rayon`
  ADD PRIMARY KEY (`id_rayon`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id_stock`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `detail_facture`
--
ALTER TABLE `detail_facture`
  MODIFY `id_detail_facture` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `detail_produit`
--
ALTER TABLE `detail_produit`
  MODIFY `id_detail_produit` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id_fournisseur` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rayon`
--
ALTER TABLE `rayon`
  MODIFY `id_rayon` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `id_stock` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_facture`
--
ALTER TABLE `detail_facture`
  ADD CONSTRAINT `FK157mikilkxp92l06tlp625vcx` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `FKfnn8vralvky85ep0nsrhx26gm` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id_facture`);

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FKf5bkipv94vydrvtgv62l1t349` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FKjmywqa2ugb0g0jg9vx84a9pcr` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`id_stock`),
  ADD CONSTRAINT `FKl2t99opcwks2llukvf12n2s0e` FOREIGN KEY (`id_detail_produit`) REFERENCES `detail_produit` (`id_detail_produit`),
  ADD CONSTRAINT `FKo33bua3c8l0yu3npmo1xihsl5` FOREIGN KEY (`id_rayon`) REFERENCES `rayon` (`id_rayon`);

--
-- Constraints for table `produit_fournisseur`
--
ALTER TABLE `produit_fournisseur`
  ADD CONSTRAINT `FKeewkt2lc19tv39w529d3ftwk8` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `FKr9nrbyaajdkhku498s5maxwg9` FOREIGN KEY (`id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

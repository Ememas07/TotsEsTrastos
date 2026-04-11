/*
 Navicat Premium Dump SQL

 Source Server         : portatil2
 Source Server Type    : MariaDB
 Source Server Version : 100241 (10.2.41-MariaDB-1:10.2.41+maria~bionic)
 Source Host           : 192.168.1.115:33700
 Source Schema         : Pra2nTri

 Target Server Type    : MariaDB
 Target Server Version : 100241 (10.2.41-MariaDB-1:10.2.41+maria~bionic)
 File Encoding         : 65001

 Date: 11/04/2026 10:23:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accio
-- ----------------------------
DROP TABLE IF EXISTS `accio`;
CREATE TABLE `accio`  (
  `idAccio` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `margeAplicacio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `esEquip` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idAccio`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 269 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for accioPenalitzacio
-- ----------------------------
DROP TABLE IF EXISTS `accioPenalitzacio`;
CREATE TABLE `accioPenalitzacio`  (
  `idAccioPenalitzacio` int(11) NOT NULL AUTO_INCREMENT,
  `idAccio` int(11) NOT NULL,
  `idPenalitzacio` int(11) NOT NULL,
  PRIMARY KEY (`idAccioPenalitzacio`, `idAccio`, `idPenalitzacio`) USING BTREE,
  INDEX `idPenalitzacio`(`idPenalitzacio`) USING BTREE,
  INDEX `idAccio`(`idAccio`) USING BTREE,
  CONSTRAINT `acciopenalitzacio_ibfk_1` FOREIGN KEY (`idPenalitzacio`) REFERENCES `penalitzacio` (`idPenalitzacio`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `acciopenalitzacio_ibfk_2` FOREIGN KEY (`idAccio`) REFERENCES `accio` (`idAccio`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 255 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for alineacio
-- ----------------------------
DROP TABLE IF EXISTS `alineacio`;
CREATE TABLE `alineacio`  (
  `idAlineacio` int(11) NOT NULL AUTO_INCREMENT,
  `idEquip` int(11) NOT NULL,
  `temps` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idAlineacio`) USING BTREE,
  INDEX `idEquip`(`idEquip`) USING BTREE,
  CONSTRAINT `alineacio_ibfk_1` FOREIGN KEY (`idEquip`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 266 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for alineacioJugador
-- ----------------------------
DROP TABLE IF EXISTS `alineacioJugador`;
CREATE TABLE `alineacioJugador`  (
  `idAlineacio` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  PRIMARY KEY (`idAlineacio`, `idJugador`) USING BTREE,
  INDEX `idJugador`(`idJugador`) USING BTREE,
  CONSTRAINT `alineaciojugador_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `alineaciojugador_ibfk_2` FOREIGN KEY (`idAlineacio`) REFERENCES `alineacio` (`idAlineacio`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria`  (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nivell` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `descripcio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idCategoria`, `nom`) USING BTREE,
  INDEX `idCategoria`(`idCategoria`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equip
-- ----------------------------
DROP TABLE IF EXISTS `equip`;
CREATE TABLE `equip`  (
  `idEquip` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `patrocinador` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `respresentant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idEquip`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipEsport
-- ----------------------------
DROP TABLE IF EXISTS `equipEsport`;
CREATE TABLE `equipEsport`  (
  `idEquip` int(11) NOT NULL,
  `idEsport` int(11) NOT NULL,
  PRIMARY KEY (`idEquip`, `idEsport`) USING BTREE,
  INDEX `idEsport`(`idEsport`) USING BTREE,
  CONSTRAINT `equipesport_ibfk_1` FOREIGN KEY (`idEquip`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `equipesport_ibfk_2` FOREIGN KEY (`idEsport`) REFERENCES `esport` (`idEsport`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipFilial
-- ----------------------------
DROP TABLE IF EXISTS `equipFilial`;
CREATE TABLE `equipFilial`  (
  `idEquip` int(11) NOT NULL,
  `idEquipFilial` int(11) NOT NULL,
  PRIMARY KEY (`idEquip`, `idEquipFilial`) USING BTREE,
  INDEX `idEquipFilial`(`idEquipFilial`) USING BTREE,
  CONSTRAINT `equipfilial_ibfk_1` FOREIGN KEY (`idEquip`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `equipfilial_ibfk_2` FOREIGN KEY (`idEquipFilial`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipJugador
-- ----------------------------
DROP TABLE IF EXISTS `equipJugador`;
CREATE TABLE `equipJugador`  (
  `idEquip` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  PRIMARY KEY (`idEquip`, `idJugador`) USING BTREE,
  INDEX `idJugador`(`idJugador`) USING BTREE,
  CONSTRAINT `equipjugador_ibfk_1` FOREIGN KEY (`idEquip`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `equipjugador_ibfk_2` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esdeveniment
-- ----------------------------
DROP TABLE IF EXISTS `esdeveniment`;
CREATE TABLE `esdeveniment`  (
  `idEsdeveniment` int(11) NOT NULL AUTO_INCREMENT,
  `idPartit` int(11) NOT NULL,
  `temps` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `idAccio` int(11) NOT NULL,
  `idPenalitzacio` int(11) NULL DEFAULT NULL,
  `actor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idEsdeveniment`) USING BTREE,
  INDEX `idPartit`(`idPartit`) USING BTREE,
  INDEX `idAccio`(`idAccio`) USING BTREE,
  INDEX `idPenalitzacio`(`idPenalitzacio`) USING BTREE,
  CONSTRAINT `esdeveniment_ibfk_1` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esdeveniment_ibfk_2` FOREIGN KEY (`idAccio`) REFERENCES `accio` (`idAccio`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `esdeveniment_ibfk_3` FOREIGN KEY (`idPenalitzacio`) REFERENCES `penalitzacio` (`idPenalitzacio`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1288 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for esport
-- ----------------------------
DROP TABLE IF EXISTS `esport`;
CREATE TABLE `esport`  (
  `idEsport` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `Descripcio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idEsport`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for format
-- ----------------------------
DROP TABLE IF EXISTS `format`;
CREATE TABLE `format`  (
  `idFormat` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `Descripcio` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idFormat`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jugador
-- ----------------------------
DROP TABLE IF EXISTS `jugador`;
CREATE TABLE `jugador`  (
  `idJugador` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `dni` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `rol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idJugador`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 228 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jugadorEsport
-- ----------------------------
DROP TABLE IF EXISTS `jugadorEsport`;
CREATE TABLE `jugadorEsport`  (
  `idJugador` int(11) NOT NULL,
  `idEsport` int(11) NOT NULL,
  PRIMARY KEY (`idJugador`, `idEsport`) USING BTREE,
  INDEX `idEsport`(`idEsport`) USING BTREE,
  CONSTRAINT `jugadoresport_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `jugadoresport_ibfk_2` FOREIGN KEY (`idEsport`) REFERENCES `esport` (`idEsport`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lliga
-- ----------------------------
DROP TABLE IF EXISTS `lliga`;
CREATE TABLE `lliga`  (
  `idLliga` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idEsport` int(11) NOT NULL,
  `idFormat` int(11) NOT NULL,
  `idReglament` int(11) NOT NULL,
  `patrocinador` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombreParticipants` int(11) NOT NULL,
  `tipusParticipants` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idLliga`, `nom`, `idCategoria`, `idEsport`) USING BTREE,
  INDEX `idEsport`(`idEsport`) USING BTREE,
  INDEX `idCategoria`(`idCategoria`) USING BTREE,
  INDEX `idFormat`(`idFormat`) USING BTREE,
  INDEX `idReglament`(`idReglament`) USING BTREE,
  INDEX `idLliga`(`idLliga`) USING BTREE,
  CONSTRAINT `lliga_ibfk_1` FOREIGN KEY (`idEsport`) REFERENCES `esport` (`idEsport`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lliga_ibfk_2` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lliga_ibfk_3` FOREIGN KEY (`idFormat`) REFERENCES `format` (`idFormat`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lliga_ibfk_4` FOREIGN KEY (`idReglament`) REFERENCES `reglament` (`idReglament`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partit
-- ----------------------------
DROP TABLE IF EXISTS `partit`;
CREATE TABLE `partit`  (
  `idPartit` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `durada` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `resultat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idPartit`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1055 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partitAlineacio
-- ----------------------------
DROP TABLE IF EXISTS `partitAlineacio`;
CREATE TABLE `partitAlineacio`  (
  `idPartit` int(11) NOT NULL,
  `idAlineacio` int(11) NOT NULL,
  PRIMARY KEY (`idPartit`, `idAlineacio`) USING BTREE,
  INDEX `idAlineacio`(`idAlineacio`) USING BTREE,
  CONSTRAINT `partitalineacio_ibfk_1` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `partitalineacio_ibfk_2` FOREIGN KEY (`idAlineacio`) REFERENCES `alineacio` (`idAlineacio`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partitEquip
-- ----------------------------
DROP TABLE IF EXISTS `partitEquip`;
CREATE TABLE `partitEquip`  (
  `idPartit` int(11) NOT NULL,
  `idEquip` int(11) NOT NULL,
  PRIMARY KEY (`idPartit`, `idEquip`) USING BTREE,
  INDEX `idEquip`(`idEquip`) USING BTREE,
  CONSTRAINT `partitequip_ibfk_1` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `partitequip_ibfk_2` FOREIGN KEY (`idEquip`) REFERENCES `equip` (`idEquip`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partitEsdeveniment
-- ----------------------------
DROP TABLE IF EXISTS `partitEsdeveniment`;
CREATE TABLE `partitEsdeveniment`  (
  `idPartit` int(11) NOT NULL,
  `idEsdeveniment` int(11) NOT NULL,
  PRIMARY KEY (`idPartit`, `idEsdeveniment`) USING BTREE,
  INDEX `idEsdeveniment`(`idEsdeveniment`) USING BTREE,
  CONSTRAINT `partitesdeveniment_ibfk_1` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `partitesdeveniment_ibfk_2` FOREIGN KEY (`idEsdeveniment`) REFERENCES `esdeveniment` (`idEsdeveniment`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partitJugador
-- ----------------------------
DROP TABLE IF EXISTS `partitJugador`;
CREATE TABLE `partitJugador`  (
  `idPartit` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  PRIMARY KEY (`idPartit`, `idJugador`) USING BTREE,
  INDEX `idJugador`(`idJugador`) USING BTREE,
  CONSTRAINT `partitjugador_ibfk_1` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `partitjugador_ibfk_2` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`idJugador`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for penalitzacio
-- ----------------------------
DROP TABLE IF EXISTS `penalitzacio`;
CREATE TABLE `penalitzacio`  (
  `idPenalitzacio` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `tipus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `valor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idPenalitzacio`) USING BTREE,
  INDEX `idPenalitzacio`(`idPenalitzacio`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 280 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reglament
-- ----------------------------
DROP TABLE IF EXISTS `reglament`;
CREATE TABLE `reglament`  (
  `idReglament` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idReglament`, `nom`) USING BTREE,
  INDEX `idReglament`(`idReglament`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reglamentAccio
-- ----------------------------
DROP TABLE IF EXISTS `reglamentAccio`;
CREATE TABLE `reglamentAccio`  (
  `idReglament` int(11) NOT NULL,
  `idAccio` int(11) NOT NULL,
  PRIMARY KEY (`idReglament`, `idAccio`) USING BTREE,
  INDEX `idAccio`(`idAccio`) USING BTREE,
  CONSTRAINT `reglamentaccio_ibfk_1` FOREIGN KEY (`idReglament`) REFERENCES `reglament` (`idReglament`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reglamentaccio_ibfk_2` FOREIGN KEY (`idAccio`) REFERENCES `accio` (`idAccio`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporada
-- ----------------------------
DROP TABLE IF EXISTS `temporada`;
CREATE TABLE `temporada`  (
  `idTemporada` int(11) NOT NULL AUTO_INCREMENT,
  `any` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `idLliga` int(11) NOT NULL,
  `guanyador` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idTemporada`, `any`, `idLliga`) USING BTREE,
  INDEX `any`(`any`) USING BTREE,
  INDEX `idLliga`(`idLliga`) USING BTREE,
  INDEX `idTemporada`(`idTemporada`) USING BTREE,
  CONSTRAINT `temporada_ibfk_1` FOREIGN KEY (`idLliga`) REFERENCES `lliga` (`idLliga`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for temporadaPartit
-- ----------------------------
DROP TABLE IF EXISTS `temporadaPartit`;
CREATE TABLE `temporadaPartit`  (
  `idTemporada` int(11) NOT NULL,
  `idPartit` int(11) NOT NULL,
  PRIMARY KEY (`idTemporada`, `idPartit`) USING BTREE,
  INDEX `idPartit`(`idPartit`) USING BTREE,
  CONSTRAINT `temporadapartit_ibfk_1` FOREIGN KEY (`idTemporada`) REFERENCES `temporada` (`idTemporada`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `temporadapartit_ibfk_2` FOREIGN KEY (`idPartit`) REFERENCES `partit` (`idPartit`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

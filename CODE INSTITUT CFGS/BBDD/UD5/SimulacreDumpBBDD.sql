/*
Navicat Premium Dump SQL

Source Server         : Clase
Source Server Type    : MariaDB
Source Server Version : 100241 (10.2.41-MariaDB-1:10.2.41+maria~bionic)
Source Host           : localhost:33700
Source Schema         : centreFormacio

Target Server Type    : MariaDB
Target Server Version : 100241 (10.2.41-MariaDB-1:10.2.41+maria~bionic)
File Encoding         : 65001

Date: 26/03/2026 18:53:54
*/

SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alumnes
-- ----------------------------
DROP TABLE IF EXISTS `alumnes`;

CREATE TABLE `alumnes` (
    `dni` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `nom` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `llinatge1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `llinatge2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
    `esBilingue` tinyint(1) NULL DEFAULT NULL,
    `dataNaixement` date NOT NULL,
    `poble` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    PRIMARY KEY (`dni`) USING BTREE,
    INDEX `poble` (`poble`) USING BTREE,
    CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`poble`) REFERENCES `poble` (`codiPoble`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for alumnesAssignatures
-- ----------------------------
DROP TABLE IF EXISTS `alumnesAssignatures`;

CREATE TABLE `alumnesAssignatures` (
    `alumne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `assignatura` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `any` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `nota` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`alumne`, `assignatura`) USING BTREE,
    INDEX `assignatura` (`assignatura`) USING BTREE,
    CONSTRAINT `alumnesassignatures_ibfk_1` FOREIGN KEY (`alumne`) REFERENCES `alumnes` (`dni`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `alumnesassignatures_ibfk_2` FOREIGN KEY (`assignatura`) REFERENCES `assignatura` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for assignatura
-- ----------------------------
DROP TABLE IF EXISTS `assignatura`;

CREATE TABLE `assignatura` (
    `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `numeroHores` int(11) NOT NULL,
    `esBilingue` tinyint(1) NULL DEFAULT NULL,
    `cicleFormatiu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    PRIMARY KEY (`nom`) USING BTREE,
    INDEX `cicleFormatiu` (`cicleFormatiu`) USING BTREE,
    CONSTRAINT `assignatura_ibfk_1` FOREIGN KEY (`cicleFormatiu`) REFERENCES `cicleFormatiu` (`sigles`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cicleFormatiu
-- ----------------------------
DROP TABLE IF EXISTS `cicleFormatiu`;

CREATE TABLE `cicleFormatiu` (
    `sigles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    PRIMARY KEY (`sigles`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for departament
-- ----------------------------
DROP TABLE IF EXISTS `departament`;

CREATE TABLE `departament` (
    `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `capDepartament` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
    PRIMARY KEY (`nom`) USING BTREE,
    INDEX `capDepartament` (`capDepartament`) USING BTREE,
    CONSTRAINT `departament_ibfk_1` FOREIGN KEY (`capDepartament`) REFERENCES `professor` (`DNI`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for poble
-- ----------------------------
DROP TABLE IF EXISTS `poble`;

CREATE TABLE `poble` (
    `codiPoble` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `ubicacioGps` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    PRIMARY KEY (`codiPoble`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
    `dni` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `llinatge1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `llinatge2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
    `departament` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
    PRIMARY KEY (`dni`) USING BTREE,
    INDEX `departament` (`departament`) USING BTREE,
    CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`departament`) REFERENCES `departament` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for professorsAssignatures
-- ----------------------------
DROP TABLE IF EXISTS `professorsAssignatures`;

CREATE TABLE `professorsAssignatures` (
    `professor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `assignatura` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
    `any` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
    PRIMARY KEY (`professor`, `assignatura`) USING BTREE,
    INDEX `assignatura` (`assignatura`) USING BTREE,
    CONSTRAINT `professorsasignatures_ibfk_1` FOREIGN KEY (`professor`) REFERENCES `professor` (`dni`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `professorsassignatures_ibfk_2` FOREIGN KEY (`assignatura`) REFERENCES `assignatura` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
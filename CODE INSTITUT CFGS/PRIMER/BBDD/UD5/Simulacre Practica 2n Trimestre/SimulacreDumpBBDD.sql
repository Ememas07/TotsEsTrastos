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

 Date: 27/03/2026 18:36:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alumnes
-- ----------------------------
DROP TABLE IF EXISTS `alumnes`;
CREATE TABLE `alumnes`  (
  `dni` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nom` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `esBilingue` tinyint(1) NULL DEFAULT NULL,
  `dataNaixement` date NOT NULL,
  `poble` int(11) NOT NULL,
  PRIMARY KEY (`dni`) USING BTREE,
  INDEX `poble`(`poble`) USING BTREE,
  CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`poble`) REFERENCES `poble` (`codiPoble`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alumnes
-- ----------------------------
INSERT INTO `alumnes` VALUES ('14587289A', 'Marc', 'Mas', 'Hernández', 1, '2007-02-15', 1);
INSERT INTO `alumnes` VALUES ('14587458B', 'Pere', 'Munar', NULL, NULL, '2007-05-23', 1);
INSERT INTO `alumnes` VALUES ('14895278C', 'Mateu', 'Ripoll', 'Morales', NULL, '2003-03-03', 8);
INSERT INTO `alumnes` VALUES ('15863210D', 'Joan Pere', 'Gelabert', NULL, NULL, '2008-11-02', 4);
INSERT INTO `alumnes` VALUES ('4051378E', 'Ashley', 'Dreijer', NULL, 1, '2007-09-09', 7);
INSERT INTO `alumnes` VALUES ('4691297F', 'Rokiow', 'Bum', NULL, 1, '2011-03-16', 3);
INSERT INTO `alumnes` VALUES ('78102913G', 'Juan', 'Antonio', NULL, NULL, '1979-11-13', 6);

-- ----------------------------
-- Table structure for alumnesAssignatures
-- ----------------------------
DROP TABLE IF EXISTS `alumnesAssignatures`;
CREATE TABLE `alumnesAssignatures`  (
  `alumne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `assignatura` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `any` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nota` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`alumne`, `assignatura`, `any`) USING BTREE,
  INDEX `assignatura`(`assignatura`) USING BTREE,
  CONSTRAINT `alumnesassignatures_ibfk_1` FOREIGN KEY (`alumne`) REFERENCES `alumnes` (`dni`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `alumnesassignatures_ibfk_2` FOREIGN KEY (`assignatura`) REFERENCES `assignatura` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alumnesAssignatures
-- ----------------------------
INSERT INTO `alumnesAssignatures` VALUES ('14587289A', 'Programacio', '2025-2026', 9);
INSERT INTO `alumnesAssignatures` VALUES ('14587289A', 'Sistemes informatics', '2026-2027', 8);
INSERT INTO `alumnesAssignatures` VALUES ('14587458B', 'Accés a Dades', '2027-2028', 9);
INSERT INTO `alumnesAssignatures` VALUES ('14587458B', 'Sistemes informatics II', '2025-2026', 6);
INSERT INTO `alumnesAssignatures` VALUES ('15863210D', 'Simulacio de Fluids', '2026-2027', 7);
INSERT INTO `alumnesAssignatures` VALUES ('4051378E', 'Accés a Dades', '2025-2026', 9);
INSERT INTO `alumnesAssignatures` VALUES ('4051378E', 'Base de dades', '', NULL);
INSERT INTO `alumnesAssignatures` VALUES ('4051378E', 'Simulacio de Fluids', '2026-2027', 5);
INSERT INTO `alumnesAssignatures` VALUES ('4051378E', 'Xarxes Web', '2027-2028', 10);
INSERT INTO `alumnesAssignatures` VALUES ('78102913G', 'Assignatura de exemple 3', '2025-2026', 6);

-- ----------------------------
-- Table structure for assignatura
-- ----------------------------
DROP TABLE IF EXISTS `assignatura`;
CREATE TABLE `assignatura`  (
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `numeroHores` int(11) NOT NULL,
  `esBilingue` tinyint(1) NULL DEFAULT NULL,
  `cicleFormatiu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`nom`) USING BTREE,
  INDEX `cicleFormatiu`(`cicleFormatiu`) USING BTREE,
  CONSTRAINT `assignatura_ibfk_1` FOREIGN KEY (`cicleFormatiu`) REFERENCES `cicleFormatiu` (`sigles`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assignatura
-- ----------------------------
INSERT INTO `assignatura` VALUES ('Accés a Dades', 450, 0, 'DAM');
INSERT INTO `assignatura` VALUES ('Assignatura Cicle 1', 300, 0, '1');
INSERT INTO `assignatura` VALUES ('Assignatura Cicle 2', 300, 0, '2');
INSERT INTO `assignatura` VALUES ('Assignatura de exemple 3', 400, 0, '1');
INSERT INTO `assignatura` VALUES ('Base de dades', 300, 0, 'DAM');
INSERT INTO `assignatura` VALUES ('Programacio', 200, 1, 'DAM');
INSERT INTO `assignatura` VALUES ('Simulacio de fluids', 300, 0, 'ASIX');
INSERT INTO `assignatura` VALUES ('Sistemes informatics', 400, 1, 'DAW');
INSERT INTO `assignatura` VALUES ('Sistemes informatics II', 150, 0, 'DAM');
INSERT INTO `assignatura` VALUES ('Xarxes Web', 600, 1, 'ASIX');

-- ----------------------------
-- Table structure for cicleFormatiu
-- ----------------------------
DROP TABLE IF EXISTS `cicleFormatiu`;
CREATE TABLE `cicleFormatiu`  (
  `sigles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`sigles`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cicleFormatiu
-- ----------------------------
INSERT INTO `cicleFormatiu` VALUES ('1', 'T\'ho vaig dir a classe');
INSERT INTO `cicleFormatiu` VALUES ('2', 'Gracies Macia per llegir-te es teus apunts');
INSERT INTO `cicleFormatiu` VALUES ('ASIX', 'Administracio de Sistemes Informàtics en Xarxa');
INSERT INTO `cicleFormatiu` VALUES ('DAM', 'Desenvolupament Aplicacions Multiplataforma');
INSERT INTO `cicleFormatiu` VALUES ('DAW', 'Desenvolupament Aplicacions Web');
INSERT INTO `cicleFormatiu` VALUES ('EAN', 'Enginyeria AeroNautica');

-- ----------------------------
-- Table structure for departament
-- ----------------------------
DROP TABLE IF EXISTS `departament`;
CREATE TABLE `departament`  (
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `capDepartament` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`nom`) USING BTREE,
  INDEX `capDepartament`(`capDepartament`) USING BTREE,
  CONSTRAINT `departament_ibfk_1` FOREIGN KEY (`capDepartament`) REFERENCES `professor` (`DNI`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departament
-- ----------------------------
INSERT INTO `departament` VALUES ('Administració i Finances', NULL);
INSERT INTO `departament` VALUES ('Fisica', NULL);
INSERT INTO `departament` VALUES ('Tecnologia', NULL);
INSERT INTO `departament` VALUES ('Informatica', '12345678B');
INSERT INTO `departament` VALUES ('Quimica', '12486478C');
INSERT INTO `departament` VALUES ('Matematiques', '15987538D');
INSERT INTO `departament` VALUES ('Angles', '43928334F');
INSERT INTO `departament` VALUES ('Biologia', '64379087G');
INSERT INTO `departament` VALUES ('Alemany', '79423487I');

-- ----------------------------
-- Table structure for poble
-- ----------------------------
DROP TABLE IF EXISTS `poble`;
CREATE TABLE `poble`  (
  `codiPoble` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `ubicacioGps` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`codiPoble`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of poble
-- ----------------------------
INSERT INTO `poble` VALUES (1, 'Maria de la salut', '');
INSERT INTO `poble` VALUES (2, 'Sineu', '');
INSERT INTO `poble` VALUES (3, 'Marratxí', '');
INSERT INTO `poble` VALUES (4, 'Lloret', '');
INSERT INTO `poble` VALUES (5, 'Lloseta', '');
INSERT INTO `poble` VALUES (6, 'Lluc', '');
INSERT INTO `poble` VALUES (7, 'Palma', '');
INSERT INTO `poble` VALUES (8, 'Inca', '');
INSERT INTO `poble` VALUES (9, 'Manacor', '');
INSERT INTO `poble` VALUES (10, 'Ariany', '');
INSERT INTO `poble` VALUES (11, 'Petra', '');
INSERT INTO `poble` VALUES (12, 'Esporles', '');
INSERT INTO `poble` VALUES (13, 'Selva', '');
INSERT INTO `poble` VALUES (14, 'Artà', '');

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor`  (
  `dni` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `llinatge2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `departament` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NULL DEFAULT NULL,
  `poble` int(255) NOT NULL,
  PRIMARY KEY (`dni`) USING BTREE,
  INDEX `departament`(`departament`) USING BTREE,
  INDEX `poble`(`poble`) USING BTREE,
  CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`departament`) REFERENCES `departament` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `professor_ibfk_2` FOREIGN KEY (`poble`) REFERENCES `poble` (`codiPoble`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professor
-- ----------------------------
INSERT INTO `professor` VALUES ('06472894A', 'Bernat', 'Martorell', 'Jorda', 'Informatica', 1);
INSERT INTO `professor` VALUES ('12345678B', 'Macia', 'Bartomeu', 'Llabres', 'Informatica', 3);
INSERT INTO `professor` VALUES ('12486478C', 'Pere', 'Saste', 'Heredia', 'Quimica', 5);
INSERT INTO `professor` VALUES ('15987538D', 'Joan', 'Miralles', 'Jorda', 'Matematiques', 7);
INSERT INTO `professor` VALUES ('41415878X', 'Josep', 'Galmés', 'Riutort', 'Administració i Finances', 5);
INSERT INTO `professor` VALUES ('42924384E', 'Daniel', 'Sampol', 'Sastre', 'Angles', 9);
INSERT INTO `professor` VALUES ('43928334F', 'Jaume', 'Ramirez', 'Bauza', 'Angles', 11);
INSERT INTO `professor` VALUES ('64379087G', 'Mateu', 'Fernandez', 'Busquets', 'Biologia', 8);
INSERT INTO `professor` VALUES ('68437246H', 'Raimundo', 'Ribot', 'Rigo', 'Matematiques', 4);
INSERT INTO `professor` VALUES ('79423487I', 'Ana', 'Gomez', 'Tugores', 'Alemany', 2);

-- ----------------------------
-- Table structure for professorsAssignatures
-- ----------------------------
DROP TABLE IF EXISTS `professorsAssignatures`;
CREATE TABLE `professorsAssignatures`  (
  `professor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `assignatura` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `any` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`professor`, `assignatura`, `any`) USING BTREE,
  INDEX `assignatura`(`assignatura`) USING BTREE,
  CONSTRAINT `professorsasignatures_ibfk_1` FOREIGN KEY (`professor`) REFERENCES `professor` (`dni`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `professorsassignatures_ibfk_2` FOREIGN KEY (`assignatura`) REFERENCES `assignatura` (`nom`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professorsAssignatures
-- ----------------------------
INSERT INTO `professorsAssignatures` VALUES ('06472894A', 'Simulacio de fluids', '2021-2022');
INSERT INTO `professorsAssignatures` VALUES ('12345678B', 'Accés a Dades', '2025-2026');
INSERT INTO `professorsAssignatures` VALUES ('12345678B', 'Base de dades', '2024-2025');
INSERT INTO `professorsAssignatures` VALUES ('12345678B', 'Programacio', '2025-2026');
INSERT INTO `professorsAssignatures` VALUES ('12345678B', 'Sistemes informatics', '2025-2026');
INSERT INTO `professorsAssignatures` VALUES ('12345678B', 'Xarxes Web', '2025-2026');
INSERT INTO `professorsAssignatures` VALUES ('12486478C', 'Xarxes Web', '2019-2020');
INSERT INTO `professorsAssignatures` VALUES ('41415878X', 'Assignatura de exemple 3', '2025-2026');
INSERT INTO `professorsAssignatures` VALUES ('42924384E', 'Sistemes informatics II', '2015-2016');
INSERT INTO `professorsAssignatures` VALUES ('64379087G', 'Sistemes informatics II', '2022-2023');
INSERT INTO `professorsAssignatures` VALUES ('79423487I', 'Programacio', '2025-2026');

SET FOREIGN_KEY_CHECKS = 1;

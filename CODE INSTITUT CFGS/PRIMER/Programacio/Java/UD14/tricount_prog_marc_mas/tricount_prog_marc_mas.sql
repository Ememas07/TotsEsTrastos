/*
 Navicat Premium Dump SQL

 Source Server         : Postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 180003 (180003)
 Source Host           : localhost:5432
 Source Catalog        : TricountMarcMas
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 180003 (180003)
 File Encoding         : 65001

 Date: 16/05/2026 13:45:59
*/


-- ----------------------------
-- Sequence structure for despesa_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."despesa_id_seq";
CREATE SEQUENCE "public"."despesa_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for grup_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."grup_id_seq";
CREATE SEQUENCE "public"."grup_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for log_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."log_id_seq";
CREATE SEQUENCE "public"."log_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for pagador_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."pagador_id_seq";
CREATE SEQUENCE "public"."pagador_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for despesa
-- ----------------------------
DROP TABLE IF EXISTS "public"."despesa";
CREATE TABLE "public"."despesa" (
  "id" int4 NOT NULL DEFAULT nextval('despesa_id_seq'::regclass),
  "idgrup" int4 NOT NULL,
  "pagadororiginal" text COLLATE "pg_catalog"."default" NOT NULL,
  "datadespesa" timestamptz(5) NOT NULL,
  "descripcio" text COLLATE "pg_catalog"."default",
  "categoria" text COLLATE "pg_catalog"."default",
  "importtotal" numeric(10,2) NOT NULL,
  "importpagat" numeric(10,2)
)
;

-- ----------------------------
-- Records of despesa
-- ----------------------------
INSERT INTO "public"."despesa" VALUES (82, 44, 'ericahc@gmail.com', '2026-05-16 11:40:22.96+02', 'Simulador nou', 'Gastos Tontos', 1500.00, 1500.00);
INSERT INTO "public"."despesa" VALUES (76, 44, 'ericahc@gmail.com', '2026-05-16 11:29:42.028+02', 'Dinar Alcudia', 'Menjar', 1600.00, 800.00);
INSERT INTO "public"."despesa" VALUES (51, 2, 'charles818@outlook.com', '2026-05-16 09:52:30.57+02', 'Compres de maig', 'diari', 20.00, 5.00);
INSERT INTO "public"."despesa" VALUES (27, 4, 'marcmashernandez@gmail.com', '2026-05-15 18:14:15.797+02', 'a', 'a', 300.50, 300.50);
INSERT INTO "public"."despesa" VALUES (29, 4, 'peremunar@mp.com', '2026-05-15 18:15:59.405+02', 'a', 'b', 1000.00, 1000.00);
INSERT INTO "public"."despesa" VALUES (47, 4, 'marcmashernandez@gmail.com', '2026-05-16 09:39:07.659+02', 'Simulador', 'Gastos Tontos', 1500.44, 750.21);
INSERT INTO "public"."despesa" VALUES (61, 44, 'ericahc@gmail.com', '2026-05-16 10:36:25.634+02', 'Sopar Figureet', 'sopars', 300.89, 300.89);
INSERT INTO "public"."despesa" VALUES (73, 44, 'walter1@icloud.com', '2026-05-16 11:24:38.218+02', 'Dinar', 'Menjar', 1700.00, 300.00);
INSERT INTO "public"."despesa" VALUES (78, 44, 'peremunar@mp.com', '2026-05-16 11:34:43.014+02', 'Verbena', 'Menjar', 300.00, 150.00);
INSERT INTO "public"."despesa" VALUES (80, 44, 'marcmashernandez@gmail.com', '2026-05-16 11:38:18.904+02', 'Dinar Cas padri toni', 'Menjar', 150.00, 75.00);
INSERT INTO "public"."despesa" VALUES (89, 43, 'uncorreudeprova@iessineu.net', '2025-01-06 13:03:50.638+01', 'Test ', 'Test', 1500.00, 1500.00);
INSERT INTO "public"."despesa" VALUES (93, 44, 'waltjen@mail.com', '2026-05-16 13:28:31.619+02', 'Cotxe nou', 'Luxes', 16700.54, 7700.00);

-- ----------------------------
-- Table structure for grup
-- ----------------------------
DROP TABLE IF EXISTS "public"."grup";
CREATE TABLE "public"."grup" (
  "id" int4 NOT NULL DEFAULT nextval('grup_id_seq'::regclass),
  "nom" text COLLATE "pg_catalog"."default",
  "descripcio" text COLLATE "pg_catalog"."default",
  "datacreacio" timestamptz(5) NOT NULL
)
;

-- ----------------------------
-- Records of grup
-- ----------------------------
INSERT INTO "public"."grup" VALUES (4, 'Viatge a valencia', 'un viatge a valencia amb tot incluit sopars i tal', '2026-05-15 16:54:05.276+02');
INSERT INTO "public"."grup" VALUES (43, 'Mariandos por el mundo', '', '2026-05-16 09:49:29.095+02');
INSERT INTO "public"."grup" VALUES (44, 'Mallorca Power', 'Un grup per fer gasto a festes', '2026-05-16 09:50:02.602+02');
INSERT INTO "public"."grup" VALUES (2, 'Grup de Prova', 'Hola bon dia', '2026-05-15 16:52:18.494+02');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS "public"."log";
CREATE TABLE "public"."log" (
  "id" int4 NOT NULL DEFAULT nextval('log_id_seq'::regclass),
  "datetime" timestamptz(5) NOT NULL,
  "oldrow" text COLLATE "pg_catalog"."default",
  "newrow" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO "public"."log" VALUES (14, '2026-05-15 17:36:29.38866+02', NULL, '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,0.00)');
INSERT INTO "public"."log" VALUES (17, '2026-05-15 17:39:17.65819+02', NULL, '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,0.00)');
INSERT INTO "public"."log" VALUES (19, '2026-05-15 17:42:51.58305+02', NULL, '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,0.00)');
INSERT INTO "public"."log" VALUES (21, '2026-05-15 17:49:35.76369+02', NULL, '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,0.00)');
INSERT INTO "public"."log" VALUES (23, '2026-05-15 18:06:43.11989+02', NULL, '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,0.00)');
INSERT INTO "public"."log" VALUES (25, '2026-05-15 18:13:17.0549+02', NULL, '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,0.00)');
INSERT INTO "public"."log" VALUES (27, '2026-05-15 18:14:24.92249+02', NULL, '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,0.00)');
INSERT INTO "public"."log" VALUES (28, '2026-05-15 18:14:30.0422+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,0.00)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (29, '2026-05-15 18:14:30.0422+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,0.00)', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)');
INSERT INTO "public"."log" VALUES (30, '2026-05-15 18:14:30.0422+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,0.00)', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)');
INSERT INTO "public"."log" VALUES (31, '2026-05-15 18:14:30.0422+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,0.00)', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)');
INSERT INTO "public"."log" VALUES (32, '2026-05-15 18:14:30.0422+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,0.00)', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)');
INSERT INTO "public"."log" VALUES (33, '2026-05-15 18:14:30.0422+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,0.00)', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)');
INSERT INTO "public"."log" VALUES (34, '2026-05-15 18:14:30.0422+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,0.00)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (35, '2026-05-15 18:14:30.04655+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (36, '2026-05-15 18:14:30.04655+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)');
INSERT INTO "public"."log" VALUES (37, '2026-05-15 18:14:30.04655+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)');
INSERT INTO "public"."log" VALUES (38, '2026-05-15 18:14:30.04655+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)');
INSERT INTO "public"."log" VALUES (39, '2026-05-15 18:14:30.04655+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)');
INSERT INTO "public"."log" VALUES (40, '2026-05-15 18:14:30.04655+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)');
INSERT INTO "public"."log" VALUES (41, '2026-05-15 18:14:30.04655+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (43, '2026-05-15 18:16:08.76803+02', NULL, '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,0.00)');
INSERT INTO "public"."log" VALUES (44, '2026-05-15 18:16:15.23859+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (45, '2026-05-15 18:16:15.23859+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)');
INSERT INTO "public"."log" VALUES (46, '2026-05-15 18:16:15.23859+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)');
INSERT INTO "public"."log" VALUES (47, '2026-05-15 18:16:15.23859+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)');
INSERT INTO "public"."log" VALUES (48, '2026-05-15 18:16:15.23859+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)');
INSERT INTO "public"."log" VALUES (49, '2026-05-15 18:16:15.23859+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)');
INSERT INTO "public"."log" VALUES (50, '2026-05-15 18:16:15.23859+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (51, '2026-05-15 18:16:15.23859+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,0.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,500.00)');
INSERT INTO "public"."log" VALUES (52, '2026-05-15 18:16:15.24352+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (53, '2026-05-15 18:16:15.24352+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)');
INSERT INTO "public"."log" VALUES (54, '2026-05-15 18:16:15.24352+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)');
INSERT INTO "public"."log" VALUES (55, '2026-05-15 18:16:15.24352+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)');
INSERT INTO "public"."log" VALUES (56, '2026-05-15 18:16:15.24352+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)');
INSERT INTO "public"."log" VALUES (57, '2026-05-15 18:16:15.24352+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)');
INSERT INTO "public"."log" VALUES (58, '2026-05-15 18:16:15.24352+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (59, '2026-05-15 18:16:15.24352+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,500.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,500.00)');
INSERT INTO "public"."log" VALUES (60, '2026-05-15 18:16:31.52218+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (61, '2026-05-15 18:16:31.52218+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)');
INSERT INTO "public"."log" VALUES (62, '2026-05-15 18:16:31.52218+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)');
INSERT INTO "public"."log" VALUES (63, '2026-05-15 18:16:31.52218+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)');
INSERT INTO "public"."log" VALUES (64, '2026-05-15 18:16:31.52218+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)');
INSERT INTO "public"."log" VALUES (65, '2026-05-15 18:16:31.52218+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)');
INSERT INTO "public"."log" VALUES (66, '2026-05-15 18:16:31.52218+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (67, '2026-05-15 18:16:31.52218+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,500.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (77, '2026-05-16 08:53:01.14745+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,4.00)');
INSERT INTO "public"."log" VALUES (78, '2026-05-16 08:53:25.75556+02', '(19,4,marcmashernandez@gmail.com,"2026-05-15 17:42:41.939+02",asd,asd,300.67,)', NULL);
INSERT INTO "public"."log" VALUES (79, '2026-05-16 08:53:25.75556+02', '(21,4,marcmashernandez@gmail.com,"2026-05-15 17:49:16.425+02",hola,hola,300.89,)', NULL);
INSERT INTO "public"."log" VALUES (80, '2026-05-16 08:53:25.75556+02', '(23,4,marcmashernandez@gmail.com,"2026-05-15 18:06:34.437+02",hola,hola,300.35,)', NULL);
INSERT INTO "public"."log" VALUES (81, '2026-05-16 08:53:25.75556+02', '(25,4,marcmashernandez@gmail.com,"2026-05-15 18:13:07.765+02",a,a,1006.37,)', NULL);
INSERT INTO "public"."log" VALUES (82, '2026-05-16 08:53:28.45369+02', '(17,4,marcmashernandez@gmail.com,"2026-05-15 17:39:05.91+02",coses,coses,100.67,)', NULL);
INSERT INTO "public"."log" VALUES (91, '2026-05-16 09:39:27.11393+02', NULL, '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,0.00)');
INSERT INTO "public"."log" VALUES (92, '2026-05-16 09:39:42.70555+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (93, '2026-05-16 09:39:42.70555+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (94, '2026-05-16 09:39:42.70555+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,4.00)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (95, '2026-05-16 09:39:42.70555+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,0.00)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (96, '2026-05-16 09:39:42.70968+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (97, '2026-05-16 09:39:42.70968+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (98, '2026-05-16 09:39:42.70968+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (99, '2026-05-16 09:39:42.70968+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (103, '2026-05-16 09:52:54.46927+02', NULL, '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,0.00)');
INSERT INTO "public"."log" VALUES (104, '2026-05-16 09:53:17.93484+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,0.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (105, '2026-05-16 09:53:17.93484+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (106, '2026-05-16 09:53:17.93484+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (107, '2026-05-16 09:53:17.93484+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (108, '2026-05-16 09:53:17.93484+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (109, '2026-05-16 09:53:17.93932+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (110, '2026-05-16 09:53:17.93932+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (111, '2026-05-16 09:53:17.93932+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (112, '2026-05-16 09:53:17.93932+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (113, '2026-05-16 09:53:17.93932+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (114, '2026-05-16 09:53:17.94182+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (115, '2026-05-16 09:53:17.94182+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (116, '2026-05-16 09:53:17.94182+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (117, '2026-05-16 09:53:17.94182+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (118, '2026-05-16 09:53:17.94182+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (127, '2026-05-16 10:34:15.48326+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,4.00)');
INSERT INTO "public"."log" VALUES (129, '2026-05-16 10:36:42.58049+02', NULL, '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,0.00)');
INSERT INTO "public"."log" VALUES (130, '2026-05-16 10:36:49.72989+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (142, '2026-05-16 10:37:23.74992+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', NULL);
INSERT INTO "public"."log" VALUES (131, '2026-05-16 10:36:49.72989+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (132, '2026-05-16 10:36:49.72989+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (133, '2026-05-16 10:36:49.72989+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (134, '2026-05-16 10:36:49.72989+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,4.00)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (135, '2026-05-16 10:36:49.72989+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,0.00)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,150.44)');
INSERT INTO "public"."log" VALUES (136, '2026-05-16 10:36:49.73361+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (137, '2026-05-16 10:36:49.73361+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (138, '2026-05-16 10:36:49.73361+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (139, '2026-05-16 10:36:49.73361+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (140, '2026-05-16 10:36:49.73361+02', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)', '(14,4,marcmashernandez@gmail.com,"2026-05-15 17:36:17.222+02","Sopar molt gros",sopar,400.45,)');
INSERT INTO "public"."log" VALUES (141, '2026-05-16 10:36:49.73361+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,150.44)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,150.44)');
INSERT INTO "public"."log" VALUES (148, '2026-05-16 10:48:05.37194+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (149, '2026-05-16 10:48:05.37194+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (150, '2026-05-16 10:48:05.37194+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (151, '2026-05-16 10:48:05.37194+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (152, '2026-05-16 10:48:05.37194+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,150.44)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (159, '2026-05-16 11:24:55.73292+02', NULL, '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,0.00)');
INSERT INTO "public"."log" VALUES (160, '2026-05-16 11:25:27.9451+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (161, '2026-05-16 11:25:27.9451+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (162, '2026-05-16 11:25:27.9451+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (163, '2026-05-16 11:25:27.9451+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (164, '2026-05-16 11:25:27.9451+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (165, '2026-05-16 11:25:27.9451+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,0.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (166, '2026-05-16 11:25:27.94862+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (167, '2026-05-16 11:25:27.94862+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (168, '2026-05-16 11:25:27.94862+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (169, '2026-05-16 11:25:27.94862+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (170, '2026-05-16 11:25:27.94862+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (171, '2026-05-16 11:25:27.94862+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (172, '2026-05-16 11:25:27.95113+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (173, '2026-05-16 11:25:27.95113+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (174, '2026-05-16 11:25:27.95113+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (175, '2026-05-16 11:25:27.95113+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (176, '2026-05-16 11:25:27.95113+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (177, '2026-05-16 11:25:27.95113+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (178, '2026-05-16 11:25:27.95471+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (179, '2026-05-16 11:25:27.95471+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (180, '2026-05-16 11:25:27.95471+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (181, '2026-05-16 11:25:27.95471+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (182, '2026-05-16 11:25:27.95471+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (183, '2026-05-16 11:25:27.95471+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (186, '2026-05-16 11:30:04.241+02', NULL, '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,0.00)');
INSERT INTO "public"."log" VALUES (187, '2026-05-16 11:30:11.39984+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,0.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (188, '2026-05-16 11:30:11.39984+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (189, '2026-05-16 11:30:11.39984+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (190, '2026-05-16 11:30:11.39984+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (191, '2026-05-16 11:30:11.39984+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (192, '2026-05-16 11:30:11.39984+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (193, '2026-05-16 11:30:11.39984+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (194, '2026-05-16 11:30:11.4035+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (195, '2026-05-16 11:30:11.4035+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (196, '2026-05-16 11:30:11.4035+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (197, '2026-05-16 11:30:11.4035+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (198, '2026-05-16 11:30:11.4035+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (199, '2026-05-16 11:30:11.4035+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (200, '2026-05-16 11:30:11.4035+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (202, '2026-05-16 11:34:58.45408+02', NULL, '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,0.00)');
INSERT INTO "public"."log" VALUES (203, '2026-05-16 11:35:15.814+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (204, '2026-05-16 11:35:15.814+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (205, '2026-05-16 11:35:15.814+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (206, '2026-05-16 11:35:15.814+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (207, '2026-05-16 11:35:15.814+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (208, '2026-05-16 11:35:15.814+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (209, '2026-05-16 11:35:15.814+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (210, '2026-05-16 11:35:15.814+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,0.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (211, '2026-05-16 11:35:15.81745+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (212, '2026-05-16 11:35:15.81745+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (213, '2026-05-16 11:35:15.81745+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (214, '2026-05-16 11:35:15.81745+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (215, '2026-05-16 11:35:15.81745+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (216, '2026-05-16 11:35:15.81745+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (217, '2026-05-16 11:35:15.81745+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (218, '2026-05-16 11:35:15.81745+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (220, '2026-05-16 11:38:44.09612+02', NULL, '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,0.00)');
INSERT INTO "public"."log" VALUES (221, '2026-05-16 11:38:49.62977+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (222, '2026-05-16 11:38:49.62977+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (223, '2026-05-16 11:38:49.62977+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (224, '2026-05-16 11:38:49.62977+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (225, '2026-05-16 11:38:49.62977+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (226, '2026-05-16 11:38:49.62977+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (227, '2026-05-16 11:38:49.62977+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (228, '2026-05-16 11:38:49.62977+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (229, '2026-05-16 11:38:49.62977+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,0.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (230, '2026-05-16 11:38:49.63362+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (231, '2026-05-16 11:38:49.63362+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (232, '2026-05-16 11:38:49.63362+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (233, '2026-05-16 11:38:49.63362+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (234, '2026-05-16 11:38:49.63362+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (235, '2026-05-16 11:38:49.63362+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (236, '2026-05-16 11:38:49.63362+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (237, '2026-05-16 11:38:49.63362+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (238, '2026-05-16 11:38:49.63362+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (240, '2026-05-16 11:40:56.79228+02', NULL, '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,0.00)');
INSERT INTO "public"."log" VALUES (241, '2026-05-16 11:41:03.18435+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (242, '2026-05-16 11:41:03.18435+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (243, '2026-05-16 11:41:03.18435+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (244, '2026-05-16 11:41:03.18435+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (245, '2026-05-16 11:41:03.18435+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (246, '2026-05-16 11:41:03.18435+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (247, '2026-05-16 11:41:03.18435+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (248, '2026-05-16 11:41:03.18435+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (249, '2026-05-16 11:41:03.18435+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (250, '2026-05-16 11:41:03.18435+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,0.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)');
INSERT INTO "public"."log" VALUES (251, '2026-05-16 11:41:03.18858+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (252, '2026-05-16 11:41:03.18858+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (253, '2026-05-16 11:41:03.18858+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (254, '2026-05-16 11:41:03.18858+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (255, '2026-05-16 11:41:03.18858+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (256, '2026-05-16 11:41:03.18858+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (257, '2026-05-16 11:41:03.18858+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (258, '2026-05-16 11:41:03.18858+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (259, '2026-05-16 11:41:03.18858+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (260, '2026-05-16 11:41:03.18858+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)');
INSERT INTO "public"."log" VALUES (261, '2026-05-16 11:41:03.19101+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)');
INSERT INTO "public"."log" VALUES (262, '2026-05-16 11:41:17.52888+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,750.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (263, '2026-05-16 11:41:17.52888+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (264, '2026-05-16 11:41:17.52888+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (265, '2026-05-16 11:41:17.52888+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (266, '2026-05-16 11:41:17.52888+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (267, '2026-05-16 11:41:17.52888+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (268, '2026-05-16 11:41:17.52888+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (269, '2026-05-16 11:41:17.52888+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (270, '2026-05-16 11:41:17.52888+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (271, '2026-05-16 11:41:17.52888+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (278, '2026-05-16 13:04:36.2385+02', NULL, '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,0.00)');
INSERT INTO "public"."log" VALUES (279, '2026-05-16 13:04:38.45335+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (280, '2026-05-16 13:04:38.45335+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (281, '2026-05-16 13:04:38.45335+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (282, '2026-05-16 13:04:38.45335+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (283, '2026-05-16 13:04:38.45335+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (284, '2026-05-16 13:04:38.45335+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (285, '2026-05-16 13:04:38.45335+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (286, '2026-05-16 13:04:38.45335+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (287, '2026-05-16 13:04:38.45335+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (288, '2026-05-16 13:04:38.45335+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (289, '2026-05-16 13:04:38.45335+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,0.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (290, '2026-05-16 13:04:38.45821+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (294, '2026-05-16 13:29:34.01336+02', NULL, '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,0.00)');
INSERT INTO "public"."log" VALUES (295, '2026-05-16 13:36:01.36572+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (296, '2026-05-16 13:36:01.36572+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (297, '2026-05-16 13:36:01.36572+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (298, '2026-05-16 13:36:01.36572+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (299, '2026-05-16 13:36:01.36572+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (300, '2026-05-16 13:36:01.36572+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (301, '2026-05-16 13:36:01.36572+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (302, '2026-05-16 13:36:01.36572+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (303, '2026-05-16 13:36:01.36572+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (304, '2026-05-16 13:36:01.36572+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (305, '2026-05-16 13:36:01.36572+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (306, '2026-05-16 13:36:01.36572+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,0.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)');
INSERT INTO "public"."log" VALUES (307, '2026-05-16 13:36:01.36983+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (308, '2026-05-16 13:36:01.36983+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (309, '2026-05-16 13:36:01.36983+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (310, '2026-05-16 13:36:01.36983+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (311, '2026-05-16 13:36:01.36983+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (312, '2026-05-16 13:36:01.36983+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (313, '2026-05-16 13:36:01.36983+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (314, '2026-05-16 13:36:01.36983+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (315, '2026-05-16 13:36:01.36983+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (316, '2026-05-16 13:36:01.36983+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (317, '2026-05-16 13:36:01.36983+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (318, '2026-05-16 13:36:01.36983+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)');
INSERT INTO "public"."log" VALUES (319, '2026-05-16 13:36:01.37191+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (320, '2026-05-16 13:36:01.37191+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (321, '2026-05-16 13:36:01.37191+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (322, '2026-05-16 13:36:01.37191+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (323, '2026-05-16 13:36:01.37191+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (324, '2026-05-16 13:36:01.37191+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (325, '2026-05-16 13:36:01.37191+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (326, '2026-05-16 13:36:01.37191+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (327, '2026-05-16 13:36:01.37191+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (328, '2026-05-16 13:36:01.37191+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (329, '2026-05-16 13:36:01.37191+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (330, '2026-05-16 13:36:01.37191+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)');
INSERT INTO "public"."log" VALUES (331, '2026-05-16 13:36:01.37461+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (332, '2026-05-16 13:36:01.37461+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (333, '2026-05-16 13:36:01.37461+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (334, '2026-05-16 13:36:01.37461+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (335, '2026-05-16 13:36:01.37461+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (336, '2026-05-16 13:36:01.37461+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (337, '2026-05-16 13:36:01.37461+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (338, '2026-05-16 13:36:01.37461+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (339, '2026-05-16 13:36:01.37461+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (340, '2026-05-16 13:36:01.37461+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (341, '2026-05-16 13:36:01.37461+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (342, '2026-05-16 13:36:01.37461+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)');
INSERT INTO "public"."log" VALUES (343, '2026-05-16 13:36:01.37779+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)');
INSERT INTO "public"."log" VALUES (345, '2026-05-16 13:42:21.87463+02', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)', '(82,44,ericahc@gmail.com,"2026-05-16 11:40:22.96+02","Simulador nou","Gastos Tontos",1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (346, '2026-05-16 13:42:21.87463+02', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)', '(76,44,ericahc@gmail.com,"2026-05-16 11:29:42.028+02","Dinar Alcudia",Menjar,1600.00,800.00)');
INSERT INTO "public"."log" VALUES (347, '2026-05-16 13:42:21.87463+02', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)', '(51,2,charles818@outlook.com,"2026-05-16 09:52:30.57+02","Compres de maig",diari,20.00,5.00)');
INSERT INTO "public"."log" VALUES (348, '2026-05-16 13:42:21.87463+02', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)', '(27,4,marcmashernandez@gmail.com,"2026-05-15 18:14:15.797+02",a,a,300.50,300.50)');
INSERT INTO "public"."log" VALUES (349, '2026-05-16 13:42:21.87463+02', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)', '(29,4,peremunar@mp.com,"2026-05-15 18:15:59.405+02",a,b,1000.00,1000.00)');
INSERT INTO "public"."log" VALUES (350, '2026-05-16 13:42:21.87463+02', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)', '(47,4,marcmashernandez@gmail.com,"2026-05-16 09:39:07.659+02",Simulador,"Gastos Tontos",1500.44,750.21)');
INSERT INTO "public"."log" VALUES (351, '2026-05-16 13:42:21.87463+02', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)', '(61,44,ericahc@gmail.com,"2026-05-16 10:36:25.634+02","Sopar Figureet",sopars,300.89,300.89)');
INSERT INTO "public"."log" VALUES (352, '2026-05-16 13:42:21.87463+02', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)', '(73,44,walter1@icloud.com,"2026-05-16 11:24:38.218+02",Dinar,Menjar,1700.00,300.00)');
INSERT INTO "public"."log" VALUES (353, '2026-05-16 13:42:21.87463+02', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)', '(78,44,peremunar@mp.com,"2026-05-16 11:34:43.014+02",Verbena,Menjar,300.00,150.00)');
INSERT INTO "public"."log" VALUES (354, '2026-05-16 13:42:21.87463+02', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)', '(80,44,marcmashernandez@gmail.com,"2026-05-16 11:38:18.904+02","Dinar Cas padri toni",Menjar,150.00,75.00)');
INSERT INTO "public"."log" VALUES (355, '2026-05-16 13:42:21.87463+02', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)', '(89,43,uncorreudeprova@iessineu.net,"2025-01-06 13:03:50.638+01","Test ",Test,1500.00,1500.00)');
INSERT INTO "public"."log" VALUES (356, '2026-05-16 13:42:21.87463+02', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,700.00)', '(93,44,waltjen@mail.com,"2026-05-16 13:28:31.619+02","Cotxe nou",Luxes,16700.54,7700.00)');

-- ----------------------------
-- Table structure for pagador
-- ----------------------------
DROP TABLE IF EXISTS "public"."pagador";
CREATE TABLE "public"."pagador" (
  "id" int4 NOT NULL DEFAULT nextval('pagador_id_seq'::regclass),
  "iddespesa" int4 NOT NULL,
  "idusuari" text COLLATE "pg_catalog"."default" NOT NULL,
  "contribucio" numeric(10,2) NOT NULL,
  "hapagat" bool NOT NULL
)
;

-- ----------------------------
-- Records of pagador
-- ----------------------------
INSERT INTO "public"."pagador" VALUES (21, 27, 'marcmashernandez@gmail.com', 300.50, 't');
INSERT INTO "public"."pagador" VALUES (22, 27, 'peremunar@mp.com', 0.00, 'f');
INSERT INTO "public"."pagador" VALUES (24, 29, 'peremunar@mp.com', 500.00, 't');
INSERT INTO "public"."pagador" VALUES (25, 29, 'marcmashernandez@gmail.com', 500.00, 't');
INSERT INTO "public"."pagador" VALUES (43, 47, 'marcmashernandez@gmail.com', 750.21, 't');
INSERT INTO "public"."pagador" VALUES (44, 47, 'peremunar@mp.com', 750.22, 'f');
INSERT INTO "public"."pagador" VALUES (48, 51, 'charles818@outlook.com', 5.00, 't');
INSERT INTO "public"."pagador" VALUES (49, 51, 'bukaren@icloud.com', 7.50, 'f');
INSERT INTO "public"."pagador" VALUES (50, 51, 'peremunar@mp.com', 7.50, 'f');
INSERT INTO "public"."pagador" VALUES (60, 61, 'ericahc@gmail.com', 150.44, 't');
INSERT INTO "public"."pagador" VALUES (61, 61, 'marcmashernandez@gmail.com', 150.45, 't');
INSERT INTO "public"."pagador" VALUES (73, 73, 'walter1@icloud.com', 300.00, 't');
INSERT INTO "public"."pagador" VALUES (74, 73, 'waltjen@mail.com', 100.00, 'f');
INSERT INTO "public"."pagador" VALUES (75, 73, 'ericahc@gmail.com', 650.00, 'f');
INSERT INTO "public"."pagador" VALUES (76, 73, 'marcmashernandez@gmail.com', 650.00, 'f');
INSERT INTO "public"."pagador" VALUES (79, 76, 'ericahc@gmail.com', 800.00, 't');
INSERT INTO "public"."pagador" VALUES (80, 76, 'marcmashernandez@gmail.com', 800.00, 'f');
INSERT INTO "public"."pagador" VALUES (82, 78, 'peremunar@mp.com', 150.00, 't');
INSERT INTO "public"."pagador" VALUES (83, 78, 'marcmashernandez@gmail.com', 150.00, 'f');
INSERT INTO "public"."pagador" VALUES (85, 80, 'marcmashernandez@gmail.com', 75.00, 't');
INSERT INTO "public"."pagador" VALUES (86, 80, 'peremunar@mp.com', 75.00, 'f');
INSERT INTO "public"."pagador" VALUES (88, 82, 'ericahc@gmail.com', 750.00, 't');
INSERT INTO "public"."pagador" VALUES (89, 82, 'marcmashernandez@gmail.com', 750.00, 't');
INSERT INTO "public"."pagador" VALUES (96, 89, 'uncorreudeprova@iessineu.net', 1500.00, 't');
INSERT INTO "public"."pagador" VALUES (100, 93, 'waltjen@mail.com', 700.00, 't');
INSERT INTO "public"."pagador" VALUES (102, 93, 'peremunar@mp.com', 4500.27, 'f');
INSERT INTO "public"."pagador" VALUES (103, 93, 'ericahc@gmail.com', 4500.27, 'f');
INSERT INTO "public"."pagador" VALUES (101, 93, 'walter1@icloud.com', 7000.00, 't');

-- ----------------------------
-- Table structure for usuari
-- ----------------------------
DROP TABLE IF EXISTS "public"."usuari";
CREATE TABLE "public"."usuari" (
  "correu" text COLLATE "pg_catalog"."default" NOT NULL,
  "nom" text COLLATE "pg_catalog"."default" NOT NULL,
  "llinatge1" text COLLATE "pg_catalog"."default" NOT NULL,
  "llinatge2" text COLLATE "pg_catalog"."default",
  "iban" text COLLATE "pg_catalog"."default" NOT NULL,
  "alias" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of usuari
-- ----------------------------
INSERT INTO "public"."usuari" VALUES ('uncorreudeprova@iessineu.net', 'Tomeu', 'Llabres', '', 'ES1461515167', 'DepartamentInformatica2026');
INSERT INTO "public"."usuari" VALUES ('charles818@outlook.com', 'Charles', 'Butler', NULL, 'DO352255756531358716135132772030', 'butcha');
INSERT INTO "public"."usuari" VALUES ('marcmashernandez@gmail.com', 'Marc', 'Mas', 'Hernandez', 'ES63232626262', 'MarcMas07 ');
INSERT INTO "public"."usuari" VALUES ('walter1@icloud.com', 'Walter', 'Sanders', NULL, 'SO415174131809794271865381445524', 'sw118');
INSERT INTO "public"."usuari" VALUES ('richardsonwalter1959@gmail.com', 'Walter', 'Richardson', NULL, 'KF611165719028786211856726601658', 'richwalt');
INSERT INTO "public"."usuari" VALUES ('waltjen@mail.com', 'Walter', 'Jenkins', NULL, 'SL733081795289149128729107664067', 'waltjenkins4');
INSERT INTO "public"."usuari" VALUES ('waltehamilton@icloud.com', 'Walter', 'Hamilton', NULL, 'SO732491316837245262534549969659', 'waltehami');
INSERT INTO "public"."usuari" VALUES ('bukaren@icloud.com', 'Karen', 'Burns', NULL, 'EH451108730168983820809755265199', 'kburn');
INSERT INTO "public"."usuari" VALUES ('peremunar@mp.com', 'Pere', 'Munar', 'Payeras', 'ES357131341', 'Fenicles');
INSERT INTO "public"."usuari" VALUES ('herrerawalte1123@gmail.com', 'Walter', 'Herrera', NULL, 'RM628082943014005264820526207106', 'walter3');
INSERT INTO "public"."usuari" VALUES ('ericahc@gmail.com', 'Erica', 'Hernandez', NULL, 'DE147814141', 'Erica');

-- ----------------------------
-- Table structure for usuarigrup
-- ----------------------------
DROP TABLE IF EXISTS "public"."usuarigrup";
CREATE TABLE "public"."usuarigrup" (
  "idusuari" text COLLATE "pg_catalog"."default" NOT NULL,
  "idgrup" int4 NOT NULL
)
;

-- ----------------------------
-- Records of usuarigrup
-- ----------------------------
INSERT INTO "public"."usuarigrup" VALUES ('marcmashernandez@gmail.com', 2);
INSERT INTO "public"."usuarigrup" VALUES ('marcmashernandez@gmail.com', 4);
INSERT INTO "public"."usuarigrup" VALUES ('peremunar@mp.com', 4);
INSERT INTO "public"."usuarigrup" VALUES ('charles818@outlook.com', 2);
INSERT INTO "public"."usuarigrup" VALUES ('peremunar@mp.com', 2);
INSERT INTO "public"."usuarigrup" VALUES ('bukaren@icloud.com', 2);
INSERT INTO "public"."usuarigrup" VALUES ('waltehamilton@icloud.com', 2);
INSERT INTO "public"."usuarigrup" VALUES ('ericahc@gmail.com', 4);
INSERT INTO "public"."usuarigrup" VALUES ('ericahc@gmail.com', 44);
INSERT INTO "public"."usuarigrup" VALUES ('marcmashernandez@gmail.com', 44);
INSERT INTO "public"."usuarigrup" VALUES ('walter1@icloud.com', 44);
INSERT INTO "public"."usuarigrup" VALUES ('waltjen@mail.com', 44);
INSERT INTO "public"."usuarigrup" VALUES ('peremunar@mp.com', 44);
INSERT INTO "public"."usuarigrup" VALUES ('uncorreudeprova@iessineu.net', 2);
INSERT INTO "public"."usuarigrup" VALUES ('uncorreudeprova@iessineu.net', 43);

-- ----------------------------
-- Function structure for actualitzarimport
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."actualitzarimport"();
CREATE FUNCTION "public"."actualitzarimport"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
UPDATE despesa set importpagat = (
    SELECT sum(contribucio) 
	FROM pagador 
	WHERE pagador.iddespesa = despesa.id
	AND hapagat='true')::numeric 
    WHERE despesa.id = id;
RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for arrodonir
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."arrodonir"("pagat" numeric, "total" numeric);
CREATE FUNCTION "public"."arrodonir"("pagat" numeric, "total" numeric)
  RETURNS "pg_catalog"."numeric" AS $BODY$
DECLARE
    result NUMERIC;
BEGIN
    IF (pagat + 0.01) = total THEN
        result = total;
    ELSE
        result = pagat;
    END IF;
    RETURN result;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for arrodonirimport
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."arrodonirimport"();
CREATE FUNCTION "public"."arrodonirimport"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
NEW.importpagat := arrodonir(NEW.importpagat,NEW.importtotal);
RETURN NEW;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Procedure structure for assignarpreupartsiguals
-- ----------------------------
DROP PROCEDURE IF EXISTS "public"."assignarpreupartsiguals"("preu" numeric, "despesa" int4);
CREATE PROCEDURE "public"."assignarpreupartsiguals"("preu" numeric, "despesa" int4)
 AS $BODY$
DECLARE numPagadors INTEGER;
BEGIN
numPagadors = (
    SELECT COUNT(*)
    FROM pagador
    WHERE
        pagador.idDespesa = despesa
);
UPDATE pagador
SET
    contribucio = (preu / numPagadors)
WHERE
    pagador.iddespesa = despesa;
END
$BODY$
  LANGUAGE plpgsql;

-- ----------------------------
-- Function structure for mostrardespesescategoriagrup
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."mostrardespesescategoriagrup"("grup" int4);
CREATE FUNCTION "public"."mostrardespesescategoriagrup"("grup" int4)
  RETURNS TABLE("cat" text, "import" numeric, "percent" text) AS $BODY$
BEGIN
    RETURN QUERY SELECT 
    categoria,
    sumatotal, 
    TO_CHAR(sumatotal * 100 / SUM(sumatotal) OVER (), 'fm90D00%')::TEXT AS percent
    FROM (
        SELECT categoria, SUM(importtotal) AS sumatotal
        FROM despesa
        WHERE despesa.idgrup = grup
        GROUP BY categoria
    )
    RETURN;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- ----------------------------
-- Function structure for mostrardespesesusuarisgrup
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."mostrardespesesusuarisgrup"("grup" int4);
CREATE FUNCTION "public"."mostrardespesesusuarisgrup"("grup" int4)
  RETURNS TABLE("usuari" text, "import" numeric) AS $BODY$
BEGIN
    RETURN QUERY SELECT idusuari, sumatotal
FROM (
        SELECT idusuari, sum(contribucio) AS sumatotal, idgrup
        from despesa
            LEFT JOIN pagador ON pagador.iddespesa = despesa.id
        WHERE
            hapagat = true
        GROUP BY
            idgrup, idusuari
        ORDER BY idgrup
    )
    WHERE idGrup = grup;
    RETURN;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- ----------------------------
-- Function structure for mostrardeutesgrup
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."mostrardeutesgrup"("grup" int4);
CREATE FUNCTION "public"."mostrardeutesgrup"("grup" int4)
  RETURNS TABLE("usuarirep" text, "usuarideu" text, "quantitat" numeric) AS $BODY$
BEGIN
    RETURN QUERY SELECT pagadororiginal AS usuariRep, idusuari AS usuariDeu , sum(contribucio) AS quantitat 
                FROM despesa 
                LEFT JOIN pagador ON pagador.iddespesa = despesa.id 
                WHERE hapagat = false AND idGrup = grup
                GROUP BY pagadororiginal,idusuari
                ORDER BY pagadororiginal;
    RETURN;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;

-- ----------------------------
-- Function structure for omplirlog
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."omplirlog"();
CREATE FUNCTION "public"."omplirlog"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
BEGIN
  INSERT INTO LOG (datetime, oldrow,newrow)
  VALUES
  (NOW(),OLD::text, NEW::text);
  RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."despesa_id_seq"
OWNED BY "public"."despesa"."id";
SELECT setval('"public"."despesa_id_seq"', 94, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."grup_id_seq"
OWNED BY "public"."grup"."id";
SELECT setval('"public"."grup_id_seq"', 82, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."log_id_seq"
OWNED BY "public"."log"."id";
SELECT setval('"public"."log_id_seq"', 356, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."pagador_id_seq"
OWNED BY "public"."pagador"."id";
SELECT setval('"public"."pagador_id_seq"', 104, true);

-- ----------------------------
-- Triggers structure for table despesa
-- ----------------------------
CREATE TRIGGER "arrodonirimport" BEFORE UPDATE OF "importpagat" ON "public"."despesa"
FOR EACH ROW
EXECUTE PROCEDURE "public"."arrodonirimport"();
CREATE TRIGGER "omplirlog" AFTER INSERT OR UPDATE OR DELETE ON "public"."despesa"
FOR EACH ROW
EXECUTE PROCEDURE "public"."omplirlog"();

-- ----------------------------
-- Primary Key structure for table despesa
-- ----------------------------
ALTER TABLE "public"."despesa" ADD CONSTRAINT "despesa_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table grup
-- ----------------------------
ALTER TABLE "public"."grup" ADD CONSTRAINT "grup_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table log
-- ----------------------------
ALTER TABLE "public"."log" ADD CONSTRAINT "log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Triggers structure for table pagador
-- ----------------------------
CREATE TRIGGER "actualitzarimport" AFTER INSERT OR UPDATE OR DELETE ON "public"."pagador"
FOR EACH STATEMENT
EXECUTE PROCEDURE "public"."actualitzarimport"();

-- ----------------------------
-- Primary Key structure for table pagador
-- ----------------------------
ALTER TABLE "public"."pagador" ADD CONSTRAINT "pagador_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table usuari
-- ----------------------------
ALTER TABLE "public"."usuari" ADD CONSTRAINT "usuari_pkey" PRIMARY KEY ("correu");

-- ----------------------------
-- Primary Key structure for table usuarigrup
-- ----------------------------
ALTER TABLE "public"."usuarigrup" ADD CONSTRAINT "usuarigrup_pkey" PRIMARY KEY ("idusuari", "idgrup");

-- ----------------------------
-- Foreign Keys structure for table despesa
-- ----------------------------
ALTER TABLE "public"."despesa" ADD CONSTRAINT "despesa_idgrup_fkey" FOREIGN KEY ("idgrup") REFERENCES "public"."grup" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."despesa" ADD CONSTRAINT "despesa_pagadororiginal_fkey" FOREIGN KEY ("pagadororiginal") REFERENCES "public"."usuari" ("correu") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table pagador
-- ----------------------------
ALTER TABLE "public"."pagador" ADD CONSTRAINT "pagador_iddespesa_fkey" FOREIGN KEY ("iddespesa") REFERENCES "public"."despesa" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."pagador" ADD CONSTRAINT "pagador_idusuari_fkey" FOREIGN KEY ("idusuari") REFERENCES "public"."usuari" ("correu") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table usuarigrup
-- ----------------------------
ALTER TABLE "public"."usuarigrup" ADD CONSTRAINT "usuarigrup_idgrup_fkey" FOREIGN KEY ("idgrup") REFERENCES "public"."grup" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."usuarigrup" ADD CONSTRAINT "usuarigrup_idusuari_fkey" FOREIGN KEY ("idusuari") REFERENCES "public"."usuari" ("correu") ON DELETE NO ACTION ON UPDATE NO ACTION;

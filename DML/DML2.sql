------------------------------------------------------
-- 1. PAIS (10 registros fijos)
------------------------------------------------------
INSERT INTO PAIS (nombre) VALUES
('España'),
('Colombia'),
('Estados Unidos'),
('Rusia'),
('China'),
('Mongolia'),
('Italia'),
('Grecia'),
('Francia'),
('Reino Unido');

------------------------------------------------------
-- 2. CODIGO_CIVIL 
-- (por la restricción UNIQUE, solo se puede insertar 1 registro por país)
------------------------------------------------------
INSERT INTO CODIGO_CIVIL (idPais) VALUES
(1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

------------------------------------------------------
-- 3. CONGRESO
-- (igual que CODIGO_CIVIL, 1 registro por país)
------------------------------------------------------
INSERT INTO CONGRESO (idPais) VALUES
(1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

------------------------------------------------------
-- 4. PERSONA
-- Se insertan 10 registros por país (total 100). 
-- Se usan claves de la forma:
--   Para políticos: 'C{i}_T{n}'  (T de “top político”)
--   Para ciudadanos: 'C{i}_C{n}'  (C de “ciudadano”)
------------------------------------------------------
-- País 1: España (idPais = 1): 5 políticos, 5 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C1_T1','Antonio','Gómez','López','1970-01-01','H',1),
('C1_T2','Marina','Fernández',NULL,'1972-02-02','M',1),
('C1_T3','Luis','Martínez','Ruiz','1968-03-03','H',1),
('C1_T4','Carmen','Sánchez','Diaz','1975-04-04','M',1),
('C1_T5','Javier','Pérez','García','1971-05-05','H',1),
('C1_C1','Marta','Rodríguez',NULL,'1980-06-06','M',1),
('C1_C2','Carlos','Hernández','Morales','1982-07-07','H',1),
('C1_C3','Lucía','Jiménez','Cruz','1981-08-08','M',1),
('C1_C4','Pedro','Ruiz','Soto','1979-09-09','H',1),
('C1_C5','Elena','López','Vargas','1983-10-10','M',1);

-- País 2: Colombia (idPais = 2): 3 políticos, 7 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C2_T1','Andrés','Martínez','Pineda','1970-01-11','H',2),
('C2_T2','Isabel','Gómez','Rojas','1973-02-12','M',2),
('C2_T3','Ricardo','Castaño',NULL,'1969-03-13','H',2),
('C2_C1','Laura','Ramírez','Moreno','1982-04-14','M',2),
('C2_C2','Diego','Sánchez','Vega','1980-05-15','H',2),
('C2_C3','Paula','González','Molina','1981-06-16','M',2),
('C2_C4','Santiago','Cabrera','Díaz','1978-07-17','H',2),
('C2_C5','Valentina','Acosta','Navarro','1983-08-18','M',2),
('C2_C6','Felipe','Ortiz','Castro','1979-09-19','H',2),
('C2_C7','Carolina','Ramos','Herrera','1984-10-20','M',2);

-- País 3: Estados Unidos (idPais = 3): 7 políticos, 3 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C3_T1','Robert','Smith',NULL,'1965-01-21','H',3),
('C3_T2','Jennifer','Johnson','Williams','1967-02-22','M',3),
('C3_T3','Michael','Brown','Jones','1966-03-23','H',3),
('C3_T4','Linda','Garcia','Miller','1968-04-24','M',3),
('C3_T5','William','Davis','Rodriguez','1964-05-25','H',3),
('C3_T6','Elizabeth','Martinez','Hernandez','1969-06-26','M',3),
('C3_T7','David','Lopez','Gonzalez','1963-07-27','H',3),
('C3_C1','Susan','Wilson','Anderson','1975-08-28','M',3),
('C3_C2','Joseph','Thomas','Taylor','1976-09-29','H',3),
('C3_C3','Margaret','Moore','Jackson','1977-10-30','M',3);

-- País 4: Rusia (idPais = 4): 4 políticos, 6 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C4_T1','Ivan','Ivanov','Petrov','1960-01-31','H',4),
('C4_T2','Olga','Sidorova',NULL,'1962-02-01','M',4),
('C4_T3','Sergey','Kuznetsov','Smirnov','1961-03-02','H',4),
('C4_T4','Natalia','Popova','Vasilyeva','1963-04-03','M',4),
('C4_C1','Dmitry','Novikov','Fedorov','1970-05-04','H',4),
('C4_C2','Elena','Morozova','Alexandrova','1971-06-05','M',4),
('C4_C3','Mikhail','Volkov','Karpov','1972-07-06','H',4),
('C4_C4','Tatiana','Lebedeva',NULL,'1973-08-07','M',4),
('C4_C5','Alexei','Semenov','Gordeev','1974-09-08','H',4),
('C4_C6','Irina','Pavlova','Nikolaeva','1975-10-09','M',4);

-- País 5: China (idPais = 5): 6 políticos, 4 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C5_T1','Wei','Zhang','Li','1965-11-10','H',5),
('C5_T2','Fang','Wang','Chen','1966-12-11','M',5),
('C5_T3','Ming','Liu','Yang','1967-01-12','H',5),
('C5_T4','Li','Huang','Zhao','1968-02-13','M',5),
('C5_T5','Jun','Wu','Zhou','1969-03-14','H',5),
('C5_T6','Mei','Xu','Sun','1970-04-15','M',5),
('C5_C1','Lei','Ma','Hu','1975-05-16','H',5),
('C5_C2','Lan','Guo','He','1976-06-17','M',5),
('C5_C3','Ting','Gao','Lin','1977-07-18','H',5),
('C5_C4','Xia','Zheng','Cao','1978-08-19','M',5);

-- País 6: Mongolia (idPais = 6): 2 políticos, 8 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C6_T1','Bat','Chuluun','Enkhtuya','1960-09-20','H',6),
('C6_T2','Naran','Bold','Tumen','1961-10-21','M',6),
('C6_C1','Sarnai','Baatar','Altansukh','1975-11-22','M',6),
('C6_C2','Oyunchimeg','Erdene','Chinbat','1976-12-23','M',6),
('C6_C3','Temuulen','Ganbold',NULL,'1977-01-24','H',6),
('C6_C4','Khulan','Enkhtaivan','Zolbayar','1978-02-25','M',6),
('C6_C5','Tsetseg','Bat','Dashdorj','1979-03-26','M',6),
('C6_C6','Amar','Boldbaatar','Narantsetseg','1980-04-27','H',6),
('C6_C7','Sarangerel','Chuluun','Oyunbileg','1981-05-28','M',6),
('C6_C8','Erdenesukh','Batjargal',NULL,'1982-06-29','M',6);

-- País 7: Italia (idPais = 7): 8 políticos, 2 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C7_T1','Giovanni','Rossi','Bianchi','1955-07-01','H',7),
('C7_T2','Marco','Russo','Ferrari','1956-08-02','H',7),
('C7_T3','Luca','Esposito','Romano','1957-09-03','H',7),
('C7_T4','Francesco','Ricci','Colombo','1958-10-04','H',7),
('C7_T5','Andrea','Marino','Greco','1959-11-05','M',7),
('C7_T6','Paolo','Conti','De Luca','1960-12-06','H',7),
('C7_T7','Stefano','Costa','Giordano','1961-01-07','H',7),
('C7_T8','Roberto','Giuliani','Rinaldi','1962-02-08','H',7),
('C7_C1','Silvia','Moretti','Fontana','1970-03-09','M',7),
('C7_C2','Chiara','Martini','Galli','1971-04-10','M',7);

-- País 8: Grecia (idPais = 8): 5 políticos, 5 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C8_T1','Giorgos','Papadopoulos','Nikolaidis','1960-03-11','H',8),
('C8_T2','Dimitra','Georgiou','Pappas','1961-04-12','M',8),
('C8_T3','Nikolas','Christodoulou','Anagnostou','1962-05-13','H',8),
('C8_T4','Eleni','Konstantinou','Mitsotaki','1963-06-14','M',8),
('C8_T5','Kostas','Alexandris','Theodorou','1964-07-15','H',8),
('C8_C1','Sofia','Lazarou','Kostopoulou','1970-08-16','M',8),
('C8_C2','Maria','Stefanou','Voulgaris','1971-09-17','M',8),
('C8_C3','Ioanna','Mitsis','Papandreou','1972-10-18','M',8),
('C8_C4','Antonis','Nikolaou','Sarris','1973-11-19','H',8),
('C8_C5','Despina','Petridou','Kalogirou','1974-12-20','M',8);

-- País 9: Francia (idPais = 9): 4 políticos, 6 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C9_T1','Jean','Dupont','Martin','1965-01-21','H',9),
('C9_T2','Marie','Bernard','Petit','1966-02-22','M',9),
('C9_T3','Pierre','Robert','Richard','1967-03-23','H',9),
('C9_T4','Sophie','Durand','Moreau','1968-04-24','M',9),
('C9_C1','Nathalie','Leroy','Garcia','1975-05-25','M',9),
('C9_C2','Laurent','Roux','David','1976-06-26','H',9),
('C9_C3','Isabelle','Morel','Faure','1977-07-27','M',9),
('C9_C4','Philippe','Girard','Andre','1978-08-28','H',9),
('C9_C5','Céline','Mercier','Blanc','1979-09-29','M',9),
('C9_C6','Guillaume','Fournier','Lambert','1980-10-30','H',9);

-- País 10: Reino Unido (idPais = 10): 6 políticos, 4 ciudadanos
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
('C10_T1','James','Smith','Brown','1960-11-01','H',10),
('C10_T2','Sarah','Jones','Taylor','1961-12-02','M',10),
('C10_T3','Robert','Williams','Davies','1962-01-03','H',10),
('C10_T4','Emma','Wilson','Evans','1963-02-04','M',10),
('C10_T5','Michael','Thomas','Roberts','1964-03-05','H',10),
('C10_T6','Olivia','Robinson','Johnson','1965-04-06','M',10),
('C10_C1','William','Walker','Wright','1970-05-07','H',10),
('C10_C2','Ava','White','Thompson','1971-06-08','M',10),
('C10_C3','Sophia','Harris','Martin','1972-07-09','M',10),
('C10_C4','Benjamin','Hall','Lee','1973-08-10','H',10);

------------------------------------------------------
-- 5. POLITICO 
-- Se insertan solo los registros de PERSONA designados como políticos.
-- Se asume que el idCongreso corresponde al id del país.
-- Se generan fechas de iniciación y, opcionalmente, fecha de retirada (cumpliendo la restricción).
------------------------------------------------------
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
-- País 1: España (5 políticos)
('C1_T1','2000-01-01','2005-01-01',1),
('C1_T2','2001-02-02',NULL,1),
('C1_T3','2002-03-03','2007-03-03',1),
('C1_T4','2003-04-04',NULL,1),
('C1_T5','2004-05-05','2009-05-05',1),
-- País 2: Colombia (3 políticos)
('C2_T1','2000-06-06','2005-06-06',2),
('C2_T2','2001-07-07',NULL,2),
('C2_T3','2002-08-08','2007-08-08',2),
-- País 3: Estados Unidos (7 políticos)
('C3_T1','1999-01-10','2004-01-10',3),
('C3_T2','1999-02-11',NULL,3),
('C3_T3','1999-03-12','2004-03-12',3),
('C3_T4','1999-04-13',NULL,3),
('C3_T5','1999-05-14','2004-05-14',3),
('C3_T6','1999-06-15',NULL,3),
('C3_T7','1999-07-16','2004-07-16',3),
-- País 4: Rusia (4 políticos)
('C4_T1','1998-08-17','2003-08-17',4),
('C4_T2','1998-09-18',NULL,4),
('C4_T3','1998-10-19','2003-10-19',4),
('C4_T4','1998-11-20',NULL,4),
-- País 5: China (6 políticos)
('C5_T1','1997-12-21','2002-12-21',5),
('C5_T2','1997-01-22',NULL,5),
('C5_T3','1997-02-23','2002-02-23',5),
('C5_T4','1997-03-24',NULL,5),
('C5_T5','1997-04-25','2002-04-25',5),
('C5_T6','1997-05-26',NULL,5),
-- País 6: Mongolia (2 políticos)
('C6_T1','1996-06-27','2001-06-27',6),
('C6_T2','1996-07-28',NULL,6),
-- País 7: Italia (8 políticos)
('C7_T1','1995-08-29','2000-08-29',7),
('C7_T2','1995-09-30',NULL,7),
('C7_T3','1995-10-01','2000-10-01',7),
('C7_T4','1995-11-02',NULL,7),
('C7_T5','1995-12-03','2000-12-03',7),
('C7_T6','1996-01-04',NULL,7),
('C7_T7','1996-02-05','2001-02-05',7),
('C7_T8','1996-03-06',NULL,7),
-- País 8: Grecia (5 políticos)
('C8_T1','1994-04-07','1999-04-07',8),
('C8_T2','1994-05-08',NULL,8),
('C8_T3','1994-06-09','1999-06-09',8),
('C8_T4','1994-07-10',NULL,8),
('C8_T5','1994-08-11','1999-08-11',8),
-- País 9: Francia (4 políticos)
('C9_T1','1993-09-12','1998-09-12',9),
('C9_T2','1993-10-13',NULL,9),
('C9_T3','1993-11-14','1998-11-14',9),
('C9_T4','1993-12-15',NULL,9),
-- País 10: Reino Unido (6 políticos)
('C10_T1','1992-01-16','1997-01-16',10),
('C10_T2','1992-02-17',NULL,10),
('C10_T3','1992-03-18','1997-03-18',10),
('C10_T4','1992-04-19',NULL,10),
('C10_T5','1992-05-20','1997-05-20',10),
('C10_T6','1992-06-21',NULL,10);

------------------------------------------------------
-- 6. CIUDADANO 
-- Se insertan los registros de PERSONA designados como ciudadanos.
------------------------------------------------------
INSERT INTO CIUDADANO (numPasaporte) VALUES
-- País 1: España (5 ciudadanos)
('C1_C1'),('C1_C2'),('C1_C3'),('C1_C4'),('C1_C5'),
-- País 2: Colombia (7 ciudadanos)
('C2_C1'),('C2_C2'),('C2_C3'),('C2_C4'),('C2_C5'),('C2_C6'),('C2_C7'),
-- País 3: Estados Unidos (3 ciudadanos)
('C3_C1'),('C3_C2'),('C3_C3'),
-- País 4: Rusia (6 ciudadanos)
('C4_C1'),('C4_C2'),('C4_C3'),('C4_C4'),('C4_C5'),('C4_C6'),
-- País 5: China (4 ciudadanos)
('C5_C1'),('C5_C2'),('C5_C3'),('C5_C4'),
-- País 6: Mongolia (8 ciudadanos)
('C6_C1'),('C6_C2'),('C6_C3'),('C6_C4'),('C6_C5'),('C6_C6'),('C6_C7'),('C6_C8'),
-- País 7: Italia (2 ciudadanos)
('C7_C1'),('C7_C2'),
-- País 8: Grecia (5 ciudadanos)
('C8_C1'),('C8_C2'),('C8_C3'),('C8_C4'),('C8_C5'),
-- País 9: Francia (6 ciudadanos)
('C9_C1'),('C9_C2'),('C9_C3'),('C9_C4'),('C9_C5'),('C9_C6'),
-- País 10: Reino Unido (4 ciudadanos)
('C10_C1'),('C10_C2'),('C10_C3'),('C10_C4');

------------------------------------------------------
-- 7. LEY
-- Se insertan 10 LEY por país (total 100).
-- Para cada LEY se utiliza el idCodigoCivil correspondiente al país.
-- Se usan fechas que cumplen: fechaImplementacion < fechaAplicacion y fechaImplementacion <= fechaModificacion.
------------------------------------------------------
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
-- Para país 1 (idCodigoCivil = 1), LEY 1 a 10:
('Ley España 1','2021-06-01','2021-06-15','2021-01-01',1),
('Ley España 2','2021-07-01','2021-07-15','2021-02-01',1),
('Ley España 3','2021-08-01','2021-08-15','2021-03-01',1),
('Ley España 4','2021-09-01','2021-09-15','2021-04-01',1),
('Ley España 5','2021-10-01','2021-10-15','2021-05-01',1),
('Ley España 6','2021-11-01','2021-11-15','2021-06-01',1),
('Ley España 7','2021-12-01','2021-12-15','2021-07-01',1),
('Ley España 8','2022-01-01','2022-01-15','2021-08-01',1),
('Ley España 9','2022-02-01','2022-02-15','2021-09-01',1),
('Ley España 10','2022-03-01','2022-03-15','2021-10-01',1),
-- País 2 (idCodigoCivil = 2):
('Ley Colombia 1','2021-06-02','2021-06-16','2021-01-02',2),
('Ley Colombia 2','2021-07-02','2021-07-16','2021-02-02',2),
('Ley Colombia 3','2021-08-02','2021-08-16','2021-03-02',2),
('Ley Colombia 4','2021-09-02','2021-09-16','2021-04-02',2),
('Ley Colombia 5','2021-10-02','2021-10-16','2021-05-02',2),
('Ley Colombia 6','2021-11-02','2021-11-16','2021-06-02',2),
('Ley Colombia 7','2021-12-02','2021-12-16','2021-07-02',2),
('Ley Colombia 8','2022-01-02','2022-01-16','2021-08-02',2),
('Ley Colombia 9','2022-02-02','2022-02-16','2021-09-02',2),
('Ley Colombia 10','2022-03-02','2022-03-16','2021-10-02',2),
-- País 3 (idCodigoCivil = 3):
('Ley EU 1','2021-06-03','2021-06-17','2021-01-03',3),
('Ley EU 2','2021-07-03','2021-07-17','2021-02-03',3),
('Ley EU 3','2021-08-03','2021-08-17','2021-03-03',3),
('Ley EU 4','2021-09-03','2021-09-17','2021-04-03',3),
('Ley EU 5','2021-10-03','2021-10-17','2021-05-03',3),
('Ley EU 6','2021-11-03','2021-11-17','2021-06-03',3),
('Ley EU 7','2021-12-03','2021-12-17','2021-07-03',3),
('Ley EU 8','2022-01-03','2022-01-17','2021-08-03',3),
('Ley EU 9','2022-02-03','2022-02-17','2021-09-03',3),
('Ley EU 10','2022-03-03','2022-03-17','2021-10-03',3),
-- País 4 (idCodigoCivil = 4):
('Ley Rusia 1','2021-06-04','2021-06-18','2021-01-04',4),
('Ley Rusia 2','2021-07-04','2021-07-18','2021-02-04',4),
('Ley Rusia 3','2021-08-04','2021-08-18','2021-03-04',4),
('Ley Rusia 4','2021-09-04','2021-09-18','2021-04-04',4),
('Ley Rusia 5','2021-10-04','2021-10-18','2021-05-04',4),
('Ley Rusia 6','2021-11-04','2021-11-18','2021-06-04',4),
('Ley Rusia 7','2021-12-04','2021-12-18','2021-07-04',4),
('Ley Rusia 8','2022-01-04','2022-01-18','2021-08-04',4),
('Ley Rusia 9','2022-02-04','2022-02-18','2021-09-04',4),
('Ley Rusia 10','2022-03-04','2022-03-18','2021-10-04',4),
-- País 5 (idCodigoCivil = 5):
('Ley China 1','2021-06-05','2021-06-19','2021-01-05',5),
('Ley China 2','2021-07-05','2021-07-19','2021-02-05',5),
('Ley China 3','2021-08-05','2021-08-19','2021-03-05',5),
('Ley China 4','2021-09-05','2021-09-19','2021-04-05',5),
('Ley China 5','2021-10-05','2021-10-19','2021-05-05',5),
('Ley China 6','2021-11-05','2021-11-19','2021-06-05',5),
('Ley China 7','2021-12-05','2021-12-19','2021-07-05',5),
('Ley China 8','2022-01-05','2022-01-19','2021-08-05',5),
('Ley China 9','2022-02-05','2022-02-19','2021-09-05',5),
('Ley China 10','2022-03-05','2022-03-19','2021-10-05',5),
-- País 6 (idCodigoCivil = 6):
('Ley Mongolia 1','2021-06-06','2021-06-20','2021-01-06',6),
('Ley Mongolia 2','2021-07-06','2021-07-20','2021-02-06',6),
('Ley Mongolia 3','2021-08-06','2021-08-20','2021-03-06',6),
('Ley Mongolia 4','2021-09-06','2021-09-20','2021-04-06',6),
('Ley Mongolia 5','2021-10-06','2021-10-20','2021-05-06',6),
('Ley Mongolia 6','2021-11-06','2021-11-20','2021-06-06',6),
('Ley Mongolia 7','2021-12-06','2021-12-20','2021-07-06',6),
('Ley Mongolia 8','2022-01-06','2022-01-20','2021-08-06',6),
('Ley Mongolia 9','2022-02-06','2022-02-20','2021-09-06',6),
('Ley Mongolia 10','2022-03-06','2022-03-20','2021-10-06',6),
-- País 7 (idCodigoCivil = 7):
('Ley Italia 1','2021-06-07','2021-06-21','2021-01-07',7),
('Ley Italia 2','2021-07-07','2021-07-21','2021-02-07',7),
('Ley Italia 3','2021-08-07','2021-08-21','2021-03-07',7),
('Ley Italia 4','2021-09-07','2021-09-21','2021-04-07',7),
('Ley Italia 5','2021-10-07','2021-10-21','2021-05-07',7),
('Ley Italia 6','2021-11-07','2021-11-21','2021-06-07',7),
('Ley Italia 7','2021-12-07','2021-12-21','2021-07-07',7),
('Ley Italia 8','2022-01-07','2022-01-21','2021-08-07',7),
('Ley Italia 9','2022-02-07','2022-02-21','2021-09-07',7),
('Ley Italia 10','2022-03-07','2022-03-21','2021-10-07',7),
-- País 8 (idCodigoCivil = 8):
('Ley Grecia 1','2021-06-08','2021-06-22','2021-01-08',8),
('Ley Grecia 2','2021-07-08','2021-07-22','2021-02-08',8),
('Ley Grecia 3','2021-08-08','2021-08-22','2021-03-08',8),
('Ley Grecia 4','2021-09-08','2021-09-22','2021-04-08',8),
('Ley Grecia 5','2021-10-08','2021-10-22','2021-05-08',8),
('Ley Grecia 6','2021-11-08','2021-11-22','2021-06-08',8),
('Ley Grecia 7','2021-12-08','2021-12-22','2021-07-08',8),
('Ley Grecia 8','2022-01-08','2022-01-22','2021-08-08',8),
('Ley Grecia 9','2022-02-08','2022-02-22','2021-09-08',8),
('Ley Grecia 10','2022-03-08','2022-03-22','2021-10-08',8),
-- País 9 (idCodigoCivil = 9):
('Ley Francia 1','2021-06-09','2021-06-23','2021-01-09',9),
('Ley Francia 2','2021-07-09','2021-07-23','2021-02-09',9),
('Ley Francia 3','2021-08-09','2021-08-23','2021-03-09',9),
('Ley Francia 4','2021-09-09','2021-09-23','2021-04-09',9),
('Ley Francia 5','2021-10-09','2021-10-23','2021-05-09',9),
('Ley Francia 6','2021-11-09','2021-11-23','2021-06-09',9),
('Ley Francia 7','2021-12-09','2021-12-23','2021-07-09',9),
('Ley Francia 8','2022-01-09','2022-01-23','2021-08-09',9),
('Ley Francia 9','2022-02-09','2022-02-23','2021-09-09',9),
('Ley Francia 10','2022-03-09','2022-03-23','2021-10-09',9),
-- País 10 (idCodigoCivil = 10):
('Ley UK 1','2021-06-10','2021-06-24','2021-01-10',10),
('Ley UK 2','2021-07-10','2021-07-24','2021-02-10',10),
('Ley UK 3','2021-08-10','2021-08-24','2021-03-10',10),
('Ley UK 4','2021-09-10','2021-09-24','2021-04-10',10),
('Ley UK 5','2021-10-10','2021-10-24','2021-05-10',10),
('Ley UK 6','2021-11-10','2021-11-24','2021-06-10',10),
('Ley UK 7','2021-12-10','2021-12-24','2021-07-10',10),
('Ley UK 8','2022-01-10','2022-01-24','2021-08-10',10),
('Ley UK 9','2022-02-10','2022-02-24','2021-09-10',10),
('Ley UK 10','2022-03-10','2022-03-24','2021-10-10',10);

------------------------------------------------------
-- 8. PROPUESTA
-- Se insertan 10 PROPUESTA por país (total 100).
-- Cada propuesta se asocia al congreso del país (idCongreso = id del país)
-- y se usa como numPasaportePolitico alguno de los políticos de ese país.
-- Las fechas cumplen: fechaAceptacion > fechaProposicion, fechaPublicacion > fechaProposicion, fechaExpiracion > fechaPublicacion.
------------------------------------------------------
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
-- País 1: España (con idCongreso = 1, se usan políticos de C1_T*)
('Propuesta España 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',1,'C1_T1','2022-01-01','2022-02-01','2022-03-01'),
('Propuesta España 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',1,'C1_T2','2022-01-02','2022-02-02','2022-03-02'),
('Propuesta España 3','Detalle de la propuesta 3','2022-12-31','VOTACION',1,'C1_T3','2022-01-03','2022-02-03','2022-03-03'),
('Propuesta España 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',1,'C1_T4','2022-01-04','2022-02-04','2022-03-04'),
('Propuesta España 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',1,'C1_T5','2022-01-05','2022-02-05','2022-03-05'),
('Propuesta España 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',1,'C1_T1','2022-01-06','2022-02-06','2022-03-06'),
('Propuesta España 7','Detalle de la propuesta 7','2022-12-31','VOTACION',1,'C1_T2','2022-01-07','2022-02-07','2022-03-07'),
('Propuesta España 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',1,'C1_T3','2022-01-08','2022-02-08','2022-03-08'),
('Propuesta España 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',1,'C1_T4','2022-01-09','2022-02-09','2022-03-09'),
('Propuesta España 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',1,'C1_T5','2022-01-10','2022-02-10','2022-03-10'),
-- País 2: Colombia (con idCongreso = 2, usar políticos de C2_T*)
('Propuesta Colombia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',2,'C2_T1','2022-01-11','2022-02-11','2022-03-11'),
('Propuesta Colombia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',2,'C2_T2','2022-01-12','2022-02-12','2022-03-12'),
('Propuesta Colombia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',2,'C2_T3','2022-01-13','2022-02-13','2022-03-13'),
('Propuesta Colombia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',2,'C2_T1','2022-01-14','2022-02-14','2022-03-14'),
('Propuesta Colombia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',2,'C2_T2','2022-01-15','2022-02-15','2022-03-15'),
('Propuesta Colombia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',2,'C2_T3','2022-01-16','2022-02-16','2022-03-16'),
('Propuesta Colombia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',2,'C2_T1','2022-01-17','2022-02-17','2022-03-17'),
('Propuesta Colombia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',2,'C2_T2','2022-01-18','2022-02-18','2022-03-18'),
('Propuesta Colombia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',2,'C2_T3','2022-01-19','2022-02-19','2022-03-19'),
('Propuesta Colombia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',2,'C2_T1','2022-01-20','2022-02-20','2022-03-20'),
-- País 3: Estados Unidos (idCongreso = 3)
('Propuesta EU 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',3,'C3_T1','2022-02-01','2022-03-01','2022-04-01'),
('Propuesta EU 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',3,'C3_T2','2022-02-02','2022-03-02','2022-04-02'),
('Propuesta EU 3','Detalle de la propuesta 3','2022-12-31','VOTACION',3,'C3_T3','2022-02-03','2022-03-03','2022-04-03'),
('Propuesta EU 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',3,'C3_T4','2022-02-04','2022-03-04','2022-04-04'),
('Propuesta EU 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',3,'C3_T5','2022-02-05','2022-03-05','2022-04-05'),
('Propuesta EU 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',3,'C3_T6','2022-02-06','2022-03-06','2022-04-06'),
('Propuesta EU 7','Detalle de la propuesta 7','2022-12-31','VOTACION',3,'C3_T7','2022-02-07','2022-03-07','2022-04-07'),
('Propuesta EU 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',3,'C3_T1','2022-02-08','2022-03-08','2022-04-08'),
('Propuesta EU 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',3,'C3_T2','2022-02-09','2022-03-09','2022-04-09'),
('Propuesta EU 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',3,'C3_T3','2022-02-10','2022-03-10','2022-04-10'),
-- País 4: Rusia (idCongreso = 4)
('Propuesta Rusia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',4,'C4_T1','2022-03-01','2022-04-01','2022-05-01'),
('Propuesta Rusia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',4,'C4_T2','2022-03-02','2022-04-02','2022-05-02'),
('Propuesta Rusia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',4,'C4_T3','2022-03-03','2022-04-03','2022-05-03'),
('Propuesta Rusia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',4,'C4_T4','2022-03-04','2022-04-04','2022-05-04'),
('Propuesta Rusia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',4,'C4_T1','2022-03-05','2022-04-05','2022-05-05'),
('Propuesta Rusia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',4,'C4_T2','2022-03-06','2022-04-06','2022-05-06'),
('Propuesta Rusia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',4,'C4_T3','2022-03-07','2022-04-07','2022-05-07'),
('Propuesta Rusia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',4,'C4_T4','2022-03-08','2022-04-08','2022-05-08'),
('Propuesta Rusia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',4,'C4_T1','2022-03-09','2022-04-09','2022-05-09'),
('Propuesta Rusia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',4,'C4_T2','2022-03-10','2022-04-10','2022-05-10'),
-- País 5: China (idCongreso = 5)
('Propuesta China 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',5,'C5_T1','2022-04-01','2022-05-01','2022-06-01'),
('Propuesta China 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',5,'C5_T2','2022-04-02','2022-05-02','2022-06-02'),
('Propuesta China 3','Detalle de la propuesta 3','2022-12-31','VOTACION',5,'C5_T3','2022-04-03','2022-05-03','2022-06-03'),
('Propuesta China 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',5,'C5_T4','2022-04-04','2022-05-04','2022-06-04'),
('Propuesta China 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',5,'C5_T5','2022-04-05','2022-05-05','2022-06-05'),
('Propuesta China 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',5,'C5_T6','2022-04-06','2022-05-06','2022-06-06'),
('Propuesta China 7','Detalle de la propuesta 7','2022-12-31','VOTACION',5,'C5_T1','2022-04-07','2022-05-07','2022-06-07'),
('Propuesta China 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',5,'C5_T2','2022-04-08','2022-05-08','2022-06-08'),
('Propuesta China 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',5,'C5_T3','2022-04-09','2022-05-09','2022-06-09'),
('Propuesta China 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',5,'C5_T4','2022-04-10','2022-05-10','2022-06-10'),
-- País 6: Mongolia (idCongreso = 6)
('Propuesta Mongolia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',6,'C6_T1','2022-05-01','2022-06-01','2022-07-01'),
('Propuesta Mongolia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',6,'C6_T2','2022-05-02','2022-06-02','2022-07-02'),
('Propuesta Mongolia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',6,'C6_T1','2022-05-03','2022-06-03','2022-07-03'),
('Propuesta Mongolia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',6,'C6_T2','2022-05-04','2022-06-04','2022-07-04'),
('Propuesta Mongolia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',6,'C6_T1','2022-05-05','2022-06-05','2022-07-05'),
('Propuesta Mongolia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',6,'C6_T2','2022-05-06','2022-06-06','2022-07-06'),
('Propuesta Mongolia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',6,'C6_T1','2022-05-07','2022-06-07','2022-07-07'),
('Propuesta Mongolia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',6,'C6_T2','2022-05-08','2022-06-08','2022-07-08'),
('Propuesta Mongolia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',6,'C6_T1','2022-05-09','2022-06-09','2022-07-09'),
('Propuesta Mongolia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',6,'C6_T2','2022-05-10','2022-06-10','2022-07-10'),
-- País 7: Italia (idCongreso = 7)
('Propuesta Italia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',7,'C7_T1','2022-06-01','2022-07-01','2022-08-01'),
('Propuesta Italia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',7,'C7_T2','2022-06-02','2022-07-02','2022-08-02'),
('Propuesta Italia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',7,'C7_T3','2022-06-03','2022-07-03','2022-08-03'),
('Propuesta Italia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',7,'C7_T4','2022-06-04','2022-07-04','2022-08-04'),
('Propuesta Italia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',7,'C7_T5','2022-06-05','2022-07-05','2022-08-05'),
('Propuesta Italia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',7,'C7_T6','2022-06-06','2022-07-06','2022-08-06'),
('Propuesta Italia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',7,'C7_T7','2022-06-07','2022-07-07','2022-08-07'),
('Propuesta Italia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',7,'C7_T8','2022-06-08','2022-07-08','2022-08-08'),
('Propuesta Italia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',7,'C7_T1','2022-06-09','2022-07-09','2022-08-09'),
('Propuesta Italia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',7,'C7_T2','2022-06-10','2022-07-10','2022-08-10'),
-- País 8: Grecia (idCongreso = 8)
('Propuesta Grecia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',8,'C8_T1','2022-07-01','2022-08-01','2022-09-01'),
('Propuesta Grecia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',8,'C8_T2','2022-07-02','2022-08-02','2022-09-02'),
('Propuesta Grecia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',8,'C8_T3','2022-07-03','2022-08-03','2022-09-03'),
('Propuesta Grecia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',8,'C8_T4','2022-07-04','2022-08-04','2022-09-04'),
('Propuesta Grecia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',8,'C8_T5','2022-07-05','2022-08-05','2022-09-05'),
('Propuesta Grecia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',8,'C8_T1','2022-07-06','2022-08-06','2022-09-06'),
('Propuesta Grecia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',8,'C8_T2','2022-07-07','2022-08-07','2022-09-07'),
('Propuesta Grecia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',8,'C8_T3','2022-07-08','2022-08-08','2022-09-08'),
('Propuesta Grecia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',8,'C8_T4','2022-07-09','2022-08-09','2022-09-09'),
('Propuesta Grecia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',8,'C8_T5','2022-07-10','2022-08-10','2022-09-10'),
-- País 9: Francia (idCongreso = 9)
('Propuesta Francia 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',9,'C9_T1','2022-08-01','2022-09-01','2022-10-01'),
('Propuesta Francia 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',9,'C9_T2','2022-08-02','2022-09-02','2022-10-02'),
('Propuesta Francia 3','Detalle de la propuesta 3','2022-12-31','VOTACION',9,'C9_T3','2022-08-03','2022-09-03','2022-10-03'),
('Propuesta Francia 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',9,'C9_T4','2022-08-04','2022-09-04','2022-10-04'),
('Propuesta Francia 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',9,'C9_T1','2022-08-05','2022-09-05','2022-10-05'),
('Propuesta Francia 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',9,'C9_T2','2022-08-06','2022-09-06','2022-10-06'),
('Propuesta Francia 7','Detalle de la propuesta 7','2022-12-31','VOTACION',9,'C9_T3','2022-08-07','2022-09-07','2022-10-07'),
('Propuesta Francia 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',9,'C9_T4','2022-08-08','2022-09-08','2022-10-08'),
('Propuesta Francia 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',9,'C9_T1','2022-08-09','2022-09-09','2022-10-09'),
('Propuesta Francia 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',9,'C9_T2','2022-08-10','2022-09-10','2022-10-10'),
-- País 10: Reino Unido (idCongreso = 10)
('Propuesta UK 1','Detalle de la propuesta 1','2022-12-31','ACEPTACION',10,'C10_T1','2022-09-01','2022-10-01','2022-11-01'),
('Propuesta UK 2','Detalle de la propuesta 2','2022-12-31','PUBLICACION',10,'C10_T2','2022-09-02','2022-10-02','2022-11-02'),
('Propuesta UK 3','Detalle de la propuesta 3','2022-12-31','VOTACION',10,'C10_T3','2022-09-03','2022-10-03','2022-11-03'),
('Propuesta UK 4','Detalle de la propuesta 4','2022-12-31','TERMINADA',10,'C10_T4','2022-09-04','2022-10-04','2022-11-04'),
('Propuesta UK 5','Detalle de la propuesta 5','2022-12-31','ACEPTACION',10,'C10_T5','2022-09-05','2022-10-05','2022-11-05'),
('Propuesta UK 6','Detalle de la propuesta 6','2022-12-31','PUBLICACION',10,'C10_T6','2022-09-06','2022-10-06','2022-11-06'),
('Propuesta UK 7','Detalle de la propuesta 7','2022-12-31','VOTACION',10,'C10_T1','2022-09-07','2022-10-07','2022-11-07'),
('Propuesta UK 8','Detalle de la propuesta 8','2022-12-31','TERMINADA',10,'C10_T2','2022-09-08','2022-10-08','2022-11-08'),
('Propuesta UK 9','Detalle de la propuesta 9','2022-12-31','ACEPTACION',10,'C10_T3','2022-09-09','2022-10-09','2022-11-09'),
('Propuesta UK 10','Detalle de la propuesta 10','2022-12-31','PUBLICACION',10,'C10_T4','2022-09-10','2022-10-10','2022-11-10');

------------------------------------------------------
-- 9. DESARROLLAR
-- Se empareja cada PROPUESTA con una LEY de la misma “zona”.
-- Suponiendo que las primeras 10 PROPUESTA corresponden al país 1, las siguientes 10 al país 2, etc.,
-- se empareja la propuesta n° j de un país con la ley n° j de ese mismo país.
------------------------------------------------------
-- Se insertan registros para desarrollar solo algunas propuestas (no necesariamente 10 por país)
-- País 1: España (idPais = 1, propuestas del bloque 1 a 10)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (1, 1),  -- Propuesta 1 se desarrolla con Ley 1
  (3, 3),
  (7, 7);
  
-- País 2: Colombia (propuestas 11 a 20)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (11, 11),
  (15, 15),
  (18, 18);
  
-- País 3: Estados Unidos (propuestas 21 a 30)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (22, 22),
  (27, 27);
  
-- País 4: Rusia (propuestas 31 a 40)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (33, 33),
  (38, 38),
  (40, 40);
  
-- País 5: China (propuestas 41 a 50)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (43, 43),
  (46, 46),
  (49, 49);
  
-- País 6: Mongolia (propuestas 51 a 60)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (52, 52),
  (55, 55),
  (59, 59);
  
-- País 7: Italia (propuestas 61 a 70)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (62, 62),
  (66, 66),
  (69, 69),
  (70, 70);
  
-- País 8: Grecia (propuestas 71 a 80)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (72, 72),
  (75, 75),
  (77, 77),
  (80, 80);
  
-- País 9: Francia (propuestas 81 a 90)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (83, 83),
  (87, 87),
  (90, 90);
  
-- País 10: Reino Unido (propuestas 91 a 100)
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (93, 93),
  (96, 96),
  (98, 98),
  (100, 100);

------------------------------------------------------
-- 10. VOTAR
-- Se insertan 10 votos por país (total 100).
-- Para cada país se asume que las propuestas del país corresponden a un bloque de 10 (ver PROPUESTA)
-- y se usan algunos de los ciudadanos (de CIUDADANO) del mismo país.
-- Se alterna la decisión entre TRUE y FALSE.
------------------------------------------------------

-- Para España (país 1, propuestas 1 a 10; ciudadanos: C1_C1 a C1_C5)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C1_C1', 1, TRUE),
  ('C1_C2', 2, FALSE),
  ('C1_C3', 3, TRUE),
  ('C1_C4', 4, FALSE),
  ('C1_C5', 5, TRUE),
  ('C1_C1', 6, FALSE),
  ('C1_C2', 7, TRUE),
  ('C1_C3', 8, FALSE),
  ('C1_C4', 9, TRUE),
  ('C1_C5', 10, FALSE),
  ('C1_C1', 3, TRUE),
  ('C1_C2', 5, FALSE),
  ('C1_C3', 7, TRUE),
  ('C1_C4', 9, FALSE);
  
-- Para Colombia (país 2, propuestas 11 a 20; ciudadanos: C2_C1 a C2_C7)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C2_C1', 11, TRUE),
  ('C2_C2', 12, FALSE),
  ('C2_C3', 13, TRUE),
  ('C2_C4', 14, FALSE),
  ('C2_C5', 15, TRUE),
  ('C2_C6', 16, FALSE),
  ('C2_C7', 17, TRUE),
  ('C2_C1', 18, FALSE),
  ('C2_C2', 19, TRUE),
  ('C2_C3', 20, FALSE),
  ('C2_C4', 13, TRUE),
  ('C2_C5', 14, TRUE);
  
-- Para Estados Unidos (país 3, propuestas 21 a 30; ciudadanos: C3_C1 a C3_C3)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C3_C1', 21, TRUE),
  ('C3_C2', 22, FALSE),
  ('C3_C3', 23, TRUE),
  ('C3_C1', 24, FALSE),
  ('C3_C2', 25, TRUE),
  ('C3_C3', 26, FALSE),
  ('C3_C1', 27, TRUE),
  ('C3_C2', 28, FALSE),
  ('C3_C3', 29, TRUE),
  ('C3_C1', 30, FALSE),
  ('C3_C2', 23, TRUE);
  
-- Para Rusia (país 4, propuestas 31 a 40; ciudadanos: C4_C1 a C4_C6)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C4_C1', 31, TRUE),
  ('C4_C2', 32, FALSE),
  ('C4_C3', 33, TRUE),
  ('C4_C4', 34, FALSE),
  ('C4_C5', 35, TRUE),
  ('C4_C6', 36, FALSE),
  ('C4_C1', 37, TRUE),
  ('C4_C2', 38, FALSE),
  ('C4_C3', 39, TRUE),
  ('C4_C4', 40, FALSE),
  ('C4_C5', 33, TRUE),
  ('C4_C6', 37, FALSE);
  
-- Para China (país 5, propuestas 41 a 50; ciudadanos: C5_C1 a C5_C4)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C5_C1', 41, TRUE),
  ('C5_C2', 42, FALSE),
  ('C5_C3', 43, TRUE),
  ('C5_C4', 44, FALSE),
  ('C5_C1', 45, TRUE),
  ('C5_C2', 46, FALSE),
  ('C5_C3', 47, TRUE),
  ('C5_C4', 48, FALSE),
  ('C5_C1', 49, TRUE),
  ('C5_C2', 50, FALSE),
  ('C5_C3', 42, TRUE),
  ('C5_C4', 47, FALSE);
  
-- Para Mongolia (país 6, propuestas 51 a 60; ciudadanos: C6_C1 a C6_C8)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C6_C1', 51, TRUE),
  ('C6_C2', 52, FALSE),
  ('C6_C3', 53, TRUE),
  ('C6_C4', 54, FALSE),
  ('C6_C5', 55, TRUE),
  ('C6_C6', 56, FALSE),
  ('C6_C7', 57, TRUE),
  ('C6_C8', 58, FALSE),
  ('C6_C1', 59, TRUE),
  ('C6_C2', 60, FALSE),
  ('C6_C3', 55, TRUE),
  ('C6_C4', 57, FALSE);
  
-- Para Italia (país 7, propuestas 61 a 70; ciudadanos: C7_C1 y C7_C2)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C7_C1', 61, TRUE),
  ('C7_C2', 62, FALSE),
  ('C7_C1', 63, TRUE),
  ('C7_C2', 64, FALSE),
  ('C7_C1', 65, TRUE),
  ('C7_C2', 66, FALSE),
  ('C7_C1', 67, TRUE),
  ('C7_C2', 68, FALSE),
  ('C7_C1', 69, TRUE),
  ('C7_C2', 70, FALSE),
  ('C7_C1', 65, FALSE);
  
-- Para Grecia (país 8, propuestas 71 a 80; ciudadanos: C8_C1 a C8_C5)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C8_C1', 71, TRUE),
  ('C8_C2', 72, FALSE),
  ('C8_C3', 73, TRUE),
  ('C8_C4', 74, FALSE),
  ('C8_C5', 75, TRUE),
  ('C8_C1', 76, FALSE),
  ('C8_C2', 77, TRUE),
  ('C8_C3', 78, FALSE),
  ('C8_C4', 79, TRUE),
  ('C8_C5', 80, FALSE),
  ('C8_C1', 73, TRUE),
  ('C8_C5', 79, TRUE);
  
-- Para Francia (país 9, propuestas 81 a 90; ciudadanos: C9_C1 a C9_C6)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C9_C1', 81, TRUE),
  ('C9_C2', 82, FALSE),
  ('C9_C3', 83, TRUE),
  ('C9_C4', 84, FALSE),
  ('C9_C5', 85, TRUE),
  ('C9_C6', 86, FALSE),
  ('C9_C1', 87, TRUE),
  ('C9_C2', 88, FALSE),
  ('C9_C3', 89, TRUE),
  ('C9_C4', 90, FALSE),
  ('C9_C5', 83, TRUE),
  ('C9_C6', 87, FALSE);
  
-- Para Reino Unido (país 10, propuestas 91 a 100; ciudadanos: C10_C1 a C10_C4)
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('C10_C1', 91, TRUE),
  ('C10_C2', 92, FALSE),
  ('C10_C3', 93, TRUE),
  ('C10_C4', 94, FALSE),
  ('C10_C1', 95, TRUE),
  ('C10_C2', 96, FALSE),
  ('C10_C3', 97, TRUE),
  ('C10_C4', 98, FALSE),
  ('C10_C1', 99, TRUE),
  ('C10_C2', 100, FALSE),
  ('C10_C3', 95, TRUE),
  ('C10_C4', 100, TRUE);

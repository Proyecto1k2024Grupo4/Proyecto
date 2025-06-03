-- ============================================================
-- Inserción de 10 países
-- ============================================================
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

-- ============================================================
-- Inserción de 10 códigos civiles (1 por país)
-- ============================================================
INSERT INTO CODIGO_CIVIL (idPais) VALUES
  (1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

-- ============================================================
-- Inserción de 10 congresos (1 por país)
-- ============================================================
INSERT INTO CONGRESO (idPais) VALUES
  (1),(2),(3),(4),(5),(6),(7),(8),(9),(10);

-- ============================================================
-- Inserción de 20 personas por país
-- Se usa un formato de pasaporte: [prefijo]-NNN, nombre genérico y fechas variadas.
-- ============================================================

/* --- España (país 1) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('ES-001','Ana','García','López','1980-01-15','M',1),
  ('ES-002','Luis','Pérez','Sanz','1981-02-20','H',1),
  ('ES-003','María','Martínez','Ruiz','1982-03-25','M',1),
  ('ES-004','Javier','Gómez','Fernández','1983-04-10','H',1),
  ('ES-005','Carmen','Sánchez','Moreno','1984-05-05','M',1),
  ('ES-006','José','Díaz','Jiménez','1985-06-15','H',1),
  ('ES-007','Lucía','Romero','Hernández','1986-07-20','M',1),
  ('ES-008','Miguel','Flores','Vargas','1987-08-25','H',1),
  ('ES-009','Elena','Ruiz','Castro','1988-09-30','M',1),
  ('ES-010','Carlos','Morales','Ortega','1989-10-05','H',1),
  ('ES-011','Paula','Ibáñez','Delgado','1990-11-10','M',1),
  ('ES-012','Diego','Navarro','Cortés','1991-12-15','H',1),
  ('ES-013','Sara','Ortiz','Molina','1992-01-20','M',1),
  ('ES-014','Andrés','Vega','Pardo','1993-02-25','H',1),
  ('ES-015','Sofía','Molina','Ramos','1994-03-30','M',1),
  ('ES-016','Fernando','Castro','Guzmán','1995-04-15','H',1),
  ('ES-017','Isabel','Luna','Peña','1996-05-20','M',1),
  ('ES-018','Roberto','Cano','Soler','1997-06-25','H',1),
  ('ES-019','Verónica','Soler','Miranda','1998-07-30','M',1),
  ('ES-020','Raúl','Herrera','Duran','1999-08-05','H',1);

  /* --- Colombia (país 2) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('CO-001','Andrés','Gómez','Martínez','1979-01-10','H',2),
  ('CO-002','Laura','Ramírez','Castro','1980-02-11','M',2),
  ('CO-003','Diego','Pérez','López','1981-03-12','H',2),
  ('CO-004','Sara','Torres','García','1982-04-13','M',2),
  ('CO-005','Miguel','Ruiz','Sánchez','1983-05-14','H',2),
  ('CO-006','Ana','Morales','Ortiz','1984-06-15','M',2),
  ('CO-007','Carlos','Díaz','Herrera','1985-07-16','H',2),
  ('CO-008','Paola','Castro','Rojas','1986-08-17','M',2),
  ('CO-009','Juan','Suárez','Molina','1987-09-18','H',2),
  ('CO-010','Marta','Vargas','Jiménez','1988-10-19','M',2),
  ('CO-011','Santiago','Lozano','Castaño','1989-11-20','H',2),
  ('CO-012','Camila','Rincón','Restrepo','1990-12-21','M',2),
  ('CO-013','Felipe','Navarro','Ortiz','1991-01-22','H',2),
  ('CO-014','Daniela','Aguilar','Muñoz','1992-02-23','M',2),
  ('CO-015','Ricardo','Cruz','Gómez','1993-03-24','H',2),
  ('CO-016','Valentina','Moreno','Pineda','1994-04-25','M',2),
  ('CO-017','Esteban','García','Solís','1995-05-26','H',2),
  ('CO-018','Natalia','Fernández','Córdoba','1996-06-27','M',2),
  ('CO-019','Jorge','Sierra','Gutiérrez','1997-07-28','H',2),
  ('CO-020','Paula','Mendoza','Londoño','1998-08-29','M',2);

  /* --- Estados Unidos (país 3) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('US-001','John','Smith','Johnson','1975-01-05','H',3),
  ('US-002','Emily','Williams','Brown','1976-02-06','M',3),
  ('US-003','Michael','Jones','Davis','1977-03-07','H',3),
  ('US-004','Jessica','Miller','Wilson','1978-04-08','M',3),
  ('US-005','David','Moore','Taylor','1979-05-09','H',3),
  ('US-006','Ashley','Anderson','Thomas','1980-06-10','M',3),
  ('US-007','Chris','Jackson','White','1981-07-11','H',3),
  ('US-008','Amanda','Harris','Martin','1982-08-12','M',3),
  ('US-009','Brian','Thompson','Garcia','1983-09-13','H',3),
  ('US-010','Megan','Martinez','Robinson','1984-10-14','M',3),
  ('US-011','Kevin','Clark','Rodriguez','1985-11-15','H',3),
  ('US-012','Laura','Lewis','Lee','1986-12-16','M',3),
  ('US-013','Eric','Walker','Hall','1987-01-17','H',3),
  ('US-014','Nicole','Allen','Young','1988-02-18','M',3),
  ('US-015','Ryan','King','Hernandez','1989-03-19','H',3),
  ('US-016','Sarah','Wright','Lopez','1990-04-20','M',3),
  ('US-017','Jason','Scott','Hill','1991-05-21','H',3),
  ('US-018','Brittany','Green','Adams','1992-06-22','M',3),
  ('US-019','Brandon','Baker','Nelson','1993-07-23','H',3),
  ('US-020','Rachel','Gonzalez','Carter','1994-08-24','M',3);

  /* --- Rusia (país 4) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('RU-001','Ivan','Ivanov','Petrov','1970-01-10','H',4),
  ('RU-002','Olga','Smirnova','Sidorova','1971-02-11','M',4),
  ('RU-003','Sergey','Kuznetsov','Popov','1972-03-12','H',4),
  ('RU-004','Tatiana','Volkova','Fedorova','1973-04-13','M',4),
  ('RU-005','Dmitry','Lebedev','Nikolaev','1974-05-14','H',4),
  ('RU-006','Elena','Morozova','Orlova','1975-06-15','M',4),
  ('RU-007','Nikolay','Novikov','Semenov','1976-07-16','H',4),
  ('RU-008','Irina','Pavlova','Vasilieva','1977-08-17','M',4),
  ('RU-009','Vladimir','Sokolov','Mikhailov','1978-09-18','H',4),
  ('RU-010','Svetlana','Makarova','Frolova','1979-10-19','M',4),
  ('RU-011','Alexey','Gorbatov','Medvedev','1980-11-20','H',4),
  ('RU-012','Marina','Kozlova','Belova','1981-12-21','M',4),
  ('RU-013','Pavel','Semenov','Tarasov','1982-01-22','H',4),
  ('RU-014','Ekaterina','Ermolova','Grigorieva','1983-02-23','M',4),
  ('RU-015','Mikhail','Fedorov','Antonov','1984-03-24','H',4),
  ('RU-016','Natalia','Vinogradova','Filipova','1985-04-25','M',4),
  ('RU-017','Oleg','Belov','Gusev','1986-05-26','H',4),
  ('RU-018','Marina','Kirilova','Zaytseva','1987-06-27','M',4),
  ('RU-019','Sergei','Novikov','Osipov','1988-07-28','H',4),
  ('RU-020','Anna','Larin','Karpova','1989-08-29','M',4);

  /* --- China (país 5) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('CH-001','Li','Wang','Zhang','1960-01-01','H',5),
  ('CH-002','Mei','Chen','Liu','1961-02-02','M',5),
  ('CH-003','Wei','Yang','Huang','1962-03-03','H',5),
  ('CH-004','Fang','Zhao','Wu','1963-04-04','M',5),
  ('CH-005','Jun','Zhou','Xu','1964-05-05','H',5),
  ('CH-006','Lan','Hu','Sun','1965-06-06','M',5),
  ('CH-007','Ming','Ma','Gao','1966-07-07','H',5),
  ('CH-008','Xia','Lin','Guo','1967-08-08','M',5),
  ('CH-009','Tao','He','Gu','1968-09-09','H',5),
  ('CH-010','Juan','Lu','Ma','1969-10-10','M',5),
  ('CH-011','Ping','Xu','Feng','1970-11-11','H',5),
  ('CH-012','Rong','Deng','Xie','1971-12-12','M',5),
  ('CH-013','Lei','Cao','Peng','1972-01-13','H',5),
  ('CH-014','Hua','Duan','Qian','1973-02-14','M',5),
  ('CH-015','Bo','Shi','Jin','1974-03-15','H',5),
  ('CH-016','Ying','Liao','Bao','1975-04-16','M',5),
  ('CH-017','Chen','Qiu','Zheng','1976-05-17','H',5),
  ('CH-018','Xiu','Xia','Lu','1977-06-18','M',5),
  ('CH-019','Feng','Song','Dong','1978-07-19','H',5),
  ('CH-020','Jing','Kong','Yu','1979-08-20','M',5);

  /* --- Mongolia (país 6) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('MO-001','Bat','Baatar','Chimed','1980-01-01','H',6),
  ('MO-002','Sarnai','Enkhtuya','Bilegt','1981-02-02','M',6),
  ('MO-003','Temuulen','Tserendorj','Bold','1982-03-03','H',6),
  ('MO-004','Naran','Altansukh','Ganbold','1983-04-04','M',6),
  ('MO-005','Erdene','Davaadorj','Munkh','1984-05-05','H',6),
  ('MO-006','Oyunchimeg','Batjargal','Zorig','1985-06-06','M',6),
  ('MO-007','Bold','Enkhbayar','Ganbaatar','1986-07-07','H',6),
  ('MO-008','Altan','Temuulen','Chuluun','1987-08-08','M',6),
  ('MO-009','Davaa','Naran','Togtokh','1988-09-09','H',6),
  ('MO-010','Khulan','Baatar','Erdene','1989-10-10','M',6),
  ('MO-011','Ganbaatar','Sukhbaatar','Bold','1990-11-11','H',6),
  ('MO-012','Ochir','Chimed','Naran','1991-12-12','M',6),
  ('MO-013','Tuguldur','Enkh','Gan','1992-01-13','H',6),
  ('MO-014','Sarnai','Bat','Altan','1993-02-14','M',6),
  ('MO-015','Temuulen','Davaasuren','Chuluun','1994-03-15','H',6),
  ('MO-016','Nomin','Ganbold','Bilegt','1995-04-16','M',6),
  ('MO-017','Bolormaa','Altansukh','Enkh','1996-05-17','M',6),
  ('MO-018','Tungalag','Baatar','Chimed','1997-06-18','M',6),
  ('MO-019','Erdenechimeg','Tserendorj','Ganbaatar','1998-07-19','M',6),
  ('MO-020','Munkh','Enkhtuya','Bold','1999-08-20','M',6);

  /* --- Italia (país 7) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('IT-001','Marco','Rossi','Bianchi','1970-01-10','H',7),
  ('IT-002','Giulia','Russo','Ferrari','1971-02-11','M',7),
  ('IT-003','Luca','Esposito','Romano','1972-03-12','H',7),
  ('IT-004','Sofia','Colombo','Ricci','1973-04-13','M',7),
  ('IT-005','Matteo','Ricci','Marino','1974-05-14','H',7),
  ('IT-006','Francesca','Gallo','Greco','1975-06-15','M',7),
  ('IT-007','Davide','Conti','Lombardi','1976-07-16','H',7),
  ('IT-008','Elena','Costa','Fontana','1977-08-17','M',7),
  ('IT-009','Alessandro','Ferrari','Rinaldi','1978-09-18','H',7),
  ('IT-010','Martina','Romano','Marini','1979-10-19','M',7),
  ('IT-011','Giovanni','Marino','Testa','1980-11-20','H',7),
  ('IT-012','Laura','Rinaldi','Barbieri','1981-12-21','M',7),
  ('IT-013','Andrea','Fontana','Moretti','1982-01-22','H',7),
  ('IT-014','Valentina','Greco','Costa','1983-02-23','M',7),
  ('IT-015','Federico','Lombardi','Ricci','1984-03-24','H',7),
  ('IT-016','Chiara','Conti','Esposito','1985-04-25','M',7),
  ('IT-017','Simone','Gallo','Rossi','1986-05-26','H',7),
  ('IT-018','Alice','Ricci','Colombo','1987-06-27','M',7),
  ('IT-019','Matteo','Testa','Ferrari','1988-07-28','H',7),
  ('IT-020','Sara','Marino','Bianchi','1989-08-29','M',7);

  /* --- Grecia (país 8) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('GR-001','Giorgos','Papadopoulos','Nikolaidis','1965-01-05','H',8),
  ('GR-002','Maria','Georgiou','Christodoulou','1966-02-06','M',8),
  ('GR-003','Dimitris','Ioannidis','Pappas','1967-03-07','H',8),
  ('GR-004','Elena','Vasilakis','Kostopoulos','1968-04-08','M',8),
  ('GR-005','Nikos','Karagiannis','Lazaridis','1969-05-09','H',8),
  ('GR-006','Sofia','Economou','Anagnostopoulos','1970-06-10','M',8),
  ('GR-007','Kostas','Petridis','Sotiriou','1971-07-11','H',8),
  ('GR-008','Eleni','Christodoulou','Alexandrou','1972-08-12','M',8),
  ('GR-009','Vasilis','Nikolaou','Pappas','1973-09-13','H',8),
  ('GR-010','Ioanna','Papadakis','Georgiou','1974-10-14','M',8),
  ('GR-011','Spyros','Vasilopoulos','Konstantinou','1975-11-15','H',8),
  ('GR-012','Anna','Theodorou','Zachariadis','1976-12-16','M',8),
  ('GR-013','Yannis','Konstantinou','Loukis','1977-01-17','H',8),
  ('GR-014','Dora','Alexandrou','Manousakis','1978-02-18','M',8),
  ('GR-015','Stefanos','Manousakis','Papandreou','1979-03-19','H',8),
  ('GR-016','Irene','Lambrou','Stamati','1980-04-20','M',8),
  ('GR-017','Antonis','Stavrou','Nikolaidis','1981-05-21','H',8),
  ('GR-018','Katerina','Kostopoulou','Vasileiou','1982-06-22','M',8),
  ('GR-019','Panagiotis','Georgiadis','Christodoulou','1983-07-23','H',8),
  ('GR-020','Eirini','Papadopoulou','Ioannou','1984-08-24','M',8);

  /* --- Francia (país 9) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('FR-001','Pierre','Martin','Bernard','1960-01-10','H',9),
  ('FR-002','Marie','Bernard','Dubois','1961-02-11','M',9),
  ('FR-003','Jean','Thomas','Robert','1962-03-12','H',9),
  ('FR-004','Sophie','Robert','Petit','1963-04-13','M',9),
  ('FR-005','Luc','Richard','Durand','1964-05-14','H',9),
  ('FR-006','Claire','Moreau','Simon','1965-06-15','M',9),
  ('FR-007','Nicolas','Leroy','Michel','1966-07-16','H',9),
  ('FR-008','Isabelle','Roux','Vincent','1967-08-17','M',9),
  ('FR-009','Antoine','Fournier','Fournier','1968-09-18','H',9),
  ('FR-010','Camille','Girard','Andre','1969-10-19','M',9),
  ('FR-011','Julien','Dupont','Lambert','1970-11-20','H',9),
  ('FR-012','Amandine','Fontaine','Rousseau','1971-12-21','M',9),
  ('FR-013','Maxime','Blanc','Guerin','1972-01-22','H',9),
  ('FR-014','Chloe','Guerin','Mathieu','1973-02-23','M',9),
  ('FR-015','Guillaume','Mercier','Noel','1974-03-24','H',9),
  ('FR-016','Julie','Dupuis','Renaud','1975-04-25','M',9),
  ('FR-017','Thomas','Lopez','Clement','1976-05-26','H',9),
  ('FR-018','Manon','Roussel','Giraud','1977-06-27','M',9),
  ('FR-019','Alexandre','Perrin','Leclerc','1978-07-28','H',9),
  ('FR-020','Eva','Colin','Baron','1979-08-29','M',9);

  /* --- Reino Unido (país 10) --- */
INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
  ('UK-001','James','Smith','Brown','1955-01-10','H',10),
  ('UK-002','Emma','Jones','Taylor','1956-02-11','M',10),
  ('UK-003','Oliver','Williams','Davies','1957-03-12','H',10),
  ('UK-004','Ava','Brown','Evans','1958-04-13','M',10),
  ('UK-005','William','Wilson','Thomas','1959-05-14','H',10),
  ('UK-006','Sophia','Davies','Roberts','1960-06-15','M',10),
  ('UK-007','Henry','Evans','Johnson','1961-07-16','H',10),
  ('UK-008','Isabella','Thomas','Robinson','1962-08-17','M',10),
  ('UK-009','Alexander','Roberts','Walker','1963-09-18','H',10),
  ('UK-010','Mia','Johnson','Wright','1964-10-19','M',10),
  ('UK-011','Michael','Walker','Green','1965-11-20','H',10),
  ('UK-012','Charlotte','Robinson','Hall','1966-12-21','M',10),
  ('UK-013','Benjamin','Wright','Allen','1967-01-22','H',10),
  ('UK-014','Amelia','Green','Young','1968-02-23','M',10),
  ('UK-015','Daniel','Hall','King','1969-03-24','H',10),
  ('UK-016','Harper','Allen','Scott','1970-04-25','M',10),
  ('UK-017','Samuel','Young','Adams','1971-05-26','H',10),
  ('UK-018','Evelyn','King','Baker','1972-06-27','M',10),
  ('UK-019','Joseph','Scott','Nelson','1973-07-28','H',10),
  ('UK-020','Abigail','Adams','Carter','1974-08-29','M',10);

-- ============================================================
-- Inserción de POLITICO y CIUDADANO para cada país (distribución variable)
-- Distribuciones elegidas:
--   España: 5 políticos, 15 ciudadanos
--   Colombia: 15 políticos, 5 ciudadanos
--   Estados Unidos: 8 políticos, 12 ciudadanos
--   Rusia: 12 políticos, 8 ciudadanos
--   China: 10 políticos, 10 ciudadanos
--   Mongolia: 7 políticos, 13 ciudadanos
--   Italia: 14 políticos, 6 ciudadanos
--   Grecia: 6 políticos, 14 ciudadanos
--   Francia: 11 políticos, 9 ciudadanos
--   Reino Unido: 9 políticos, 11 ciudadanos
-- Se asume que se seleccionan los primeros N registros de PERSONA de cada país para ser POLITICO.
-- ============================================================

/* --- España (país 1) --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('ES-001','2010-01-01',NULL,1),
  ('ES-002','2011-02-01','2020-01-01',1),
  ('ES-003','2012-03-01',NULL,1),
  ('ES-004','2013-04-01','2021-04-01',1),
  ('ES-005','2014-05-01',NULL,1);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('ES-006'),('ES-007'),('ES-008'),('ES-009'),('ES-010'),
  ('ES-011'),('ES-012'),('ES-013'),('ES-014'),('ES-015'),
  ('ES-016'),('ES-017'),('ES-018'),('ES-019'),('ES-020');

/* --- Colombia (país 2) --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('CO-001','2009-01-15',NULL,2),
  ('CO-002','2010-02-15','2018-02-15',2),
  ('CO-003','2011-03-15',NULL,2),
  ('CO-004','2012-04-15',NULL,2),
  ('CO-005','2013-05-15',NULL,2),
  ('CO-006','2014-06-15',NULL,2),
  ('CO-007','2015-07-15',NULL,2),
  ('CO-008','2016-08-15','2019-08-15',2),
  ('CO-009','2017-09-15',NULL,2),
  ('CO-010','2018-10-15',NULL,2),
  ('CO-011','2019-11-15',NULL,2),
  ('CO-012','2020-12-15',NULL,2),
  ('CO-013','2021-01-15',NULL,2),
  ('CO-014','2021-02-15','2022-02-15',2),
  ('CO-015','2021-03-15',NULL,2);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('CO-016'),('CO-017'),('CO-018'),('CO-019'),('CO-020');

/* --- Estados Unidos (país 3): 8 políticos, 12 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('US-001','2005-01-01',NULL,3),
  ('US-002','2006-02-01','2015-02-01',3),
  ('US-003','2007-03-01',NULL,3),
  ('US-004','2008-04-01','2016-04-01',3),
  ('US-005','2009-05-01',NULL,3),
  ('US-006','2010-06-01',NULL,3),
  ('US-007','2011-07-01',NULL,3),
  ('US-008','2012-08-01','2020-08-01',3);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('US-009'),('US-010'),('US-011'),('US-012'),('US-013'),
  ('US-014'),('US-015'),('US-016'),('US-017'),('US-018'),
  ('US-019'),('US-020');

/* --- Rusia (país 4): 12 políticos, 8 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('RU-001','1999-01-01',NULL,4),
  ('RU-002','2000-02-01','2010-02-01',4),
  ('RU-003','2001-03-01',NULL,4),
  ('RU-004','2002-04-01','2011-04-01',4),
  ('RU-005','2003-05-01',NULL,4),
  ('RU-006','2004-06-01',NULL,4),
  ('RU-007','2005-07-01',NULL,4),
  ('RU-008','2006-08-01','2012-08-01',4),
  ('RU-009','2007-09-01',NULL,4),
  ('RU-010','2008-10-01',NULL,4),
  ('RU-011','2009-11-01',NULL,4),
  ('RU-012','2010-12-01',NULL,4);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('RU-013'),('RU-014'),('RU-015'),('RU-016'),
  ('RU-017'),('RU-018'),('RU-019'),('RU-020');

/* --- China (país 5): 10 políticos, 10 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('CH-001','1990-01-01',NULL,5),
  ('CH-002','1991-02-01','2000-02-01',5),
  ('CH-003','1992-03-01',NULL,5),
  ('CH-004','1993-04-01',NULL,5),
  ('CH-005','1994-05-01',NULL,5),
  ('CH-006','1995-06-01',NULL,5),
  ('CH-007','1996-07-01',NULL,5),
  ('CH-008','1997-08-01','2005-08-01',5),
  ('CH-009','1998-09-01',NULL,5),
  ('CH-010','1999-10-01',NULL,5);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('CH-011'),('CH-012'),('CH-013'),('CH-014'),('CH-015'),
  ('CH-016'),('CH-017'),('CH-018'),('CH-019'),('CH-020');

/* --- Mongolia (país 6): 7 políticos, 13 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('MO-001','2000-01-01',NULL,6),
  ('MO-002','2001-02-01',NULL,6),
  ('MO-003','2002-03-01','2010-03-01',6),
  ('MO-004','2003-04-01',NULL,6),
  ('MO-005','2004-05-01',NULL,6),
  ('MO-006','2005-06-01',NULL,6),
  ('MO-007','2006-07-01',NULL,6);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('MO-008'),('MO-009'),('MO-010'),('MO-011'),('MO-012'),
  ('MO-013'),('MO-014'),('MO-015'),('MO-016'),('MO-017'),
  ('MO-018'),('MO-019'),('MO-020');

/* --- Italia (país 7): 14 políticos, 6 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('IT-001','1995-01-01',NULL,7),
  ('IT-002','1996-02-01','2005-02-01',7),
  ('IT-003','1997-03-01',NULL,7),
  ('IT-004','1998-04-01','2006-04-01',7),
  ('IT-005','1999-05-01',NULL,7),
  ('IT-006','2000-06-01',NULL,7),
  ('IT-007','2001-07-01',NULL,7),
  ('IT-008','2002-08-01','2010-08-01',7),
  ('IT-009','2003-09-01',NULL,7),
  ('IT-010','2004-10-01',NULL,7),
  ('IT-011','2005-11-01',NULL,7),
  ('IT-012','2006-12-01',NULL,7),
  ('IT-013','2007-01-01',NULL,7),
  ('IT-014','2008-02-01',NULL,7);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('IT-015'),('IT-016'),('IT-017'),('IT-018'),('IT-019'),('IT-020');

/* --- Grecia (país 8): 6 políticos, 14 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('GR-001','2000-01-01',NULL,8),
  ('GR-002','2001-02-01','2010-02-01',8),
  ('GR-003','2002-03-01',NULL,8),
  ('GR-004','2003-04-01',NULL,8),
  ('GR-005','2004-05-01',NULL,8),
  ('GR-006','2005-06-01',NULL,8);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('GR-007'),('GR-008'),('GR-009'),('GR-010'),('GR-011'),
  ('GR-012'),('GR-013'),('GR-014'),('GR-015'),('GR-016'),
  ('GR-017'),('GR-018'),('GR-019'),('GR-020');

  /* --- Francia (país 9): 11 políticos, 9 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('FR-001','1990-01-01',NULL,9),
  ('FR-002','1991-02-01','2000-02-01',9),
  ('FR-003','1992-03-01',NULL,9),
  ('FR-004','1993-04-01',NULL,9),
  ('FR-005','1994-05-01',NULL,9),
  ('FR-006','1995-06-01',NULL,9),
  ('FR-007','1996-07-01',NULL,9),
  ('FR-008','1997-08-01','2005-08-01',9),
  ('FR-009','1998-09-01',NULL,9),
  ('FR-010','1999-10-01',NULL,9),
  ('FR-011','2000-11-01',NULL,9);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('FR-012'),('FR-013'),('FR-014'),('FR-015'),
  ('FR-016'),('FR-017'),('FR-018'),('FR-019'),('FR-020');

/* --- Reino Unido (país 10): 9 políticos, 11 ciudadanos --- */
INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
  ('UK-001','1985-01-01',NULL,10),
  ('UK-002','1986-02-01','1995-02-01',10),
  ('UK-003','1987-03-01',NULL,10),
  ('UK-004','1988-04-01','1996-04-01',10),
  ('UK-005','1989-05-01',NULL,10),
  ('UK-006','1990-06-01',NULL,10),
  ('UK-007','1991-07-01',NULL,10),
  ('UK-008','1992-08-01','2000-08-01',10),
  ('UK-009','1993-09-01',NULL,10);
INSERT INTO CIUDADANO (numPasaporte) VALUES
  ('UK-010'),('UK-011'),('UK-012'),('UK-013'),
  ('UK-014'),('UK-015'),('UK-016'),('UK-017'),('UK-018'),
  ('UK-019'),('UK-020');

-- ============================================================
-- Inserción de 10 propuestas por país (total 100 propuestas)
-- Se varían estados y fechas; se asigna un político (usando alguno de los pasaportes de POLITICO de cada país).
-- Para facilitar, se asume que el idCongreso coincide con el id del país.
-- ============================================================

/* --- Propuestas para España (país 1, idCongreso = 1) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta ES 1','Descripcion ES 1','2023-12-31','TERMINADA',1,'ES-001','2020-01-01','2020-02-01','2020-03-01'),
  ('Propuesta ES 2','Descripcion ES 2','2024-01-15','VOTACION',1,'ES-002','2021-02-10',NULL,'2021-03-10'),
  ('Propuesta ES 3','Descripcion ES 3','2025-05-20','PUBLICACION',1,'ES-003','2022-03-15','2022-04-15','2022-05-15'),
  ('Propuesta ES 4','Descripcion ES 4','2022-11-30','TERMINADA',1,'ES-004','2019-06-01','2019-07-01','2019-08-01'),
  ('Propuesta ES 5','Descripcion ES 5','2023-07-15','ACEPTACION',1,'ES-005','2022-01-20',NULL,NULL),
  ('Propuesta ES 6','Descripcion ES 6','2024-09-10','VOTACION',1,'ES-001','2020-11-11','2020-12-11','2021-01-11'),
  ('Propuesta ES 7','Descripcion ES 7','2023-03-03','PUBLICACION',1,'ES-002','2021-04-04','2021-05-05','2021-06-06'),
  ('Propuesta ES 8','Descripcion ES 8','2025-08-08','ACEPTACION',1,'ES-003','2022-07-07',NULL,NULL),
  ('Propuesta ES 9','Descripcion ES 9','2024-04-04','VOTACION',1,'ES-004','2020-08-08','2020-09-09','2020-10-10'),
  ('Propuesta ES 10','Descripcion ES 10','2023-10-10','TERMINADA',1,'ES-005','2019-12-12','2020-01-01','2020-02-02');

/* --- Propuestas para Colombia (país 2, idCongreso = 2) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta CO 1','Descripcion CO 1','2023-11-30','TERMINADA',2,'CO-001','2020-01-05','2020-02-05','2020-03-05'),
  ('Propuesta CO 2','Descripcion CO 2','2024-02-15','VOTACION',2,'CO-002','2021-03-10',NULL,'2021-04-10'),
  ('Propuesta CO 3','Descripcion CO 3','2025-06-20','PUBLICACION',2,'CO-003','2022-04-15','2022-05-15','2022-06-15'),
  ('Propuesta CO 4','Descripcion CO 4','2022-12-30','TERMINADA',2,'CO-004','2019-07-01','2019-08-01','2019-09-01'),
  ('Propuesta CO 5','Descripcion CO 5','2023-08-15','ACEPTACION',2,'CO-005','2022-02-20',NULL,NULL),
  ('Propuesta CO 6','Descripcion CO 6','2024-10-10','VOTACION',2,'CO-006','2020-12-11','2020-12-31','2021-01-15'),
  ('Propuesta CO 7','Descripcion CO 7','2023-04-03','PUBLICACION',2,'CO-007','2021-05-05','2021-06-05','2021-07-05'),
  ('Propuesta CO 8','Descripcion CO 8','2025-09-08','ACEPTACION',2,'CO-008','2022-08-08',NULL,NULL),
  ('Propuesta CO 9','Descripcion CO 9','2024-05-04','VOTACION',2,'CO-009','2020-09-09','2020-10-09','2020-11-09'),
  ('Propuesta CO 10','Descripcion CO 10','2023-11-10','TERMINADA',2,'CO-010','2019-12-12','2020-01-12','2020-02-12');

/* --- Propuestas para Estados Unidos (país 3, idCongreso = 3) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta US 1','Descripcion US 1','2023-10-31','TERMINADA',3,'US-001','2010-01-10','2010-02-10','2010-03-10'),
  ('Propuesta US 2','Descripcion US 2','2024-03-15','VOTACION',3,'US-002','2011-02-15',NULL,'2011-03-15'),
  ('Propuesta US 3','Descripcion US 3','2025-07-20','PUBLICACION',3,'US-003','2012-03-20','2012-04-20','2012-05-20'),
  ('Propuesta US 4','Descripcion US 4','2022-11-30','TERMINADA',3,'US-004','2009-06-10','2009-07-10','2009-08-10'),
  ('Propuesta US 5','Descripcion US 5','2023-08-15','ACEPTACION',3,'US-005','2010-02-20',NULL,NULL),
  ('Propuesta US 6','Descripcion US 6','2024-10-10','VOTACION',3,'US-006','2011-11-11','2011-12-11','2012-01-11'),
  ('Propuesta US 7','Descripcion US 7','2023-04-03','PUBLICACION',3,'US-007','2012-04-04','2012-05-04','2012-06-04'),
  ('Propuesta US 8','Descripcion US 8','2025-09-08','ACEPTACION',3,'US-008','2013-07-07',NULL,NULL),
  ('Propuesta US 9','Descripcion US 9','2024-05-04','VOTACION',3,'US-001','2010-08-08','2010-09-08','2010-10-08'),
  ('Propuesta US 10','Descripcion US 10','2023-11-10','TERMINADA',3,'US-002','2009-12-12','2010-01-12','2010-02-12');

/* --- Propuestas para Rusia (país 4, idCongreso = 4) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta RU 1','Descripcion RU 1','2023-09-30','TERMINADA',4,'RU-001','1999-01-05','1999-02-05','1999-03-05'),
  ('Propuesta RU 2','Descripcion RU 2','2024-02-15','VOTACION',4,'RU-002','2000-03-10',NULL,'2000-04-10'),
  ('Propuesta RU 3','Descripcion RU 3','2025-06-20','PUBLICACION',4,'RU-003','2001-04-15','2001-05-15','2001-06-15'),
  ('Propuesta RU 4','Descripcion RU 4','2022-12-30','TERMINADA',4,'RU-004','2002-07-01','2002-08-01','2002-09-01'),
  ('Propuesta RU 5','Descripcion RU 5','2023-08-15','ACEPTACION',4,'RU-005','2003-02-20',NULL,NULL),
  ('Propuesta RU 6','Descripcion RU 6','2024-10-10','VOTACION',4,'RU-006','2004-11-11','2004-12-11','2005-01-11'),
  ('Propuesta RU 7','Descripcion RU 7','2023-04-03','PUBLICACION',4,'RU-007','2005-04-04','2005-05-04','2005-06-04'),
  ('Propuesta RU 8','Descripcion RU 8','2025-09-08','ACEPTACION',4,'RU-008','2006-07-07',NULL,NULL),
  ('Propuesta RU 9','Descripcion RU 9','2024-05-04','VOTACION',4,'RU-009','2007-08-08','2007-09-08','2007-10-08'),
  ('Propuesta RU 10','Descripcion RU 10','2023-11-10','TERMINADA',4,'RU-010','2008-12-12','2009-01-12','2009-02-12');

/* --- Propuestas para China (país 5, idCongreso = 5) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta CH 1','Descripcion CH 1','2023-08-31','TERMINADA',5,'CH-001','1990-01-10','1990-02-10','1990-03-10'),
  ('Propuesta CH 2','Descripcion CH 2','2024-01-15','VOTACION',5,'CH-002','1991-02-15',NULL,'1991-03-15'),
  ('Propuesta CH 3','Descripcion CH 3','2025-05-20','PUBLICACION',5,'CH-003','1992-03-20','1992-04-20','1992-05-20'),
  ('Propuesta CH 4','Descripcion CH 4','2022-11-30','TERMINADA',5,'CH-004','1993-06-10','1993-07-10','1993-08-10'),
  ('Propuesta CH 5','Descripcion CH 5','2023-07-15','ACEPTACION',5,'CH-005','1994-02-20',NULL,NULL),
  ('Propuesta CH 6','Descripcion CH 6','2024-09-10','VOTACION',5,'CH-006','1995-11-11','1995-12-11','1996-01-11'),
  ('Propuesta CH 7','Descripcion CH 7','2023-03-03','PUBLICACION',5,'CH-007','1996-04-04','1996-05-04','1996-06-04'),
  ('Propuesta CH 8','Descripcion CH 8','2025-08-08','ACEPTACION',5,'CH-008','1997-07-07',NULL,NULL),
  ('Propuesta CH 9','Descripcion CH 9','2024-04-04','VOTACION',5,'CH-009','1998-08-08','1998-09-08','1998-10-08'),
  ('Propuesta CH 10','Descripcion CH 10','2023-10-10','TERMINADA',5,'CH-010','1999-12-12','2000-01-12','2000-02-12');

/* --- Propuestas para Mongolia (país 6, idCongreso = 6) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta MO 1','Descripcion MO 1','2023-07-31','TERMINADA',6,'MO-001','2000-01-05','2000-02-05','2000-03-05'),
  ('Propuesta MO 2','Descripcion MO 2','2024-01-15','VOTACION',6,'MO-002','2001-03-10',NULL,'2001-04-10'),
  ('Propuesta MO 3','Descripcion MO 3','2025-05-20','PUBLICACION',6,'MO-003','2002-03-20','2002-04-20','2002-05-20'),
  ('Propuesta MO 4','Descripcion MO 4','2022-11-30','TERMINADA',6,'MO-004','2003-06-10','2003-07-10','2003-08-10'),
  ('Propuesta MO 5','Descripcion MO 5','2023-07-15','ACEPTACION',6,'MO-005','2004-02-20',NULL,NULL),
  ('Propuesta MO 6','Descripcion MO 6','2024-09-10','VOTACION',6,'MO-006','2005-11-11','2005-12-11','2006-01-11'),
  ('Propuesta MO 7','Descripcion MO 7','2023-03-03','PUBLICACION',6,'MO-007','2006-04-04','2006-05-04','2006-06-04'),
  ('Propuesta MO 8','Descripcion MO 8','2025-08-08','ACEPTACION',6,'MO-001','2007-07-07',NULL,NULL),
  ('Propuesta MO 9','Descripcion MO 9','2024-04-04','VOTACION',6,'MO-002','2008-08-08','2008-09-08','2008-10-08'),
  ('Propuesta MO 10','Descripcion MO 10','2023-10-10','TERMINADA',6,'MO-003','2009-12-12','2010-01-12','2010-02-12');

/* --- Propuestas para Italia (país 7, idCongreso = 7) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta IT 1','Descripcion IT 1','2023-12-31','TERMINADA',7,'IT-001','1995-01-10','1995-02-10','1995-03-10'),
  ('Propuesta IT 2','Descripcion IT 2','2024-02-15','VOTACION',7,'IT-002','1996-02-15',NULL,'1996-03-15'),
  ('Propuesta IT 3','Descripcion IT 3','2025-06-20','PUBLICACION',7,'IT-003','1997-03-20','1997-04-20','1997-05-20'),
  ('Propuesta IT 4','Descripcion IT 4','2022-11-30','TERMINADA',7,'IT-004','1998-06-10','1998-07-10','1998-08-10'),
  ('Propuesta IT 5','Descripcion IT 5','2023-07-15','ACEPTACION',7,'IT-005','1999-02-20',NULL,NULL),
  ('Propuesta IT 6','Descripcion IT 6','2024-09-10','VOTACION',7,'IT-006','2000-11-11','2000-12-11','2001-01-11'),
  ('Propuesta IT 7','Descripcion IT 7','2023-03-03','PUBLICACION',7,'IT-007','2001-04-04','2001-05-04','2001-06-04'),
  ('Propuesta IT 8','Descripcion IT 8','2025-08-08','ACEPTACION',7,'IT-008','2002-07-07',NULL,NULL),
  ('Propuesta IT 9','Descripcion IT 9','2024-04-04','VOTACION',7,'IT-009','2003-08-08','2003-09-08','2003-10-08'),
  ('Propuesta IT 10','Descripcion IT 10','2023-11-10','TERMINADA',7,'IT-010','2004-12-12','2005-01-12','2005-02-12');

/* --- Propuestas para Grecia (país 8, idCongreso = 8) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta GR 1','Descripcion GR 1','2023-10-31','TERMINADA',8,'GR-001','2000-01-10','2000-02-10','2000-03-10'),
  ('Propuesta GR 2','Descripcion GR 2','2024-03-15','VOTACION',8,'GR-002','2001-02-15',NULL,'2001-03-15'),
  ('Propuesta GR 3','Descripcion GR 3','2025-07-20','PUBLICACION',8,'GR-003','2002-03-20','2002-04-20','2002-05-20'),
  ('Propuesta GR 4','Descripcion GR 4','2022-11-30','TERMINADA',8,'GR-004','2003-06-10','2003-07-10','2003-08-10'),
  ('Propuesta GR 5','Descripcion GR 5','2023-08-15','ACEPTACION',8,'GR-005','2004-02-20',NULL,NULL),
  ('Propuesta GR 6','Descripcion GR 6','2024-10-10','VOTACION',8,'GR-006','2005-11-11','2005-12-11','2006-01-11'),
  ('Propuesta GR 7','Descripcion GR 7','2023-04-03','PUBLICACION',8,'GR-001','2006-04-04','2006-05-04','2006-06-04'),
  ('Propuesta GR 8','Descripcion GR 8','2025-09-08','ACEPTACION',8,'GR-002','2007-07-07',NULL,NULL),
  ('Propuesta GR 9','Descripcion GR 9','2024-05-04','VOTACION',8,'GR-003','2008-08-08','2008-09-08','2008-10-08'),
  ('Propuesta GR 10','Descripcion GR 10','2023-11-10','TERMINADA',8,'GR-004','2009-12-12','2010-01-12','2010-02-12');

/* --- Propuestas para Francia (país 9, idCongreso = 9) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta FR 1','Descripcion FR 1','2023-12-31','TERMINADA',9,'FR-001','1990-01-10','1990-02-10','1990-03-10'),
  ('Propuesta FR 2','Descripcion FR 2','2024-02-15','VOTACION',9,'FR-002','1991-02-15',NULL,'1991-03-15'),
  ('Propuesta FR 3','Descripcion FR 3','2025-06-20','PUBLICACION',9,'FR-003','1992-03-20','1992-04-20','1992-05-20'),
  ('Propuesta FR 4','Descripcion FR 4','2022-11-30','TERMINADA',9,'FR-004','1993-06-10','1993-07-10','1993-08-10'),
  ('Propuesta FR 5','Descripcion FR 5','2023-08-15','ACEPTACION',9,'FR-005','1994-02-20',NULL,NULL),
  ('Propuesta FR 6','Descripcion FR 6','2024-09-10','VOTACION',9,'FR-006','1995-11-11','1995-12-11','1996-01-11'),
  ('Propuesta FR 7','Descripcion FR 7','2023-04-03','PUBLICACION',9,'FR-007','1996-04-04','1996-05-04','1996-06-04'),
  ('Propuesta FR 8','Descripcion FR 8','2025-08-08','ACEPTACION',9,'FR-008','1997-07-07',NULL,NULL),
  ('Propuesta FR 9','Descripcion FR 9','2024-04-04','VOTACION',9,'FR-009','1998-08-08','1998-09-08','1998-10-08'),
  ('Propuesta FR 10','Descripcion FR 10','2023-10-10','TERMINADA',9,'FR-010','1999-12-12','2000-01-12','2000-02-12');

/* --- Propuestas para Reino Unido (país 10, idCongreso = 10) --- */
INSERT INTO PROPUESTA (titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
  ('Propuesta UK 1','Descripcion UK 1','2023-11-30','TERMINADA',10,'UK-001','1985-01-10','1985-02-10','1985-03-10'),
  ('Propuesta UK 2','Descripcion UK 2','2024-03-15','VOTACION',10,'UK-002','1986-02-15',NULL,'1986-03-15'),
  ('Propuesta UK 3','Descripcion UK 3','2025-07-20','PUBLICACION',10,'UK-003','1987-03-20','1987-04-20','1987-05-20'),
  ('Propuesta UK 4','Descripcion UK 4','2022-12-30','TERMINADA',10,'UK-004','1988-06-10','1988-07-10','1988-08-10'),
  ('Propuesta UK 5','Descripcion UK 5','2023-08-15','ACEPTACION',10,'UK-005','1989-02-20',NULL,NULL),
  ('Propuesta UK 6','Descripcion UK 6','2024-10-10','VOTACION',10,'UK-006','1990-11-11','1990-12-11','1991-01-11'),
  ('Propuesta UK 7','Descripcion UK 7','2023-04-03','PUBLICACION',10,'UK-007','1991-04-04','1991-05-04','1991-06-04'),
  ('Propuesta UK 8','Descripcion UK 8','2025-09-08','ACEPTACION',10,'UK-008','1992-07-07',NULL,NULL),
  ('Propuesta UK 9','Descripcion UK 9','2024-05-04','VOTACION',10,'UK-009','1993-08-08','1993-09-08','1993-10-08'),
  ('Propuesta UK 10','Descripcion UK 10','2023-11-10','TERMINADA',10,'UK-001','1985-12-12','1986-01-12','1986-02-12');

-- ============================================================
-- Inserción de 10 leyes por país (total 100 leyes)
-- Se cuida que: fechaAplicacion > fechaImplementacion y fechaModificacion >= fechaImplementacion.
-- Se asigna idCodigoCivil correspondiente al país (1 a 10).
-- ============================================================

/* --- Leyes para España (país 1, idCodigoCivil = 1) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley ES 1','2021-02-01','2021-02-15','2021-01-01',1),
  ('Ley ES 2','2022-03-10','2022-03-15','2022-02-10',1),
  ('Ley ES 3','2023-04-20','2023-04-25','2023-03-20',1),
  ('Ley ES 4','2020-05-30','2020-06-05','2020-05-01',1),
  ('Ley ES 5','2021-07-15','2021-07-20','2021-06-15',1),
  ('Ley ES 6','2022-08-10','2022-08-15','2022-07-10',1),
  ('Ley ES 7','2023-09-05','2023-09-10','2023-08-05',1),
  ('Ley ES 8','2024-10-10','2024-10-15','2024-09-10',1),
  ('Ley ES 9','2025-11-11','2025-11-15','2025-10-11',1),
  ('Ley ES 10','2023-12-12','2023-12-15','2023-11-12',1);

/* --- Leyes para Colombia (país 2, idCodigoCivil = 2) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley CO 1','2021-03-01','2021-03-15','2021-02-01',2),
  ('Ley CO 2','2022-04-10','2022-04-15','2022-03-10',2),
  ('Ley CO 3','2023-05-20','2023-05-25','2023-04-20',2),
  ('Ley CO 4','2020-06-30','2020-07-05','2020-06-01',2),
  ('Ley CO 5','2021-08-15','2021-08-20','2021-07-15',2),
  ('Ley CO 6','2022-09-10','2022-09-15','2022-08-10',2),
  ('Ley CO 7','2023-10-05','2023-10-10','2023-09-05',2),
  ('Ley CO 8','2024-11-10','2024-11-15','2024-10-10',2),
  ('Ley CO 9','2025-12-11','2025-12-15','2025-11-11',2),
  ('Ley CO 10','2023-01-12','2023-01-15','2022-12-12',2);

/* --- Leyes para Estados Unidos (país 3, idCodigoCivil = 3) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley US 1','2010-02-01','2010-02-15','2010-01-01',3),
  ('Ley US 2','2011-03-10','2011-03-15','2011-02-10',3),
  ('Ley US 3','2012-04-20','2012-04-25','2012-03-20',3),
  ('Ley US 4','2013-05-30','2013-06-05','2013-05-01',3),
  ('Ley US 5','2014-07-15','2014-07-20','2014-06-15',3),
  ('Ley US 6','2015-08-10','2015-08-15','2015-07-10',3),
  ('Ley US 7','2016-09-05','2016-09-10','2016-08-05',3),
  ('Ley US 8','2017-10-10','2017-10-15','2017-09-10',3),
  ('Ley US 9','2018-11-11','2018-11-15','2018-10-11',3),
  ('Ley US 10','2019-12-12','2019-12-15','2019-11-12',3);

/* --- Leyes para Rusia (país 4, idCodigoCivil = 4) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley RU 1','2000-02-01','2000-02-15','2000-01-01',4),
  ('Ley RU 2','2001-03-10','2001-03-15','2001-02-10',4),
  ('Ley RU 3','2002-04-20','2002-04-25','2002-03-20',4),
  ('Ley RU 4','2003-05-30','2003-06-05','2003-05-01',4),
  ('Ley RU 5','2004-07-15','2004-07-20','2004-06-15',4),
  ('Ley RU 6','2005-08-10','2005-08-15','2005-07-10',4),
  ('Ley RU 7','2006-09-05','2006-09-10','2006-08-05',4),
  ('Ley RU 8','2007-10-10','2007-10-15','2007-09-10',4),
  ('Ley RU 9','2008-11-11','2008-11-15','2008-10-11',4),
  ('Ley RU 10','2009-12-12','2009-12-15','2009-11-12',4);

/* --- Leyes para China (país 5, idCodigoCivil = 5) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley CH 1','1991-02-01','1991-02-15','1991-01-01',5),
  ('Ley CH 2','1992-03-10','1992-03-15','1992-02-10',5),
  ('Ley CH 3','1993-04-20','1993-04-25','1993-03-20',5),
  ('Ley CH 4','1994-05-30','1994-06-05','1994-05-01',5),
  ('Ley CH 5','1995-07-15','1995-07-20','1995-06-15',5),
  ('Ley CH 6','1996-08-10','1996-08-15','1996-07-10',5),
  ('Ley CH 7','1997-09-05','1997-09-10','1997-08-05',5),
  ('Ley CH 8','1998-10-10','1998-10-15','1998-09-10',5),
  ('Ley CH 9','1999-11-11','1999-11-15','1999-10-11',5),
  ('Ley CH 10','2000-12-12','2000-12-15','2000-11-12',5);

/* --- Leyes para Mongolia (país 6, idCodigoCivil = 6) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley MO 1','2001-02-01','2001-02-15','2001-01-01',6),
  ('Ley MO 2','2002-03-10','2002-03-15','2002-02-10',6),
  ('Ley MO 3','2003-04-20','2003-04-25','2003-03-20',6),
  ('Ley MO 4','2004-05-30','2004-06-05','2004-05-01',6),
  ('Ley MO 5','2005-07-15','2005-07-20','2005-06-15',6),
  ('Ley MO 6','2006-08-10','2006-08-15','2006-07-10',6),
  ('Ley MO 7','2007-09-05','2007-09-10','2007-08-05',6),
  ('Ley MO 8','2008-10-10','2008-10-15','2008-09-10',6),
  ('Ley MO 9','2009-11-11','2009-11-15','2009-10-11',6),
  ('Ley MO 10','2010-12-12','2010-12-15','2010-11-12',6);

/* --- Leyes para Italia (país 7, idCodigoCivil = 7) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley IT 1','2005-02-01','2005-02-15','2005-01-01',7),
  ('Ley IT 2','2006-03-10','2006-03-15','2006-02-10',7),
  ('Ley IT 3','2007-04-20','2007-04-25','2007-03-20',7),
  ('Ley IT 4','2008-05-30','2008-06-05','2008-05-01',7),
  ('Ley IT 5','2009-07-15','2009-07-20','2009-06-15',7),
  ('Ley IT 6','2010-08-10','2010-08-15','2010-07-10',7),
  ('Ley IT 7','2011-09-05','2011-09-10','2011-08-05',7),
  ('Ley IT 8','2012-10-10','2012-10-15','2012-09-10',7),
  ('Ley IT 9','2013-11-11','2013-11-15','2013-10-11',7),
  ('Ley IT 10','2014-12-12','2014-12-15','2014-11-12',7);

/* --- Leyes para Grecia (país 8, idCodigoCivil = 8) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley GR 1','2000-02-01','2000-02-15','2000-01-01',8),
  ('Ley GR 2','2001-03-10','2001-03-15','2001-02-10',8),
  ('Ley GR 3','2002-04-20','2002-04-25','2002-03-20',8),
  ('Ley GR 4','2003-05-30','2003-06-05','2003-05-01',8),
  ('Ley GR 5','2004-07-15','2004-07-20','2004-06-15',8),
  ('Ley GR 6','2005-08-10','2005-08-15','2005-07-10',8),
  ('Ley GR 7','2006-09-05','2006-09-10','2006-08-05',8),
  ('Ley GR 8','2007-10-10','2007-10-15','2007-09-10',8),
  ('Ley GR 9','2008-11-11','2008-11-15','2008-10-11',8),
  ('Ley GR 10','2009-12-12','2009-12-15','2009-11-12',8);

/* --- Leyes para Francia (país 9, idCodigoCivil = 9) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley FR 1','2010-02-01','2010-02-15','2010-01-01',9),
  ('Ley FR 2','2011-03-10','2011-03-15','2011-02-10',9),
  ('Ley FR 3','2012-04-20','2012-04-25','2012-03-20',9),
  ('Ley FR 4','2013-05-30','2013-06-05','2013-05-01',9),
  ('Ley FR 5','2014-07-15','2014-07-20','2014-06-15',9),
  ('Ley FR 6','2015-08-10','2015-08-15','2015-07-10',9),
  ('Ley FR 7','2016-09-05','2016-09-10','2016-08-05',9),
  ('Ley FR 8','2017-10-10','2017-10-15','2017-09-10',9),
  ('Ley FR 9','2018-11-11','2018-11-15','2018-10-11',9),
  ('Ley FR 10','2019-12-12','2019-12-15','2019-11-12',9);

/* --- Leyes para Reino Unido (país 10, idCodigoCivil = 10) --- */
INSERT INTO LEY (descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
  ('Ley UK 1','1986-02-01','1986-02-15','1986-01-01',10),
  ('Ley UK 2','1987-03-10','1987-03-15','1987-02-10',10),
  ('Ley UK 3','1988-04-20','1988-04-25','1988-03-20',10),
  ('Ley UK 4','1989-05-30','1989-06-05','1989-05-01',10),
  ('Ley UK 5','1990-07-15','1990-07-20','1990-06-15',10),
  ('Ley UK 6','1991-08-10','1991-08-15','1991-07-10',10),
  ('Ley UK 7','1992-09-05','1992-09-10','1992-08-05',10),
  ('Ley UK 8','1993-10-10','1993-10-15','1993-09-10',10),
  ('Ley UK 9','1994-11-11','1994-11-15','1994-10-11',10),
  ('Ley UK 10','1995-12-12','1995-12-15','1995-11-12',10);

-- ============================================================
-- Inserción en DESARROLLAR (relaciona algunas propuestas con leyes)
-- Se insertan relaciones arbitrarias; no todas las propuestas o leyes se relacionan.
-- ============================================================
INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES
  (1,1),
  (2,2),
  (12,11),
  (23,21),
  (35,31),
  (47,41),
  (58,51),
  (69,61),
  (80,71),
  (91,81);

-- ============================================================
-- Inserción de registros en VOTAR (variedad de votos)
-- Se incluyen casos:
--   - Propuestas sin votos.
--   - Ciudadanos que no votan.
--   - Ciudadanos que votan en más de una propuesta.
-- ============================================================

/* --- Votos para España --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('ES-006', 1, TRUE),
  ('ES-007', 1, FALSE),
  ('ES-008', 2, TRUE),
  ('ES-009', 3, TRUE),
  ('ES-010', 3, FALSE),
  ('ES-011', 2, TRUE),
  ('ES-012', 4, TRUE),
  ('ES-012', 5, FALSE);

/* --- Votos para Colombia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('CO-016', 11, TRUE),
  ('CO-017', 12, FALSE),
  ('CO-018', 13, TRUE),
  ('CO-019', 14, FALSE),
  ('CO-020', 15, TRUE);

/* --- Votos para Estados Unidos --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('US-009', 21, TRUE),
  ('US-010', 22, FALSE),
  ('US-011', 23, TRUE),
  ('US-012', 24, TRUE),
  ('US-013', 25, FALSE);

/* --- Votos para Rusia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('RU-013', 31, TRUE),
  ('RU-014', 32, FALSE),
  ('RU-015', 33, TRUE),
  ('RU-016', 34, FALSE);

/* --- Votos para China --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('CH-011', 41, TRUE),
  ('CH-012', 42, FALSE),
  ('CH-013', 43, TRUE);

/* --- Votos para Mongolia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('MO-015', 51, TRUE),
  ('MO-016', 52, FALSE);

/* --- Votos para Italia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('IT-015', 61, TRUE),
  ('IT-016', 62, FALSE),
  ('IT-017', 63, TRUE);

/* --- Votos para Grecia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('GR-015', 71, TRUE),
  ('GR-016', 72, FALSE);

/* --- Votos para Francia --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('FR-012', 81, TRUE),
  ('FR-013', 82, FALSE),
  ('FR-014', 83, TRUE);

/* --- Votos para Reino Unido --- */
INSERT INTO VOTAR (numPasaporteCiudadano, idPropuesta, decision) VALUES
  ('UK-010', 91, TRUE),
  ('UK-011', 92, FALSE),
  ('UK-012', 93, TRUE),
  ('UK-013', 94, FALSE);

-- Fin del script DML completo.

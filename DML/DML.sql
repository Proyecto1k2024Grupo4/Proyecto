INSERT INTO PAIS(nombre) VALUES
("España"),
("Colombia"),
("Estados Unidos"),
("Rusia"),
("China"),
("Mongolia"),
("Italia"),
("Grecia"),
("Francia"),
("Reino Unido");

INSERT INTO CONGRESO(nombrePais) VALUES 
("España"),
("Colombia"),
("Estados Unidos"),
("Rusia"),
("China"),
("Mongolia"),
("Italia"),
("Grecia"),
("Francia"),
("Reino Unido");

INSERT INTO CODIGO_CIVIL(nombrePais) VALUES 
("España"),
("Colombia"),
("Estados Unidos"),
("Rusia"),
("China"),
("Mongolia"),
("Italia"),
("Grecia"),
("Francia"),
("Reino Unido");

INSERT INTO PERSONA(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
("123456789A", "Desiderio", "Alcazares", "Segundo", '2000/1/10', 'H', "España"),
("234567891A", "Juan", "Pericles", NULL, '1900/2/10', 'H', "España"),
("12345678B", "Lucia", NULL, "Artida", '1995/3/10', 'M', "Colombia"),
("23456789B", "Cullera", "Macia", "Roberto", '2006/4/25', 'H', "Colombia"),
("A1234567C", "Wilson", "Jackson", "Person", '2001/5/1', 'H', "Estados Unidos"),
("A2345678C", "Tracy", "Mary", "Larson", '1999/5/10', 'M', "Estados Unidos"),
("12345678901D", "Bladimyr", "Bostov", "Artyom", '1997/6/15', 'H', "Rusia"),
("23456789012D", "Marie", "Azkaya", "Ligla", '1980/9/15', 'M', "Rusia"),
("12345E", "Xi", "Ginpin", "Tzu", '1997/6/15', 'H', "China"),
("23456E", "Xensue", "Laocao", "Lu", '2002/8/17', 'H', "China"),
("123456789F", "Gengis", "Khan", "Yangau", '2002/9/17', NULL, "Mongolia"),
("234567891F", "Curimi", "Bukyak", "Nica", '1980/9/13', 'H', "Mongolia"),
("123G", "Pesto", "Di", "Cuesto", '1998/10/6', 'H', "Italia"),
("234G", "Carabina", "Na", "Politana", '1990/10/26', 'M', "Italia"),
("1234567890123H", "Yikmir", "Amir", "Palir", '1980/11/30', 'H', "Grecia"),
("2345678901234H", "Bracut", "Nagal", "Sinsi", '1960/1/30', 'H', "Grecia"),
("123456I", "Bagguette", "Croisant", "Eifel", '1999/12/1', 'H', "Francia"),
("234567I", "Wi", "Wi", "Lacamoua", '2003/12/2', 'M', "Francia"),
("23456789J", "Charles", "Darwin", "Natural", '1950/2/2', 'H', "Reino Unido"),
("12345678J", "Isabel", "The", "Queen", '1200/1/25', 'M', "Reino Unido");

INSERT INTO POLITICO(numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
("123456789A", '2008/5/5', NULL, 1),
("12345678B", '2009/5/5', NULL, 2),
("A1234567C", '2010/5/5', NULL, 3),
("23456789012D", '2011/5/5', NULL, 4),
("12345E", '2008/5/5', NULL, 5),
("234567891F", '2008/5/5', NULL, 6),
("234G", '2009/5/5', NULL, 7),
("2345678901234H", '2009/5/5', NULL, 8),
("123456I", '2012/5/5', NULL, 9),
("23456789J", '2012/5/5', NULL, 10);


INSERT INTO CIUDADANO(numPasaporte) VALUES
("234567891A"),
("23456789B"),
("A2345678C"),
("12345678901D"),
("23456E"),
("123456789F"),
("123G"),
("1234567890123H"),
("234567I"),
("12345678J");

INSERT INTO LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
("Ley de Salud", '2030/1/1','1999/1/1','1998/1/1',1),
("Ley de Salud", '2028/1/1','1999/1/3','1999/1/3',2),
("Ley de Justicia", '2026/1/5','2001/1/5','2001/1/1',3),
("Ley de Trabajadores", '2026/1/1','1998/1/1','1998/1/1',4),
("Ley de Perros", '2025/1/1','2023/2/3','2017/1/1',5),
("Ley de Gatos", NULL,'1998/6/2','1998/1/1',6),
("Ley de Pensiones", '2026/1/1', NULL,'1998/1/1',7),
("Ley de Comida", '2040/1/1','1998/1/2','1998/1/1',8),
("Ley de Turismo", NULL, NULL,'1998/1/1',9),
("Ley de Coches", NULL,'2024/5/2','2024/1/1',10);

INSERT INTO PROPUESTA(titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 1, "123456789A", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 2, "12345678B", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Perros", "Cambiar la ley de perros", NULL, "ACEPTACION", 3, "A1234567C", '2024/2/2', NULL, NULL),
("Reforma ley de Gatos", "Cambiar la ley de gatos", NULL, "PUBLICACION", 4, "23456789012D", '2023/2/2', '2023/3/2', NULL),
("Reforma ley de Perros", "Cambiar la ley de Perros",'2023/2/2', "TERMINADA", 5, "12345E", '2022/2/2', '2022/3/3', '2022/4/15'),
("Reforma ley de Comida", "Cambiar la ley de comida",'2026/2/2', "VOTACION", 6, "234567891F", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Turismo", "Cambiar la ley de turismo",'2027/2/2', "VOTACION", 7, "234G", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Coches", "Cambiar la ley de coches",'2027/2/2', "VOTACION", 8, "2345678901234H", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 9, "123456I", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 10, "23456789J", '2023/2/2', '2023/3/3', '2024/4/15');

INSERT INTO VOTAR(numPasaporteCiudadano, idPropuesta, decision) VALUES
("234567891A", 1, TRUE),
("23456789B", 2, FALSE),
("23456E", 5, TRUE),
("123456789F", 6, TRUE),
("123G", 7, TRUE),
("1234567890123H", 8, FALSE),
("234567I", 9, TRUE),
("12345678J", 10, FALSE);
-- Se han añadido menos registros porque no todas las propuestas están en votación o terminadas

INSERT INTO DESARROLLAR(idPropuesta, idLey) VALUES 
(5, 5);
-- Solo se ha añadido un registro porque solo hay una propuesta terminada


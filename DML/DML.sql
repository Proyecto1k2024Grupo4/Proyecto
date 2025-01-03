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

INSERT INTO CONGRESO(idPais) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO CODIGO_CIVIL(idPais) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO PERSONA(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
("123456789A", "Desiderio", "Alcazares", "Segundo", '2000/1/10', 'H', 1),
("234567891A", "Juan", "Pericles", NULL, '1900/2/10', 'H', 1),
("345678912A", "Pepe", "Villuela", "Morcon", '1966/3/19', 'M', 1),
("456789123A", "Maria", "Unpa", "Lumpa", '2001/9/11', 'M', 1),
("567891234A", "Lingan", "Guli", "Wacha", '2002/9/11', 'H', 1),
("678912345A", "Mario", "Vaquerizo", "Mario", '2000/9/11', 'M', 1),
("789123456A", "Dos", "Dados", "Dorados", '1999/9/11', 'M', 1),
("891234567A", "Tres", "Tristres", "Tigres", '2000/9/11', 'H', 1),
("912345678A", "Alberto", "Chicote", "Bar", '2002/4/1', 'H', 1),
("991234567A", "Chema", "Llema", "Crema", '2001/5/11', 'M', 1),
("12345678B", "Lucia", NULL, "Artida", '1995/3/10', 'M', 2),
("23456789B", "Cullera", "Macia", "Roberto", '2006/4/25', 'H', 2),
("34567891B", "Alpa", "Chino", "Mandarino", '1996/3/10', 'H', 2),
("A1234567C", "Wilson", "Jackson", "Person", '2001/5/1', 'H', 3),
("A2345678C", "Tracy", "Mary", "Larson", '1999/5/10', 'M', 3),
("12345678901D", "Bladimyr", "Bostov", "Artyom", '1997/6/15', 'H', 4),
("23456789012D", "Marie", "Azkaya", "Ligla", '1980/9/15', 'M', 4),
("12345E", "Xi", "Ginpin", "Tzu", '1997/6/15', 'H', 5),
("23456E", "Xensue", "Laocao", "Lu", '2002/8/17', 'H', 5),
("123456789F", "Gengis", "Khan", "Yangau", '2002/9/17', NULL, 6),
("234567891F", "Curimi", "Bukyak", "Nica", '1980/9/13', 'H', 6),
("123G", "Pesto", "Di", "Cuesto", '1998/10/6', 'H', 7),
("234G", "Carabina", "Na", "Politana", '1990/10/26', 'M', 7),
("1234567890123H", "Yikmir", "Amir", "Palir", '1980/11/30', 'H', 8),
("2345678901234H", "Bracut", "Nagal", "Sinsi", '1960/1/30', 'H', 8),
("123456I", "Bagguette", "Croisant", "Eifel", '1999/12/1', 'H', 9),
("234567I", "Wi", "Wi", "Lacamoua", '2003/12/2', 'M', 9),
("23456789J", "Charles", "Darwin", "Natural", '1950/2/2', 'H', 10),
("12345678J", "Isabel", "The", "Queen", '1200/1/25', 'M', 10);


INSERT INTO POLITICO(numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
("123456789A", '2008/5/5', NULL, 1),
("345678912A", '2010/8/15', NULL, 1),
("34567891B", '2009/6/3', '2010/8/5', 2),
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
("456789123A"),
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
("Ley de Coches", NULL,'2024/5/2','2024/1/1',10),
("Ley de Videojuegos", '2030/1/1','2026/1/1','1998/1/1',1);


INSERT INTO PROPUESTA(titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 1, "123456789A", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 2, "12345678B", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Perros", "Cambiar la ley de perros", NULL, "ACEPTACION", 3, "A1234567C", '2024/2/2', NULL, NULL),
("Reforma ley de Gatos", "Cambiar la ley de gatos", NULL, "PUBLICACION", 4, "23456789012D", '2023/2/2', '2023/3/2', NULL),
("Reforma ley de Perros", "Cambiar la ley de Perros",'2023/2/2', "TERMINADA", 5, "12345E", '2022/2/2', '2022/3/3', '2022/4/15'),
("Reforma ley de Comida", "Cambiar la ley de comida",'2026/2/2', "VOTACION", 6, "234567891F", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Comida", "Cambiar la ley de comida",'2026/2/2', "VOTACION", 6, "234567891F", '2024/2/2', '2024/3/3', '2024/4/15'),
("Reforma ley de Turismo", "Cambiar la ley de turismo",'2027/2/2', "VOTACION", 7, "234G", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Coches", "Cambiar la ley de coches",'2027/2/2', "VOTACION", 8, "2345678901234H", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 9, "123456I", '2023/2/2', '2023/3/3', '2024/4/15'), 
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 10, "23456789J", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Videojuegos", "Cambiar la ley de videojuegos",'2025/2/2', "TERMINADA", 1, "123456789A", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Videojuegos", "Cambiar la ley de videojuegos para mal",'2025/1/1', "TERMINADA", 1, "123456789A", '2022/2/2', '2024/1/3', '2024/12/15'),
("Reforma ley de Videojuegos", "Cambiar la ley de videojuegos",'2025/1/1', "TERMINADA", 1, "123456789A", '2022/2/2', '2024/1/3', '2024/12/15');


INSERT INTO VOTAR(numPasaporteCiudadano, idPropuesta, decision) VALUES
("234567891A", 1, TRUE),
("456789123A", 1, TRUE),
("567891234A", 1, FALSE),
("678912345A", 1, FALSE),
("789123456A", 1, TRUE),
("891234567A", 1, TRUE),
("912345678A", 1, TRUE),
("991234567A", 1, TRUE),
("23456789B", 2, FALSE),
("23456E", 5, TRUE),
("123456789F", 6, TRUE),
("123G", 8, TRUE),
("1234567890123H", 9, FALSE),
("234567I", 10, TRUE),
("12345678J", 11, FALSE),
("567891234A", 12, FALSE),
("678912345A", 12, FALSE),
("789123456A", 12, TRUE),
("891234567A", 12, TRUE),
("912345678A", 12, TRUE),
("991234567A", 12, TRUE),
("567891234A", 13, FALSE),
("678912345A", 13, FALSE),
("789123456A", 13, FALSE),
("891234567A", 13, FALSE),
("912345678A", 13, FALSE),
("991234567A", 13, FALSE),
("567891234A", 14, TRUE),
("678912345A", 14, TRUE),
("789123456A", 14, TRUE),
("891234567A", 14, TRUE),
("912345678A", 14, TRUE),
("991234567A", 14, TRUE);

INSERT INTO DESARROLLAR(idPropuesta, idLey) VALUES 
(5, 5),
(12,11),
(14,11);



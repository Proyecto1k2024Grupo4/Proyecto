# Consultas 3

**Participantes:** 

- Diego Fernando Valencia Correa
- Jonathan Villalba Moran
- Samini Abdel

<br>

## Definición de 5 consultas que utilicen subconsultas, tanto escalares, como fila y de tabla##

### 1. Obtén la persona mas mayor utilizando not exists

``` sql
select * from PERSONA p where not exists (select * from PERSONA p2 where p2.fnac < p.fnac);
```
![alt text](image-12.png)

### 2. Selecciona el codigo de la ley con la fecha de aplicación más lejana

``` sql
select id from LEY where fechaAplicacion = (select max(fechaAplicacion) from LEY);
```
![alt text](image-11.png)

### 3. Selecciona el numero de pasaporte y nombre de todos los politicos cuya fecha de iniciación no sea la más antigua de su pais

``` sql
select p.numPasaporte, p.nombre from PERSONA p join POLITICO po on p.numPasaporte = po.numPasaporte where po.fechaIniciacion > any (select po2.fechaIniciacion from POLITICO po2 join PERSONA p2 on po2.numPasaporte = p2.numPasaporte where p2.paisNacimiento = p.paisNacimiento);
```
![alt text](image-21.png)

### 4. Listar propuestas donde todos sus votos son positivos:

``` sql
select distinct v.idPropuesta
from VOTAR v
where v.idPropuesta in 
(select v2.idPropuesta from VOTAR v2 group by v2.idPropuesta having count(*) = 
(select count(*) from VOTAR v3 where decision = 1 group by v3.idPropuesta having v3.idPropuesta = v2.idPropuesta));
```
![alt text](image-22.png)


### 5. Obtener la/las propuesta con la fecha de proposición más antigua:

``` sql
SELECT titulo, fechaProposicion 
FROM PROPUESTA 
WHERE fechaProposicion = (
    SELECT MIN(fechaProposicion) FROM PROPUESTA
);
```
![alt text](image-23.png)

<br><br>


## Definición de 2 consultas que utilicen CTE##

<br>

### 1. Obten el número de políticos por país

``` sql
WITH PoliticosPorPais AS (
    SELECT c.idPais, COUNT(p.numPasaporte) AS total_politicos
    from POLITICO p
    JOIN CONGRESO c ON p.idCongreso = c.id
    GROUP BY c.idPais
)
SELECT pa.nombre, pp.total_politicos 
from PoliticosPorPais pp
join PAIS pa ON pp.idPais = pa.id;
```
![alt text](image-24.png)

### 2. Obten la propuesta con más votos
``` sql
WITH VotosPorPropuesta AS (
    SELECT idPropuesta, COUNT(*) AS total_votos
    FROM VOTAR
    GROUP BY idPropuesta
)
SELECT P.titulo, vp.total_votos
FROM VotosPorPropuesta vp
join PROPUESTA P ON vp.idPropuesta = P.id
order by  vp.total_votos DESC
LIMIT 1;
```
![alt text](image-25.png)

<br><br>


## Creación de una tabla a partir del resultado de una consulta compleja


### Crea una tabla a partir del resultado de obtener el orden de los ciudadanos por cada pais y el numero de ciudadanos de su mismo pais

``` sql
create table ORDEN_CIUDADANOS_COOCIUDADANOS as 
select row_number() over (partition by p.paisNacimiento) as NumCiud, 
p.nombre, pa.nombre as Pais, count(*) over (partition by p.paisNacimiento) as Conciudadanos
from CIUDADANO c join PERSONA p on p.numPasaporte = c.numPasaporte
join PAIS pa on pa.id = p.paisNacimiento;
```
![alt text](image-26.png)

<br><br>

## Definición de dos índices que mejoren el rendimiento de las consultas ya definida

<br>

### Índice en la tabla PROPUESTA para optimizar búsquedas por estado y fecha

``` sql
CREATE INDEX idx_estado_fecha ON PROPUESTA(estado, fechaProposicion);
```
![alt text](image-19.png)

### Índice en la tabla VOTAR para mejorar la búsqueda por idPropuesta

``` sql
CREATE INDEX idx_votacion_propuesta ON VOTAR(decision);
```
![alt text](image-17.png)

<br><br>

## Planes de ejecución, antes y después de la creación de los índices, comprobando su uso

<br>

### Consulta 1 para plan de ejecución
``` sql
EXPLAIN SELECT titulo FROM PROPUESTA WHERE estado = 'ACEPTACION' order by fechaProposicion;
```

### Plan de ejecución antes de la creación del índice:
![alt text](image-13.png)

### Plan de ejecución después de la creación del índice:
![alt text](image-14.png)


### Consulta 2 para plan de ejecución 
``` sql
EXPLAIN SELECT idPropuesta, COUNT(*) as totalVotosFavor FROM VOTAR WHERE decision = 1 GROUP BY idPropuesta;
```

### Plan de ejecución antes de la creación del índice:
![alt text](image-15.png)

### Plan de ejecución después de la creación del índice:
![alt text](image-18.png)

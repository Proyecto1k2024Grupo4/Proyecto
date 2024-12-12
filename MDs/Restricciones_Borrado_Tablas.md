### Restricciones de modificaciones/eliminaciones en tablas

**Eliminaciones RECHAZADAS**

La eliminacion de cualquier instancia de las siguientes entidades se rechazará:

- **PAIS**
- **CONGRESO**
- **CODIGO_CIVIL**
- **PROPUESTA**
- **POLITICO**


**Eliminaciones PROPAGADAS**

La eliminación de cualquier instancia de las siguientes entidades se propagará, es decir, se borrará la instancia y todas las instancias que apunten a esta

- **LEY**
- **PERSONA**


**Eliminaciones ANULADAS**

La eliminacion de cualquier instancia de las siguientes entidades se anulará, es decir, se eliminará la instancia y en las claves foráneas que apunten a esta se marcarán como nulas:

- **CIUDADANO**


**Modificaciones RECHAZADAS**

La modificación de cualquier instancia de las siguientes entidades se rechazará:

- **PAIS**
- **CODIGO_CIVIL**
- **CONGRESO**
- **PROPUESTA**

**Modificaciones PROPAGADAS**

La modificación de cualquier instancia de las siguientes entidades será propagada, es decir, se modificará la instancia y todos los campos que la referencien desde otras instancias:

- **PERSONA**
- **POLITICO**
- **CIUDADANO**
- **LEY**
# Arquitectura y Estructura del Dominio (`domain/core`) - CEA 29

Este paquete representa el **núcleo de negocio (Dominio)** para el sistema del concesionario (**CEA 29**). Se ha diseñado siguiendo los principios de **Domain-Driven Design (DDD)** y **Arquitectura Hexagonal**, garantizando independencia absoluta de cualquier marco de trabajo (*framework*), base de datos o API externa (sólo utiliza Java Estándar).

---

## Estructura de Paquetes

```text
com.jcaa.udec.collections.domain.core/
│
├── exception/        Excepciones de negocio explícitas
├── valueobject/      Objetos de valor inmutables y auto-validados
├── event/            Eventos de dominio que representan hechos pasados
├── model/            Entidades y Agregados Raíz con ciclo de vida
├── service/          Servicios de dominio puramente lógicos
├── factory/          Factorías para la creación de agregados complejos
└── specification/    Especificaciones y reglas de negocio reutilizables
```

---

##  Descripción de Submódulos

### 1. `exception/`
Contiene las excepciones específicas del dominio que extienden de `RuntimeException`. Representan violaciones explícitas de las reglas de negocio del concesionario.
* **`InvalidVINException.java`**: Lanzada cuando un código VIN de chasis no cumple con los 17 caracteres requeridos.
* **`VehiculoNoDisponibleException.java`**: Lanzada al intentar vender un vehículo cuyo estado no es `DISPONIBLE`.

### 2. `valueobject/`
Contiene los Objetos de Valor (*Value Objects*). Son clases inmutables sin identidad propia que encapsulan conceptos descriptivos del dominio y aplican validaciones estrictas en sus constructores.
* **`ChassisVIN.java`**: Representa el número de serie único del vehículo (17 caracteres).
* **`Money.java`**: Representa montos monetarios de forma precisa mediante `BigDecimal` y divisa.

### 3. `event/`
Aloja los eventos de dominio que registran hechos significativos ocurridos dentro de la lógica comercial.
* **`VentaConsolidadaEvent.java`**: Registra la consolidación de una venta con su respectivo ID, cliente, vehículo y monto cobrado.

### 4. `model/`
Agrupa las Entidades y las Raíces de Agregado (*Aggregate Roots*). Manejan el estado, ciclo de vida e invariantes principales.
* **`Vehiculo.java`**: Entidad que representa la unidad automotriz y su disponibilidad.
* **`VentaAggregate.java`**: Raíz de agregado que encapsula y asegura la consistencia de la transacción entre un cliente y un vehículo.

### 5. `service/`
Contiene servicios de dominio sin estado (*stateless*). Alojan operaciones de negocio que no pertenecen de forma natural a una sola entidad o involucran múltiples agregados.
* **`CalculadorDescuentoService.java`**: Calcula el precio final aplicando políticas de descuento dinámicas.

### 6. `factory/`
Aplica el patrón *Factory* para instanciar construcciones complejas de entidades y Value Objects garantizando que el objeto nazca en un estado válido.
* **`VehiculoFactory.java`**: Facilita la creación de instancias de `Vehiculo` a partir de tipos primitivos (`String`, `BigDecimal`).

### 7. `specification/`
Define las reglas o filtros de negocio mediante el patrón *Specification*.
* **`VehiculoAptoParaVentaSpecification.java`**: Interfaz/clase que evalúa si un vehículo cumple con las condiciones comerciales para ser puesto en catálogo o promoción.

---

## Aislamiento e Invariantes
1. **Dependencias:** Este paquete solo utiliza librerías nativas del JDK de Java (`java.math.*`, `java.time.*`, `java.util.*`).
2. **Frameworks:** No contiene anotaciones ni importaciones de Spring, JPA, Hibernate, Lombok ni bibliotecas de serialización JSON.
3. **Persistencia:** La persistencia se abstrae completamente a través de puertos que residen fuera de este paquete.
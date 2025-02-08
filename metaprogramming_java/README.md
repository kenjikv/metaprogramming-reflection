# Metaprogramación en Java: Repositorio Genérico con Reflexión

## Descripción
Este proyecto implementa un **repositorio genérico en Java** utilizando **Reflection y anotaciones personalizadas** para interactuar con una base de datos de manera dinámica. Además, se incluyen pruebas de rendimiento comparando **Reflection vs Inserción Manual** y se genera código dinámico con **Javassist**.

## Características
- **Uso de Reflection** para analizar y manipular clases en tiempo de ejecución.
- **Anotaciones Personalizadas (`@TableName` y `@ColumnName`)** para mapear entidades de Java a bases de datos.
- **Pruebas de rendimiento** comparando la inserción mediante Reflection vs Inserción Manual.
- **Generación de Clases en Tiempo de Ejecución** con **Javassist**.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot** (Spring JDBC, HikariCP)
- **PostgreSQL** (Conector JDBC)
- **Javassist** (Manipulación de bytecode en tiempo de ejecución)
- **Maven** (Gestor de dependencias)

## Configuración del Proyecto
### 1. Configurar la Base de Datos
Ejecuta la siguiente consulta en PostgreSQL:
```sql
CREATE TABLE user_table (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

### 2. Configurar `application.properties`
Modifica `src/main/resources/application.properties` para conectar con PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 3. Ejecutar el Proyecto
Ejecuta el siguiente comando desde la terminal:
```sh
mvn spring-boot:run
```

## Uso del Repositorio Genérico
### Insertar un Usuario con ID Autoincremental
```java
User newUser = new User(0, "Juan", "Perez", "juan.perez@example.com");
genericRepository.insert(newUser);
```
## Prueba de Rendimiento: Reflection vs Inserción Manual
Se comparó el rendimiento de la inserción de datos mediante Reflection contra una inserción manual.

| Método                 | Tiempo (ms) | Memoria (MB) |
|-------------------------|------------|--------------|
| **Reflection**          | 28.82      | 1.39         |
| **Inserción Manual**   | 1.47       | 0.00         |

La inserción manual es significativamente **más rápida y eficiente** en términos de memoria, mientras que Reflection ofrece **más flexibilidad** pero introduce una penalización en rendimiento.

## Generación de Clases Dinámicas con Javassist
Ejemplo de código que crea una clase `DynamicMath` en tiempo de ejecución:
```java
ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.makeClass("DynamicMath");
CtMethod sumMethod = CtNewMethod.make("public int sum(int a, int b) { return a + b; }", cc);
cc.addMethod(sumMethod);
```

# Metaprogramación en Java y .NET: Comparación y Aplicaciones

## Descripción
Este proyecto explora la **metaprogramación en Java y .NET**, analizando sus aplicaciones en la manipulación dinámica de clases, generación de código en tiempo de ejecución y comparación de rendimiento. Se presentan dos implementaciones separadas:

- **Metaprogramación en Java**: Uso de **Reflection y Javassist** para la manipulación de clases y acceso a bases de datos con repositorios dinámicos.
- **Metaprogramación en .NET**: Uso de **System.Reflection y System.Reflection.Emit** para la inspección y generación dinámica de métodos.

Ambas implementaciones permiten comprender cómo la metaprogramación puede **automatizar procesos, reducir código repetitivo y mejorar la flexibilidad**, aunque con impacto en rendimiento.

## Tecnologías Utilizadas
### 📌 Java
- **Java 17**
- **Spring Boot (Spring JDBC, HikariCP)**
- **PostgreSQL**
- **Javassist** (Manipulación de bytecode)
- **Maven**

### 📌 .NET
- **.NET 9.0**
- **C#**
- **System.Reflection y System.Reflection.Emit**
- **BenchmarkDotNet (opcional)**

## Estructura del Proyecto
```
Metaprogramming/
│── java/
│   ├── MetaprogrammingJava.sln
│   ├── src/
│   ├── GenericRepository.java
│   ├── ReflectionExample.java
│── dotnet/
│   ├── MetaprogrammingDotNet.sln
│   ├── WithMetaprogramming/
│   ├── WithOutMetaprogramming/
```

## Configuración y Ejecución
### 📌 Java
1. **Configurar PostgreSQL**
```sql
CREATE TABLE user_table (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```
2. **Configurar `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
```
3. **Ejecutar el Proyecto**
```sh
mvn spring-boot:run
```

### 📌 .NET
1. **Clonar y Construir el Proyecto**
```sh
git clone https://github.com/usuario/proyecto-metaprogramacion.git
cd proyecto-metaprogramacion
```
2. **Compilar el Código**
```sh
dotnet build
```
3. **Ejecutar las Implementaciones**
```sh
dotnet run --project WithMetaprogramming
```
```sh
dotnet run --project WithOutMetaprogramming
```


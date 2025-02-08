# Metaprogramación en .NET: Comparación de Enfoques

## Descripción
Este proyecto demuestra la aplicación de **metaprogramación en .NET** mediante el uso de **Reflection y generación dinámica de código**, comparando su rendimiento con un enfoque tradicional. Se incluyen dos implementaciones:

- **WithMetaprogramming/**: Implementa metaprogramación utilizando **Reflection y generación de código en tiempo de ejecución**.
- **WithOutMetaprogramming/**: Implementación manual sin uso de Reflection, para comparar rendimiento y eficiencia.

## Características
- Uso de **System.Reflection** para inspección de clases y métodos en tiempo de ejecución.
- Generación dinámica de métodos utilizando **System.Reflection.Emit**.

## Tecnologías Utilizadas
- **.NET 9.0**
- **C#**
- **System.Reflection y System.Reflection.Emit**
- **BenchmarkDotNet (opcional)** para pruebas de rendimiento

## Estructura del Proyecto
```
Metaprogramming/
│── Metaprogramming.sln
│── WithMetaprogramming/
│   ├── WithMetaprogramming.csproj
│   ├── Program.cs
│   ├── ReflectionHelper.cs
│── WithOutMetaprogramming/
│   ├── WithOutMetaprogramming.csproj
│   ├── Program.cs
```

## Configuración y Ejecución
### 1. Clonar el Repositorio
```sh
git clone https://github.com/usuario/proyecto-metaprogramacion-dotnet.git
cd proyecto-metaprogramacion-dotnet
```

### 2. Construir el Proyecto
```sh
dotnet build
```

### 3. Ejecutar la Versión con Metaprogramación
```sh
dotnet run --project WithMetaprogramming
```

### 4. Ejecutar la Versión sin Metaprogramación
```sh
dotnet run --project WithOutMetaprogramming
```

# 📚 Sistema de Gestión de Biblioteca

Un proyecto educativo en Java para aprender a hacer contribuciones open source mediante pull requests.

## Objetivo del Proyecto

Este proyecto está diseñado específicamente para que estudiantes y principiantes practiquen:
- Hacer fork de repositorios
- Crear ramas (branches)
- Hacer commits
- Crear pull requests
- Trabajar con issues de GitHub
- Colaborar en proyectos de código abierto

## Características

- ✅ Gestión de libros (agregar, buscar, listar)
- ✅ Sistema de préstamos
- ✅ Devolución de libros
- ✅ Interfaz de consola interactiva

## Cómo empezar

### Requisitos previos

- Java JDK 11 o superior
- Git instalado
- Un IDE (IntelliJ IDEA, Eclipse, VS Code)

### Instalación

1. Haz un fork de este repositorio
2. Clona tu fork:
```bash
git clone https://github.com/TU-USUARIO/biblioteca-java.git
cd biblioteca-java
```

3. Compila el proyecto:
```bash
javac -d bin src/com/biblioteca/**/*.java src/com/biblioteca/*.java
```

4. Ejecuta la aplicación:
```bash
java -cp bin com.biblioteca.BibliotecaApp
```

#### Correr en Netbeans

Corre la aplicación en Netbeans abriendo el archivo de BibliotecaApp.java y dándole a Run > Run File.

## Estructura del Proyecto

```
biblioteca-java/
├── src/
│   └── com/biblioteca/
│       ├── BibliotecaApp.java          # Clase principal
│       ├── modelo/
│       │   ├── Libro.java              # Modelo de datos de Libro
│       │   └── Prestamo.java           # Modelo de datos de Préstamo
│       └── servicio/
│           └── BibliotecaServicio.java # Lógica de negocio
├── CONTRIBUTING.md                      # Guía de contribución
└── README.md                           # Este archivo
```

## Cómo Contribuir

¡Todas las contribuciones son bienvenidas! Este proyecto tiene **30 issues** listas para que las trabajes.

1. Lee la [Guía de Contribución](CONTRIBUTING.md)
2. Busca una [issue abierta](../../issues) que te interese
3. Comenta en la issue para que te la asignen
4. Haz tu contribución siguiendo la guía
5. Crea un pull request

### Para principiantes

Busca issues con la etiqueta `good first issue` - ¡son perfectas para empezar! 🌟

## 📖 Funcionalidades del Sistema

### Menú Principal

```
--- MENÚ PRINCIPAL ---
1. Listar todos los libros
2. Agregar nuevo libro
3. Buscar libro
4. Prestar libro
5. Devolver libro
6. Listar préstamos activos
0. Salir
```

## Lo que Aprenderás

Al contribuir a este proyecto, aprenderás:

- ✅ Flujo de trabajo con Git y GitHub
- ✅ Programación orientada a objetos en Java
- ✅ Buenas prácticas de código
- ✅ Trabajo colaborativo
- ✅ Revisión de código
- ✅ Resolución de issues

## 📝 Licencia

Este proyecto es de código abierto y está disponible bajo la Licencia MIT.

## Contacto y Soporte

- ¿Encontraste un bug? [Abre un issue](../../issues/new)
- ¿Tienes una idea? [Compártela en las discusiones](../../discussions)
- ¿Necesitas ayuda? Pregunta en los comentarios de la issue

---

**¿Listo para tu primera contribución?**

[Empieza aquí: Guía de Contribución](CONTRIBUTING.md)

# Questions & Answers API

### About
API para la aplicación de preguntas y respuestas del reto técnico para Bit2Bit.

### Requisites
* [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
* [Maven](https://maven.apache.org/download.cgi)
* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/#section=windows)
* [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

### Check Requisites
Para verificar que se tienen instalados los requisitos, se puede ejecutar el siguiente comando en la terminal:
```bash
java -version
mvn -version
```

### Database Configuration
Para configurar la base de datos, se debe crear una base de datos en MySQL Workbench con el nombre `qa` y modificar el archivo `application.properties` con los datos de conexión a la base de datos.

## Run Project
Para correr el proyecto se debe ejecutar el siguiente comando:
```bash
mvn spring-boot:run
```

### Swagger
Para ver la documentación de la API se puede acceder a la siguiente URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


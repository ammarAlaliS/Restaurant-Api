# Usa una imagen base de OpenJDK para Java 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY build/libs/*.jar app.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 6060
# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]

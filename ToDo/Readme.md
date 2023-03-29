Ez az alkalmazás a Glassfish alkalmazásszerveren fut
Az alkalmazásunk lebildelése mavennel (a JAR állomány elkészítése):
```shell
mvn clean package 
```

Alkalmazás deploy:
```shell
java -jar payara-5.48.1.jar --deploy C:\H\ujratervez2021\SEJavaRaepulo\java-EE-projects\ToDo\target\todo.war --port 8080
```
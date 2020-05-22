# ****************************************************************
# Commands to build and run ( Execute it in the shell )
# ****************************************************************
#   JAVA_HOME=$(dirname $( readlink -f $(which java) )) &&
#   JAVA_HOME=$(realpath "$JAVA_HOME"/../) &&
#   export JAVA_HOME &&
#   mvn clean &&
#   ./mvnw install &&
#   docker build -t preauthorization . &&
#   docker run -p 8888:8888 preauthorization
#*****************************************************************

# In this case we are using .jar insted of .war

FROM openjdk:12-alpine
COPY target/PreAuthorization-1.0.0-SNAPSHOT-fat.jar /preauthorization.jar
CMD ["java", "-jar", "/preauthorization.jar"]
ENTRYPOINT [ "sh", "-c", "java -jar preauthorization.jar" ]

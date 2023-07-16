
mvn clean install -DskipTests

docker build -f Docker/Dockerfile --build-arg JAR_FILE=target/*.jar -t jeremyqzt/ribbon-notif .

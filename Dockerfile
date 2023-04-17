#### Stage 1: Build the application
FROM eclipse-temurin:11-jdk-centos7 as build

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Set permission to execute file
RUN chmod +x mvnw

# Prepare and install dos2unix to make gradlew file accessible
RUN yum update -y && yum install -y dos2unix
RUN dos2unix mvnw

RUN yum update -y
RUN yum install -y curl

# Copy the project source
COPY src src

COPY scripts/wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh && dos2unix wait-for-it.sh

COPY scripts/start.sh start.sh
RUN chmod +x start.sh && dos2unix start.sh

# Package the application
RUN ./mvnw package -Pdev -DskipTests

#### Stage 2: A minimal docker image with command to run the app
FROM eclipse-temurin:11-jdk-centos7

# Set the current working directory inside the image
WORKDIR /app

COPY --from=build /app/wait-for-it.sh ./wait-for-it.sh
COPY --from=build /app/start.sh ./start.sh
COPY --from=build /app/target/sequencing-runs-service*.jar ./app.jar

ENTRYPOINT ["./start.sh"]
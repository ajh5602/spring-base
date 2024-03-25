FROM eclipse-temurin:17-jre-alpine as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder build/libs/*.jar /app.jar

ENV TZ Asia/Seoul

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app.jar"]

# docker build -t spring-java-api:latest . -f ./docker/dev.Dockerfile
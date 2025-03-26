# Этап 1: Сборка JAR файла
FROM gradle:8.13-jdk21 AS build
## Скопировать необходимые файлы и модули
COPY . /build

WORKDIR /build
## Сборка JAR файла
RUN gradle clean bootJar

## Этап 2: Старт JAR файла
FROM openjdk:21-jdk-slim

WORKDIR /app
## Копирование JAR файла
COPY --from=build /build/manager_bot/build/libs/manager_bot-*.jar app.jar
## Запуск приложения
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "./app.jar"]

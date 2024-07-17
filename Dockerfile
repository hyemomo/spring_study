FROM openjdk:22
CMD ["./gradlew", "clean", "build"]
ARG JAR_FILE_PATH=build/libs/*.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
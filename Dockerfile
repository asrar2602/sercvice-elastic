FROM gradle:8-jdk17 as build
WORKDIR /app
COPY . .
RUN ./gradlew build --stacktrace

FROM openjdk
WORKDIR /app
EXPOSE 80
COPY --from=build /app/build/libs/search-service-0.0.1-SNAPSHOT.jar .
CMD java -jar search-service-0.0.1-SNAPSHOT.jar
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY build/libs/pg-server.jar app.jar

ENV TZ=Asia/Seoul

EXPOSE 8090

ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]
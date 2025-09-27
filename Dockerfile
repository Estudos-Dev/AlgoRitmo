FROM amazoncorretto:21-alpine

ENV TZ="America/Sao_Paulo"

RUN mkdir /app

COPY /build/libs*.jar /app/algoritmo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/algoritmo.jar"]
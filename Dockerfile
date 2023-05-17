FROM openjdk:17-jdk-alpine

WORKDIR /MeasurementConversionAPP

RUN apk add --no-cache maven

COPY . /MeasurementConversionAPP

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "target/MeasurementConversion-0.0.1.jar"]
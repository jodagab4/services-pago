FROM openjdk:13
VOLUME /tmp
EXPOSE 8806
ADD ./target/services-pago-0.0.1-SNAPSHOT.jar service-pago.jar
ENTRYPOINT  ["java","-jar","/service-pago.jar"]
FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-ubuntu

WORKDIR /carina-demo

FROM maven
COPY pom.xml ./
RUN mvn dependency:resolve

COPY src ./src

CMD [ "mvn", "test", "-Dsuite=${SUITE_NAME}" ]
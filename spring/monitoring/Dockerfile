FROM bellsoft/liberica-openjre-alpine:21
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /application/application.jar
# https://www.baeldung.com/properties-with-spring
ENTRYPOINT ["java","-jar","/application/application.jar","--spring.config.location=/application/configuration/application.yml"]
FROM openjdk:8
WORKDIR /home/app/micronaut
COPY target/Bachelorarbeit_Micronaut-0.1.jar /home/app/micronaut/build/app.jar
COPY src/main/java/resources/logback.xml /home/app/micronaut/build
#RUN java -jar build/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","build/app.jar", "--logging.config=","build/logback.xml"]
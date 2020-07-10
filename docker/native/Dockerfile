FROM oracle/graalvm-ce:latest as builder
RUN gu install native-image
COPY target/Bachelorarbeit_Micronaut-0.1.jar /home/app/micronaut/build/app.jar
COPY src/main/resources/META-INF/native-image/com/example/Bachelorarbeit_Micronaut/reflectionconfig.json /home/app/micronaut
COPY src/main/resources/META-INF/native-image/com/example/Bachelorarbeit_Micronaut/reflect-config.json /home/app/micronaut
COPY src/main/resources/META-INF/native-image/com/example/Bachelorarbeit_Micronaut/proxy-config.json /home/app/micronaut
COPY src/main/resources/META-INF/native-image/com/example/Bachelorarbeit_Micronaut/resource-config.json /home/app/micronaut
COPY src/main/resources/META-INF/native-image/com/example/Bachelorarbeit_Micronaut/resourceconfig.json /home/app/micronaut
WORKDIR /home/app/micronaut
RUN native-image -jar build/app.jar
EXPOSE 8080
ENTRYPOINT ["./micronaut"]
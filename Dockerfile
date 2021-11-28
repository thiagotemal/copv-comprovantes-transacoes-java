FROM openjdk:11


COPY /target/*.jar /usr/app/copv-comprovantes-transacoes-java.jar
COPY target/classes/logback-spring.xml /usr/app/

COPY target/classes/*.properties /usr/app/

ENV profile="prd"
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${profile}","-Duser.timezone=America/Sao_Paulo", "-jar", "/usr/app/copv-comprovantes-transacoes-java.jar"]

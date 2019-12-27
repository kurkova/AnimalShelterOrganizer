FROM openjdk:8u232-jdk-stretch
ADD target/animal_shelter-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar animal_shelter-0.0.1-SNAPSHOT.jar
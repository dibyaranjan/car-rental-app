FROM java:8
MAINTAINER Dibya Ranjan <dibyaranjanpanda@gmail.com>

WORKDIR /
ADD target/app-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java -jar app.jar

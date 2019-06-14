FROM openjdk:8-alpine

MAINTAINER lprakashv

VOLUME /tmp

EXPOSE 8080

ADD ./build/libs/blog-0.0.1-SNAPSHOT.jar blog-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","blog-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod", "--error"]
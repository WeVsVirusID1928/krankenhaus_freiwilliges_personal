FROM openjdk:11-jdk-slim-sid

WORKDIR /var/opt

RUN apt-get update && apt-get install -y

COPY target/krankenperso-1.0-SNAPSHOT.jar /var/opt/krankenperso.jar
COPY docker/init.sh /var/opt/init.sh

EXPOSE 8443

USER nobody

CMD ["./init.sh"]

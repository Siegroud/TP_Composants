FROM openjdk:17-alpine

# [LABELS]
LABEL maintainer="Bosquet Valadier"
LABEL description="Service contenant les memes"

#[EV]

ENV SERVER_PORT=8080

#[ARGS]
ARG JAR_FILE=target/TP_Composants-*.jar

#[USER]
RUN  addgroup --system user \
     && adduser --system --ingroup user user

USER user

#[Actions]
WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

#[Ports]
EXPOSE ${SERVER_PORT}

#[Entry Point]
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "app.jar"]
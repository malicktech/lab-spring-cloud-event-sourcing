FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    APP_SLEEP=20 \
    JAVA_OPTS="-Xmx512m -Xms256m"

ARG JAR_FILE

CMD echo "The application will start in ${APP_SLEEP}s..." && \
    sleep ${APP_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar

ADD ${JAR_FILE} app.jar

FROM docker.io/library/openjdk:21-jdk

COPY jvm-stats/target/jvm-stats.jar /app/jvm-stats.jar

EXPOSE 8081

ENTRYPOINT ["java"]
FROM docker.io/library/openjdk:21-jdk

COPY JvmStatisticsInfo.java /app/JvmStatisticsInfo.java

ENTRYPOINT ["java"]
FROM centos
USER root
RUN yum -y install java-1.8.0-openjdk
ADD target/vagabond-core.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
EXPOSE 1337
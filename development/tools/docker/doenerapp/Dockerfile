ARG DOCKER_REPO_URL=reposrv02nexus3.entwicklung.god.de:5000
FROM $DOCKER_REPO_URL/god/websphere-liberty-vw:2.1

#FROM reposrv02nexus3.entwicklung.god.de:5000/godmbh/ojdk18ansible/ojdk18ansible
#RUN echo 'Acquire::http::Proxy "http://proxy.god.de:3142/";'> /etc/apt/apt.conf.d/02proxy
# RUN apt-get update
# RUN apt-get install -y oracle-java8-jdk
# RUN apt-get install -y netcat
# RUN apt-get install -y curl
# RUN apt-get install -y less
# RUN apt-get install -y lsof
# RUN apt-get install -y procps
#RUN yum -y update
RUN yum install -y nc
RUN yum install -y curl
RUN yum install -y less
RUN yum install -y lsof
RUN yum install -y procps



# Install dependencies 
COPY god-doener*.jar /usr/share/doener/god-doener.jar
#no npm app...
RUN unset http_proxy

CMD ["/usr/bin/java", "-jar", "/usr/share/doener/god-doener.jar"]
EXPOSE 8080
#CMD ["/bin/sleep", "999"]

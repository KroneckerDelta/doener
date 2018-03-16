FROM reposrv02nexus3.entwicklung.god.de:5000/godmbh/ojdk18ansible/ojdk18ansible
RUN echo 'Acquire::http::Proxy "http://proxy.god.de:3142/";'> /etc/apt/apt.conf.d/02proxy
RUN apt-get update
RUN apt-get install -y oracle-java8-jdk
RUN apt-get install -y netcat
RUN apt-get install -y curl
RUN apt-get install -y lsof
RUN apt-get install -y procps
RUN unset http_proxy

# Install dependencies 
COPY god-doener*.jar /usr/share/doener/god-doener.jar
#no npm app...
CMD ["/usr/bin/java", "-jar", "/usr/share/doener/god-doener.jar"]
EXPOSE 8080
#CMD ["/bin/sleep", "999"]

FROM reposrv02nexus3.entwicklung.god.de:5000/debian/stretch/ansible-and-godrepo
RUN echo 'Acquire::http::Proxy "http://proxy.god.de:3142/";'> /etc/apt/apt.conf.d/02proxy
RUN apt-get update
RUN apt-get install -y oracle-java8-jdk
# Install dependencies 
COPY god-doener-0.1.0.jar /usr/share/doener/
#no npm app...
CMD ["/usr/bin/java", "-jar", "/usr/share/doener/god-doener-0.1.0.jar"]
EXPOSE 8080
#CMD ["/bin/sleep", "999"]

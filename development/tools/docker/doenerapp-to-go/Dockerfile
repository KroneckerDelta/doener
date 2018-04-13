FROM reposrv02nexus3.entwicklung.god.de:5000/debian/stretch/ansible-and-godrepo 



#transport via env to ansible
ARG MYDATABASE=god_doener
ENV MYDATABASE=$MYDATABASE
ARG MYSQLUSER=schoener
ENV MYSQLUSER=$MYSQLUSER
ARG MYSQLUSERPWD=schoener
ENV MYSQLUSERPWD=$MYSQLUSERPWD
###############################
COPY ansible/ /media/ansible
COPY god-doener*.jar /usr/share/doener/god-doener.jar

RUN echo runinng
RUN ansible-playbook -i "local," /media/ansible/mariadb.yml --connection=local
EXPOSE 3306
EXPOSE 8080


RUN java -version	
CMD ["/media/ansible/start.sh"]

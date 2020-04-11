FROM mysql:5.7.29
LABEL maintainer="cemp2703@gmail.com"
#WORKDIR /workspace
#Podemos usar ADD o COPY
#ADD scripts/DDL.sql /docker-entrypoint-initdb.d/DDL.sql
ENV MYSQL_ROOT_PASSWORD=12345678
ENV MYSQL_DATABASE=demobd
ENV MYSQL_ROOT_HOST=%

COPY ./scripts/ /docker-entrypoint-initdb.d/
CMD ["--default-authentication-plugin=mysql_native_password"]
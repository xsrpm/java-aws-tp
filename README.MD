Pasos ejecutados:

1.- PROBANDO APIS LOCALMENTE

cd aplicativo/compose-sin-dockerize
ó
cd aplicativo/compose-con-dockerize

docker-compose build
docker-compose up -d

Ingresar a la bd (cliente mysql):
localhost:3310

docker-compose ps

Ingresar a las apis (browser):
http://localhost:8081/status/verificar
http://localhost:8081/api/personas/listar
http://localhost:8082/status/verificar
http://localhost:8082/api/preferencias/listar

2.-

Iniciando proyecto angular

Requiere: 
nodejs > 10
angular
angular material

https://tecadmin.net/install-angular-on-ubuntu/
https://material.angular.io/guide/getting-started

IDE: Visual Studio Code
Extensiones:
 - Angular Language Service by Angular
 - Angular Snippets (Version 9) by John Papa

 https://code.visualstudio.com/docs/?dv=linux64_deb

 Pasos:
 cd aplicativo/angular
 npm install
 ng s
 http://localhost:4200


3- Subiendo a la nube

login en dockerhub
docker login

Enviando imagenes a dockerhub

cd cloudformation
docker-compose push

Cargando stacks de cloudformation en orden:
1-infraestructura.json
2-security-groups.json
3-a-bastion.json
4-basedatos.json

Carga de scripts de base de datos en RDS

#Ingresando a carpeta de scripts
cd aplicativo/basedatos/scripts

#copiando scrips DDL.sql y DML.sql a ec2-bastion
scp -i "kp_cesar_ohio.pem" DDL.sql ec2-user@ec2-18-221-43-189.us-east-2.compute.amazonaws.com:/tmp
scp -i "kp_cesar_ohio.pem" DML.sql ec2-user@ec2-18-221-43-189.us-east-2.compute.amazonaws.com:/tmp

#Ingresando a bastion
ssh -i "kp_cesar_ohio.pem" ec2-user@ec2-3-21-207-183.us-east-2.compute.amazonaws.com

#Instalando mysql
sudo yum install mysql -y

#Ingresando a base de datos en RDS
mysql -h demobd.c9eaxdedlyrv.us-east-2.rds.amazonaws.com -u root -p

#Cargando los scripts en base de datos RDS
source /tmp/DDL.sql
source /tmp/DML.sql


Cargando stacks de cloudformation en orden:

6-balanceador.json
7-apis.json

4 - Apuntando frontend a balanceador en la nube

#En archivo:
cd aplicativo/angular/src/environments/environments.ts












Anexos:
1- How to pull layers one by one in Docker to avoid connection timeout?

Please follow the step if docker running already Ubuntu:

sudo service docker stop
sudo dockerd --max-concurrent-downloads 1

Download your images after that stop this terminal and start the daemon again as it was earlier.

sudo service docker start

https://stackoverflow.com/questions/41303784/how-to-pull-layers-one-by-one-in-docker-to-avoid-connection-timeout


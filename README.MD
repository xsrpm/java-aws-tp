
# Proyecto Angular/Java Spring - Docker / AWS (VPC,SG,RDS,EC2-Docker,ALB).

Despliegue de proyecto en la nube de AWS.

## 1.- PROBANDO APIS LOCALMENTE
**Directorio con docker-compose.yml**

    cd aplicativo/compose-sin-dockerize

ó

    cd aplicativo/compose-con-dockerize

**Creando imagenes docker**

    docker-compose build
**Levantando contenedores de imagenes**
 
    docker-compose up -d

  
**Ingresar a la bd (cliente mysql):**

    localhost:3310

**Revisando contenedores generados**
  
docker-compose ps

**Ingresar a las apis (browser):**

http://localhost:8081/status/verificar

http://localhost:8081/api/personas/listar

http://localhost:8082/status/verificar

http://localhost:8082/api/preferencias/listar

 
## 2.- Iniciando proyecto angular


### Requiere:

 - nodejs > 10
 - angular
 - angular material

	https://tecadmin.net/install-angular-on-ubuntu/
	https://material.angular.io/guide/getting-started

- IDE: Visual Studio Code
	Extensiones:
	- Angular Language Service by Angular
	- Angular Snippets (Version 9) by John Papa

  

https://code.visualstudio.com/docs/?dv=linux64_deb

### Pasos:
**Directorio con proyecto Angular**

    cd aplicativo/angular

**Descargando dependencias**

    npm install

**Levantando Frontend en Servidor local**

    ng s

**Url de Despliegue**

http://localhost:4200

  
  

## 3- Subiendo a la nube

  

**Login en dockerhub**

    docker login
    
**Enviando imagenes a dockerhub**

    docker-compose push

**Directorio con CloudFormation (AWS)**

      cd cloudformation

**Cargando stacks de cloudformation en orden:**

 - 1-infraestructura.json
 - 2-security-groups.json
 - 3-a-bastion.json
 - 4-basedatos.json

**Carga de scripts de base de datos en RDS**

Ingresando a carpeta de scripts:

    cd aplicativo/basedatos/scripts

copiando scrips DDL.sql y DML.sql a ec2-bastion

    scp -i "kp_cesar_ohio.pem" DDL.sql ec2-user@ec2-18-221-43-189.us-east-2.compute.amazonaws.com:/tmp

    scp -i "kp_cesar_ohio.pem" DML.sql ec2-user@ec2-18-221-43-189.us-east-2.compute.amazonaws.com:/tmp

Ingresando a bastion

    ssh -i "kp_cesar_ohio.pem" ec2-user@ec2-3-21-207-183.us-east-2.compute.amazonaws.com

Instalando mysql

    sudo yum install mysql -y

Ingresando a base de datos en RDS

    mysql -h demobd.c9eaxdedlyrv.us-east-2.rds.amazonaws.com -u root -p

Cargando los scripts en base de datos RDS

    source /tmp/DDL.sql
    source /tmp/DML.sql

**Cargando stacks de cloudformation en orden:**

 - 6-balanceador.json
 - 7-apis.json

  

## 4 - Apuntando frontend a balanceador en la nube

**Variables de entorno:**

    cd aplicativo/angular/src/environments/environments.ts

## Anexos:**

**1- How to pull layers one by one in Docker to avoid connection timeout?**

Please follow the step if docker running already Ubuntu:

    sudo service docker stop
    sudo dockerd --max-concurrent-downloads 1

Download your images after that stop this terminal and start the daemon again as it was earlier.

    sudo service docker start

https://stackoverflow.com/questions/41303784/how-to-pull-layers-one-by-one-in-docker-to-avoid-connection-timeout

## Basado en:

https://github.com/wjma90/taller-docker-swarm
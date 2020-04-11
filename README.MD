Pasos ejecutados:

1.- PROBANDO LOCAL

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













Anexos:
1- How to pull layers one by one in Docker to avoid connection timeout?

Please follow the step if docker running already Ubuntu:

sudo service docker stop
sudo dockerd --max-concurrent-downloads 1

Download your images after that stop this terminal and start the daemon again as it was earlier.

sudo service docker start

https://stackoverflow.com/questions/41303784/how-to-pull-layers-one-by-one-in-docker-to-avoid-connection-timeout


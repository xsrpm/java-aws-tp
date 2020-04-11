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
Ingresar en <port> el puerto efimero asignado al levantar los contenedores:
http://localhost:<port>/status/verificar
http://localhost:<port>/api/persona/listar
http://localhost:<port>/status/verificar
http://localhost:<port>/api/preferencias/listar













Anexos:
1- How to pull layers one by one in Docker to avoid connection timeout?

Please follow the step if docker running already Ubuntu:

sudo service docker stop
sudo dockerd --max-concurrent-downloads 1

Download your images after that stop this terminal and start the daemon again as it was earlier.

sudo service docker start

https://stackoverflow.com/questions/41303784/how-to-pull-layers-one-by-one-in-docker-to-avoid-connection-timeout


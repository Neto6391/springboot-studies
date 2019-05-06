## Require Tecnologies
1- JAVA JDK 11
2- maven
3- Docker && Docker-compose

## Instructions For Run Containers in Docker

1- inside in project path
2- docker-compose up --build
3- execute in path root project 'mvn flyway:migrate'
4- execute in path root 'mvn clean package spring-boot:run'
5- Solve Fix Bug, if you use phpmyadmin

## Bug Container PHPMYADMIN not loging up in root 'user' Fix

1 - docker exec -it db-mysql-app bash
2 - mysql -u root -prestApp
3 - ALTER USER root IDENTIFIED WITH mysql_native_password BY 'restApp';
4 - exit
5 - exit
6 - docker-compose up
#!/bin/sh
echo "Construction du backend..."
cd ../backend
mvn install
docker build -t my-ms:0.1 .

echo "Construction du frontend...\n"
cd ../consumer/web
docker build -t consumer:0.1 .

echo "Démarage du projet.."
cd ../../demo/
docker-compose up

#!/bin/bash

user=$(whoami)
git_host="github.com"

while getopts :b:e:h: arg; do
  case "${arg}" in
  b) branch="--branch ${OPTARG}" ;;
  e) env=${OPTARG};;
  h) git_host=${OPTARG} ;;
  *) ;;
  esac
done

mkdir temp
chown $user temp

cd temp || exit

if [ -d "./portfolio-backend" ]; then
  cd ./portfolio-backend || exit
  git pull --rebase
else
  sudo -u "$user" git clone git@"$git_host":krykra7/portfolio-backend.git $branch
  cd ./portfolio-backend || exit
fi

mvn clean package -DskipTests=true
cd ../..
pwd

if [ "$env" == "prod" ]; then
  docker image rm portfolio-backend:latest
  docker build --build-arg JAR_FILE=./temp/portfolio-backend/target/portfolio-backend.jar -t portfolio-backend:latest -f ./prod/Dockerfile ./
else
  docker image rm portfolio-backend:latest
  docker build --build-arg JAR_FILE=./temp/portfolio-backend/target/portfolio-backend.jar -t portfolio-backend:latest -f ./local/Dockerfile ./
fi

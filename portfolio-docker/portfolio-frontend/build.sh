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

if [ -d "./portfolio-frontend" ]; then
  cd ./portfolio-frontend || exit
  git pull --rebase
else
  sudo -u "$user" git clone git@"$git_host":krykra7/portfolio-frontend.git $branch
  cd ./portfolio-frontend || exit
fi

yarn install && yarn build
cd ../..
pwd

if [ "$env" == "prod" ]; then
  mkdir ./nginx/prod/dist && cp -R ./temp/portfolio-frontend/dist ./nginx/prod/dist/
  docker image rm portfolio-frontend
  docker build -t portfolio-frontend:latest -f ./nginx/prod/Dockerfile ./nginx/prod/
  rm -rf ./nginx/prod/dist
else
  mkdir ./nginx/local/dist && cp -R ./temp/portfolio-frontend/dist ./nginx/local/dist/
  docker image rm portfolio-frontend
  docker build -t portfolio-frontend:latest -f ./nginx/local/Dockerfile ./nginx/local/
  rm -rf ./nginx/local/dist
fi

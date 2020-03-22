#!/usr/bin/env bash

set -e -o pipefail

function start-postgres()
{
  local compose_file="backend/local/docker-compose-postgresql.yaml"
  docker-compose -p howtohelppeople-postgresql --file ${compose_file} up --build --detach
}


function build-jar()
{
  cd backend
  make package
  cd ..
}
function start-application()
{
echo ${PWD}  
local compose_file_root="docker-compose.yml"
docker-compose -p howtohelppeople-postgresql --file ${compose_file_root} up --build --detach
}
start-postgres
build-jar
start-application

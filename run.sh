#!/usr/bin/env bash

set -e -o pipefail


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
docker-compose -p howtohelppeople --file ${compose_file_root} up --build --detach --force-recreate
}
build-jar
start-application

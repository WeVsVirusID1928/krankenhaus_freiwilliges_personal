#!/usr/bin/env bash

set -e -o pipefail

function check-dependencies()
{
  sudo apt update && sudo apt install -y cron openjdk-8-jdk
  mvn --version || curl -f -o /opt/maven.tar.gz http://mirror.netcologne.de/apache.org/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz &&\
    [ $(md5sum /opt/maven.tar.gz | cut -d' ' -f1) = "89eea39183139e5f8a0c1601d495b3b6" ] && \
    tar xzf /opt/maven.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.5.4/bin/mvn /usr/bin
  java --version || curl -f https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz -o /tmp/openjdk-11+28_linux-x64_bin.tar.gz && \
    [ $(md5sum  /tmp/openjdk-11+28_linux-x64_bin.tar.gz | cut -d' ' -f1) = "ede2734bdadffa4c26f1db8df2d48fdc" ] && \
    tar xfvz /tmp/openjdk-11+28_linux-x64_bin.tar.gz --directory /usr/lib/jvm && \
    rm -f /tmp/openjdk-11+28_linux-x64_bin.tar.gz
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
docker-compose -p howtohelppeople --file ${compose_file_root} up --build --detach --force-recreate
}
check-dependencies
build-jar
start-application

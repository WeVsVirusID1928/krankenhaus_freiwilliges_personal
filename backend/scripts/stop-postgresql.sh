#!/usr/bin/env bash

set -e -o pipefail

function main() {
  local compose_file="local/docker-compose-postgresql.yaml"
  docker-compose -p howtohelppeople-postgresql --file ${compose_file} down
}

PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/../"
pushd "${PROJECT_DIR}" > /dev/null
  source "scripts/lib.sh"
  main
popd > /dev/null

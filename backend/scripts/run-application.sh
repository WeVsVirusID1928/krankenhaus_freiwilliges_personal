#!/usr/bin/env bash

set -e -o pipefail

function main() {
  SPRING_PROFILES_ACTIVE=$1

  SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE} \
  run_maven spring-boot:run
}

PROJECT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/../"
pushd "${PROJECT_DIR}" > /dev/null
  source "scripts/lib.sh"
  main $1
popd > /dev/null

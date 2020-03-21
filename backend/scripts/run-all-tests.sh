#!/usr/bin/env bash
set -e -o pipefail

function main() {
cd backend  
run_maven test 
}

pushd "${PROJECT_DIR}" > /dev/null
  source ${PWD}"/backend/scripts/lib.sh"
  main
popd > /dev/null

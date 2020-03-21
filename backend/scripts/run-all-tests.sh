#!/usr/bin/env bash
set -e -o pipefail

function main() {
run_maven test 
}

pushd "${PROJECT_DIR}" > /dev/null
  source "scripts/lib.sh"
  main
popd > /dev/null

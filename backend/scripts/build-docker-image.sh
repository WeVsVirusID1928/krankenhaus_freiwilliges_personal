#!/usr/bin/env bash
set -e -o pipefail

docker build . -t krankenperso:latest

#!/usr/bin/env bash

function run_maven() {
  mvn $@
}

function log() {
  echo $1 >&2
}

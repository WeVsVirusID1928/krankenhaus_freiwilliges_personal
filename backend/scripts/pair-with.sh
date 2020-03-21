#!/bin/bash

set -eu -o pipefail

_find_pair() {
  local name="$1"

  if [ -n "${name}" ] ; then
    cat <<EOF |grep -i "${name}" | head -1
Philipp Ludewig <diesdas@philippludewig.de>

EOF
  else
    echo "tbd"
  fi
}

_format_issue() {
  local issue="$1"
  local jira_board="KP"

  if [ -z "${issue}" ] ; then
    echo "${jira_board}-???"
  elif [[ "${issue}" = *${jira_board}* ]] ; then
    echo "${issue}"
  else
    echo "${jira_board}-${issue}"
  fi
}

_create_git_message() {
  local pair="$1"
  local issue="$2"

  echo "subject"
  echo
  echo "some context/description"
  if [ -n "${issue}" ] ; then
    echo
    echo "Addresses ${issue}"
  fi
  if [ -n "${pair}" ] ; then
    echo
    echo
    echo "Co-authored-by: ${pair}"
  fi
}

_main() {
  local name="$1"
  local issue="$2"
  issue=$(_format_issue "${issue}")

  if [ -z "${LONELY}" ] ; then
    pair=$(_find_pair "${name}")
  else
    pair=""
  fi

  if [ -z "${DRY_RUN}" ] ; then
    _create_git_message "${pair}" "${issue}" > ./.git/.gitmessage.txt
    git config commit.template "$PWD/.git/.gitmessage.txt"
  else
    _create_git_message "${pair}" "${issue}"
  fi
}

_usage() {
  cat <<EOF
Usage: $0 [-n] [-p <partial pair name>] [-l] [-i <issue-number>]

Options:
  -i <issue number>		The JIRA issue number
  -p <partial pair name>	Part of the pair name
  -l				lonely - you don't have a pair :'-/
  -n				dry run - only print template


This will create a file .git/.gitmessage.txt and set commit.template option to it.

EOF
  exit 1
}

PAIR=
ISSUE=
DRY_RUN=
LONELY=

while getopts "hi:np:l" opt; do
  case "${opt}" in
    h) _usage ;;
    p) PAIR="${OPTARG}" ;;
    i) ISSUE="${OPTARG}" ;;
    n) DRY_RUN=1 ;;
    l) LONELY=1 ;;
    *) _usage ;;
  esac
done
shift $((OPTIND-1))

if [ ! -d ./.git ] ; then
  echo "This is not a git directory!" 1>&1
  _usage
fi

_main "${PAIR}" "${ISSUE}"

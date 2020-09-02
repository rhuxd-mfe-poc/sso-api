#!/usr/bin/env bash

DIR=$(dirname "$0")
source ${DIR}/common/logger.sh
source ${DIR}/common/util.sh

usage() {
  log-info "Usage: $(basename $0) [deploy|undeploy]"
  exit 1
}

APP_NAME=${APP_NAME:-mfe-poc}
DEPLOYMENT_NAME=sso-api

NAMESPACE=${NAMESPACE}
if [ -z "${NAMESPACE}" ]; then
  log-err "You have to set NAMESPACE environment variable"
  exit 1
fi

deploy() {
  dd-oc new-app quay.io/quarkus/ubi-quarkus-native-s2i:19.3.1-java11~https://github.com/rhuxd-mfe-poc/sso-api.git --name=${DEPLOYMENT_NAME}
  oc expose svc/${DEPLOYMENT_NAME}
  dd-oc label deployment ${DEPLOYMENT_NAME} app.kubernetes.io/part-of=${APP_NAME} --overwrite=true
  dd-oc label deployment ${DEPLOYMENT_NAME} app.openshift.io/runtime=java --overwrite=true
}

undeploy() {
    dd-oc delete all --selector app=${DEPLOYMENT_NAME}
}

# execute
case $1 in
  deploy)
    deploy
  ;;
  undeploy)
    undeploy
  ;;
  *)
    usage
  ;;
esac

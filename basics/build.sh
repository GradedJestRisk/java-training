#!/usr/bin/env bash

# read application name from settings.gradle
#TMP=$(awk -v FS="rootProject.name = " 'NF>1{print $2}' settings.gradle)
#APPLICATION_NAME="${TMP:1:-1}"
#export APPLICATION_NAME

export APPLICATION_NAME=hello-world-java-gardle

export VERSION=latest
export COMPILE_IMAGE=gradle:8-jdk21-alpine
export EXECUTE_IMAGE=bellsoft/liberica-openjre-alpine:21
export BUILD_CONTEXT=.

# Remove all intermediate layers and final image
# docker image remove $APPLICATION_NAME:$VERSION
# docker builder prune --all --force

echo "rootProject.name = '$APPLICATION_NAME'" > settings.gradle


docker build \
  --build-arg APPLICATION_NAME \
  --build-arg COMPILE_IMAGE \
  --build-arg EXECUTE_IMAGE \
  --tag $APPLICATION_NAME:$VERSION \
  --file=./Dockerfile \
  $BUILD_CONTEXT


docker image ls $APPLICATION_NAME:$VERSION

# To inspect the compiled image
#
# - you can skip run image in Dockerfile
# docker run --interactive --tty  hello-world:latest sh
#
# - you can run the intermediate image
#docker history $APPLICATION_NAME:$VERSION
# docker run --interactive --tty $IMAGE_ID sh
# https://windsock.io/explaining-docker-image-ids/
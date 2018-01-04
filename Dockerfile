FROM alpine:3.5
MAINTAINER level11.com

RUN apk add --update --no-cache openjdk8-jre && rm -rf /var/cache/apk/*
COPY target/*.jar /bin
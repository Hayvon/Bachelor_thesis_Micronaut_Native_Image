#!/bin/sh
cd ../../
docker build -f docker/native/Dockerfile . -t micronaut_bachelorarbeit
docker run --name micronaut_bachelorarbeit -v C:/dockerVolume:/mnt -p 8080:8080 micronaut_bachelorarbeit
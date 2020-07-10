#!/bin/sh
cd ../../
docker build -f docker/app/Dockerfile . -t micronaut
docker run --name Bachelorarbeit_Micronaut -v C:/dockerVolume:/mnt -p 8080:8080 micronaut
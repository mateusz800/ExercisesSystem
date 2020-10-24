#!/bin/bash
mkdir docker/dist

# build userMicorservice
cd userMicroservice
../gradlew build -x test
cd ..
cp ./userMicroservice/build/libs/userMicroservice-1.0.jar ./docker/dist
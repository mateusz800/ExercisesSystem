#!/bin/bash
mkdir docker/dist

# build userMicorservice
cd userMicroservice
../gradlew build -x test
cd ..
cp ./userMicroservice/build/libs/userMicroservice-0.0.1-SNAPSHOT.jar ./docker/dist
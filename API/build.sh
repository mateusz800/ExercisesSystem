#!/bin/bash
mkdir docker/dist

# build userMicroservice
cd userMicroservice
../gradlew build -x test
cd ..
cp ./userMicroservice/build/libs/userMicroservice-1.0.jar ./docker/dist

# build teacherMicroservice
cd teacherMicroservice
../gradlew build -x test
cd ..
cp ./teacherMicroservice/build/libs/teacherMicroservice-1.0.jar ./docker/dist
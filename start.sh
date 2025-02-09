#!/bin/bash

./gradlew clean build

cd build/libs

java -jar ATM-0.0.1-SNAPSHOT.jar login Dulip


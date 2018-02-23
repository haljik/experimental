#!/usr/bin/env bash
pushd ./apache-tomcat-8.5.28

./bin/shutdown.sh

pushd ./webapps

rm -rf demo*

popd

popd


./gradlew clean build

cp ./build/libs/*.war ./apache-tomcat-8.5.28/webapps


pushd ./apache-tomcat-8.5.28
export JPDA_SUSPEND=y
export JPDA_ADDRESS=8000
./bin/startup.sh
tail -f ./logs/catalina.out
popd


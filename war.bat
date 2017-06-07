cd ftisp-web
call fis3 install
cd ../ftisp-web/src/main/webapp
git clean -df
cd ../../../../ftisp-front
call fis3 release prod -d ../ftisp-web/src/main/webapp
cd ../ftisp-web
call mvn clean install -Dmaven.test.skip=true -Dautoconfig.userProperties=dev.properties
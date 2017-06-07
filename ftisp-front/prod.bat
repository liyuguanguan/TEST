call fis3 install
cd ../ftisp-web/src/main/webapp
git clean -df
cd ../../../../ftisp-front
fis3 release prod -d ../ftisp-web/src/main/webapp -Lwc

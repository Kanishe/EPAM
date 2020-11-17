#!/bin/bash

 docker ps --filter "name=^selenoid$" --format '{{.Ports}}'
 if [ $? -eq 0 ]
  then
  echo "Selenoid is already running"
  exit 666
  else
  	open --background -a Docker
  	sleep 40
  	echo "Docker is start"
  	curl -s https://aerokube.com/cm/bash | bash \
  	&& cm selenoid start --vnc
  	echo "selenoid is start"
  	cm selenoid-ui start
  	cd /Users/alexandrkanishevskii/IdeaProjects/EPAM/
  	mvn test
  	echo "Test EPAM finish"
  	fi
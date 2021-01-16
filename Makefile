maven-build:
	mvn clean package
build: maven-build
	docker-compose build
up: build
	docker-compose up

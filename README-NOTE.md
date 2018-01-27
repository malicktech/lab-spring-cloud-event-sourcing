

# ressource

* docker maven
https://github.com/spotify/dockerfile-maven

* Spring Cloud reference application for building an online store as microservices that use event sourcing
http://www.kennybastani.com/2016/04/event-sourcing-microservices-spring-cloud.html
https://github.com/kbastani/spring-cloud-event-sourcing-example


# Development > manuel
mvn -Pdevelop

# Developement > manual start

0. clean
> docker-compose rm -f

* powershell
> docker rm $(docker ps -qa --no-trunc --filter "status=exited")
> docker rmi $(docker images -f "dangling=true" -q)


1. Build docker
> mvn clean package -DskipTests

2. Start the config service first and wait for it to become available
> docker-compose up -d config-service

3. Start the discovery service next and wait
> docker-compose up -d discovery-service

4. Start the database service next and wait
> docker-compose up -d mysql redis neo4j

5. Start the other containers
> docker-compose up -d user
> docker-compose up -d

6. Attach to the log output of the cluster
> docker-compose logs


# docker

* Deploy 

> docker login
(citizendiop/aqwzsx123)

> docker push citizendiop/config-service:latest && docker push citizendiop/discovery-service:latest
> docker push citizendiop/online-store-web:latest && docker push citizendiop/edge-service:latest
> docker push citizendiop/account-service:latest && docker push citizendiop/user-service:latest

> docker push citizendiop/catalog-service:latest && docker push citizendiop/inventory-service:latest
> docker push citizendiop/shopping-cart-service:latest && docker push citizendiop/order-service:latest

> mvn deploy




# Windows 10
Failed to execute goal com.spotify:docker-maven-plugin:0.3.258:build (default) on project inventory-service

https://github.com/kbastani/spring-cloud-microservice-example/issues/35

solved by updating the docker.plugin.version to 0.4.13.

or 

change to docker-maven

or 
https://github.com/openanalytics/shinyproxy/issues/25
You may also have to have to set cert-path to avoid certificate resolution errors.
Alternatively, you can use plain http via port 2375, but you have to enable this explicitly in docker-for-windows: settings > general > expose daemon on tcp
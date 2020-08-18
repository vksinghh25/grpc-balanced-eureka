# grpc-balanced-eureka
Find GRPC service using Netflix Eureka Server

## Run this locally 

### Modfify **/private/etc/hosts** file on Mac to have the following entries. 

> 127.0.0.1       peer-1-eureka-server.com

> 127.0.0.1       peer-2-eureka-server.com

> 127.0.0.1       peer-3-eureka-server.com

### Build and Run Eureka Server

>mvn clean install 

> java -jar -Dspring.profiles.active=peer-1 target/eurekaserver-0.0.1-SNAPSHOT.jar

> java -jar -Dspring.profiles.active=peer-2 target/eurekaserver-0.0.1-SNAPSHOT.jar

> java -jar -Dspring.profiles.active=peer-3 target/eurekaserver-0.0.1-SNAPSHOT.jar

### Build and Run Hello Service

>mvn clean install

> java -jar -Dspring.profiles.active=hello-service-1 target/hello-service-0.0.1-SNAPSHOT.jar

> java -jar -Dspring.profiles.active=hello-service-2 target/hello-service-0.0.1-SNAPSHOT.jar

> java -jar -Dspring.profiles.active=hello-service-3 target/hello-service-0.0.1-SNAPSHOT.jar

### Build and Run Hello Service Client from IntelliJ or command line

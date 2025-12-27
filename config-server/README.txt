# Run multiple instances

- Go to the directory where pom.xml is present
D:\spring-mircoservices-apps\config-server

- Server Instances

# Server 1
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=8888"

# Server 2
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=8889"

# Server 3
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=8890"
# Run multiple instances

- Go to the directory where pom.xml is present
D:\spring-mircoservices-apps\test-service

- Server Instances

# Server 1
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=1000"

# Server 2
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=1001"

# Server 3
.\mvnw spring-boot:run -D"spring-boot.run.arguments=--server.port=1000"
# NOTES

<details>
<summary>DISCOVERY SERVER</summary>

> Definition

- It is the **central registry** for locating the microservices
- All the microservices with **dynamically** registers to service discovery
- It helps microservices to **communicate** with each other by locating it
- It can also scan other service discoveries
- It uses heart-beat mechanism to identify the eureka clients status

> Types

- Client Side Service Discovery
    - In this type, service discovery is responsible for locating service, find instance and send client request
      directly to instance
    - It is really useful for internal service to service communication
    - It works well within the infrastructure or internally
    - <u>Advantage</u>: Decentralized approach, Low Latency, Better control
    - <u>Disadvantage</u>: Adds more complexity
    - Example Netflix Eureka, Consul, Apache Zookeeper, ETCD
      <br><br>
- Server Side Service Discovery
    - In this type, service discovery is responsible for locating service, forward to load balancer and load balancer
      will find instance and send client request to instance
    - It is useful where security and external configuration matters
    - It works well outside the infrastructure or externally
    - <u>Advantage</u>: Easy to manage, centralized approach
    - <u>Disadvantage</u>: SPOF, Increases latency
    - Example: Kubernetes Service, AWS Elastic Load Balancer
      <br><br>
- Load Balancers:
    - Popular load balancers installed and managed on server are NGINX, HAProxy

> Good Practices

- As this can become Single Point Of Failure [SPOF], as a good practice we must create 3 instances for scaled systems
- If the load it very high, the best we can increase instance up to 5

</details>
<br>

<details>
<summary>GATEWAY</summary>

> Definition

- It is the **central entrypoint** to all our microservices
- It has in-built load balancer for distributing the traffic
- It has **PRE & POST filters** to modify the request. i.e. modify header, url rewrite, validate token etc..
- It performs following activities
    - Request Validation
    - Logging
    - Routing / Re-writing
    - Rate Limiting
    - Security
    - Authentication / Authorization

</details>
<br>

<details>
<summary>CLOUD CONFIG SERVER</summary>

> Definition

- It is the centralized configuration for loading application configuration
- Different environment can be setup per application

> Advantage

- Externalise configuration for reading application configuration that too securely

> Good Practice

- Good to register with discovery service
- Minimum 2 instances are required for high availability and resilience

<summary>CLOUD BUS</summary>

> Definition

- It is used pushing all dynamic properties updates to all apps configured in config server
- It uses rabbitmq and actuator to refresh the properties dynamically

</details>
<br>

<details>
<summary>ACTUATOR</summary>

> Definition

- To monitor the application, actuator endpoints are provided
- It can provided statistics for analysis
- It can monitor health, provide info etc.

> Good Practices

- Enable only required endpoints for effectiveness else it will create load on startup

</details>
<br>

<details>
<summary>PROFILING</summary>

> Definition

- It is designed to manage the configuration based on environment
- It will work on **'default'** profile, if not set

> Good Practices

- Always create environment based configuration for testing, debugging

</details>
<br>

<details>
<summary>SPRING DATA</summary>

> Definition

- It is the rich layer build on top of jpa
- It internally uses **hibernate** as implementation but can be changed

> Advantage

- It provides rich operations for performing query
- Manages the connection pool
- Reduces boiler plate code
- Extensible to write custom query
- Transactional support

> Good Practices

- Use JPA Repository, to get enhanced batch functions for queries

</details>
<br>

<details>
<summary>DEPENDENCY INJECTION</summary>

> Definition

- It is process of injecting the dependencies into the object
- It works on the principle of inversion of control [IOC]
- **Inversion Of Control**: is the principle which specifies the object lifecycle is managed by framework
  rather than manually created by user.

> Types

- Field DI
    - It is the type of injection where dependency will be directly injected via fields

- Constructor DI
    - It is the type of injection where dependency will be injected via constructor
    - All **mandatory** dependencies must be specified here else Exception will be thrown

- Setter Based DI
    - It is the type of injection where dependency will be injected via setter methods
    - Any **optional or conditional** based dependencies must be specified here

> Good Practices

- Always use Constructor DI for mandatory dependencies
- Always use Setter DI for optional or conditional based dependencies

</details>
<br>
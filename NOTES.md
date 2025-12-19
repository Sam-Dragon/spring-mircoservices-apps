# NOTES

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
<summary>DISCOVERY SERVER</summary>

> Definition

- It is the **central registry** for locating the microservices
- All the microservices with **dynamically** registers to service discovery
- It helps microservices to **communicate** with each other by locating it
- It can also scan other service discoveries

> Types

- Client Side Discovery
    - In this type, service discovery is responsible for locating service, find instance and send client request
      directly to instance
    - Example: Netflix Eureka, Consul

- Server Side Discovery
    - In this type, service discovery is responsible for locating service, forward to load balancer and load balancer
      will find instance and send client request to instance
    - Example: Kubernetes Service

> Good Practices

- As this can become Single Point Of Failure [SPOF], as a good practice we must create 3 instances for scaled systems
- If the load it very high, the best we can increase instance up to 5

</details>
<br>
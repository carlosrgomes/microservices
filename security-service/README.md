Security Service
===
Service to handle Authorization token endpoint making it distributed between all services. 

#####Build & Run
```
$ mvn clean install && java -jar target/security-service.jar
```
or
```
$ mvn spring-boot:run
```

#####Using with spring-boot applications
Add the following maven dependencies:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<!-- Spring Boot - Security -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-oauth2</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

At your SpringApplication main class add the annotation @EnableOAuth2Resource to make you microservice protected by spring-security oauth2.
```
@EnableOAuth2Resource
@SpringCloudApplication
public class MyApplication {
  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
  }
}
```

At you application.yml(properties) add the following attribute to make your application retrieve the authenticated user.
```
spring.oauth2.resource.userInfoUri: http://{GATEWAY-APPLICATION-DNS}:{PORT}/rest/sec/user
```

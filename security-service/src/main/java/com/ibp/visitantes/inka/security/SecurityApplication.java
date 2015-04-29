package com.ibp.visitantes.inka.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Security Authorization server.
 *
 * To authenticate the client use the following command:
 * curl -X POST client:secret@localhost:8443/oauth/token -d grant_type=client_credentials -d scope=read%20write
 * curl -X POST visitantesclient:somesecret@localhost:8443/oauth/token -d grant_type=client_credentials -d scope=read%20write
 * It will give a json response like:
 * {"access_token":"c3fcd384-1a04-40a4-9674-145ba251bcb5","token_type":"bearer","expires_in":300,"scope":"read write"}
 *
 * Use the access_token on header of nexts requests, ex:
 * curl -k https://$GATEWAYHOST:$PORT/rest/$SERVICE -H "Authorization: Bearer $ACCESS_TOKEN"
 *
 * @author marcos.barbero
 */
@SpringBootApplication
@ImportResource("classpath:spring/transaction-config.xml")
public class SecurityApplication {

    public static void main(String... args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
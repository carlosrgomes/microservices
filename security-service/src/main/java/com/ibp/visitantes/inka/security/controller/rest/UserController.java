package com.ibp.visitantes.inka.security.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Controller to get authenticated user.
 *
 * @author marcos.barbero
 */
@RestController
public class UserController {

    /**
     * Return the authenticated user, in this case it' an oauth2 client.
     *
     * @param user Principal
     * @return Authenticated User.
     */
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}

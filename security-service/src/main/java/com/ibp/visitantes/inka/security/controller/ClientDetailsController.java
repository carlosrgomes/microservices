package com.ibp.visitantes.inka.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Rest controller to expose clientDetails CRUD as REST services.
 *
 * @author marcos.barbero
 */
@PreAuthorize("hasRole('ROLE_TRUST')")
@RestController
@RequestMapping("/client")
public class ClientDetailsController {

    private ClientRegistrationService clientRegistrationService;

    private ClientDetailsService clientDetailsService;

    @Autowired
    public ClientDetailsController(ClientRegistrationService clientRegistrationService,
                                   ClientDetailsService clientDetailsService) {
        this.clientRegistrationService = clientRegistrationService;
        this.clientDetailsService = clientDetailsService;
    }

    /**
     * Return a list of ClientDetails.
     *
     * @return List of ClientDetails
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Collection<ClientDetails> get() {
        return clientRegistrationService.listClientDetails();
    }

    /**
     * Return a clientDetails for given clientId.
     *
     * @param clientId The clientId
     * @return return ClientDetails
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientDetails> get(@PathVariable("clientId") String clientId) {
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

        if (clientDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientDetails, HttpStatus.OK);
    }

    /**
     * Create a new Client.
     *
     * @param clientDetails ClientDetails
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody BaseClientDetails clientDetails) {
        this.clientRegistrationService.addClientDetails(clientDetails);
    }

    /**
     * Update an existing client.
     *
     * @param clientDetails ClientDetails to update
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void put(@RequestBody BaseClientDetails clientDetails) {
        this.clientRegistrationService.updateClientDetails(clientDetails);
    }

    /**
     * Remove a client from database for given clientId.
     *
     * @param clientId The clientId
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("clientId") String clientId) {
        this.clientRegistrationService.removeClientDetails(clientId);
    }

}

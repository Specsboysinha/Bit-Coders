package com.bitcoders.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcoders.clientservice.ClientService;
import com.bitcoders.entity.ClientEntity;
import com.bitcoders.model.Client;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/v1/client")
public class ClientRegistrationController {
	
	private ClientService clientService;
	
	public ClientRegistrationController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerClient(@Valid @RequestBody Client client) {
		clientService.registerclient(client);
        return ResponseEntity.ok("Client registered successfully: " + client.name);
	}	
	
	@GetMapping("/getAllClients")
	public ResponseEntity<List<ClientEntity>> fetchAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<ClientEntity> fetchByName(@PathVariable String name) {
        return new ResponseEntity<>(clientService.getClientByName(name), HttpStatus.OK);
	}
	
	@PutMapping("/updateClient")
	public ResponseEntity<ClientEntity> updateClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClientDetails(client), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteClient")
	public ResponseEntity<String> deleteClient(@Valid @RequestBody Client client) {
		clientService.deleteClientdetails(client);
        return ResponseEntity.ok("Client deleted successfully: " + client.name);
	}
}

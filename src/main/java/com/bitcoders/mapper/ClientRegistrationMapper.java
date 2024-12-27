package com.bitcoders.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bitcoders.entity.ClientEntity;
import com.bitcoders.model.Client;

@Component
@Service
public class ClientRegistrationMapper {
	
	public ClientEntity clientEntityMapper(Client client) {
		ClientEntity registerClient = new ClientEntity();
		registerClient.setName(client.getName());
		registerClient.setEmail(client.getEmail());
		registerClient.setPhone(client.getPhone());
		registerClient.setCompanyName(client.getCompanyName());
		registerClient.setQuery(client.getQuery());
		return registerClient;
	}
}

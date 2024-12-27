package com.bitcoders.clientservice;

import java.util.List;

import com.bitcoders.entity.ClientEntity;
import com.bitcoders.model.Client;

import jakarta.validation.Valid;

public interface ClientService {

	void registerclient(@Valid Client client);

	List<ClientEntity> getAllClients();

	ClientEntity getClientByName(String name);

	ClientEntity updateClientDetails(@Valid Client client);

	void deleteClientdetails(@Valid Client client);

}

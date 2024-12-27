package com.bitcoders.clientserviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcoders.clientservice.ClientService;
import com.bitcoders.db.repository.ClientDetailsRepository;
import com.bitcoders.entity.ClientEntity;
import com.bitcoders.mapper.ClientRegistrationMapper;
import com.bitcoders.model.Client;

import jakarta.validation.Valid;

@Service
public class ClientServiceImpl implements ClientService{
	

	public ClientDetailsRepository clientDetailsRepository;
	public ClientRegistrationMapper clientRegistrationMapper;

	public ClientServiceImpl(ClientDetailsRepository clientDetailsRepository,ClientRegistrationMapper clientRegistrationMapper) {
		super();
		this.clientDetailsRepository = clientDetailsRepository;
		this.clientRegistrationMapper = clientRegistrationMapper;
	}

	@Override
	public void registerclient(Client client) {
		ClientEntity clientEntity = clientRegistrationMapper.clientEntityMapper(client);
		clientDetailsRepository.save(clientEntity);
	}

	@Override
	public List<ClientEntity> getAllClients() {
		return clientDetailsRepository.findAll();
	}

	@Override
	public ClientEntity getClientByName(String name) {
		return clientDetailsRepository.findByName(name);
	}

	@Override
	public ClientEntity updateClientDetails(@Valid Client client) {
		ClientEntity updateClientEntity = clientRegistrationMapper.clientEntityMapper(client);
		clientDetailsRepository.save(updateClientEntity);
		return updateClientEntity;
	}

	@Override
	public void deleteClientdetails(@Valid Client client) {
		ClientEntity deleteClientEntity = clientDetailsRepository.findByName(client.getName());
		clientDetailsRepository.deleteById(deleteClientEntity.getId());
	}
}

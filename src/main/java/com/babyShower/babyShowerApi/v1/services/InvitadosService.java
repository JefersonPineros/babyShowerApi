package com.babyShower.babyShowerApi.v1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babyShower.babyShowerApi.v1.models.InvitadosEntity;
import com.babyShower.babyShowerApi.v1.repositories.InvitadosModelRepository;

@Service
public class InvitadosService implements IInvitadosService {

	@Autowired
	private InvitadosModelRepository invitadosRepository;
	
	@Override
	public void createInvitado(InvitadosEntity invitados) throws Exception {
		
		this.invitadosRepository.save(invitados);
		
	}

}

package com.babyShower.babyShowerApi.v1.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babyShower.babyShowerApi.v1.models.ListaEntity;
import com.babyShower.babyShowerApi.v1.repositories.ListaModelRepository;

@Service
public class ListaService implements IListaService {

	@Autowired
	private ListaModelRepository listaRepository;
	
	@Override
	public ArrayList<ListaEntity> getListaRegalos() {

		return (ArrayList<ListaEntity>) this.listaRepository.findAll();
	}

	@Override
	public void updateRegaloById(Integer id) throws Exception, SQLException {
		
		ListaEntity updateItem = this.listaRepository.findById(id).orElse(null);
		
		if (updateItem != null) {
			ListaEntity newUpdate = new ListaEntity();
			newUpdate.setId(updateItem.getId());
			newUpdate.setCategoria(updateItem.getCategoria());
			newUpdate.setNombre(updateItem.getNombre());
			newUpdate.setCantidad(updateItem.getCantidad() - 1);
			
			this.listaRepository.saveAndFlush(newUpdate);
		}
		
	}

}
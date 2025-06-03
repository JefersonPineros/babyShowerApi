package com.babyShower.babyShowerApi.v1.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
	public void updateRegaloById(ArrayList<ListaEntity> list) throws Exception, SQLException {
		
		for (ListaEntity itemR : list ) {
			
			ListaEntity updateItem = this.listaRepository.findById(itemR.getId()).orElse(null);
			
			System.out.println(updateItem);
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

}

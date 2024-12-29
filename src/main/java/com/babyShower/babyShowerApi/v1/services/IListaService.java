package com.babyShower.babyShowerApi.v1.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.babyShower.babyShowerApi.v1.models.ListaEntity;

public interface IListaService {
	
	public ArrayList<ListaEntity> getListaRegalos();
	
	public void updateRegaloById(Integer id) throws Exception, SQLException;
	
}

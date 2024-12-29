package com.babyShower.babyShowerApi.v1.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.babyShower.babyShowerApi.v1.models.InvitadosEntity;
import com.babyShower.babyShowerApi.v1.models.ListaEntity;
import com.babyShower.babyShowerApi.v1.services.IInvitadosService;
import com.babyShower.babyShowerApi.v1.services.IListaService;

@RestController
@RequestMapping("babyShower/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class BabyShowerController {
	
	@Autowired
	private IListaService listaService;
	
	@Autowired
	private IInvitadosService invitadosService;
	
	@PostMapping("/invitados")
	public ResponseEntity<?> insertInvitados(@RequestBody InvitadosEntity invitados) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			this.invitadosService.createInvitado(invitados);
		} catch (Exception e) {
			result.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			result.put("error", e.getMessage());
			
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		result.put("status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<?> finAll(){
		ArrayList<ListaEntity> lista = this.listaService.getListaRegalos();
		return new ResponseEntity<ArrayList<ListaEntity>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/lista/{id}")
	public ResponseEntity<?> updateItem(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			this.listaService.updateRegaloById(id);
		} catch (Exception e) {
			result.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			result.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		result.put("status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

}

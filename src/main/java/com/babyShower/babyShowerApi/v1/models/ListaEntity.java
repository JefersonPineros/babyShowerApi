package com.babyShower.babyShowerApi.v1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "lista_regalos")
@Getter
@Setter
public class ListaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "nombre")
	public String nombre;
	
	@Column(name = "cantidad")
	public Integer cantidad;
	
	@Column(name = "categoria")
	public String categoria;
}

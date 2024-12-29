package com.babyShower.babyShowerApi.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babyShower.babyShowerApi.v1.models.ListaEntity;

public interface ListaModelRepository extends JpaRepository<ListaEntity, Integer> {

}

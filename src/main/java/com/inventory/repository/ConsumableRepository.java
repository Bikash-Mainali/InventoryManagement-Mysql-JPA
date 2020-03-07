package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Consumable;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Integer>{

}

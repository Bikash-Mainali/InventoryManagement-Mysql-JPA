package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.NonConsumable;

public interface NonConsumableRepository extends JpaRepository<NonConsumable, Integer>{

}

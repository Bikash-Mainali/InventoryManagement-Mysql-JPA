package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.model.InventoryMain;

public interface InventoryMainRepository extends JpaRepository<InventoryMain, Integer> {
	
	
	@Query("Select i from InventoryMain i where i.item=:name AND i.type=:type AND i.quantity=:quantity")
	public List<InventoryMain> findByNameTypeQuantity(String name,String type,int quantity);

	
	@Query("Select sum(i.quantity) from InventoryMain i where i.item=:name group by i.item")
	public String searchQuantityByName(String name);

	@Query("Select i from InventoryMain i where i.item=?1")
	public InventoryMain findByName(String name);
	

	
}

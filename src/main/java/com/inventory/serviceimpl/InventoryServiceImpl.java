package com.inventory.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.InventoryMain;
import com.inventory.repository.InventoryMainRepository;
import com.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	
	@Autowired
	InventoryMainRepository inventoryMainRepository;
	
	
	public void doSave(InventoryMain inventory)
	{
		
		inventoryMainRepository.save(inventory);
		
		
	}


	@Override
	public List<InventoryMain> doGet() {

		return inventoryMainRepository.findAll();
	}


	@Override
	public List<InventoryMain> doSearch(String name, String type, int quantity) {
	
		return inventoryMainRepository.findByNameTypeQuantity(name,type,quantity);
	}


	@Override
	public String searchQuantity(String name) {

		return inventoryMainRepository.searchQuantityByName(name);
	}


	@Override
	public InventoryMain findByName(InventoryMain inventory) {
	
		return inventoryMainRepository.save(inventory);
	}


	@Override
	public void doDelete(int id) 
	{
		inventoryMainRepository.deleteById(id);
		
	}



	


}

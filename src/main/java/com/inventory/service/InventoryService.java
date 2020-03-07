package com.inventory.service;

import java.util.List;

import com.inventory.model.InventoryMain;

public interface InventoryService {
	
	
	public void doSave(InventoryMain inventory);

	public List<InventoryMain> doGet();

	public List<InventoryMain> doSearch(String name, String type, int quantity);

	public String searchQuantity(String name);

	public InventoryMain findByName(InventoryMain inventory);

	public void doDelete(int id);





}

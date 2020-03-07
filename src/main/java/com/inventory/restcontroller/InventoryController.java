package com.inventory.restcontroller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Consumable;
import com.inventory.model.InventoryMain;
import com.inventory.model.NonConsumable;
import com.inventory.repository.InventoryMainRepository;
import com.inventory.service.ConsumableService;
import com.inventory.service.InventoryService;
import com.inventory.service.NonConsumableService;
import com.inventory.validator.ResponseValidator;

@RestController
@RequestMapping("/basePath")
@CrossOrigin
public class InventoryController {
	

	@Autowired
	InventoryService iService;
	
	@Autowired
	ConsumableService cService;
	
	@Autowired
	NonConsumableService nService;
	
	Consumable consumable=new Consumable();
	NonConsumable nonConsumable=new NonConsumable();
	
	
	@PostMapping(value="/api/inventory/add-item",produces = "application/json")	
	public void doAdd(@RequestBody InventoryMain inventory)
	
	{		
		iService.doSave(inventory);
		
		if(inventory.getType().equalsIgnoreCase("consumable"))
		{
						
			System.out.println("insert item into consumable table");			
			consumable.setId(inventory.getId());
			consumable.setItem(inventory.getItem());
			consumable.setQuantity(inventory.getQuantity());
			cService.doSave(consumable);					
		}
		else
		{
			System.out.println("insert item into non consumable table");
			nonConsumable.setId(inventory.getId());
			nonConsumable.setItem(inventory.getItem());
			nonConsumable.setQuantity(inventory.getQuantity());
			nService.doSave(nonConsumable);
			
		}
			
	}		
		@GetMapping(value="/api/inventory/findAll",produces = "application/json")
		public List<InventoryMain> doGet()
		{	
			List<InventoryMain> itemList=iService.doGet();
			
		    ResponseValidator.validateItemList(itemList);
			return itemList;
		}
						
		@GetMapping(value="api/inventory/searchByNameTypeQuantity",produces = "application/json")
		public List<InventoryMain> doSearch(@RequestParam String name,@RequestParam String type,@RequestParam int quantity)
		{
			System.out.println(name);
			return iService.doSearch(name,type,quantity);
			
		}
		
		@GetMapping(value="api/inventory/searchQuantityByName",produces = "application/json")
		public String searchQuantity(@RequestParam String name)
		{
			String quantity=iService.searchQuantity(name);
			System.out.println(quantity);
			ResponseValidator.validateQuantity(quantity);
			return quantity;
			
		}
		@PutMapping(path="api/inventory/updateQuantityByName",produces = "application/json")
		public InventoryMain doUpdate(@PathParam("id") int id,@RequestBody InventoryMain inventory )
		{
			System.out.println(id);
			System.out.println(inventory.getItem());
			return iService.findByName(inventory);		
		}
		
		@DeleteMapping(value="api/inventory/deleteByName",produces="application/json")
		public String doDelete(@PathParam("id") int id)
		{
			
			iService.doDelete(id);
		
			return "corresponding item is deleted...";
			
		}

}

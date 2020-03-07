package com.inventory.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.NonConsumable;
import com.inventory.repository.NonConsumableRepository;
import com.inventory.service.NonConsumableService;

@Service
public class NonConsumableServiceImpl implements NonConsumableService {

	
	@Autowired
	NonConsumableRepository nonConsumableRepo;
	@Override
	public void doSave(NonConsumable nonConsumable) 
	{
		
		
		nonConsumableRepo.save(nonConsumable);
		
		
		
	
	}
	
	

}

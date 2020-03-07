package com.inventory.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Consumable;
import com.inventory.repository.ConsumableRepository;
import com.inventory.service.ConsumableService;
@Service
public class ConsumableServiceImpl implements ConsumableService{

	
	@Autowired
	ConsumableRepository consumableRepo;
	@Override
	public void doSave(Consumable consumable) {

		consumableRepo.save(consumable);
		
		
	}

}

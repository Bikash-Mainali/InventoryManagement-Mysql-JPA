package com.inventory.validator;

import java.util.List;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

import com.inventory.Exception.GenericException;
import com.inventory.model.InventoryMain;

public class ResponseValidator {
		
	public static void validateItemList(List<InventoryMain> itemList)
	{
		if(itemList.size()==0)
		{
			throw new GenericException("no items are found");
			
		}
	}
	
	
	public static void validateUser(List<String> userList)
	{
		
		
		if(userList==null)
		{			
			throw new GenericException("no users are found");
						
		}
	}
	public static void validateQuantity(String quantity)
	{
		
		
		if(quantity==null)
		{			
			throw new GenericException("no items are present in stock");
						
		}
	}

}

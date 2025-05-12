package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.myapp.entity.Item;
import com.myapp.service.ItemService;

@EnableWebMvc
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;      
	@RequestMapping(value = "/rest/itemList", method = RequestMethod.GET, produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllItem() {
		System.out.println("#########getAll()#########");
		List<Item> itemList = itemService.findAll();
		return itemList;
	}
   
	@RequestMapping(value = "/rest/addItem", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody String addItem(Item item) {
		System.out.println("#########addItem()#########");
		itemService.addItem(item);
		return "OK item.name: "+item.getName();
	}	
	
}
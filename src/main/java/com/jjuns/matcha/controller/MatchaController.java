package com.jjuns.matcha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjuns.matcha.vo.Store;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/")
public class MatchaController {

	@GetMapping("index")
	public String index() {
		log.info(" ###  Welcome to Matcha!!!!    ### ");
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model, @ModelAttribute("keyword") String keyword) {
		log.info(" ###  List page    ### : "+keyword);
		
		List<Store> list = new ArrayList<Store>();
		
		for (int i=0; i<10; i++) {
			
			Store store = new Store();
			store.setStoreName("안녕 식당"+i);
			store.setStoreCategory("식당");
			store.setStoreId(i);
			store.setStoreMenu("연어덮밥");
			list.add(store);
		}
		model.addAttribute("list",list);
		return "list";
	}
	
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Store> search(@ModelAttribute("keyword") String keyword) throws Exception {
    	log.info("Search page ");
		
		List<Store> list = new ArrayList<Store>();
		
		for (int i=0; i<10; i++) {
			
			Store store = new Store();
			store.setStoreName("안녕 식당"+i);
			store.setStoreCategory("식당");
			store.setStoreId(i);
			store.setStoreMenu("연어덮밥");
			list.add(store);
		}
		
		return list;
    }
	
	@GetMapping("detail")
	public String read(Model model, @ModelAttribute("storeId") Integer storeId) {
		log.info(" ###  Detail page  storeId  ### : "+storeId);
		Store store = new Store();
		store.setStoreId(storeId);
		store.setStoreAddress("방이동");
		store.setStoreMenu("타코");
		store.setStoreName("갓잇");
		store.setStoreRating("4");
		
		model.addAttribute("store", store);
		return "detail";
	}
}

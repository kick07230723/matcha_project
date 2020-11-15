package com.jjuns.matcha.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jjuns.matcha.dao.MatchaCafeDaoImpl;
import com.jjuns.matcha.dao.MatchaFoodDaoImpl;
import com.jjuns.matcha.util.MatchComparator;
import com.jjuns.matcha.vo.MyReview;
import com.jjuns.matcha.vo.Review;
import com.jjuns.matcha.vo.Store;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/")
public class MatchaController {

	@Autowired
	MatchaFoodDaoImpl food;
	@Autowired
	MatchaCafeDaoImpl cafe;
	
	@GetMapping("matcha")
	public String index() {
		log.info(" ###  Welcome to Matcha!!!!    ### ");
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model, @ModelAttribute("query") String query, @RequestParam(required = false) String name) throws IOException, GeneralSecurityException {
		log.info(" ###  List page    ### : "+query);
		
		Integer id = 2;
		if(name!=null) {
			switch (name) {
			case "river":
				id=1;
				break;
			case "jun":
				id=2;
				break;
			default:
				id=2;
				break;
			}
		}
		
		List<MyReview> myFoodReviewList = food.getMyReviewList(query, id);
		List<MyReview> myCafeReviewList = cafe.getMyReviewList(query, id);
//		Collections.sort(myReviewList,  new MatchComparator());
		
		
		model.addAttribute("myFoodReviewList", myFoodReviewList);		
		model.addAttribute("myCafeReviewList", myCafeReviewList);
		
		
//		List<Store> storeList = docs.getStoreList(query);
//		List<Review> reviewList = docs.getReviewList(query);
//		model.addAttribute("storeList",storeList);
//		model.addAttribute("reviewList",reviewList);
		return "list";
	}
	@GetMapping("matcha/yeona")
	public String index2() {
		log.info(" ###  Welcome to Matcha!!!!    ### ");
		ModelAndView mav = null;
		mav.addObject("name", "yeona");
		return "index";
	}
	
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Store> search(@ModelAttribute("query") String query) throws Exception {
    	log.info(" ###  Search page !  ### : "+query);
		
		List<Store> list = new ArrayList<Store>();
		
		for (int i=0; i<10; i++) {
			
			Store store = new Store();
			store.setStoreName(query+i);
			store.setStoreCategory(query+" 카테고리");
			store.setStoreId(i);
			store.setStoreMenu(query+" 메뉴");
			list.add(store);
		}
		
		return list;
    }
	
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
	public Store read(Model model, @ModelAttribute("storeId") Integer storeId) {
		log.info(" ###  Detail page  storeId  ### : "+storeId);
		Store store = new Store();
		store.setStoreId(storeId);
		store.setStoreAddress("방이동");
		store.setStoreMenu("타코");
		store.setStoreName("갓잇");
		
		return store;
	}
}

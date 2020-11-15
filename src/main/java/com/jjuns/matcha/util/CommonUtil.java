package com.jjuns.matcha.util;

import java.util.ArrayList;
import java.util.List;

import com.jjuns.matcha.vo.MyReview;
import com.jjuns.matcha.vo.Review;
import com.jjuns.matcha.vo.Store;

import lombok.extern.java.Log;

@Log
public class CommonUtil {

	public static List<Store> setStore(List<List<Object>> values, Integer id) {
		List<Store> storeList = new ArrayList<Store>();
		
		if(values!=null && !values.isEmpty()) {
			for (List row : values) {
				try {
					Store store = new Store();
					store.setStoreId(Integer.parseInt(nullToBlank(row.get(0))));
					store.setStoreName(nullToBlank(row.get(1)));
					store.setStoreCategory(nullToBlank(row.get(2)));
					store.setStoreMenu(nullToBlank(row.get(3)));
					store.setStoreAddress(nullToBlank(row.get(4)));
					store.setDetailAddress(nullToBlank(row.get(5)));
					store.setStoreHashtag(nullToBlank(row.get(6)));
					storeList.add(store);
					log.info(store.toString());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					log.info("Error in setting store vo.");
				}
			}
		}
		return storeList;
	}
	
	public static List<Review> setReview(List<List<Object>> values, Integer id) {
		List<Review> reviewList = new ArrayList<Review>();
		
		if(values!=null && !values.isEmpty()) {
			for (List row : values) {
				try {
					Review review = new Review();
					review.setStoreId(Integer.parseInt(nullToBlank(row.get(0))));
					review.setStoreRating(nullToBlank(row.get(4+(2*id))));
					review.setStoreReview(nullToBlank(row.get(4+(2*id)+1)));
					reviewList.add(review);
					log.info(review.toString());
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Error in setting review vo.");
				}
			}
		}
		return reviewList;
	}
	
	public static List<MyReview> setMyReview(List<List<Object>> values, String keyword, Integer id) {
		List<MyReview> reviewList = new ArrayList<MyReview>();
		
		if(values!=null && !values.isEmpty()) {
			for (List row : values) {
				try {
					if(searchByStoreName(row, keyword)) {
						MyReview review = new MyReview();
						log.info(row.toString());
						review.setStoreId(Integer.parseInt(nullToBlank(row.get(0))));
						review.setStoreName(nullToBlank(row.get(1)));
						review.setStoreCategory(nullToBlank(row.get(2)));
						review.setStoreMenu(nullToBlank(row.get(3)));
						review.setStoreAddress(nullToBlank(row.get(4)));
						review.setDetailAddress(nullToBlank(row.get(5)));
						review.setStoreHashtag(nullToBlank(row.get(6)));
						review.setStoreRating(nullToBlank(row.get(4+(2*id)+1)));
						review.setStoreReview(nullToBlank(row.get(4+(2*id)+2)));
						reviewList.add(review);
					}
//				log.info(review.toString());
				} catch (Exception e) {
					e.printStackTrace();
					log.info("Error in setting review vo.");
				}
			}
		}
		return reviewList;
	}

	private static boolean searchByStoreName(List row, String keyword) {
		return nullToBlank(row.get(1)).contains(keyword) ? true : false;
	}
	
	
	public static String nullToBlank(Object object) {
		if(object != null) {
			return object.toString();
		}else {
			return "";
		}
	}
	public static Integer nullToBlank(Integer num) {
		if(num != null) {
			return num;
		}else {
			return 0;
		}
	}
	
}

package com.jjuns.matcha.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyReview {

	private Integer storeId;
	private String storeName;
	private String storeCategory;
	private String storeMenu;
	private String storeAddress;
	private String detailAddress;
	private String storeHashtag;
	
	private String storeRating;
	private String storeReview;
	
}

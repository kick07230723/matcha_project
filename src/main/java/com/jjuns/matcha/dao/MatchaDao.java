package com.jjuns.matcha.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.jjuns.matcha.vo.MyReview;
import com.jjuns.matcha.vo.Review;
import com.jjuns.matcha.vo.Store;

public interface MatchaDao {

	List<Store> getStoreList(String keyword, Integer id) throws IOException, GeneralSecurityException;

	List<Review> getReviewList(String keyword, Integer id) throws IOException, GeneralSecurityException;

	List<MyReview> getMyReviewList(String keyword, Integer id) throws IOException, GeneralSecurityException;

}
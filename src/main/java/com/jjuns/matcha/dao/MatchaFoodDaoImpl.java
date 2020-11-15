package com.jjuns.matcha.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jjuns.matcha.util.CommonUtil;
import com.jjuns.matcha.vo.MyReview;
import com.jjuns.matcha.vo.Review;
import com.jjuns.matcha.vo.Store;


@Component
public class MatchaFoodDaoImpl implements MatchaDao {

	
	@Autowired
	MatchaConnection dao;
	
	@Override
	public List<Store> getStoreList(String keyword, Integer id) throws IOException, GeneralSecurityException {
		List<List<Object>> values = dao.getSheetValues("밥집리스트");
        List<Store> list =CommonUtil.setStore(values, id);
        return list;
    }
    
    @Override
	public List<Review> getReviewList(String keyword, Integer id) throws IOException, GeneralSecurityException {
		List<List<Object>> values = dao.getSheetValues("밥집리스트");
        List<Review> list = CommonUtil.setReview(values, id);
        return list;
    }
    
    @Override
	public List<MyReview> getMyReviewList(String keyword, Integer id) throws IOException, GeneralSecurityException {
		List<List<Object>> values = dao.getSheetValues("밥집리스트");
        List<MyReview> list = CommonUtil.setMyReview(values, keyword, id);
        return list;
    }
}
package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.ComplainDAO;
import com.project.DAO.FeedbackDAO;
import com.project.model.AirlineVO;
import com.project.model.ComplainVO;
import com.project.model.FeedbackVO;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDAO feedbackDAO;
	

	
	
	@Override
	public void saveFeedback(FeedbackVO feedbackVO) {
		this.feedbackDAO.save(feedbackVO);
		
	}




	@Override
	public List<FeedbackVO> viewFeedback() {
		return this.feedbackDAO.viewFeedback();
	}




	@Override
	public List<FeedbackVO> getFeedbackById(int feedbackId) {
	
		return this.feedbackDAO.getFeedbackById(feedbackId);
	}




	@Override
	public List<FeedbackVO> getUserFeedbackById(int loginId) {
	
		return this.feedbackDAO.getUserFeedbackById(loginId);
	}
	

	

	
	
	
	
	



	

}

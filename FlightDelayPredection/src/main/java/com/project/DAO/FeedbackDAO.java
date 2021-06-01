package com.project.DAO;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackDAO {

	void save(FeedbackVO feedbackVO);

	List<FeedbackVO> viewFeedback();

	List<FeedbackVO> getFeedbackById(int feedbackId);

	List<FeedbackVO> getUserFeedbackById(int loginId);



}

package com.project.service;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackService {


void saveFeedback(FeedbackVO feedbackVO);



List<FeedbackVO> viewFeedback();



List<FeedbackVO> getFeedbackById(int feedbackId);



List<FeedbackVO> getUserFeedbackById(int loginId);







}

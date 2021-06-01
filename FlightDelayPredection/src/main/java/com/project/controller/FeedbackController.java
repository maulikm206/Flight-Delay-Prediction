package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AirlineVO;
import com.project.model.ComplainVO;
import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;
@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;


	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethods;

	
	@GetMapping(value = "user/addFeedback")
	public ModelAndView addFeedback(LoginVO loginVO) {
		String userName = baseMethods.getUser();
		loginVO.setUsername(userName);
		List<LoginVO> loginList = this.loginService.searchLoginID(loginVO);

		LoginVO loginVO2 = loginList.get(0);

		List<FeedbackVO> feedbackList = this.feedbackService.getUserFeedbackById(loginVO2.getLoginId());

		return new ModelAndView("user/addFeedback", "FeedbackVO", new FeedbackVO()).addObject("feedbackList",
				feedbackList);
	}


	@PostMapping(value = "user/saveFeedback")
	public ModelAndView saveFeedback(@ModelAttribute FeedbackVO feedbackVO,LoginVO loginVO) {
		String userName = baseMethods.getUser();
		loginVO.setUsername(userName);
		List<LoginVO> loginList = this.loginService.searchLoginID(loginVO);

		feedbackVO.setLoginVO(loginList.get(0));

		this.feedbackService.saveFeedback(feedbackVO);
		return new ModelAndView("redirect:addFeedback");
	
	}
	
	@GetMapping(value = "admin/viewFeedback")
	public ModelAndView viewFeedback() {
		List<FeedbackVO> feedbackList = this.feedbackService.viewFeedback();
		
		return new ModelAndView("admin/viewFeedback", "FeedbackList", feedbackList);
	}
	@GetMapping(value = "admin/deleteFeedback")
	public ModelAndView deleteFeedback(@RequestParam int feedbackId) {
		List<FeedbackVO> feedbackList = this.feedbackService.getFeedbackById(feedbackId);
		FeedbackVO feedbackVO = feedbackList.get(0);
		// Set status false
		feedbackVO.setStatus(false);
		this.feedbackService.saveFeedback(feedbackVO);
		return new ModelAndView("redirect:viewFeedback");
	}
	
	
	
	

}

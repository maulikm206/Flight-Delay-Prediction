package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class predictionController {
	
	@GetMapping(value="admin/viewPrediction")
	public ModelAndView viewPrediction()
	    {
		 return new ModelAndView("admin/viewPrediction");
		}
}

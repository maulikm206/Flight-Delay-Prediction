package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AirlineVO;
import com.project.model.StateVO;
import com.project.service.AirlineService;
import com.project.service.StateService;

@Controller
public class FlightListController {

	@Autowired
	private StateService stateService;

	@Autowired
	private AirlineService airlineService;

	@GetMapping(value = "user/flightList")
	public ModelAndView flightList() {
		List<StateVO> stateList = this.stateService.getState();
		List<AirlineVO> airlineList = this.airlineService.getAirline();
		return new ModelAndView("user/flightList").addObject("stateList", stateList).addObject("airlineList",
				airlineList);
	}

}

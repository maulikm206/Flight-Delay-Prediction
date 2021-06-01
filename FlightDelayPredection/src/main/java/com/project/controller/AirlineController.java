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
import com.project.service.AirlineService;

@Controller
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@GetMapping(value = "admin/addAirline")
	public ModelAndView addFlight() {
		return new ModelAndView("admin/addAirline", "AirlineVO", new AirlineVO());
	}

	@PostMapping(value = "admin/saveAirline")
	public ModelAndView saveAirline(@ModelAttribute AirlineVO airlineVO) {
		this.airlineService.saveAirline(airlineVO);
		return new ModelAndView("redirect:addAirline");

	}

	@GetMapping(value = "admin/viewAirline")
	public ModelAndView viewFlight() {
		List<AirlineVO> airlineList = this.airlineService.getAirline();
		return new ModelAndView("admin/viewAirline", "airlineList", airlineList);
	}

	@GetMapping(value = "admin/editAirline")
	public ModelAndView editAirline(@RequestParam int airlineId) {
		List<AirlineVO> airlineList = this.airlineService.getAirlineById(airlineId);
		return new ModelAndView("admin/addAirline", "AirlineVO", airlineList.get(0));
	}

	@GetMapping(value = "admin/deleteAirline")
	public ModelAndView deleteAirline(@RequestParam int airlineId) {
		List<AirlineVO> airlineList = this.airlineService.getAirlineById(airlineId);
		AirlineVO airlineVO = airlineList.get(0);
		airlineVO.setStatus(false);
		this.airlineService.saveAirline(airlineVO);

		return new ModelAndView("redirect:viewAirline");
	}

}

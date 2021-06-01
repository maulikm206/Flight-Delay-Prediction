package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AirportVO;
import com.project.model.CityVO;
import com.project.model.StateVO;
import com.project.service.AirportService;
import com.project.service.CityService;
import com.project.service.StateService;

@Controller
public class AirportController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@Autowired
	private AirportService airportService;

	@GetMapping(value = "admin/addAirport")
	public ModelAndView addAirport() {
		List<StateVO> stateList = this.stateService.getState();
		List<CityVO> cityList = this.cityService.getCity();
		return new ModelAndView("admin/addAirport", "AirportVO", new AirportVO()).addObject("stateList", stateList)
				.addObject("cityList", cityList);
	}

	@PostMapping(value = "admin/saveAirport")
	public ModelAndView saveAirport(@ModelAttribute AirportVO airportVO) {
		this.airportService.saveAirport(airportVO);
		return new ModelAndView("redirect:addAirport");
	}
	

	@GetMapping(value = "admin/viewAirport")
	public ModelAndView viewAirport() {
		List<AirportVO> airportList = this.airportService.getAirport();
		return new ModelAndView("admin/viewAirport", "airportList", airportList);
	}
	
	@GetMapping(value = "admin/editAirport")
	public ModelAndView editState(@ModelAttribute AirportVO airportVO,@RequestParam int airportId) {
		List<AirportVO> airportList=this.airportService.getairportById(airportId);
		 airportVO = airportList.get(0);
		 List<StateVO> stateList = this.stateService.getState();
		 List<CityVO> cityList = this.cityService.getCity();
		 return new ModelAndView("admin/addAirport","AirportVO",airportVO).addObject("stateList", stateList).addObject("cityList", cityList);
		 
	}
	
	@GetMapping(value="admin/deleteAirport")
	public ModelAndView delete(@ModelAttribute AirportVO airportVO,@RequestParam int airportId)
	{
	  List<AirportVO> airportList=this.airportService.getairportById(airportId);
	  airportVO = airportList.get(0);
	  airportVO.setStatus(false);
	  airportVO.getStateVO().setStatus(false);
	  airportVO.getCityVO().setStatus(false);
	  this.airportService.saveAirport(airportVO);
	  return new ModelAndView("redirect:viewAirport");
	}
	
	
	
	
	
	
	
	
	
	

}

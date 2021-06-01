package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AirlineVO;
import com.project.model.AirportVO;
import com.project.model.CityVO;
import com.project.model.FlightScheduleVO;
import com.project.model.StateVO;
import com.project.service.AirlineService;
import com.project.service.AirportService;
import com.project.service.CityService;
import com.project.service.FlightScheduleService;
import com.project.service.StateService;

@RestController 
public class flightScheduleController {

	@Autowired
	private AirlineService airlineService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@Autowired
	private AirportService airportService;

	@Autowired
	private FlightScheduleService flightScheduleService;

	@GetMapping(value = "admin/addFlightSchedule")
	public ModelAndView addFlightSchedule() {
		List<AirlineVO> airlineList = this.airlineService.getAirline();
		List<StateVO> stateList = this.stateService.getState();
		List<CityVO> cityList = this.cityService.getCity();
		List<AirportVO> airportList = this.airportService.getAirport();
		return new ModelAndView("admin/addFlightSchedule", "FlightScheduleVO", new FlightScheduleVO())
				.addObject("airlineList", airlineList).addObject("stateList", stateList).addObject("cityList", cityList)
				.addObject("airportList", airportList);
	}

	@PostMapping(value = "admin/saveFlightSchedule")
	public ModelAndView saveCity(@ModelAttribute FlightScheduleVO flightScheduleVO) {

		this.flightScheduleService.saveFlightSchedule(flightScheduleVO);
		return new ModelAndView("redirect:addFlightSchedule");
	}

	@GetMapping(value = "admin/viewFlightSchedule")
	public ModelAndView viewFlightSchedule() {
		List<AirlineVO> airlineList = this.airlineService.getAirline();
		List<StateVO> stateList = this.stateService.getState();
		List<CityVO> cityList = this.cityService.getCity();
		List<FlightScheduleVO> flightScheduleList = this.flightScheduleService.getFlightSchedule();
		return new ModelAndView("admin/viewFlightSchedule").addObject("airlineList", airlineList)
				.addObject("stateList", stateList).addObject("cityList", cityList)
				.addObject("flightScheduleList", flightScheduleList);
	}

	@GetMapping(value = "admin/searchCityByState")
	public ResponseEntity searchCityByState(@RequestParam int id) {
		List<CityVO> cityList = this.cityService.getCityByStateId(id);
		System.out.println("cityList : " + cityList.size());
		return new ResponseEntity(cityList, HttpStatus.OK);
	}

	@GetMapping(value = "user/searchCityByState")
	public ResponseEntity userSearchCityByState(@RequestParam int id) {
		List<CityVO> cityList = this.cityService.getCityByStateId(id);
		System.out.println("cityList : " + cityList.size());
		return new ResponseEntity(cityList, HttpStatus.OK);
	}

	@GetMapping(value = "admin/getFlightSheduleByCity")
	public ResponseEntity getFlightSheduleByCity(@RequestParam int id) {

		List<FlightScheduleVO> FlightScheduleList = this.flightScheduleService.getFlightSheduleByCity(id);
		System.out.println("FlightSchedule : " + FlightScheduleList.size());
		return new ResponseEntity(FlightScheduleList, HttpStatus.OK);
	}
	
	@GetMapping(value = "user/searchFlightForUser")
	public ResponseEntity searchFlightForUser(@RequestParam (required=false) String stateId,
			@RequestParam (required=false) String cityId,
			@RequestParam (required=false) String airlineId) {

		List<FlightScheduleVO> FlightScheduleList = this.flightScheduleService.searchFlightForUser(stateId,cityId,airlineId);
		System.out.println("FlightSchedule : " + FlightScheduleList.size());
		return new ResponseEntity(FlightScheduleList, HttpStatus.OK);
	}
	
}

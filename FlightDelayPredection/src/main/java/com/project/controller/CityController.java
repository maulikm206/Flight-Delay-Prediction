package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CityVO;
import com.project.model.StateVO;
import com.project.service.CityService;
import com.project.service.StateService;

@Controller
public class CityController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityeService;

	@GetMapping(value = "admin/addCity")
	public ModelAndView addCity() {
		List<StateVO> stateList = this.stateService.getState();
		return new ModelAndView("admin/addCity", "CityVO", new CityVO()).addObject("stateList", stateList);
	}

	@PostMapping(value = "admin/saveCity")
	public ModelAndView saveCity(@ModelAttribute CityVO cityVO) {
		this.cityeService.saveCity(cityVO);
		return new ModelAndView("redirect:addCity");
	}

	@GetMapping(value = "admin/viewCity")
	public ModelAndView viewCity() {
		List<CityVO> cityList = this.cityeService.getCity();
		return new ModelAndView("admin/viewCity", "cityList", cityList);
	}

	@GetMapping(value = "admin/editCity")
	public ModelAndView editState(@ModelAttribute CityVO cityVO, @RequestParam int cityId) {
		List<CityVO> cityList = this.cityeService.getCityById(cityId);
		cityVO = cityList.get(0);
		List<StateVO> stateList = this.stateService.getState();
		return new ModelAndView("admin/addCity", "CityVO", cityVO).addObject("stateList", stateList);

	}

	@GetMapping(value = "admin/deleteCity")
	public ModelAndView delete(@ModelAttribute CityVO cityVO, @RequestParam int cityId) {
		List<CityVO> cityList = this.cityeService.getCityById(cityId);
		cityVO = cityList.get(0);
		cityVO.setStatus(false);
		cityVO.getStateVO().setStatus(false);
		this.cityeService.saveCity(cityVO);
		return new ModelAndView("redirect:viewCity");
	}

}

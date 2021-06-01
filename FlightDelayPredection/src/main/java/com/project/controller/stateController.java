package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.StateVO;
import com.project.service.StateService;

@Controller
public class stateController {

	@Autowired
	private StateService stateService;

	@GetMapping(value = "admin/addState")
	public ModelAndView addState() {
		return new ModelAndView("admin/addState", "StateVO", new StateVO());
	}

	@PostMapping(value = "admin/saveState")
	public ModelAndView saveState(@ModelAttribute StateVO stateVO) {
		this.stateService.saveState(stateVO);
		return new ModelAndView("redirect:addState");
	}

	@GetMapping(value = "admin/viewState")
	public ModelAndView viewState() {
		List<StateVO> stateList = this.stateService.getState();
		return new ModelAndView("admin/viewState","stateList",stateList);
	}
	
	@GetMapping(value = "admin/editState")
	public ModelAndView editState(@RequestParam int stateId) {
		List<StateVO> stateList = this.stateService.getStateById(stateId);
		return new ModelAndView("admin/addState","StateVO",stateList.get(0));
	}
	@GetMapping(value = "admin/deleteState")
	public ModelAndView deleteState(@RequestParam int stateId) {
		List<StateVO> stateList = this.stateService.getStateById(stateId);
		StateVO stateVO = stateList.get(0);
		stateVO.setStatus(false);
		this.stateService.saveState(stateVO);
		
		return new ModelAndView("redirect:viewState");}
	
	
}

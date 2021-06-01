package com.project.service;


import java.util.List;

import com.project.model.StateVO;

public interface StateService {

	
	void saveState(StateVO stateVO);

	List<StateVO> getState();

	

	List<StateVO> getStateById(int stateId);
}

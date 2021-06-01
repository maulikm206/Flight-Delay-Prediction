package com.project.DAO;

import java.util.List;

import com.project.model.StateVO;


public interface StateDAO {

	public void save(StateVO stateVO);

	public List<StateVO> getState();



	public List<StateVO> getStateById(int stateId); 
		
		
		
	

}

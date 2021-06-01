package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.StateDAO;
import com.project.model.StateVO;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDAO stateDAO;

	@Override
	public void saveState(StateVO stateVO) {
		this.stateDAO.save(stateVO);

	}

	@Override
	public List<StateVO> getState() {
		return this.stateDAO.getState();
	}

	@Override
	public List<StateVO> getStateById(int stateId) {
		
		return this.stateDAO.getStateById(stateId);
	}

}

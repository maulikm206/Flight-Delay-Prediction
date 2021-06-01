package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.ComplainDAO;
import com.project.model.ComplainVO;

@Service
@Transactional
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	private ComplainDAO complainDAO;

	@Override
	public void saveComplain(ComplainVO complainVO) {
		this.complainDAO.save(complainVO);
	}

	@Override
	public List<ComplainVO> viewComplaint() {
		return this.complainDAO.viewComplaint();
	}

	@Override
	public List<ComplainVO> getComplainById(int complainId) {

		return this.complainDAO.getComplainById(complainId);
	}

	public List<ComplainVO> getUserComplainById(int loginId) {
		return this.complainDAO.getUserComplainById(loginId);
	}

}

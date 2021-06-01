package com.project.service;

import java.util.List;

import com.project.model.ComplainVO;

public interface ComplainService {

	void saveComplain(ComplainVO complainVO);

	List<ComplainVO> viewComplaint();

	List<ComplainVO> getComplainById(int complainId);
	
	List<ComplainVO> getUserComplainById(int loginId);

}

package com.project.DAO;

import java.util.List;

import com.project.model.ComplainVO;

public interface ComplainDAO {

	void save(ComplainVO complainVO);

	List<ComplainVO> viewComplaint();

	List<ComplainVO> getUserComplainById(int loginId);

	List<ComplainVO> getComplainById(int complainId);

}

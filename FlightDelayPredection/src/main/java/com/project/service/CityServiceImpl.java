package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.CityDAO;
import com.project.model.CityVO;
import com.project.model.StateVO;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDAO cityDAO;

	@Override
	public void saveCity(CityVO cityVO) {
		this.cityDAO.saveCity(cityVO);
	}

	@Override
	public List<CityVO> getCity() {
		return this.cityDAO.getCity();
	}

	@Override
	public List<CityVO> getCityById(int cityId) {
		
		return this.cityDAO.getCityById(cityId);
	}

	@Override
	public List<CityVO> getCityByStateId(int id) {
		return this.cityDAO.getCityByStateId(id);
	}

}

package com.project.service;

import java.util.List;

import com.project.model.CityVO;

public interface CityService {

	void saveCity(CityVO cityVO);

	List<CityVO> getCity();



	List<CityVO> getCityById(int cityId);

	List<CityVO> getCityByStateId(int id);
}

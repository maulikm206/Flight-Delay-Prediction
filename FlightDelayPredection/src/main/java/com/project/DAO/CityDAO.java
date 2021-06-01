package com.project.DAO;

import java.util.List;

import com.project.model.CityVO;

public interface CityDAO {

	void saveCity(CityVO cityVO);

	List<CityVO> getCity();

	
	List<CityVO> getCityById(int cityId);

	List<CityVO> getCityByStateId(int id);

}

package com.project.service;

import java.util.List;

import com.project.model.AirlineVO;

public interface AirlineService {

	void saveAirline(AirlineVO airlineVO);

	List<AirlineVO> getAirline();

	List<AirlineVO> getAirlineById(int airlineId);

}

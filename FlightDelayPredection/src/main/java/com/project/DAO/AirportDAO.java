package com.project.DAO;

import java.util.List;

import com.project.model.AirportVO;
import com.project.model.CityVO;

public interface AirportDAO {

	void saveAirport(AirportVO airportVO);

    List<AirportVO> getAirport();

	List<AirportVO> getAirportById(int airportId);

		
		
	}



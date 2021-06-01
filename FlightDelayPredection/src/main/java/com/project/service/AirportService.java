package com.project.service;

import java.util.List;

import com.project.model.AirportVO;

public interface AirportService {

	public void saveAirport(AirportVO airportVO);

	public List<AirportVO> getAirport();

	public List<AirportVO> getairportById(int airportId);

}

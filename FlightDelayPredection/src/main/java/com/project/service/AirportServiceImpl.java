package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.AirportDAO;
import com.project.model.AirportVO;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportDAO airportDAO;

	@Override
	public void saveAirport(AirportVO airportVO) {
		this.airportDAO.saveAirport(airportVO);
	}

	@Override
	public List<AirportVO> getAirport() {
		
		return this.airportDAO.getAirport();
	}

	@Override
	public List<AirportVO> getairportById(int airportId) {
		return this.airportDAO.getAirportById(airportId);
	}
	
	
	
}

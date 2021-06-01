package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.FlightScheduleDAO;
import com.project.model.FlightScheduleVO;

@Service
@Transactional
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	private FlightScheduleDAO flightScheduleDAO;

	@Override
	public void saveFlightSchedule(FlightScheduleVO flightScheduleVO) {
		this.flightScheduleDAO.saveFlightSchedule(flightScheduleVO);
	}

	@Override
	public List<FlightScheduleVO> getFlightSchedule() {
		return this.flightScheduleDAO.getFlightSchedule();
	}

	@Override
	public List<FlightScheduleVO> getFlightSheduleByCity(int id) {
		return this.flightScheduleDAO.getFlightSheduleByCity(id);
	}

	@Override
	public List<FlightScheduleVO> searchFlightForUser(String stateId, String cityId, String airlineId) {
		// TODO Auto-generated method stub
		return this.flightScheduleDAO.searchFlightForUser( stateId,  cityId,  airlineId);
	}

}

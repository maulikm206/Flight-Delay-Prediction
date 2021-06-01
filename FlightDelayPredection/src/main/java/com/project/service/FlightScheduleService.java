package com.project.service;

import java.util.List;

import com.project.model.FlightScheduleVO;

public interface FlightScheduleService {

	void saveFlightSchedule(FlightScheduleVO flighrScheduleVO);

	List<FlightScheduleVO> getFlightSchedule();

	List<FlightScheduleVO> getFlightSheduleByCity(int id);

	List<FlightScheduleVO> searchFlightForUser(String stateId, String cityId, String airlineId);

}

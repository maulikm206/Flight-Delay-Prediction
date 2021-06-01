package com.project.DAO;

import java.util.List;

import com.project.model.FlightScheduleVO;

public interface FlightScheduleDAO {

	void saveFlightSchedule(FlightScheduleVO flightScheduleVO);

	List<FlightScheduleVO> getFlightSchedule();

	List<FlightScheduleVO> getFlightSheduleByCity(int id);

	List<FlightScheduleVO> searchFlightForUser(String stateId, String cityId, String airlineId);
}

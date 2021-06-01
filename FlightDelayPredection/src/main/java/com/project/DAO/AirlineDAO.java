package com.project.DAO;

import java.util.List;

import com.project.model.AirlineVO;

public interface AirlineDAO {

	void save(AirlineVO airlineVO);

	List<AirlineVO> getAirline();

	List<AirlineVO> getAirlineById(int airlineId);

}

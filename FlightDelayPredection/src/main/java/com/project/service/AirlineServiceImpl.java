package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.AirlineDAO;
import com.project.model.AirlineVO;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineDAO airlineDAO;

	@Override
	public void saveAirline(AirlineVO airlineVO) {
		this.airlineDAO.save(airlineVO);

	}

	@Override
	public List<AirlineVO> getAirline() {
		return this.airlineDAO.getAirline();

	}

	@Override
	public List<AirlineVO> getAirlineById(int airlineId) {
		return this.airlineDAO.getAirlineById(airlineId);

	}

}

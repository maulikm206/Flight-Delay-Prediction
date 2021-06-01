package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airport_table")
public class AirportVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "airport_id")
	private int airportId;

	@Column(name = "airport_name")
	private String airportName;

	@Column(name = "airport_description")
	private String airportDescription;

	@Column(name = "status")
	private boolean status = true;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateVO stateVO;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityVO cityVO;

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportDescription() {
		return airportDescription;
	}

	public void setAirportDescription(String airportDescription) {
		this.airportDescription = airportDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

}

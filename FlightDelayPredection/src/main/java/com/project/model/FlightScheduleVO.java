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
@Table(name = "flightSchedule_table")

public class FlightScheduleVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightScheduleId;

	@ManyToOne
	@JoinColumn(name = "airline_id")
	private AirlineVO airlineVO;

	@Column(name = "flight_number")
	private String flightNumber;

	@Column(name = "week_days")
	private String weekDays;

	@ManyToOne
	@JoinColumn(name = "departurestate_id")
	private StateVO departureState; 

	@ManyToOne
	@JoinColumn(name = "departurecity_id")
	private CityVO departureCity;

	@ManyToOne
	@JoinColumn(name = "departureaiport_id")
	private AirportVO departureAirport;

	@ManyToOne
	@JoinColumn(name = "arrivalstate_id")
	private StateVO arrivalState;

	@ManyToOne
	@JoinColumn(name = "arrivalcity_id")
	private CityVO arrivalCity;

	@ManyToOne
	@JoinColumn(name = "arrivalairport_id")
	private AirportVO arrivalAirport;

	@Column(name = "departure_time")
	private String departureTime;

	@Column(name = "arrival_time")
	private String arrivalTime;

	@Column(name = "price")
	private String price;
	
	@Column(name = "air_time")
	private String airtime;

	@Column(name = "status")
	private boolean status = true;

	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public AirlineVO getAirlineVO() {
		return airlineVO;
	}

	public void setAirlineVO(AirlineVO airlineVO) {
		this.airlineVO = airlineVO;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public StateVO getDepartureState() {
		return departureState;
	}

	public void setDepartureState(StateVO departureState) {
		this.departureState = departureState;
	}

	public CityVO getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(CityVO departureCity) {
		this.departureCity = departureCity;
	}

	public AirportVO getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(AirportVO departureAirport) {
		this.departureAirport = departureAirport;
	}

	public StateVO getArrivalState() {
		return arrivalState;
	}

	public void setArrivalState(StateVO arrivalState) {
		this.arrivalState = arrivalState;
	}

	public CityVO getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(CityVO arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public AirportVO getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(AirportVO arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAirtime() {
		return airtime;
	}

	public void setAirtime(String airtime) {
		this.airtime = airtime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}

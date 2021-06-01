package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.FlightScheduleVO;

@Repository
public class FlightScheduleDAOImpl implements FlightScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFlightSchedule(FlightScheduleVO flightScheduleVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(flightScheduleVO);

	}

	@Override
	public List<FlightScheduleVO> getFlightSchedule() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FlightScheduleVO where status = true");
		return query.list();
	}

	@Override
	public List<FlightScheduleVO> getFlightSheduleByCity(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FlightScheduleVO where departureCity.cityId=" + id);
		return query.list();
	}

	@Override
	public List<FlightScheduleVO> searchFlightForUser(String stateId, String cityId, String airlineId) {

		String query =  " 1=1 ";

		if (stateId != null) {
			query = query + " and ( departureState = " + stateId + " or arrivalState = " + stateId + ")";
		}
		if (cityId != null) {
			query = query + " and ( departureCity = " + cityId + " or arrivalCity = " + cityId + ")";
		}
		if (airlineId != null) {
			query = query + " and ( airlineVO = " + airlineId + " or airlineVO = " + airlineId+ ")";
		}
		
		System.out.println(query);

		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from FlightScheduleVO where " + query);
		return q.list();
	}

}

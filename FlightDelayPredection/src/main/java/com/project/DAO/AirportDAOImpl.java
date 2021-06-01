package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AirportVO;

@Repository
public class AirportDAOImpl implements AirportDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAirport(AirportVO airportVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(airportVO);

	}

	@Override
	public List<AirportVO> getAirport() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AirportVO where status = true");
		return query.list();
	}

	@Override
	public List<AirportVO> getAirportById(int airportId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AirportVO where status = true and airportId = " +airportId);
		return query.list();

		
	}
}

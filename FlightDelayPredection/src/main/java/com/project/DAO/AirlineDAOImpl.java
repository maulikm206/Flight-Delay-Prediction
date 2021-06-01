package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AirlineVO;
import com.project.model.StateVO;

@Repository
public class AirlineDAOImpl implements AirlineDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(AirlineVO airlineVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(airlineVO);

	}

	@Override
	public List<AirlineVO> getAirline() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AirlineVO where status = true");
		System.out.println(query.list().size());
		return query.list();
	}

	@Override
	public List<AirlineVO> getAirlineById(int airlineId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AirlineVO where status = true and airlineId = " + airlineId);

		return query.list();

	}

}

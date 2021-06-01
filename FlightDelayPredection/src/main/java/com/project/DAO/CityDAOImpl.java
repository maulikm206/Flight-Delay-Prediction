package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CityVO;
import com.project.model.StateVO;

@Repository
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCity(CityVO cityVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(cityVO);
	}

	@Override
	public List<CityVO> getCity() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CityVO where status = true");
		return query.list();
	}

	@Override
	public List<CityVO> getCityById(int cityId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CityVO where status = true and cityId = " +cityId);
		return query.list();
	}

	@Override
	public List<CityVO> getCityByStateId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CityVO where status = true and stateVO.stateId = " +id);
		return query.list();
	}

}

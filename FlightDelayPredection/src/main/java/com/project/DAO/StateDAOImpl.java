package com.project.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.project.model.StateVO;

@Repository
public class StateDAOImpl implements StateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(stateVO);

	}

	@Override
	public List<StateVO> getState() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from StateVO where status = true");
		return query.list();
	}

	@Override
	public List<StateVO> getStateById(int stateId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from StateVO where status = true and stateId = " + stateId);
		
		return query.list();
	}

}

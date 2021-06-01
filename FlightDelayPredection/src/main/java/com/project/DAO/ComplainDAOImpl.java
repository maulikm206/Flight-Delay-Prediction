package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;

@Repository
public class ComplainDAOImpl implements ComplainDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ComplainVO complainVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(complainVO);
	}

	@Override
	public List<ComplainVO> viewComplaint() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ComplainVO where status = true");
		List<ComplainVO> complaintList = q.list();
		return complaintList;
	}

	@Override
	public List<ComplainVO> getComplainById(int complainId) {
	
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ComplainVO where status = true and complainId = " + complainId);
		
		return query.list();
	
	}
	

	@Override
	public List<ComplainVO> getUserComplainById(int loginId) {
	
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ComplainVO where status = true and loginVO = " + loginId);
		
		return query.list();
	
	}

}

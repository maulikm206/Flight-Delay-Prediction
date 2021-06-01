package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;

@Repository
public class LoginDAOImp implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void register(RegisterVO registerVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(registerVO);
	}

	@Override
	public void insertLogin(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginVO);
	}

	@Override
	public List<LoginVO> searchLoginID(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username='" + loginVO.getUsername() + "'");
		List<LoginVO> ls = q.list();
		return ls;
	}
}
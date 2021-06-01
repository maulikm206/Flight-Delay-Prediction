package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;
import com.project.model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void save(FeedbackVO feedbackVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(feedbackVO);		
	}



	@Override
	public List<FeedbackVO> viewFeedback() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from FeedbackVO where status = true");
		List<FeedbackVO> feedbackList = q.list();
		return feedbackList;
	}



	@Override
	public List<FeedbackVO> getFeedbackById(int feedbackId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FeedbackVO where status = true and feedbackId = " + feedbackId);
		
		return query.list();
	}



	@Override
	public List<FeedbackVO> getUserFeedbackById(int loginId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FeedbackVO where status = true and loginVO = " + loginId);
		
		return query.list();

}
}
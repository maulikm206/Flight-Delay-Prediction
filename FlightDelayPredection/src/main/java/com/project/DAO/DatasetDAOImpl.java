package com.project.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DatasetVO;

@Repository
public class DatasetDAOImpl implements DatasetDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DatasetVO datasetVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(datasetVO);

	}

	@Override
	public List<DatasetVO> getDataset() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DatasetVO where status = true");
		return query.list();

	}

	@Override
	public List<DatasetVO> getDatasetById(int datasetId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DatasetVO where status = true and datasetId = " + datasetId);

		return query.list();
	}

}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.DatasetDAO;

import com.project.model.DatasetVO;

@Service
@Transactional
public class DatasetServiceImpl implements DatasetService {

	@Autowired
	private DatasetDAO datasetDAO;

	@Override
	public void saveDataset(DatasetVO datasetVO) {
		this.datasetDAO.save(datasetVO);

	}

	@Override
	public List<DatasetVO> getDataset() {
		return this.datasetDAO.getDataset();
	}

	@Override
	public List<DatasetVO> getDatasetById(int datasetId) {

		return this.datasetDAO.getDatasetById(datasetId);
	}

}

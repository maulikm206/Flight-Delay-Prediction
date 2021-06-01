package com.project.service;

import java.util.List;

import com.project.model.DatasetVO;

public interface DatasetService {

	

	void saveDataset(DatasetVO datasetVO);


	List<DatasetVO> getDataset();

	List<DatasetVO> getDatasetById(int datasetId);

}

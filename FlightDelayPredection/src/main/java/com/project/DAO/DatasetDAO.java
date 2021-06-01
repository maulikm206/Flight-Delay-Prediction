package com.project.DAO;

import java.util.List;

import com.project.model.DatasetVO;

public interface DatasetDAO {

	void save(DatasetVO datasetVO);

	List<DatasetVO> getDataset();

	List<DatasetVO> getDatasetById(int datasetId);

}

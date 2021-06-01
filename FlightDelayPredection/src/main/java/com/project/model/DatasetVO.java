package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataset_table")
public class DatasetVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dataset_id")
	private int datasetId;

	@Column(name = "dataset_name")
	private String datasetName;

	@Column(name = "dataset_description")
	private String datasetDescription;

	@Column(name = "status")
	private boolean status = true;

	@Column(name = "dataset_file_name")
	private String datasetFileName;

	@Column(name = "dataset_file_path")
	private String datasetFilePath;

	public int getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(int datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public String getDatasetDescription() {
		return datasetDescription;
	}

	public void setDatasetDescription(String datasetDescription) {
		this.datasetDescription = datasetDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDatasetFileName() {
		return datasetFileName;
	}

	public void setDatasetFileName(String datasetFileName) {
		this.datasetFileName = datasetFileName;
	}

	public String getDatasetFilePath() {
		return datasetFilePath;
	}

	public void setDatasetFilePath(String datasetFilePath) {
		this.datasetFilePath = datasetFilePath;
	}

}

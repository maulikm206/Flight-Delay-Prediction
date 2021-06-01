package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DatasetVO;
import com.project.service.DatasetService;

@Controller
public class DatasetController {

	@Autowired
	private DatasetService datasetService;

	@GetMapping(value = "admin/addDataset")
	public ModelAndView addDataset() {
		return new ModelAndView("admin/addDataset", "DatasetVO", new DatasetVO());
	}

	@PostMapping(value = "admin/saveDataset")
	public ModelAndView saveDataset(@ModelAttribute DatasetVO datasetVO, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "docs\\dataset\\";

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		datasetVO.setDatasetFileName(fileName);
		datasetVO.setDatasetFilePath(filePath);

		this.datasetService.saveDataset(datasetVO);

		return new ModelAndView("redirect:addDataset");
	}

	@GetMapping(value = "admin/viewDataset")
	public ModelAndView viewDataset() {
		List<DatasetVO> datasetList = this.datasetService.getDataset();
		return new ModelAndView("admin/viewDataset", "datasetList", datasetList);

	}

	@GetMapping(value = "admin/editDataset")
	public ModelAndView editDataset(@RequestParam int datasetId) {
		List<DatasetVO> datasetList = this.datasetService.getDatasetById(datasetId);
		return new ModelAndView("admin/addDataset", "DatasetVO", datasetList.get(0));
	}

	@GetMapping(value = "admin/deleteDataset")
	public ModelAndView deleteDataset(@RequestParam int datasetId) {
		List<DatasetVO> datasetList = this.datasetService.getDatasetById(datasetId);
		DatasetVO datasetVO = datasetList.get(0);
		datasetVO.setStatus(false);
		this.datasetService.saveDataset(datasetVO);

		return new ModelAndView("redirect:viewDataset");
	}

}

package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.project.model.ComplainVO;
import com.project.model.LoginVO;
import com.project.service.ComplainService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class ComplainController {

	@Autowired
	private ComplainService complainService;

	@Autowired
	private BaseMethods baseMethods;

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "user/postComplain")
	public ModelAndView postComplain(LoginVO loginVO) {

		String userName = baseMethods.getUser();
		loginVO.setUsername(userName);
		List<LoginVO> loginList = this.loginService.searchLoginID(loginVO);

		LoginVO loginVO2 = loginList.get(0);

		List<ComplainVO> complaintList = this.complainService.getUserComplainById(loginVO2.getLoginId());

		return new ModelAndView("user/postComplain", "ComplainVO", new ComplainVO()).addObject("complaintList",
				complaintList);
	}

	@PostMapping(value = "user/saveComplain")
	public ModelAndView saveComplain(@ModelAttribute ComplainVO complainVO, @ModelAttribute LoginVO loginVO,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		System.out.println("in method");

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "docs\\complaint\\";

		try {
			byte barr[] = fileName.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		complainVO.setFileName(fileName);

		complainVO.setFilePath(filePath);

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss ");
		Date date = new Date();
		complainVO.setLoginVO(loginVO);
		complainVO.setComplainDate(dateFormat.format(date));
		complainVO.setComplainStatus("Pending");

		String userName = baseMethods.getUser();
		loginVO.setUsername(userName);
		List<LoginVO> loginList = this.loginService.searchLoginID(loginVO);

		complainVO.setLoginVO(loginList.get(0));

		this.complainService.saveComplain(complainVO);

		return new ModelAndView("redirect:postComplain");
	}

	@GetMapping(value = "admin/viewComplaint")
	public ModelAndView viewComplain() {
		List<ComplainVO> complaintList = this.complainService.viewComplaint();
		return new ModelAndView("admin/viewComplaint", "complaintList", complaintList);
	}

	@GetMapping(value = "admin/complainReply")
	public ModelAndView replyComplain(@RequestParam int complainId) {
		List<ComplainVO> complaintList = this.complainService.getComplainById(complainId);
		return new ModelAndView("admin/complainReply", "ComplainVO", complaintList.get(0));
	}

	@PostMapping(value = "admin/saveReply")
	public ModelAndView saveReply(@ModelAttribute ComplainVO complainVO) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();

		complainVO.setComplainStatus("resolved");
		complainVO.setReplyDate(dateFormat.format(date));

		this.complainService.saveComplain(complainVO);

		return new ModelAndView("redirect:viewComplaint");
	}

	@GetMapping(value = "admin/deleteComplaint")
	public ModelAndView deleteCompalaint(@RequestParam int complainId) {
		List<ComplainVO> complaintList = this.complainService.getComplainById(complainId);
		ComplainVO complainVO = complaintList.get(0);
		// Set status false
		complainVO.setStatus(false);
		this.complainService.saveComplain(complainVO);
		return new ModelAndView("redirect:viewComplaint");
	}

}

package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.LoginDAO;
import com.project.model.LoginVO;
import com.project.model.RegisterVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Transactional
	public void insertRegister(RegisterVO registerVO) {
		this.loginDAO.register(registerVO);
	}

	@Transactional
	public void insertLogin(LoginVO loginVO) {
		this.loginDAO.insertLogin(loginVO);
	}

	@Transactional
	public List<LoginVO> searchLoginID(LoginVO loginVO) {
		List<LoginVO> ls = this.loginDAO.searchLoginID(loginVO);
		return ls;
	}

	@Override
	public void save(LoginVO loginVO) {
		this.loginDAO.insertLogin(loginVO);
	}
}
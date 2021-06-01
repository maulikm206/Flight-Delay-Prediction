package com.project.service;

import java.util.List;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;

public interface LoginService {

	public void insertRegister(RegisterVO registerVO);

	public void insertLogin(LoginVO loginVO);

	public List<LoginVO> searchLoginID(LoginVO loginVO);

	public void save(LoginVO loginVO);

}

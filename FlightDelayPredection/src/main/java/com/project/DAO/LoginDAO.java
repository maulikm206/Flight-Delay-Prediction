package com.project.DAO;

import java.util.List;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;

public interface LoginDAO {

	void register(RegisterVO registerVO);

	void insertLogin(LoginVO loginVO);

	List<LoginVO> searchLoginID(LoginVO loginVO);

}

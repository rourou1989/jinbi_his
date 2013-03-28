package com.his.service.impl;

import com.his.service.LoginService;

public class LoginServiceImpl implements LoginService{

	public boolean isLogin(String username, String password) {
		if("hello".equals(username) && "world".equals(password))  
            return true;  
        else   
            return false;  
	}

}

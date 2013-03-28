package com.his.action;

import com.his.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private LoginService loginService;  
    private String username;  
    private String password;  
    
    public void setLoginService(LoginService loginService) {  
        this.loginService = loginService;  
    }  
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    @Override  
    public String execute() throws Exception {  
        if(loginService.isLogin(username, password))  
            return SUCCESS;  
        else  
            return INPUT;  
    }  
}

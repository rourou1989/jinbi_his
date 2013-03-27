package com.his.test;

import com.his.util.Encript;

public class TestMd5 {
	public static void main(String[] args){
		String pwd =  "123456";
		
		System.out.println(Encript.md5(pwd));
	}
}

package com.hk.clients;

import javax.naming.*;
import com.hk.ejbs.ThirdBean;

public class TestClient {

	public void runTest() throws Exception {
		InitialContext ctx = new InitialContext();
		ThirdBean bean = (ThirdBean) ctx.lookup("ejb/ThirdBeanJNDI");
		String result = bean.sayHello("Hemant Gupta");
		bean.createCustomers();
		System.out.println(result);
	}

	public static void main(String[] args) {
		try {
			TestClient cli = new TestClient();
			cli.runTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}  

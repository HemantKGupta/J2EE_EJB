package com.hk.clients;

import javax.naming.*;
import com.hk.ejbs.SecondBean;

public class TestClient {

	public void runTest() throws Exception {
		InitialContext ctx = new InitialContext();
		SecondBean bean = (SecondBean) ctx.lookup("ejb/SecondBeanJNDI");
		String result1 = bean.sayHello(" Hemant Gupta");
		String result2 = bean.sayHello(" Once again !");
		String result3 = bean.callAnother3();
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		//bean.rem();
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

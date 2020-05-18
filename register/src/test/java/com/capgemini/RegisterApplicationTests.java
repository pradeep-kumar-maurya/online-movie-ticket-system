package com.capgemini;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bean.Authentication;
import com.capgemini.controllerAdvice.NoDataFoundException;
import com.capgemini.service.ServiceI;

@SpringBootTest
class RegisterApplicationTests {
	
	@Autowired
	private ServiceI service;

	@Test
	void register() throws NoDataFoundException {
		
		Authentication auth=new Authentication();
		auth.setSno(123);
		auth.setUsername("anurag");
		auth.setPassword("anurag123");
		String actual=service.register(auth);
		String expected="Registration successfull";
		Assertions.assertEquals(expected, actual);
	}

}

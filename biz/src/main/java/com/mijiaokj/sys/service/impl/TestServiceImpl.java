package com.mijiaokj.sys.service.impl;
import org.springframework.stereotype.Service;
import com.mijiaokj.sys.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Override
	public String test(String test) {
		// TODO Auto-generated method stub
		return test+" World";
	}

}

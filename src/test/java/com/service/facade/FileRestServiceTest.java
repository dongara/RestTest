package com.service.facade;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.service.dto.FileDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FileRestServiceTest {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void store(){
		
	}
	
	@Test
	public void get(){
		ResponseEntity<FileDto> response = testRestTemplate.getForEntity("/file", FileDto.class);
		FileDto dto = response.getBody();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void search(){
		ResponseEntity<List> response = testRestTemplate.getForEntity("/file", List.class);
		List dto = response.getBody();
	}

}

package com.service.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.dto.FileDto;

@Service
public class FileService {

	private HashMap<String, FileDto> fileMap = new HashMap<String, FileDto>();

	public FileDto store(InputStream fileInputStream,
			String fileName){
		String fileLocation = "d://temp/" + fileName;
		save(fileInputStream, fileLocation);

		FileDto dto = new FileDto();
		dto.setFileLocation(fileLocation);
		dto.setFileName(fileName);
		dto.setUploadDatetime(Calendar.getInstance());

		File file =new File(fileLocation);
		if(file.exists()){
			dto.setFileSzie(file.length());
		}
		fileMap.put(fileName, dto);
		return dto;
	}

	public FileDto get(String fileName){
		return fileMap.get(fileName);
	}

	public List<FileDto> search(String file){
		List<FileDto> files = new ArrayList<FileDto>();
		for(String fileName : fileMap.keySet()){
			if(fileName.indexOf(file) > 0){
				files.add(fileMap.get(fileName));
			}
		}
		return files;
	}

	private void save(InputStream fileInputStream,
			String location) {
		try {
			OutputStream out = null;
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(location));
			while ((read = fileInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}

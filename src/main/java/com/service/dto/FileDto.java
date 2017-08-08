package com.service.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileDto implements Serializable{
	
	private static final long serialVersionUID = 8937741330166062360L;

	private String fileName;
	
	private String fileLocation;
	
	private double fileSzie;
	
	private Calendar uploadDatetime;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public double getFileSzie() {
		return fileSzie;
	}

	public void setFileSzie(double fileSzie) {
		this.fileSzie = fileSzie;
	}

	public Calendar getUploadDatetime() {
		return uploadDatetime;
	}

	public void setUploadDatetime(Calendar uploadDatetime) {
		this.uploadDatetime = uploadDatetime;
	}
}

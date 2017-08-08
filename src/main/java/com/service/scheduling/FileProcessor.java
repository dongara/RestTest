package com.service.scheduling;

import java.io.File;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor implements Runnable {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void run() {
		String fileLocation = "d://temp/";
		File f = new File(fileLocation);
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if ((Calendar.getInstance().getTimeInMillis() - file
						.lastModified()) >= (60 * 60 * 1000)) {
					sendSimpleMessage(
							"",
							file.getName() + " has been modified",
							file.getName() + " has been modified at"
									+ file.lastModified());
				}
			}
		}
	}

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

}

	package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLOutput;


	@RestController
	@RequestMapping(path = "/api")
@SpringBootApplication
public class DemoApplication {
		public String breed;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@CrossOrigin( origins = "http://localhost:5173")
	@RequestMapping(method = RequestMethod.POST,path = "/upload")
	public void upload(@RequestParam("file") MultipartFile file) throws Exception {
		byte[] bytes = file.getBytes();
		ByteArrayInputStream inStreambj = new ByteArrayInputStream(bytes);
		BufferedImage newImage = ImageIO.read(inStreambj);
		File fileImage = new File("image.jpg");
		ImageIO.write(newImage, "jpg", fileImage );
		StringBuilder myBuilder = new StringBuilder();
		for(float num : MPEG7Converter.convert()){
			myBuilder.append(num).append(",");
		}
		fileImage.delete();
		Classification classification = new Classification(myBuilder.toString());
		breed = classification.classify();

	}
		@CrossOrigin( origins = "http://localhost:5173")
		@RequestMapping(path = "/classify")
	public String sendClass(String classification){
		return breed;
	}

	
}

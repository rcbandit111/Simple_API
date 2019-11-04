package org.datalis.rest.api.server.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.datalis.rest.api.server.model.Agreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/*")
	public String defaultHandler() {
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		return zonedDateTime.format(format);
	}

	@PostMapping(value = "/v1", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> handleMessage(@RequestBody Agreement data) throws Exception {
		
		
		System.out.println("!!!! Received " + ToStringBuilder.reflectionToString(data));
 
		
		FileOutputStream fout = new FileOutputStream("/opt/result_" + data.getName());
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(ToStringBuilder.reflectionToString(data));


		return ok().build();
	}
}

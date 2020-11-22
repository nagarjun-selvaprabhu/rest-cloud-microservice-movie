package com.nagarjun.ReqSer.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.extern.java.Log;

import com.nagarjun.ReqSer.Dto.Movie;

@RestController
@Log
@CrossOrigin
public class Controller {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	private String serviceId = "MOVIE-NAGARJUN-SERVICE";

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@GetMapping("/dashboard/{id}")
	public Movie findme(@PathVariable Integer id) {
		Movie movie = new Movie();
		try {
//			HttpHeaders headers = new HttpHeaders();
//			String userPass = "user" + ":" + "user";
//			String authHeader =
//			    "Basic " + Base64.getEncoder().encodeToString(userPass.getBytes());
//			headers.set(HttpHeaders.AUTHORIZATION, authHeader);
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		this.restTemplate = restTemplateBuilder.build();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
		Application application = eurekaClient.getApplication(serviceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "/api/getOne/" + id;
		log.info("URL" + url);
		movie = restTemplate.getForObject(url, Movie.class);
		log.info("RESPONSE " + movie);
		return movie;
		}
		catch(Exception e) {
			log.severe("Error while finding the movie due to "+e);
			return movie;
		}
	}

//	@Autowired
//	private DiscoveryClient discoveryClient;
//
//	@RequestMapping("/service-instances/{applicationName}")
//	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
//		return this.discoveryClient.getInstances(applicationName);
//	}
}

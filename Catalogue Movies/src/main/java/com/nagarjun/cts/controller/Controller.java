package com.nagarjun.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarjun.cts.dto.Movie;
import com.nagarjun.cts.Exception.MovieNotFoundException;
import com.nagarjun.cts.Repo.MovieRepo;

import lombok.extern.java.Log;

@RestController
@Log
@CrossOrigin
public class Controller {

	@Autowired
	MovieRepo movrepo;

	@GetMapping("/api/getAll")
	public List<Movie> getCatalog() {
		log.info("INSIDE getCatalog()");
		return (List<Movie>) this.movrepo.findAll();
	}

	@PostMapping(value = "/api/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean insert(@Valid @RequestBody Movie movie) {
			log.info("Insertion of movie object");
			this.movrepo.save(movie);
			return true;
	}

	@RequestMapping(value="/swagger",method = RequestMethod.GET)
	public String greeting() {
		log.info("INSIDE greeting()");
		return "redirect:/swagger-ui.html";
	}

	@GetMapping("/api/getOne/{id}")
	public Movie getOne(@PathVariable Integer id) {
		log.info("Finding the movie with id :" + id);
		return this.movrepo.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
	}

	@DeleteMapping("/api/delete/{id}")
	public Boolean deleteMovie(@PathVariable Integer id) {
			log.info("Deleting the movie with id :"+id);
			movrepo.deleteById(id);
			return true;
	}

}

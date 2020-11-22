package com.nagarjun.cts.Repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarjun.cts.dto.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {

}

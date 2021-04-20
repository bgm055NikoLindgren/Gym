package com.example.Gym.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
	
List<Exercise> findByMove(@Param("move") String move);
List<Exercise> findByReps(int reps);

}

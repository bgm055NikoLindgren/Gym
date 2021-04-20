package com.example.Gym.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BodypartRepository extends CrudRepository<Bodypart, Long> {

	List <Bodypart> findBybodypartName(String bodypartName);

}

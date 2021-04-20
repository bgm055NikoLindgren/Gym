package com.example.Gym.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Gym.domain.Exercise;
import com.example.Gym.domain.ExerciseRepository;
import com.example.Gym.domain.BodypartRepository;

@Controller
public class ExerciseController {
	@Autowired
	private ExerciseRepository repository;

	@Autowired
	private BodypartRepository crepository;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/", "/exerciselist" })
	public String ExerciseList(Model model) {
		model.addAttribute("exercises", repository.findAll());
		return "exerciselist";
	}

	@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public @ResponseBody List<Exercise> exercises() {
		return (List<Exercise>) repository.findAll();
	}

	@RequestMapping(value = "/exercise/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId) {
		return repository.findById(exerciseId);
	}

	@RequestMapping(value = "/add")
	public String addExercise(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("bodyparts", crepository.findAll());
		return "addexercise";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Exercise exercise) {
		repository.save(exercise);
		return "redirect:exerciselist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteExercise(@PathVariable("id") Long exerciseId, Model model) {
		repository.deleteById(exerciseId);
		return "redirect:../exerciselist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String modifyExercise(@PathVariable("id") Long exerciseId, Model model) {
		model.addAttribute("exercise", repository.findById(exerciseId));
		model.addAttribute("bodyparts", crepository.findAll());
		return "modifyexercise";
	}
}

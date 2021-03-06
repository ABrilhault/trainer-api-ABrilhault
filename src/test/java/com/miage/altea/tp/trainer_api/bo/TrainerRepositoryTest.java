package com.miage.altea.tp.trainer_api.bo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import com.miage.altea.tp.trainer_api.repository.TrainerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrainerRepositoryTest {

	@Autowired
	private TrainerRepository repository;

	@Test
	void trainerRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
		assertTrue(CrudRepository.class.isAssignableFrom(TrainerRepository.class));
	}

	@Test
	void trainerRepositoryShouldBeInstanciedBySpring(){
		assertNotNull(repository);
	}

	@Test
	void testSave(){
		var ash = new Trainer("Ash");

		repository.save(ash);

		var saved = repository.findById(ash.getName()).orElse(null);

		assertEquals(ash.getName(), saved.getName());
	}

	@Test
	void testSaveWithPokemons(){
		var misty = new Trainer("Misty");
		var staryu = new Pokemon(120, 18);
		var starmie = new Pokemon(121, 21);
		misty.setTeam(List.of(staryu, starmie));

		repository.save(misty);

		var saved = repository.findById(misty.getName()).orElse(null);

		assertEquals(misty.getName(), saved.getName());
		assertEquals(misty.getTeam().size(), saved.getTeam().size());
	}

}

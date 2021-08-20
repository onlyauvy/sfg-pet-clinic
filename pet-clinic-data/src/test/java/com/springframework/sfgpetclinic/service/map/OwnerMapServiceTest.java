package com.springframework.sfgpetclinic.service.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	final long ownerId = 1L;
	final String lastName = "Smith";

	@BeforeEach
	void setup() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastName(lastName);
		ownerMapService.save(owner);
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		assertEquals(1L, owner.getId());
	}

	@Test
	void testSaveOwner() {
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("SK");

		Owner owner = ownerMapService.save(owner2);
		assertEquals(2L, owner.getId());
	}

	@Test
	void testSaveExistingOwner() {
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("SK");

		Owner owner = ownerMapService.save(owner2);
		assertEquals(2L, owner.getId());
	}

	@Test
	void testSaveNoId() {
		Owner owner2 = new Owner();
		ownerMapService.save(owner2);

		assertNotNull(owner2);
		assertNotNull(owner2.getId());
	}

	@Test
	void testDeleteOwner() {
		Owner smith = ownerMapService.findByLastName(lastName);

		assertNotNull(smith);

		assertEquals(ownerId, smith.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);

		assertEquals(0, ownerMapService.findAll().size());
	}

	/*
	 * @Test void testFindByLastName() { Owner smith =
	 * ownerMapService.findByLastName(lastName);
	 * 
	 * assertNotNull(smith);
	 * 
	 * assertEquals(ownerId, smith.getId()); }
	 */
}

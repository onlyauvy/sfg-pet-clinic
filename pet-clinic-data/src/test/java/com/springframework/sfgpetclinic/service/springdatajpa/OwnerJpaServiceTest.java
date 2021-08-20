package com.springframework.sfgpetclinic.service.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.springframework.sfgpetclinic.repositories.PetRepository;
import com.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
	private static final String LAST_NAME = "smith";
	private Owner returnOwner;
	
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks 
	OwnerJpaService ownerJpaService;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastName(LAST_NAME);
	}


	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		
		Owner owner1 = new Owner(); owner1.setId(1L);
		Owner owner2 = new Owner(); owner2.setId(2L);
		returnOwnerSet.add(owner1);
		returnOwnerSet.add(owner2);
		
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = ownerJpaService.findAll();
		
		assertNotNull(owners);
		assertEquals(2, returnOwnerSet.size()); 
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = ownerJpaService.findById(1L);

        assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = ownerJpaService.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner owner = new Owner(); owner.setId(1L);
		
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner ownerSaved = ownerJpaService.save(owner);
		
		assertNotNull(ownerSaved);
		
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		ownerJpaService.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerJpaService.deleteById(1L);
		verify(ownerRepository, times(1)).deleteById(any());
	}

	@Test
	void testFindByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = ownerJpaService.findByLastName(LAST_NAME);
		
		assertEquals(LAST_NAME, smith.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

}

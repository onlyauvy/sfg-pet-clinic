package com.springframework.sfgpetclinic.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.service.OwnerService;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		
		owners.add(owner1);
		owners.add(owner2);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }
	
	
	@Test
    void testDisplayOwner() throws Exception {
		Owner owner = new  Owner();
		owner.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(owner);

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }

	@Test
	void testFindByLastNameReturnMany() throws Exception {
		List<Owner> owners = new ArrayList<>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		
		owners.add(owner1);
		owners.add(owner2);
		
		when(ownerService.findAllByLastNameLike(anyString()))
		.thenReturn(owners);
		
		mockMvc.perform(get("/owners").param("lastname", ""))
			.andExpect(status().isOk())
			.andExpect(model().attribute("selections", hasSize(2)));
	}
	
	
	@Test
    void testFindByLastNameReturnOne() throws Exception {
		
		List<Owner> owners = new ArrayList<>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		
		owners.add(owner1);
		
        when(ownerService.findAllByLastNameLike(anyString()))
        	.thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }
}

package com.springframework.sfgpetclinic.service.map;

import java.util.Set;

import com.springframework.sfgpetclinic.model.Pet;
import com.springframework.sfgpetclinic.service.CrudService;

public class PetServiceMap extends AbstraceMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}

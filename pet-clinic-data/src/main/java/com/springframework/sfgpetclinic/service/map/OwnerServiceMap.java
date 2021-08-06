package com.springframework.sfgpetclinic.service.map;

import java.util.Set;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.service.CrudService;

public class OwnerServiceMap extends AbstraceMapService<Owner, Long> implements CrudService<Owner, Long> {

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}

package com.springframework.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.sfgpetclinic.model.Speciality;
import com.springframework.sfgpetclinic.repositories.SpecialityRepository;
import com.springframework.sfgpetclinic.service.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService{

	private final SpecialityRepository specialityRepository;
	
	
	public SpecialityJpaService(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}


	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}


	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}


	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}


	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}


	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}
}

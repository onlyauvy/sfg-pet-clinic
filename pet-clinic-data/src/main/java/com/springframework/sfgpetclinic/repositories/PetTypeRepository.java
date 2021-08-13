package com.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}

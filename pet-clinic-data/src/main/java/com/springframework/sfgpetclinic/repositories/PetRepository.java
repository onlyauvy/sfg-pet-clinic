package com.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}

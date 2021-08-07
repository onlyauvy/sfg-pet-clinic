package com.springframework.sfgpetclinic.service.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.service.VetService;

@Service
public class VetServiceMap extends AbstraceMapService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet object) {
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}

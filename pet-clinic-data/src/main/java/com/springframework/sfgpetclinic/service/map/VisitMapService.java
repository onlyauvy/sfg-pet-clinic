package com.springframework.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.springframework.sfgpetclinic.model.Visit;
import com.springframework.sfgpetclinic.service.VisitService;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstraceMapService<Visit, Long> implements VisitService {

	@Override
	public Visit save(Visit object) {
		return super.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}

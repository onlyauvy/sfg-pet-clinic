package com.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.service.OwnerService;
import com.springframework.sfgpetclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Loading data--------------------");
		Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Jone");
        owner2.setLastName("Thomson");
        ownerService.save(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("Sk");
        vet1.setLastName("Mamun");
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setFirstName("Ahsan");
        vet2.setLastName("Habib");
        vetService.save(vet2);

	}
	
}

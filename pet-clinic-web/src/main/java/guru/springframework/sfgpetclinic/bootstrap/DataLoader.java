package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Pipe");
		owner1.setLastName("Garcia");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("David");
		owner2.setLastName("Garcia");

		ownerService.save(owner2);

		System.out.println("Se guardaron dueños");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Jorge");
		vet1.setLastName("Garcia");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(1L);
		vet2.setFirstName("Dary");
		vet2.setLastName("Granados");

		vetService.save(vet2);

		System.out.println("Se guardaron veterinarios");
	}
}
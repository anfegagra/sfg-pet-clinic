package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService,
		VetService vetService,
		PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Pipe");
		owner1.setLastName("Garcia");
		owner1.setAddress("Address 1");
		owner1.setCity("Fredonia");
		owner1.setTelephone("123456789");

		Pet owner1Pet = new Pet();
		owner1Pet.setPetType(savedDogPetType);
		owner1Pet.setOwner(owner1);
		owner1Pet.setBirthDate(LocalDate.now());
		owner1Pet.setName("Benji");
		owner1.getPets().add(owner1Pet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("David");
		owner2.setLastName("Garcia");
		owner1.setAddress("Address 1");
		owner1.setCity("Fredonia");
		owner1.setTelephone("123456789");

		Pet owner2Pet = new Pet();
		owner2Pet.setName("Benji2");
		owner2Pet.setOwner(owner2);
		owner2Pet.setBirthDate(LocalDate.now());
		owner2Pet.setPetType(savedCatPetType);
		ownerService.save(owner2);

		System.out.println("Se guardaron dueños");

		Vet vet1 = new Vet();
		vet1.setFirstName("Jorge");
		vet1.setLastName("Garcia");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Dary");
		vet2.setLastName("Granados");

		vetService.save(vet2);

		System.out.println("Se guardaron veterinarios");
	}
}

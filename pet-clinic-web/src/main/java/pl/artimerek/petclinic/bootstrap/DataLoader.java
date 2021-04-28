package pl.artimerek.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.artimerek.petclinic.model.Owner;
import pl.artimerek.petclinic.model.Vet;
import pl.artimerek.petclinic.services.OwnerService;
import pl.artimerek.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Konrad");
        owner1.setLastName("Rzepakowski");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maciej");
        owner2.setLastName("Ananas");

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Wojciech");
        vet1.setLastName("Pieskowy");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr. Maciej");
        vet2.setLastName("Koci");

        vetService.save(vet2);

        System.out.println("Vets loaded");

    }
}
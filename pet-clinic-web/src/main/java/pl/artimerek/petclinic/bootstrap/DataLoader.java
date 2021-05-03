package pl.artimerek.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.artimerek.petclinic.model.*;
import pl.artimerek.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService typeService;
    private final SpecialtiesService specialtiesService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService typeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.typeService = typeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = typeService.findAll().size();

        if(count == 0)
            initialize();
    }

    private void initialize() {
        PetType cat = new PetType("Cat");
        PetType savedPetType = typeService.save(cat);

        PetType dog = new PetType("Dog");
        PetType savedPetType2 = typeService.save(dog);

        PetType hamster = new PetType("Hamster");
        PetType savedPetType3 = typeService.save(hamster);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

        System.out.println("Pet types loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Konrad");
        owner1.setLastName("Rzepakowski");
        owner1.setAddress("ul.Daleka 17");
        owner1.setCity("Kraków");
        owner1.setTelephone("666-666-666");

        Pet konradsPet = new Pet();
        konradsPet.setPetType(savedPetType);
        konradsPet.setOwner(owner1);
        konradsPet.setBirthDate(LocalDate.now());
        konradsPet.setName("Mimi");
        owner1.getPets().add(konradsPet);

        System.out.println(owner1.getFirstName()+"'s pet loaded - "+ konradsPet.getName() );

        Pet konradsPet2 = new Pet();
        konradsPet2.setPetType(savedPetType2);
        konradsPet2.setOwner(owner1);
        konradsPet2.setBirthDate(LocalDate.now());
        konradsPet2.setName("Reksio");
        owner1.getPets().add(konradsPet2);

        System.out.println(owner1.getFirstName()+"'s pet loaded - "+ konradsPet2.getName() );

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maciej");
        owner2.setLastName("Ananas");
        owner2.setAddress("ul.Bliska 52");
        owner2.setCity("Zakopane");
        owner2.setTelephone("777-776-666");

        Pet ananassPet = new Pet();
        ananassPet.setPetType(savedPetType3);
        ananassPet.setOwner(owner1);
        ananassPet.setBirthDate(LocalDate.now());
        ananassPet.setName("Garfield");
        owner2.getPets().add(ananassPet);

        System.out.println(owner2.getFirstName()+"'s pet loaded - "+ ananassPet.getName() );

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Joanna");
        owner3.setLastName("Rzeplińska");
        owner3.setAddress("ul.Ćwiartki 3/4");
        owner3.setCity("Wrocław");
        owner3.setTelephone("222-776-666");

        Pet joannasPet = new Pet();
        joannasPet.setPetType(savedPetType2);
        joannasPet.setOwner(owner3);
        joannasPet.setBirthDate(LocalDate.now());
        joannasPet.setName("Timmy");
        owner3.getPets().add(joannasPet);

        System.out.println(owner3.getFirstName()+"'s pet loaded - "+ joannasPet.getName() );

        ownerService.save(owner3);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr. Wojciech");
        vet1.setLastName("Pieskowy");
        vet1.getSpeciality().add(surgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr. Maciej");
        vet2.setLastName("Koci");
        vet2.getSpeciality().add(dentistry);

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}

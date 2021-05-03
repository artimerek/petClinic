package pl.artimerek.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.artimerek.petclinic.model.Speciality;
import pl.artimerek.petclinic.model.Vet;
import pl.artimerek.petclinic.services.SpecialtiesService;
import pl.artimerek.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
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
    public Vet save(Vet object) {
        if(object.getSpeciality().size()> 0){
            object.getSpeciality().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality =  specialtiesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
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

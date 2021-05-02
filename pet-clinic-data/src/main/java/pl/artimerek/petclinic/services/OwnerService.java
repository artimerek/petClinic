package pl.artimerek.petclinic.services;

import pl.artimerek.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

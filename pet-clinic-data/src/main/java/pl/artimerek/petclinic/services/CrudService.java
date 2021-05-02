package pl.artimerek.petclinic.services;

import java.util.Set;

/*
   To be inherited by services,
    helps them to be more specific
 */


public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}

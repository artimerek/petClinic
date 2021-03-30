package pl.artimerek.petclinic.model;

import java.io.Serializable;

/*
     To be inherited by model classes
 */


public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

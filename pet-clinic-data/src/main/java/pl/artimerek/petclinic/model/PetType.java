package pl.artimerek.petclinic.model;

// closing

public class PetType extends BaseEntity{

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

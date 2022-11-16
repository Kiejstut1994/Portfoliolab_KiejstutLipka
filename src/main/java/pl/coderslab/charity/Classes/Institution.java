package pl.coderslab.charity.Classes;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "Institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Size(min=5,max = 40,message = "Nazwa fundacji między 5 a 20 znaków")
    private String name;
    @Column(name = "description")
    @Size(min=5,max = 200,message = "Opis między 5 a 200 znaków")
    private String description;
    public Institution(Long id, String name,String description) {
        this.id=id;
        this.name = name;
        this.description = description;
    }
    public Institution() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

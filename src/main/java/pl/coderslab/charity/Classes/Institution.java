package pl.coderslab.charity.Classes;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    @Size(min=5,max = 40,message = "Nazwa fundacji między 5 a 20 znaków")
    private String name;
    @Column(name = "description",nullable = false)
    @Size(min=5,max = 200,message = "Opis między 5 a 200 znaków")
    private String description;





    public Institution(int id, String name,String description) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

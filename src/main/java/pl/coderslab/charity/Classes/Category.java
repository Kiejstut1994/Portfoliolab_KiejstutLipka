package pl.coderslab.charity.Classes;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@EqualsAndHashCode
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Size(min=3,max = 100,message = "Za długa lub za krótka nazwa")
    private String name;
    public Category(Long id, String name) {
        this.id=id;
        this.name = name;
    }

    public Category() {

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

}

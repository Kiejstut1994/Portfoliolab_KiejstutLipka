package pl.coderslab.charity.Classes;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    @Size(min=5,max = 100,message = "Za długa lub za krótka nazwa")
    private String name;






    public Category(int id, String name) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}

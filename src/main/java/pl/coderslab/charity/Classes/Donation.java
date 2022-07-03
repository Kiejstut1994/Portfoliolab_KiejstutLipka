package pl.coderslab.charity.Classes;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity",nullable = false)
    @Positive
    private int quantity;
    @Column(name = "street",nullable = false)
    @Size(min=2,max = 40,message = "Za długa lub za krótka nazwa")
    private String street;
    @Column(name = "city",nullable = false)
    @Size(min=2,max = 20,message = "Za długa lub za krótka nazwa")
    private String city;



    @Column(name = "phone",nullable = false)
    @NumberFormat
    private int phone;
    @Column(name = "zipCode",nullable = false)
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]",message = "Zły zipcode")
    private String zipCode;
    @Column(name = "pickUpDate",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @Column(name = "pickUpTime",nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    @Column(name = "pickUpComment",nullable = false)
    @Size(min=2,max = 50,message = "Komentarz między 2 a 50 znaków")
    private String pickUpComment;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> categories;
    @OneToOne
    private Institution institution;


    public Donation(){}

    public Donation(int id, int quantity, String street, String city,int phone, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment,List<Category> categories,Institution institution) {
        this.id = id;
        this.quantity = quantity;
        this.street = street;
        this.city = city;
        this.phone =phone;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.categories = categories;
        this.institution=institution;
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}







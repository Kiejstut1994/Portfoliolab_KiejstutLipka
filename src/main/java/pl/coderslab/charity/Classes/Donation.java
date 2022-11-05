package pl.coderslab.charity.Classes;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long id;
    @Column(name = "quantity")
    @Positive(message = "Liczba dodatnia")
    private int quantity;
    @Column(name = "street")
    @Size(min=2,max = 40,message = "Za długa lub za krótka nazwa")
    private String street;
    @Column(name = "city")
    @Size(min=2,max = 20,message = "Za długa lub za krótka nazwa")
    private String city;
    @Column(name = "phone")
    @Positive(message = "Liczba dodatnia")
    private int phone;
    @Column(name = "zipCode")
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]",message = "Zły zipcode")
    private String zipCode;
    @Column(name = "pickUpDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Wybierz wartość")
    private LocalDate pickUpDate;
    @Column(name = "pickUpTime")
    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "Wybierz wartość")
    private LocalTime pickUpTime;
    @Column(name = "pickUpComment")
    @Size(min=2,max = 50,message = "Komentarz między 2 a 50 znaków")
    private String pickUpComment;
    @ManyToMany(cascade = CascadeType.ALL)
    @NotNull(message = "Wybierz conajmniej jedną z opcji")
    private List<Category> categories;
    @OneToOne
    @NotNull(message = "Wybierz jedną z opcji")
    private Institution institution;
    @OneToOne
    private User user;

    public Donation(){}

    public Donation(Long id, int quantity, String street, String city,int phone, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment,List<Category> categories,Institution institution,User user) {
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
        this.user=user;
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}







package exercise.jpamvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street",  nullable = false)
    String street;

    @Column(name = "building",  nullable = false)
    String building;

    @Column(name = "city",  nullable = false)
    String city;

    @Column(name = "state",  nullable = false)
    String state;

    @Column(name = "zip",  nullable = false)
    String zip;

    @Column(name = "country",  nullable = false)
    String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding(){
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state) {
        this.state= state;
    }

    public String getZip(){
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public  Address(Long id, String street, String building, String city, String state, String zip, String country){
        this.id = id;
        this.street = street;
        this.building = building;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Address(){}

    @Override
    public String toString(){
        return building + " " + street + " " + city + " " + zip + " " + country;
    }
}

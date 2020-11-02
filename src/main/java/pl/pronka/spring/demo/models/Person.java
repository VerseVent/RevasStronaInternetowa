package pl.pronka.spring.demo.models;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Column(name="number", nullable = false)
    private String phone;
    private String mail;
    @Column(length = 2048)
    private String description;
    @Transient
    boolean nowy;

    public Person(String name, String surname, String phone, String mail, String description, boolean nowy) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
        this.nowy = nowy;
    }

    public Person(Integer id, String name, String surname, String phone, String mail, String description, boolean nowy) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
        this.nowy = nowy;
    }
    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", nowy=" + nowy +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}



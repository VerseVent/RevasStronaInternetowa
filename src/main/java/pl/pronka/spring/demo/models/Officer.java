package pl.pronka.spring.demo.models;

import javax.persistence.*;

@Entity
@Table(name="sellers")
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Column(name = "number", nullable = false)
    private String phone;
    private String mail;
    @Column(length = 2048)
    private String rank;
    private String info;
    @Transient
    boolean nowy;

    public Officer(Integer id, String name, String surname, String phone, String mail, String rank, boolean nowy) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.rank = rank;
        this.nowy= nowy;
    }

    public Officer(Integer id, String name, String surname, String phone, String mail, String rank, String info, boolean nowy) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.rank = rank;
        this.info = info;
        this.nowy = nowy;
    }

    public Officer(String name, String surname, String phone, String mail, String rank, String info, boolean nowy) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.rank = rank;
        this.info = info;
        this.nowy = nowy;
    }

    public Officer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", rank='" + rank + '\'' +
                ", info='" + info + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}



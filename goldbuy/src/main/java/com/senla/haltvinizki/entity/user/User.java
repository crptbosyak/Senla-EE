package com.senla.haltvinizki.entity.user;

import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.role.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = "user-credentials", attributeNodes = @NamedAttributeNode("credentials"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "credentialsId")
    private Credentials credentials;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "roleid")})
    private List<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "mail")
    private String mail;


    public User(int id, Credentials credentials, List<Role> roles, String name, String phoneNumber, String mail, List<Product> products) {
        this.id = id;
        this.credentials = credentials;
        this.roles = roles;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.products = products;
    }

    public User() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}

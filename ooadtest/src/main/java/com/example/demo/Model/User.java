package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")  
    private int id;

    @Column(name = "username")  
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }

    @Override
    public String getPassword() { return password; }
    @Override
    public void setPassword(String password) { this.password = password; }

}

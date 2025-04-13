package com.example.demo.Model;

public class Admin extends AppUser {
    public Admin() {}

    public Admin(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

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

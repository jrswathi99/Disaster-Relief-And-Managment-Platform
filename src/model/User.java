/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.ValidationUtils;

/**
 *
 * @author DELL
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private int age;
    private Role role;

    

    public User(String id, String name,String email,String password,int age, Role role) {
        if (!ValidationUtils.isValidName(name) ) {
            throw new IllegalArgumentException("Invalid User Details");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

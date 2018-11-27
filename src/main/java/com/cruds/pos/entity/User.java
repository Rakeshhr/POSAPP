/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")   
    private Long id;

    @Column(name="user_name", nullable = false, unique = true)
    private String name;     
    
    @Column
    private String password;

    @Column(name = "user_role")
    private String role;
    
    public User() {
    }

    public User(String name, String password, String role) {
        this.name = name.toUpperCase();
        this.password = password.toUpperCase();
        this.role = role;
    }
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
    
    
    
}

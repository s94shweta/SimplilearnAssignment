package org.shweta.trailpage.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity  
@Table(name= "MyIntro")   
public class MyIntro {

    @javax.persistence.Id @GeneratedValue   
    @Column(name = "Id")
	int Id;
	
    @Column(name = "Name")
	String Name;
	
    @Column(name = "email")
	String email;
	
    @Column(name = "place")
	String place;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public MyIntro(int id, String name, String email, String place) {
		super();
		Id = id;
		Name = name;
		this.email = email;
		this.place = place;
	}
	
	
	
}

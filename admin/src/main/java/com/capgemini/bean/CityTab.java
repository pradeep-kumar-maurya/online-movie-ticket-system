package com.capgemini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CityTab")
public class CityTab {
	
	@Id
	@GeneratedValue
	@Column(length = 3)
	private int city_Id;
	@Column(length = 20)
	private String city_Name;
	
	public int getCity_Id() {	
		return city_Id;
	}
	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}
	public String getCity_Name() {
		return city_Name;
	}
	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}
}
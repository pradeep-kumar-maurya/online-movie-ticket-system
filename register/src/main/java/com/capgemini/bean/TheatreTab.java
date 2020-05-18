package com.capgemini.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TheatreTab")
public class TheatreTab {
	
	@Id
	@GeneratedValue
	@Column(length = 3)
	private int theatre_Id;
	@Column(length = 15)
	private String theatre_Name;
	@Column(length = 20)
	private String theatre_manager;
	@Column(length = 20)
	private String city_Name;
	@Column(length = 10)
	private String manager_contact_no;
	
	public int getTheatre_Id() {
		return theatre_Id;
	}
	public void setTheatre_Id(int theatre_Id) {
		this.theatre_Id = theatre_Id;
	}
	public String getTheatre_Name() {
		return theatre_Name;
	}
	public void setTheatre_Name(String theatre_Name) {
		this.theatre_Name = theatre_Name;
	}
	public String getTheatre_manager() {
		return theatre_manager;
	}
	public void setTheatre_manager(String theatre_manager) {
		this.theatre_manager = theatre_manager;
	}
	public String getCity_Name() {
		return city_Name;
	}
	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}
	public String getManager_contact_no() {
		return manager_contact_no;
	}
	public void setManager_contact_no(String manager_contact_no) {
		this.manager_contact_no = manager_contact_no;
	}
}
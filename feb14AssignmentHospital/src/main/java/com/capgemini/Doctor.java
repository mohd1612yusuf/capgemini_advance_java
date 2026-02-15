package com.capgemini;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	private Long id;
	private String ename;
	private String specialization;

	@OneToMany
	private List<Appointment> list;

	public Doctor(Long id, String ename, String specialization) {
		super();
		this.id = id;
		this.ename = ename;
		this.specialization = specialization;
	}

	public Doctor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Appointment> getList() {
		return list;
	}

	public void setList(List<Appointment> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", ename=" + ename + ", specialization=" + specialization + ", list=" + list + "]";
	}

}
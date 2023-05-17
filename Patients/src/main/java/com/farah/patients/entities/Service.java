package com.farah.patients.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idSer;
	private String nomSer;
	private String descriptionSer;
	
	
	@OneToMany(mappedBy = "service")
	@JsonIgnore
	private List<Patient> patients;
	
	
	public Service() {  
		
		}

	public Service(Long idSer, String nomSer, String descriptionSer, List<Patient> patients) {
		super();
		this.idSer = idSer;
		this.nomSer = nomSer;
		this.descriptionSer = descriptionSer;
		this.patients = patients;
	}

	public Long getIdSer() {
		return idSer;
	}

	public void setIdSer(Long idSer) {
		this.idSer = idSer;
	}

	public String getNomSer() {
		return nomSer;
	}

	public void setNomSer(String nomSer) {
		this.nomSer = nomSer;
	}

	public String getDescriptionSer() {
		return descriptionSer;
	}

	public void setDescriptionSer(String descriptionSer) {
		this.descriptionSer = descriptionSer;
	}

	public List<Patient> getPatient() {
		return patients;
	}

	public void setPatient(List<Patient> patients) {
		this.patients = patients;
	}

	
}

package com.farah.patients.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Patient {
 @Id 
 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 ///les annotation
 private Long idPatient;
@NotNull
 @Size (min = 4,max = 15)
 private String nomPatient;
@NotNull
@Size (min = 4,max = 15)
 private String prenomPatient;
 
 @Temporal(TemporalType.DATE)
 @DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
 private Date datenaiss;
 @ManyToOne
 private Service service;
 
 
 public Service getService() {
	return service;
}
public void setService(Service service) {
	this.service = service;
}
public Patient() {
 super();
 }
public Patient( String nomPatient, String prenomPatient, Date datenaiss) {
	super();

	this.nomPatient = nomPatient;
	this.prenomPatient = prenomPatient;
	this.datenaiss = datenaiss;
}
public Long getIdPatient() {
	return idPatient;
}
public void setIdPatient(Long idPatient) {
	this.idPatient = idPatient;
}
public String getNomPatient() {
	return nomPatient;
}
public void setNomPatient(String nomPatient) {
	this.nomPatient = nomPatient;
}
public String getPrenomPatient() {
	return prenomPatient;
}
public void setPrenomPatient(String prenomPatient) {
	this.prenomPatient = prenomPatient;
}
public Date getDatenaiss() {
	return datenaiss;
}
public void setDatenaiss(Date datenaiss) {
	this.datenaiss = datenaiss;
}
@Override
public String toString() {
	return "Patient [idPatient=" + idPatient + ", nomPatient=" + nomPatient + ", prenomPatient=" + prenomPatient
			+ ", datenaiss=" + datenaiss + "]";
}

}

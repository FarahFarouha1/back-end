package com.farah.patients.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.farah.patients.entities.Patient;
import com.farah.patients.entities.Service;

public interface PatientService {
Patient savePatient (Patient p);
Patient updatePatient (Patient p);
	void deletePatient (Patient p);
	 void deletePatientById(Long id);
	 Patient getPatientByID(Long id);
	List<Patient> getAllPatient();
	Page<Patient> getAllPatientsParPage(int page, int size);
	
//
	List<Patient> findBynomPatient(String nom);
	 List<Patient> findBynomPatientContains(String nom);
	 List<Patient>  findByNomPrenomPatient ( String nom,String prenom) ;
	 List<Patient> findByService (Service service) ;
	 List<Patient> findByServiceIdSer(Long id);
	 List<Patient> findByOrderByNomPatientAsc();
	 List<Patient> trierPatientsNomsPrenom();
	
	 
}
package com.farah.patients.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.farah.patients.entities.Patient;
import com.farah.patients.repos.PatientRepository;
@Configuration
@Service
public class PatientServiceImpl  implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	
	
	
	@Override
	public Patient savePatient(Patient p) {
		
		return patientRepository.save(p);
	}

	@Override
	public Patient updatePatient(Patient p) {
		
		return  patientRepository.save(p);

	}

	@Override
	public void deletePatient(Patient p) {
		patientRepository.delete(p);
		
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient getPatientByID(Long id) {
		
		return  patientRepository.findById(id).get();

	}

	@Override
	public List<Patient> getAllPatient() {
	
		return patientRepository.findAll();
	}
	@Override
	public Page<Patient> getAllPatientsParPage(int page, int size) {
	return patientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Patient> findBynomPatient(String nom) {
		
		return  patientRepository.findBynomPatient(nom);
	}

	@Override
	public List<Patient> findBynomPatientContains(String nom) {
	
		return patientRepository.findBynomPatientContains(nom);
	}

	//@Override
	/*public List<Patient> findByNomPrenomPatient(String nom, String prenom) {
		
//		return patientRepository.findByNomPrenomPatient(nom, prenom);
		//return patientRepository.findByNomPrenomPatient(nom, prenom);
	}*/

//	@Override
	//public List<Patient> findByService(Service service) {

	//	return patientRepository.findByService(service);
	//}

	@Override
	public List<Patient> findByServiceIdSer(Long id) {
		
		return patientRepository.findByServiceIdSer(id);
	}

	@Override
	public List<Patient> findByOrderByNomPatientAsc() {
	
		return patientRepository.findByOrderByNomPatientAsc();
	}

	@Override
	public List<Patient> trierPatientsNomsPrenom() {
		
		return patientRepository.trierPatientsNomsPrenom();
	}

	/*
	@Override
	public List<Patient> findByService(com.farah.patients.entities.Service service) {
		
		return  patientRepository.findByService(service) ;
	}
*/
	@Override
	public List<Patient> findByNomPrenomPatient(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findByService(com.farah.patients.entities.Service service) {
		// TODO Auto-generated method stub
		return null;
	}

}

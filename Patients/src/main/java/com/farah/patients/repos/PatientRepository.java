package com.farah.patients.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farah.patients.entities.Patient;
import com.farah.patients.entities.Service;
@RepositoryRestResource(path = "rest")
public interface PatientRepository extends JpaRepository<Patient, Long> {
	 List<Patient> findBynomPatient(String nom);
	 List<Patient> findBynomPatientContains(String nom);
	
	 /*@Query("select p from Patient p where p.nomPatient like %:name and p.prenomPatient like %:prenom")
	 List<Patient> findByNomPrenomPatient(@Param("name") String name,@Param("prenom") String prenom);
	 
	 @Query("select p from patient p where p.nom_ser = ?1")
	 List<Patient> findByService (Service service) ;*/
	
	 List<Patient> findByServiceIdSer(Long id);
	 //trier les nom des patient sur l'ordre croissant
	 List<Patient> findByOrderByNomPatientAsc();
	 
	 @Query("select p from Patient p order by p.nomPatient ASC, p.prenomPatient DESC")
	 List<Patient> trierPatientsNomsPrenom();
	 
	 
}
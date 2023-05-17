package com.farah.patients;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import com.farah.patients.repos.PatientRepository;
import com.farah.patients.service.PatientService;
import com.farah.patients.entities.Patient;
import com.farah.patients.entities.Service;

@SpringBootTest
class PatientsApplicationTests {
 
	@Autowired
	private PatientRepository patientRepository;
	private PatientService patientService;
	
	@Test
	public void testCreatePatient()
	{
	Patient pas= new Patient("amin","benhmida",new Date());
	patientRepository.save(pas);
	}
	
	
	 @Test
	 public void testFindPatient()
	 {
			Patient p = patientRepository.findById(1L).get();
	 System.out.println(p);
	 }

	
	 @Test
	 public void testUpdatePatient()
	 {
		 Patient p = patientRepository.findById(1L).get();
	 p.setPrenomPatient("benhsan");
	 patientRepository.save(p);
	 }
	 @Test
	 public void testDeletePatient()
	 {
		 patientRepository.deleteById(1L);;
	 }

	
	 @Test
	 public void testListerTousPatients()
	 {
	 List<Patient> pas = patientRepository.findAll();
	 for (Patient p : pas)
	 {
	 System.out.println(p);
	 }}
	 
//	 
//	 
//	 
	 @Test
 public void testFindByNomPatientContains()
 {
 Page<Patient> pas = patientService.getAllPatientsParPage(0,2);
	 System.out.println(pas.getSize());
 System.out.println(pas.getTotalElements());
	 System.out.println(pas.getTotalPages());
 pas.getContent().forEach(p -> {System.out.println(p.toString());
	  });}
 @Test
 public void testfindBynomPatient()
 {
		List<Patient> pas = patientRepository.findBynomPatient("yasmin");
		 for (Patient p : pas)
		 {
		 System.out.println(p);}}
 
 
 @Test
 public void testFindByNomProduitContains ()
 {
 List<Patient> pas=patientRepository.findBynomPatientContains("yas");
 for (Patient p : pas)
 {
 System.out.println(p);
 } }
 
// @Test
// public void testfindByNomPrenomPatient()
// {
// List<Patient> pas = patientRepository.findByNomPrenomPatient("yasmin", "messadi");
// for( Patient p : pas)
// {
// System.out.println(p);
// }
// }
 
 @Test
 public void testfindByService()
 {
	 Service ser = new Service();
 ser.setIdSer(1L);
 }
// List<Patient> pas = patientRepository.findByService(ser);
// for (Patient p : pas)
// {
// System.out.println(p);
// }
// }
// 
 @Test
 public void testfindByServiceIdSert()
 {
 List<Patient> pas = patientRepository.findByServiceIdSer(1L);
 for (Patient p : pas)
 {
 System.out.println(p);
 }
 }
 @Test
 public void testfindByOrderByNomPatientAsc()
 {
 List<Patient> pas = patientRepository.findByOrderByNomPatientAsc();
 for (Patient p : pas)
 {
 System.out.println(p);
 }
 }
 
 @Test
 public void testtrierPatientsNomsPrenom()
 {
 List<Patient> pas = patientRepository.trierPatientsNomsPrenom();
 for (Patient p : pas)
 {
 System.out.println(p);
 }
 }

 
  
 
 
 
}

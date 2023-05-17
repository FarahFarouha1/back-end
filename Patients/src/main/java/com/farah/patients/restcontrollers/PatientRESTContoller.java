package com.farah.patients.restcontrollers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farah.patients.entities.Patient;
import com.farah.patients.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientRESTContoller {
	@Autowired
 PatientService   patientService ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Patient> getAllPatients()

         {
		return patientService.getAllPatient();
		}
	  
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") Long id)
	
	{
	return patientService.getPatientByID(id);
	 }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient ){
	return patientService.savePatient(patient);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Patient updateProduit(@RequestBody Patient patient) {
	return patientService.updatePatient(patient);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePatientt(@PathVariable("id") Long id)
	{
	patientService.deletePatientById(id);
	}

	@RequestMapping(value="/PASSER/{idCat}",method = RequestMethod.GET)
	public List<Patient> getPatientsBySerId(@PathVariable("idSer") Long idSer) {
	return patientService.findByServiceIdSer(idSer);
	}
	
	
}

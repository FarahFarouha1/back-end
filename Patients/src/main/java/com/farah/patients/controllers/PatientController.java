package com.farah.patients.controllers;

import java.text.ParseException;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;

import com.farah.patients.entities.Patient;
import com.farah.patients.service.PatientService;
//import javax.validation.constraints.Valid;

@Controller
public class PatientController {
 @Autowired 
 PatientService patientService;
 
 @RequestMapping("/showCreate")
 public String showCreate(ModelMap modelMap)
 {
 modelMap.addAttribute("patient", new Patient());
 modelMap.addAttribute("mode", "new");
 return "formPatient";
 }

 
 //valid
 @RequestMapping("/savePatient")
 public String savePatient(@Valid  Patient Patient,
                                    BindingResult bindingResult)
 {
 if (bindingResult.hasErrors()) return "formPatient";

 patientService.savePatient(Patient);
 return "formPatient";
 }

 
 @RequestMapping("/ListePatients")
 public String listePatients(ModelMap modelMap,
 @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
 {
 Page<Patient> pas = patientService.getAllPatientsParPage(page, size);
 modelMap.addAttribute("patients", pas);
  modelMap.addAttribute("pages", new int[pas.getTotalPages()]);
 modelMap.addAttribute("currentPage", page);
 return "listePatients";
 }
 
 @RequestMapping("/modifierPatient")
 public String editerPatient(@RequestParam("id") Long id,ModelMap modelMap)
 {
 Patient p= patientService.getPatientByID(id);
 modelMap.addAttribute("patient", p);
 modelMap.addAttribute("mode", "edit");
 return "formPatient";
 }

 
 
 @RequestMapping("/updatePatient")
 public String updatePatient(@ModelAttribute("patient") Patient patient,
 @RequestParam("date") String date,ModelMap modelMap) throws ParseException 
 {
SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date datenaiss = dateformat.parse(String.valueOf(date));
	 patient.setDatenaiss(datenaiss);
	 
	 patientService.updatePatient(patient);
	 List<Patient> pas = patientService.getAllPatient();
	 modelMap.addAttribute("patients", pas);
	return "listePatients";
	}

 
 
 
 
 
 @RequestMapping("/supprimerPatient")
 public String supprimerPatient(@RequestParam("id") Long id,
ModelMap modelMap,
 @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
 {
 patientService.deletePatientById(id);
 Page<Patient> pas = patientService.getAllPatientsParPage(page,
 size);
 modelMap.addAttribute("patients", pas);
 modelMap.addAttribute("pages", new int[pas.getTotalPages()]);
 modelMap.addAttribute("currentPage", page);
 modelMap.addAttribute("size", size);
 return "listePatients";
 }

 
 
 
 
 
 
 
}

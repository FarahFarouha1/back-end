package com.farah.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.farah.patients.service.PatientService;
@SpringBootApplication
public class PatientsApplication implements CommandLineRunner {
	
	
	
@Autowired
private PatientService patientService ;


public static void main(String[] args) {
SpringApplication.run(PatientsApplication.class, args);
}

public PatientService getPatientService() {
	return patientService;
}
public void setPatientService(PatientService patientService) {
	this.patientService = patientService;
	
}

@Override
public void run(String... args) throws Exception {
	 PasswordEncoder passwordEncoder = passwordEncoder ();
//	 System.out.println("Passwors Encoded BCRYPT :******************** ");
//	 System.out.println(passwordEncoder.encode("123"));
//	
	 
}

@Bean
public PasswordEncoder passwordEncoder () {
return new BCryptPasswordEncoder();

}

}






























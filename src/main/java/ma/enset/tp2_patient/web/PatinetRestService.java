package ma.enset.tp2_patient.web;

import ma.enset.tp2_patient.entities.Patient;
import ma.enset.tp2_patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatinetRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient findPatient(@PathVariable Long id){
        return patientRepository.findById(id).orElse(null);
    }
}

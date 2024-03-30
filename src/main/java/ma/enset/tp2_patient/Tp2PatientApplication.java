package ma.enset.tp2_patient;

import ma.enset.tp2_patient.entities.Patient;
import ma.enset.tp2_patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2PatientApplication implements CommandLineRunner {
	@Autowired //injection des dependances
	private PatientRepository patientRepository;
	public static void main(String[] args){
		SpringApplication.run(Tp2PatientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Date date = new Date("12/12/2002");
		//patientRepository.save(new Patient(null,"Ahmed",date,true,3));
		//patientRepository.save(new Patient(null,"Amine",new Date(),false,2));

		System.out.println("Afficher tous les patients *****************");
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(patient -> {
			System.out.println(patient.toString());
		});

		System.out.println("Chercher par ID******************");
		Patient patient = patientRepository.findById(Long.valueOf(1)).get();
		// OU patientRepository.findById(Long.valueOf(1)).orElse(null);
		System.out.println(patient.getNom());

		System.out.println("Chercher par Nom******************");
		List<Patient> patients1 = patientRepository.findByNomContains("d");
		patients1.forEach(patient1 -> {
			System.out.println(patient1.toString());
		});

		System.out.println("Search******************");
		List<Patient> patients2 = patientRepository.search("%i%");
		patients2.forEach(patient2 -> {
			System.out.println(patient2.toString());
		});

		System.out.println("Greater Than******************");
		List<Patient> patients3 = patientRepository.findByScoreGreaterThan(2);
		patients3.forEach(patient3 -> {
			System.out.println(patient3.toString());
		});

		System.out.println("Modifier******************");
		Patient patients4 = patientRepository.findById(Long.valueOf(2)).orElse(null);
		patients4.setNom("Monir");
		patientRepository.save(patients4);
		System.out.println(patients4.getNom());

		System.out.println("Supprimer*******************");
		patientRepository.delete(patientRepository.findById(Long.valueOf(4)).get());


		System.out.println("Afficher tous les patients *****************");
		List<Patient> patientsList = patientRepository.findAll();
		patientsList.forEach(p -> {
			System.out.println(p.toString());
		});

	}
}

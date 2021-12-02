package mg.orchid.appliBancaire;

import java.util.Date;

import mg.orchid.appliBancaire.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import mg.orchid.appliBancaire.entities.Client;
import mg.orchid.appliBancaire.entities.CompteCourant;
import mg.orchid.appliBancaire.entities.CompteEpargne;

public class MaBanqueApplication implements CommandLineRunner{

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
    CompteRepository compteRepository;
	
	@Autowired
    OperationRepository operationRepository;
	
	@Autowired
    EmployeRepository employeRepository;
	
	@Autowired
	AgenceRepository agenceRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*
	Client cltA=new Client("Patrick", "razashivas@gmail.com");
	clientRepository.save(cltA);
	Client cltB=new Client("Nadia", "nadia@gmail.com");
	clientRepository.save(cltB);
	
	CompteCourant ccA=new CompteCourant("CC1", new Date(), 1000L,cltA,3000L);
	compteRepository.save(ccA);
	CompteCourant ccB=new CompteCourant("CC2", new Date(), 15000L,cltB,8000L);
	compteRepository.save(ccB);
	CompteEpargne ceA=new CompteEpargne("CE1", new Date(), 18000L,cltA,10);
	compteRepository.save(ceA);
	CompteEpargne ceB=new CompteEpargne("CE2", new Date(), 181000L,cltB,10);
	compteRepository.save(ceB);
	*/
		
	}

}

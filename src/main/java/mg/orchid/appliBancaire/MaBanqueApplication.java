package mg.orchid.appliBancaire;

import java.util.Arrays;
import java.util.Date;

import mg.orchid.appliBancaire.Metier.IBanqueMetier;
import mg.orchid.appliBancaire.dao.*;
import mg.orchid.appliBancaire.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner{
    @Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;




	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
	}

    	@Override
	public void run(String... args) throws Exception {
		/*//Création des clients
		Client c1=clientRepository.save(new Client("Patrick","razashivas@gmail.com"));
		Client c2=clientRepository.save(new Client("Alex","alexs@gmail.com"));
		Client c3=clientRepository.save(new Client("Sharon","sharon@gmail.com"));
		Date date=new Date();

		//Création des comptes
		Compte cp1=compteRepository.save(new CompteCourant("c1",date,9000L,c1,6000L));
		Compte cp2=compteRepository.save(new CompteEpargne("c2",date,6000L,c2,5.5));
		Compte cp3=compteRepository.save(new CompteCourant("c3",date,22000L,c3,65000L));

		//Opérations
			//Sur le compte c1 ( objet cp1 )
			operationRepository.save(new Versement(date,9000D,cp1));
			operationRepository.save(new Versement(date,6000D,cp1));
			operationRepository.save(new Versement(date,2300D,cp1));
			operationRepository.save(new Retrait(date,9000D,cp1));


			//Sur le compte c2 ( objet cp2 )
			operationRepository.save(new Versement(date,2300D,cp2));
			operationRepository.save(new Versement(date,600D,cp2));
			operationRepository.save(new Versement(date,4400D,cp2));
			operationRepository.save(new Retrait(date,900D,cp2));

			//Sur le compte c3 ( objet cp3 )
			operationRepository.save(new Versement(date,2700D,cp3));
			operationRepository.save(new Versement(date,2600D,cp3));
			operationRepository.save(new Versement(date,4500D,cp3));
			operationRepository.save(new Retrait(date,1900D,cp3));

			//Test à partir de la couche métier
			banqueMetier.verser("c1",1111111);*/

			//banqueMetier.verser("c2",10000);
			//banqueMetier.verser("c3",10000);


		Compte compteSource=banqueMetier.consulterCompte("c1");
		Compte compteDestination=banqueMetier.consulterCompte("C3");

			//banqueMetier.virement(compteSource.getCodeCompte(),compteDestination.getCodeCompte(),200000);

			/*System.out.println("Solde des comptes après l'opération de virement");
			System.out.println("N° Compte source= " + compteSource.getCodeCompte());
			System.out.println("Solde initial= " + compteSource.getSolde());
			System.out.println("N° Compte destination = " + compteDestination.getCodeCompte());
			System.out.println("Solde initial= " + compteDestination.getSolde());*/

			//Client c4=clientRepository.save(new Client("Nadia","nadia@gmail.com"));
			//Compte cp4=compteRepository.save(new CompteCourant("c4",new Date(),250000L,c4,65000L));

			//Test liste des opérations effectuées sur un compte
			//banqueMetier.listeOperations("c1",0,10);

			//Test liste des opérations effectuées sur tous les comptes
			//banqueMetier.listeDesOperations(0,18);

			//Test liste des opérations effectuées sur les comptes triés sur leur code
			banqueMetier.listeDesOperationsParOrdreDecroissantComptes(0,10);

}
}

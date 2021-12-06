package mg.orchid.appliBancaire.Metier;

import mg.orchid.appliBancaire.dao.CompteRepository;
import mg.orchid.appliBancaire.dao.OperationRepository;
import mg.orchid.appliBancaire.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{
    //Injection des dépendances
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;


    //Implémentation des méthodes abstraites
    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp=compteRepository.findByCodeCompte(codeCompte);
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void verser(String codeCompte, double montant) {
        //Consulter d'abord le compte
        Compte cp=consulterCompte(codeCompte);
        //Créer un objet versement qui rappelons-le est un type d'opération
        Versement vers=new Versement(new Date(),montant,cp);
        //Enregistrement du versement dans la base (persistence )
        operationRepository.save(vers);
        //Mise à jour du solde du compte
        long soldeInitial= cp.getSolde();
        cp.setSolde((long) (soldeInitial+montant));
        //Enregistrement du solde final dans la base
        compteRepository.save(cp);


    }

    @Override
    public void retirer(String codeCompte, double montant) {
        //Vérifier si le com*te existe
        Compte cp=consulterCompte(codeCompte);
        long plafondDecouvert=0;
        long soldeInitial= cp.getSolde();
        //Vérifier s'il s'agit d'un compte courant.Si c'est le cas montrer le plafond
        if(cp instanceof CompteCourant)
            plafondDecouvert=((CompteCourant) cp).getDecouvert();
        //Si solde insuffisant
        if(soldeInitial+plafondDecouvert<montant)
            throw new RuntimeException("Solde insuffisant");


        //Créer un objet versement qui rappelons-le est un type d'opération
        Retrait ret=new Retrait(new Date(),montant,cp);
        //Enregistrement du versement dans la base (persistence )
        operationRepository.save(ret);
        //Mise à jour du solde du compte

        cp.setSolde((long) (soldeInitial-montant));
        //Enregistrement du solde final dans la base
        compteRepository.save(cp);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, double montant) {
        retirer(codeCompte1,montant);//On retire le montant du compte source
        verser(codeCompte2,montant);//on vire le montant dans le compte de destination

    }

    @Override
    public void listeOperations(String codeCompte, int numPage, int nbEnr) {
        Pageable PageNumberWithNumberOfRecords=PageRequest.of(numPage,nbEnr);


        List<Operation> listOper=operationRepository.listeOperations(codeCompte,PageNumberWithNumberOfRecords);
        System.out.println("Liste des opérations du compte"+listOper);
    }

    public void listeDesOperations(int numPage,int nbEnr){
        PageRequest PageNumberWithNumberOfRecords= PageRequest.of(numPage,nbEnr);
                List<Operation> listeDesOperations=operationRepository.findAll(PageNumberWithNumberOfRecords).getContent();
        System.out.println("Liste des opérations"+listeDesOperations);
}

    @Override
    public void listeDesOperationsParOrdreDecroissantComptes(int numPage, int nbEnr) {
        Pageable PageNumberWithNumberOfRecords= PageRequest.of
                        (numPage,
                        nbEnr,
                        Sort.by("codeCompte"));

        List<Operation> listeDesOperations=operationRepository.findAll(PageNumberWithNumberOfRecords).getContent();
        System.out.println("Liste des opérations"+listeDesOperations);

    }
}

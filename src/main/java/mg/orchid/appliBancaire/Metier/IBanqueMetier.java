package mg.orchid.appliBancaire.Metier;

import mg.orchid.appliBancaire.entities.Compte;

public interface IBanqueMetier {
    //Besoins fonctionnels
    public Compte consulterCompte(String codeCompte);
    public void verser(String codeCompte,double montant);
    public void retirer(String codeCompte,double montant);
    public void virement(String codeCompte1,String codeCompte2,double montant);
    public void listeOperations(String codeCompte, int page, int size);
    public void listeDesOperations(int numPage,int nbEnr);
    public void listeDesOperationsParOrdreDecroissantComptes(int numPage,int nbEnr);


}

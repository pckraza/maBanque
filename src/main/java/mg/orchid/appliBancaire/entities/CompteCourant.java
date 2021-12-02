package mg.orchid.appliBancaire.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")//Cette annotation est utilisé dans les classes FILLES
public class CompteCourant extends  Compte{
	//Attribut spécificique à la classe
	private Long decouvert;

	public CompteCourant(String codeCompte, Date dateCreation, Long solde, Client client, List<Operation> operations, Long decouvert) {
		super(codeCompte, dateCreation, solde, client, operations);
		this.decouvert = decouvert;
	}
}

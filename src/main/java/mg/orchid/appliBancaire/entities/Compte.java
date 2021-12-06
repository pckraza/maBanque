package mg.orchid.appliBancaire.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",discriminatorType =DiscriminatorType.STRING,length=2)

public class  Compte implements Serializable{
//Propriétés de la classe
	
	   	@Id
	   private String codeCompte;
	   private Date dateCreation;
	   private Long solde;

	   @ManyToOne//Définit la relation entre COMPTE et CLIENT, compté étant le owner de la relation
	   @JoinColumn(
			   name="code_cli",//clé étrangère
			   referencedColumnName ="code"
	   )
	   private Client client;

	   @OneToMany//Définit la relation entre COMPTE et OPERATION
			   (mappedBy = "compte",fetch = FetchType.LAZY)
	   private List<Operation> operations;// un compte enregistre 1 à n opérations

	public Compte(String codeCompte, Date dateCreation, Long solde, Client client) {
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}
}




package mg.orchid.appliBancaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Parce qu'il y a une héritage
@DiscriminatorColumn(name = "TYPE_OP",discriminatorType = DiscriminatorType.STRING,length = 1)

public class Operation implements Serializable{
	
	 //Propriétés de la classe
	@Id @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private Double montant;
    @ManyToOne
    @JoinColumn(name="CODE_CPTE")//Clé étrangère
    private Compte compte;//pour dire qu'une opération est enregistré dans un compte
	
    public Operation(Date dateOperation, Double montant, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	
    
    
    
}
    
    
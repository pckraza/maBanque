package mg.orchid.appliBancaire.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//Parce qu'il y a une héritage
@DiscriminatorColumn(name = "type_op",discriminatorType = DiscriminatorType.STRING,length = 1)

public class Operation implements Serializable{
	
	 //Propriétés de la classe
	@Id
    @SequenceGenerator(
            name = "compte_sequence",
            sequenceName = "compte_sequence",
            allocationSize = 1
    )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator ="compte_sequence"
            )
    private Long numero;
    private Date dateOperation;
    private Double montant;

    @ManyToOne
    @JoinColumn(
            name="code_compte",//Clé étrangère dans la table
            referencedColumnName = "codeCompte"

    )
    private Compte compte;//pour dire qu'une opération est enregistré dans un compte
	
    public Operation(Date dateOperation, Double montant, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	
    
    
    
}
    
    
package mg.orchid.appliBancaire.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
	}

	public Versement(Date dateOperation, Double montant, Compte compte) {
		super(dateOperation, montant, compte);

	}

		
	
}

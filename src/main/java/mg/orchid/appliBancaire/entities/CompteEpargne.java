package mg.orchid.appliBancaire.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
	private double taux;

	public CompteEpargne(String codeCompte, Date dateCreation, Long solde, Client client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}
}

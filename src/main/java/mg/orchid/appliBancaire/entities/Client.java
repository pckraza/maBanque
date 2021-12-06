package mg.orchid.appliBancaire.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client implements Serializable{

	//Propriétés de la classe
	
	@Id
	@SequenceGenerator(
			name = "client_sequence",
			sequenceName = "client_sequence",
			allocationSize = 1
	)
	@GeneratedValue
			(
					strategy = GenerationType.SEQUENCE,
					generator ="client_sequence"
			)
	  private Long code;
	  private String nom;
	  private String email;

	 @OneToMany//Définit la relation entre CLIENT et COMPTE
			 (
			 mappedBy="client",
			 cascade = CascadeType.ALL,
			 fetch=FetchType.LAZY)

	 private List<Compte> comptes;

//Constructeurs

	public Client(String nom, String email) {
		this.nom = nom;
		this.email = email;
	}
}
	


	
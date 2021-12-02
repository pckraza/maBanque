package mg.orchid.appliBancaire.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agence implements Serializable{
    @Id
	@SequenceGenerator(
			name = "agence_sequence",
			sequenceName = "agence_sequence",
			allocationSize = 1
	)
	@GeneratedValue
			(
					strategy = GenerationType.SEQUENCE,
					generator ="agence_sequence"
			)
	private Long codeAgence ;
	private String nomAgence;
	private String adresseAgence;

	

}

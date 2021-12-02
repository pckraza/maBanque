package mg.orchid.appliBancaire.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Employe implements Serializable {
	@Id
	@SequenceGenerator(
			name = "employe_sequence",
			sequenceName = "employe_sequence",
			allocationSize = 1
	)
	@GeneratedValue
			(
					strategy = GenerationType.SEQUENCE,
					generator ="employe_sequence"
			)
	private String matricule ;
	private String nom;
	private String prenom;
	private int age;
	
	public Employe(String matricule, String nom, String prenom, int age) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}

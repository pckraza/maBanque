package mg.orchid.appliBancaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.orchid.appliBancaire.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte,String> {

}

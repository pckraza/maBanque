package mg.orchid.appliBancaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.orchid.appliBancaire.entities.Compte;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte,String> {

    Compte findByCodeCompte(String codeCompte);
}



package mg.orchid.appliBancaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.orchid.appliBancaire.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}

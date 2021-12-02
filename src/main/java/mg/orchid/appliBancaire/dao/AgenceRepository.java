package mg.orchid.appliBancaire.dao;

import mg.orchid.appliBancaire.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence,Long> {
}

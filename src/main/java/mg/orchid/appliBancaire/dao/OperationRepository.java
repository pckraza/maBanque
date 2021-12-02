package mg.orchid.appliBancaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.orchid.appliBancaire.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}

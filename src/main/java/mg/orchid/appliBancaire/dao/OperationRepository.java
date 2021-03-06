package mg.orchid.appliBancaire.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mg.orchid.appliBancaire.entities.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
@Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
    public List<Operation> listeOperations(@Param("x") String codeCompte, Pageable pageable);

}

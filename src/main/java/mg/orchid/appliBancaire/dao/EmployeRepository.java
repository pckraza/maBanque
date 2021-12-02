package mg.orchid.appliBancaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.orchid.appliBancaire.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, String>{

}

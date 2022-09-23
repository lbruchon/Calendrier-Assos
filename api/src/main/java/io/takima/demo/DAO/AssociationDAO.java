package io.takima.demo.DAO;

import io.takima.demo.models.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationDAO extends CrudRepository<Association, Long> {
}

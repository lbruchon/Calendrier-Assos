package io.takima.demo.DAO;

import io.takima.demo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDAO extends CrudRepository<Tag, Long> {
}

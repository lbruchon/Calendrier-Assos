package io.takima.demo.DAO;

import io.takima.demo.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends CrudRepository<Post, Long> {
}

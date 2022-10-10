package io.takima.demo.DAO;

import io.takima.demo.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberDAO extends CrudRepository<Member, Long> {

    Optional<Member> findByMemberEmailAndMemberMdp(String memberEmail, String memberMdp);


}

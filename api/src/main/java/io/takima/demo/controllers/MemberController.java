package io.takima.demo.controllers;

import io.takima.demo.DAO.MemberDAO;

import io.takima.demo.models.Member;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("members")
@RestController
public class MemberController {

    private final MemberDAO memberDAo;
    public MemberController(MemberDAO memberDAo){this.memberDAo=memberDAo;}

    @GetMapping("")
    public List<Member> listMember(){
        Iterable<Member> it = memberDAo.findAll();
        List <Member> members = new ArrayList<>();
        it.forEach(member -> members.add(member));
        return members ;
    }
    @PostMapping("")
    public void addMember(@RequestBody Member member) {
        memberDAo.save(member);
    }

    @DeleteMapping("/{id}"){
        public void deleteMember(@PathVariable Long id) { userDAO.deleteById(id); }
    }
}

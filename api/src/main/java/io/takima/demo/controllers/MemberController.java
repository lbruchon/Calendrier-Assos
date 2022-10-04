package io.takima.demo.controllers;

import io.takima.demo.DAO.MemberDAO;

import io.takima.demo.models.Association;
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
    public void addMember(@ModelAttribute Member member) {
        System.out.println(member);

        memberDAo.save(member);
    }

    @GetMapping("/AssoOfOneMember/{id}")
    public Association getAssociationByMemberId(@PathVariable Long id){
        boolean present= memberDAo.findById(id).isPresent();
        if (present){
            Member member = memberDAo.findById(id).get();

           return member.getAssociation();
        }
        else return null;
    }

}

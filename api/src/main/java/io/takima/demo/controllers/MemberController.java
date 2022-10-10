package io.takima.demo.controllers;

import io.takima.demo.DAO.MemberDAO;

import io.takima.demo.models.Association;
import io.takima.demo.models.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("members")
@RestController
public class MemberController {

    private final MemberDAO memberDAo;
    public MemberController(MemberDAO memberDAo){this.memberDAo=memberDAo;}

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id){
        Optional memberOptional =memberDAo.findById(id);

        if (memberOptional.isPresent()==false){
            return null;
        }else {
            Member member = (Member) memberOptional.get();
            return member;
        }
    }

    @GetMapping("/connexion/{memberEmail}/{memberMdp}")
    public boolean memberConnectionControl(@PathVariable String memberEmail, @PathVariable String memberMdp){

        Optional<Member> member = memberDAo.findByMemberEmailAndMemberMdp(memberEmail, memberMdp);
        if (member.isPresent()){

            System.out.println("role user : " + member.get().getMemberSuperadmin());
            return true;
        } else return false;

    }


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

    @PatchMapping ("/{id}")
    public ResponseEntity<Member> updateMemberPartially(@PathVariable Long id, @ModelAttribute Member memberModif) {
        boolean exists = memberDAo.existsById(id);
        System.out.println(memberModif);
        if (exists) {
            Member member = memberDAo.findById(id).get();

            member.setMemberEmail(memberModif.getMemberEmail());
            member.setMemberMdp(memberModif.getMemberMdp());

            final Member memberUpdated = memberDAo.save(member);
            return ResponseEntity.ok(memberUpdated);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

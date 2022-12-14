package io.takima.demo.controllers;

import io.takima.demo.DAO.AssociationDAO;
import io.takima.demo.DAO.MemberDAO;
import io.takima.demo.models.Association;
import io.takima.demo.models.Member;
import io.takima.demo.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("associations")
@RestController
public class AssociationController {
    private final AssociationDAO associationDAO;
    private final MemberDAO memberDAo;

    public AssociationController(AssociationDAO associationDAO, MemberDAO memberDAo) {this.associationDAO= associationDAO;
        this.memberDAo = memberDAo;
    }

    @GetMapping("")
        public List<Association> listAssociations(){
        Iterable<Association> it = associationDAO.findAll();
        List <Association> associations = new ArrayList<>();
        it.forEach(association -> associations.add(association));
        return associations;
    }

    @GetMapping( "/{id}")
    public Association getAssociationById(@PathVariable Long id){
        Optional associationOptional =associationDAO.findById(id);

        if (associationOptional.isPresent()==false){
        return null;
        }else {
            Association association = (Association) associationOptional.get();
            return association;
        }
    }

    @GetMapping("/AllPostOfOneAssoByIdMember/{id}")
    public List<Post> getAllPostOfOneAssoByIdMember(@PathVariable Long id){
        boolean present= memberDAo.findById(id).isPresent();
        if (present){
            Member member = memberDAo.findById(id).get();
            Association association = member.getAssociation();
            List<Post> postOfOneAsso = association.getPostsAsso();
            return postOfOneAsso;
        }
        return null;
    }

    @PostMapping("/add-asso")
    public void addAssociation(@RequestBody Association association) {
        System.out.println(association.toString());
        associationDAO.save(association);
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<Long> deleteAssociation(@PathVariable Long id) {

        boolean exists = associationDAO.existsById(id);

        if (!exists) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        associationDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Association> updateAssociationPartially(@PathVariable Long id, @RequestBody Association associationModif) {
        boolean exists = associationDAO.existsById(id);
        if (exists) {
            Association association = associationDAO.findById(id).get();

            association.setAssociationName(associationModif.getAssociationName());
            association.setAssociationIgLink(associationModif.getAssociationIgLink());
            association.setAssociationFbLink(associationModif.getAssociationFbLink());
            final Association associationUpdated = associationDAO.save(association);
            return ResponseEntity.ok(associationUpdated);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping ("/membersOfAsso/{id}")
    public List<Member> getAllMemberOfAnAsso(@PathVariable Long id) {
            Iterable<Member> it = getAssociationById(id).getMembresAsso();
            List <Member> membersOfAnAsso = new ArrayList<>();
            it.forEach(member -> membersOfAnAsso.add(member));
            return membersOfAnAsso;
    }
}

package io.takima.demo.controllers;

import io.takima.demo.DAO.AssociationDAO;
import io.takima.demo.models.Association;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("associations")
@RestController
public class AssociationController {
    private final AssociationDAO associationDAO;

    public AssociationController(AssociationDAO associationDAO) {this.associationDAO= associationDAO;}

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

    @PostMapping("")
    public void addAssociation(@ModelAttribute Association association) { associationDAO.save(association); }

    @DeleteMapping( "/{id}")
    public ResponseEntity<Long> deleteAssociation(@PathVariable Long id) {

        boolean exists = associationDAO.existsById(id);

        if (!exists) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        associationDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Association> updateAssociationPartially(@PathVariable Long id, @ModelAttribute Association associationModif) {
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

}

package io.takima.demo.controllers;

import io.takima.demo.DAO.AssociationDAO;
import io.takima.demo.models.Association;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("")
    public void addAssociation(@RequestBody Association association) { associationDAO.save(association); }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAssociation(@PathVariable Long id) {

        boolean exists = associationDAO.existsById(id);

        if (!exists) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        associationDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}"){
        public void deleteAssociation(@PathVariable Long id) { associationDAO.deleteById(id); }
    }*/
}

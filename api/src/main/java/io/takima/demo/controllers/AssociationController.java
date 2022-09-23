package io.takima.demo.controllers;

import io.takima.demo.DAO.AssociationDAO;
import io.takima.demo.models.Association;
import io.takima.demo.models.User;
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
    return associations ;
}
    @PostMapping("")
    public void addassociation(@RequestBody Association association) {
        associationDAO.save(association);
    }
}

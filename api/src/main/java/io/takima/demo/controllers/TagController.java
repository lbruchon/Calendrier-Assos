package io.takima.demo.controllers;

import io.takima.demo.DAO.TagDAO;
import io.takima.demo.models.Association;
import io.takima.demo.models.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("tags")
@RestController
public class TagController {

    private final TagDAO tagDAO;
    public TagController(TagDAO tagDAO){this.tagDAO=tagDAO;}

    @GetMapping("")
    public List<Tag> listTags(){
        Iterable<Tag> it = tagDAO.findAll();
        List <Tag> tags = new ArrayList<>();
        it.forEach(tag -> tags.add(tag));
        return tags ;
    }
    @PostMapping("")
    public void addTag(@RequestBody Tag tag) {
        tagDAO.save(tag);
    }

    /*@DeleteMapping("/{id}"){
        public void deleteTag(@PathVariable Long id) { tagDAO.deleteTagById(id) }
    }*/

}

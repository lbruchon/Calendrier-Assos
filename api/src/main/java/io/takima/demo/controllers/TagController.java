package io.takima.demo.controllers;

import io.takima.demo.DAO.PostDAO;
import io.takima.demo.DAO.TagDAO;
import io.takima.demo.models.Association;
import io.takima.demo.models.Post;
import io.takima.demo.models.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("tags")
@RestController
public class TagController {

    private final TagDAO tagDAO;
    private final PostDAO postDAO;

    public TagController(TagDAO tagDAO, PostDAO postDAO){
        this.tagDAO=tagDAO;
        this.postDAO=postDAO;
    }

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
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTag(@PathVariable Long id) {
        boolean exists = tagDAO.existsById(id);

        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Tag tagToDelete = tagDAO.findById(id).get();
            Tag defaultTag = tagDAO.findById(1L).get();

            List<Post> listPostToModify = tagToDelete.getPostTag();
            listPostToModify.forEach(post -> post.setTag(defaultTag));

            tagDAO.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }

    }


}

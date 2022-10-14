package io.takima.demo.controllers;

import io.takima.demo.DAO.PostDAO;
import io.takima.demo.models.Post;
import io.takima.demo.models.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("posts")
@RestController
public class PostController {

    private final PostDAO postDAO;
    public PostController(PostDAO postDAO){this.postDAO=postDAO;}

    @GetMapping("")
    public List<Post> listPosts(){
        Iterable<Post> it = postDAO.findAll();

        List<Post> posts = new ArrayList<>();
        it.forEach(post -> posts.add(post));

        return posts;
    }

    @GetMapping( "/{id}")
    public Post getPostById(@PathVariable Long id){
        Optional postOptional =postDAO.findById(id);

        if (postOptional.isPresent()==false){
            return null;
        }else {
            Post post = (Post) postOptional.get();
            return post;
        }
    }

    @PostMapping("")
    public void addPost(@ModelAttribute Post post) {
        postDAO.save(post);
    }


    @GetMapping("/TagPost/{id}")
    public String getTagByPostId(@PathVariable Long id){
        if (postDAO.findById(id).isPresent()){
            Post post = postDAO.findById(id).get();
            Tag tag = post.getTag();
            return tag.getTagName();
        }
        
        return null;
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Post> updatePostPartially(@PathVariable Long id, @ModelAttribute Post postModif) {
        boolean exists = postDAO.existsById(id);
        if (exists) {
            Post post = postDAO.findById(id).get();

            post.setPostName(postModif.getPostName());
            post.setPostPlace(postModif.getPostPlace());
            post.setPostLink(postModif.getPostLink());
            post.setPostDescription(postModif.getPostDescription());
            post.setPostDateEvent(postModif.getPostDateEvent());
            post.setAssociation(postModif.getAssociation());
            post.setTag(postModif.getTag());

            final Post postUpdated = postDAO.save(post);
            return ResponseEntity.ok(postUpdated);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        boolean exists = postDAO.existsById(id);

        if (!exists) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postDAO.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    
}

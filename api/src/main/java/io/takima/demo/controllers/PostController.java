package io.takima.demo.controllers;

import io.takima.demo.DAO.PostDAO;
import io.takima.demo.models.Association;
import io.takima.demo.models.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("posts")
@RestController
public class PostController {

    private final PostDAO postDAO;
    public PostController(PostDAO postDAO){this.postDAO=postDAO;}

    @GetMapping("")
    public List<Post> listPosts() {
        Iterable<Post> it = postDAO.findAll();
        List<Post> posts = new ArrayList<>();
        it.forEach(post -> posts.add(post));
        return posts;
    }

    @PostMapping("")
    public void addpost(@RequestBody Post post) {
        postDAO.save(post);
    }
}

package io.takima.demo.controllers;

import io.takima.demo.DAO.PostDAO;
import io.takima.demo.models.Post;
import io.takima.demo.models.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
    public Tag getTagByPostId(@PathVariable Long id){
        if (postDAO.findById(id).isPresent()){
            Post post = postDAO.findById(id).get();

            return post.getTag();
        }
        
        return null;
    }



    @GetMapping("/threeNextMonthPosts")
    public List<Post> threeNextMonthPosts(){
        List<Post> posts = listPosts();
        List<Post> postsNextTreeMonth = new ArrayList<>();
        String  dateStr;
        //récup date actuelle
        LocalDate today = LocalDate.now();
        //récup date actuelle + 2 mois
        LocalDate maxDate = today.plusMonths(2);
        // compte nb jours dans mois date actuelle + 2 mois (et verif si année bisextille)
        int nbDay =maxDate.getMonth().length(maxDate.isLeapYear());
        //get le numero du jour actuel
        int nbOfDayOfMaxDate = maxDate.getDayOfMonth();
        // on ajoute Nb total de jour - jour actuel pour être au dernier jour du mois
        LocalDate maxDateCorrected = maxDate.plusDays(nbDay-nbOfDayOfMaxDate);
        System.out.println("Date corrected "+maxDateCorrected+" before corrected"+maxDate);
        for (Post post : posts) {
           dateStr = post.getPostDateEvent();
           LocalDate dateDate = LocalDate.parse(dateStr);
           if(dateDate.isAfter(today) && dateDate.isBefore(maxDateCorrected)){
                postsNextTreeMonth.add(post);
           }
        }
        return postsNextTreeMonth;
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

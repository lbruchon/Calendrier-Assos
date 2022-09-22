package io.takima.demo.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_name")
    private String postName;
    @Column(name = "post_place")
    private String postPlace;
    @Column(name = "post_link")
    private String postLink;
    @Column(name = "post_description")
    private String postDescription;
    @Column(name = "post_date_event")
    private String postDateEvent;
    @ManyToOne
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable=false)
    private Tag tag;


    public Post() {

    }


}
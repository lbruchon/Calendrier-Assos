package io.takima.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JoinColumn(name = "asso_id", nullable = false)
    private Association association;
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable=false)
    @JsonIgnore
    private Tag tag;


    public Post() {
    }

    public Post(Long id, String postName, String postPlace, String postLink, String postDescription, String postDateEvent, Association association, Tag tag) {
        this.id = id;
        this.postName = postName;
        this.postPlace = postPlace;
        this.postLink = postLink;
        this.postDescription = postDescription;
        this.postDateEvent = postDateEvent;
        this.association = association;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostPlace() {
        return postPlace;
    }

    public void setPostPlace(String postPlace) {
        this.postPlace = postPlace;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostDateEvent() {
        return postDateEvent;
    }

    public void setPostDateEvent(String postDateEvent) {
        this.postDateEvent = postDateEvent;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(postName, post.postName) && Objects.equals(postPlace, post.postPlace) && Objects.equals(postLink, post.postLink) && Objects.equals(postDescription, post.postDescription) && Objects.equals(postDateEvent, post.postDateEvent) && Objects.equals(association, post.association) && Objects.equals(tag, post.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postName, postPlace, postLink, postDescription, postDateEvent, association, tag);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postName='" + postName + '\'' +
                ", postPlace='" + postPlace + '\'' +
                ", postLink='" + postLink + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", postDateEvent='" + postDateEvent + '\'' +
                ", association=" + association +
                ", tag=" + tag +
                '}';
    }
}
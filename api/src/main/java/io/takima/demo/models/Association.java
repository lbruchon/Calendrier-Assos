package io.takima.demo.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long associationId;

    @Column(name="association_name")
    private String associationName;
    @Column(name="association_fb_link")
    private String associationFbLink;
    @Column(name="association_ig_link")
    private String associationIgLink;
    @OneToMany(mappedBy = "association")
    private Set<Post> posts;


    public Association(Long association_id, String associationName, String associationFbLink, String associationIgLink, Set<Post> posts, Set<Tag> tags) {
        this.associationId = association_id;
        this.associationName = associationName;
        this.associationFbLink = associationFbLink;
        this.associationIgLink = associationIgLink;
        this.posts = posts;

    }

    public Association() {

    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long association_id) {
        this.associationId = association_id;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public String getAssociationFbLink() {
        return associationFbLink;
    }

    public void setAssociationFbLink(String associationFbLink) {
        this.associationFbLink = associationFbLink;
    }

    public String getAssociationIgLink() {
        return associationIgLink;
    }

    public void setAssociationIgLink(String associationIgLink) {
        this.associationIgLink = associationIgLink;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Association that = (Association) o;
        return Objects.equals(associationId, that.associationId) && Objects.equals(associationName, that.associationName) && Objects.equals(associationFbLink, that.associationFbLink) && Objects.equals(associationIgLink, that.associationIgLink) && Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(associationId, associationName, associationFbLink, associationIgLink, posts);
    }

    @Override
    public String toString() {
        return "Association{" +
                "association_id=" + associationId +
                ", associationName='" + associationName + '\'' +
                ", associationFbLink='" + associationFbLink + '\'' +
                ", associationIgLink='" + associationIgLink + '\'' +
                ", posts=" + posts +
                '}';
    }
}


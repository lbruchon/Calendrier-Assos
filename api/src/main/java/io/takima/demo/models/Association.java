package io.takima.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="association_name")
    private String associationName;
    @Column(name="association_fb_link")
    private String associationFbLink;
    @Column(name="association_ig_link")
    private String associationIgLink;

    @OneToMany (mappedBy = "association")
    @JsonIgnore
    private List<Member> membresAsso;

    @OneToMany (mappedBy = "association")
    @JsonIgnore
    private List<Post> postsAsso;

    public List<Member> getMembresAsso() {
        return membresAsso;
    }

    public void setMembresAsso(List<Member> membresAsso) {
        this.membresAsso = membresAsso;
    }

    public List<Post> getPostsAsso() {
        return postsAsso;
    }

    public void setPostsAsso(List<Post> postsAsso) {
        this.postsAsso = postsAsso;
    }

    public Association(Long id) {
        this.id = id;
    }

    public Association(Long id, String associationName, String associationFbLink, String associationIgLink, List<Member> membresAsso, List<Post> postsAsso) {
        this.id = id;
        this.associationName = associationName;
        this.associationFbLink = associationFbLink;
        this.associationIgLink = associationIgLink;
        this.membresAsso = membresAsso;
        this.postsAsso = postsAsso;
    }

    public Association() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long association_id) {
        this.id = id;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Association that = (Association) o;
        return Objects.equals(id, that.id) && Objects.equals(associationName, that.associationName) && Objects.equals(associationFbLink, that.associationFbLink) && Objects.equals(associationIgLink, that.associationIgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, associationName, associationFbLink, associationIgLink);
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", associationName='" + associationName + '\'' +
                ", associationFbLink='" + associationFbLink + '\'' +
                ", associationIgLink='" + associationIgLink + '\'' +
                '}';
    }
}


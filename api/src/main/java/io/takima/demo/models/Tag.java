package io.takima.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag_name")
    private String tagName;

    @OneToMany (mappedBy = "tag")
    private List<Post> postTag;

    public Tag() {
    }

    public Tag(Long id, String tagName, List<Post> postTag) {
        this.id = id;
        this.tagName = tagName;
        this.postTag = postTag;
    }

    public List<Post> getPostTag() {
        return postTag;
    }

    public void setPostTag(List<Post> postTag) {
        this.postTag = postTag;
    }

    public Long getTag_id() {
        return id;
    }

    public void setTag_id(Long tag_id) {
        this.id = tag_id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(tagName, tag.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}

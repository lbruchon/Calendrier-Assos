package io.takima.demo.models;

import javax.persistence.*;
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


    public Tag() {
    }

    public Tag(Long tag_id, String tagName, Set<Post> posts) {
        this.id = tag_id;
        this.tagName = tagName;

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

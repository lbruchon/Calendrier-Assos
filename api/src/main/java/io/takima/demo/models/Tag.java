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

   @OneToMany(mappedBy = "tag")
   private Set<Post> posts;

    public Tag() {
    }

    public Tag(Long tag_id, String tagName, Set<Post> posts) {
        this.id = tag_id;
        this.tagName = tagName;
        this.posts = posts;
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
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(tagName, tag.tagName) && Objects.equals(posts, tag.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, posts);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + id +
                ", tagName='" + tagName + '\'' +
                ", posts=" + posts +
                '}';
    }
}

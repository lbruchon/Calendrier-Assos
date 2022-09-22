package io.takima.demo.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;
    @Column(name = "tag_name")
    private String tagName;

   @OneToMany(mappedBy = "tag")
   private Set<Post> posts;

    public Tag() {
    }


}

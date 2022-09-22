package io.takima.demo.models;

import javax.persistence.*;

@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_mdp")
    private String memberMdp;
    @Column(name = "member_superadmin")
    private Boolean memberSuperadmin;
    @ManyToOne
    @JoinColumn(name="associationId", nullable = false)
    private Association association;
}

package io.takima.demo.models;

import javax.persistence.*;
import java.util.Objects;

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

    public Member() {
    }

    public Member(Long member_id, String memberEmail, String memberMdp, Boolean memberSuperadmin, Association association) {
        this.member_id = member_id;
        this.memberEmail = memberEmail;
        this.memberMdp = memberMdp;
        this.memberSuperadmin = memberSuperadmin;
        this.association = association;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberMdp() {
        return memberMdp;
    }

    public void setMemberMdp(String memberMdp) {
        this.memberMdp = memberMdp;
    }

    public Boolean getMemberSuperadmin() {
        return memberSuperadmin;
    }

    public void setMemberSuperadmin(Boolean memberSuperadmin) {
        this.memberSuperadmin = memberSuperadmin;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(member_id, member.member_id) && Objects.equals(memberEmail, member.memberEmail) && Objects.equals(memberMdp, member.memberMdp) && Objects.equals(memberSuperadmin, member.memberSuperadmin) && Objects.equals(association, member.association);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_id, memberEmail, memberMdp, memberSuperadmin, association);
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberMdp='" + memberMdp + '\'' +
                ", memberSuperadmin=" + memberSuperadmin +
                ", association=" + association +
                '}';
    }
}

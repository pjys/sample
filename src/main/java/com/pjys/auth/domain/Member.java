package com.pjys.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(of = "uid")
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userId;

    private String userName;

    @Column(nullable = false, unique = true, length = 50)
    private String userEmail;

    @Column(nullable = false, length = 200)
    private String userPassword;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updateDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    private List<MemberRole> roles;

}

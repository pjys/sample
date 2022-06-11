package com.pjys.auth.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false, unique = true, length = 50)
    private String userEmail;

    @Column(nullable = false, length = 200)
    private String userPassword;

    private boolean enabled;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String username, String useremail, String password, boolean enabled, MemberRole role) {
        this.userName = username;
        this.userEmail = useremail;
        this.userPassword = password;
        this.enabled = enabled;
        this.role = role;
    }

}

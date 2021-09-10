package com.juansecu.HeySpring.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "Users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userId;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @JoinColumn(name = "User_id")
    @OneToMany
    private List<Role> roles;
    @Column(
        updatable = false
    )
    @CreationTimestamp
    private Date registeredAt;
    @UpdateTimestamp
    private Date updatedAt;
}

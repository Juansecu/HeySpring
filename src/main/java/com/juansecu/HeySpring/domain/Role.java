package com.juansecu.HeySpring.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int roleId;
    @NotEmpty
    private String name;
    @Column(
        updatable = false
    )
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}

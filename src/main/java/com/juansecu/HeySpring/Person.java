package com.juansecu.HeySpring;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "People")
public class Person implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long personId;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    private String phone;
    @Column(
        updatable = false
    )
    @CreationTimestamp
    private Date addedAt;
    @UpdateTimestamp
    private Date updatedAt;

    private static final long SERIAL_VERSION_UID = 1L;
}

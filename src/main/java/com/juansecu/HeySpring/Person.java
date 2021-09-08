package com.juansecu.HeySpring;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


@Data
@Entity
@Table(name = "People")
public class Person implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @CreationTimestamp
    private Date addedAt;

    private static final long SERIAL_VERSION_UID = 1L;
}

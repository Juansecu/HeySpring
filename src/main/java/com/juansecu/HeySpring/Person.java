package com.juansecu.HeySpring;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


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
    private String addedAt;

    private static final long SERIAL_VERSION_UID = 1L;
}

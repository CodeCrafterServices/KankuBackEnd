package com.kanku.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String fullName;
    @Column(unique = true)
    private String userContact;
    @Column(unique = true)
    private String email;
    private String password;
}

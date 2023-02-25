package com.evans.pos_system.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"username","email","phoneNumber"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    private ArrayList<Role> roles=new ArrayList<Role>();
    private boolean status=false;
    @OneToOne(mappedBy = "user")
    private VerificationToken verificationToken;


}

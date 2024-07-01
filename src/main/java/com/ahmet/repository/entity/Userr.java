package com.ahmet.repository.entity;

import com.ahmet.repository.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role = ERole.USER;

}

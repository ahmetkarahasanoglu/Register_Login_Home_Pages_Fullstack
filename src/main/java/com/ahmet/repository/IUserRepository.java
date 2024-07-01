package com.ahmet.repository;

import com.ahmet.repository.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Userr,Long> {

    boolean existsByEmail(String email);
    Optional<Userr> findOptionalByEmail(String email);
}

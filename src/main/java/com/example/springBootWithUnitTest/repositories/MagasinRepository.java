package com.example.springBootWithUnitTest.repositories;

import com.example.springBootWithUnitTest.entites.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin,Long> {
}

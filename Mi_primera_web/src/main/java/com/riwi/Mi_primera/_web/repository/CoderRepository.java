package com.riwi.Mi_primera._web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Mi_primera._web.entity.Coder;

@Repository
public interface CoderRepository extends JpaRepository<Coder, Long> {
    
}

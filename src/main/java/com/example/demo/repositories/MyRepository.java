package com.example.demo.repositories;

import com.example.demo.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<Member, Long>{
    public Member findById(long id);
}
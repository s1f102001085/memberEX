package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.MemberData;

public interface MemberDataRepository extends JpaRepository<MemberData, Integer>{

}

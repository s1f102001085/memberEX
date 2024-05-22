package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.MemberData;

public interface MemberDataRepository extends JpaRepository<MemberData, Integer>{

	public List<MemberData> findByNameLike(String find);

}

package com.example.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restApi.entity.MemberEntity;


public interface MemberRepository extends JpaRepository<MemberEntity,Integer>{

}

package com.example.restApiEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restApiEx.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo,Integer> {

}

package com.example.jpaBbs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaBbs.entity.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{

}

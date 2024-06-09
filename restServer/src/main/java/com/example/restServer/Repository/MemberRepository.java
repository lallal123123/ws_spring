package com.example.restServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restServer.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	public Member findByUsernameAndPassword(String username, String password);

	public Member findByUsername(String username);

	public Boolean existsByUsername(String username);
}

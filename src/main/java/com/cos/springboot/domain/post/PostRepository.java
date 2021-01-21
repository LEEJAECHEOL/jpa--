package com.cos.springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
// JpaRepository 안에 쭉쭉들어가면 이미 @Repository가 걸려있다. 그래서 생략이 가능함.
public interface PostRepository extends JpaRepository<Post, Integer> {
	
}

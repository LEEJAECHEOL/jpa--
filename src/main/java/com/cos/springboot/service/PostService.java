package com.cos.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.domain.post.PostRepository;

// @Controller, @RestController, @Service, @Configuration, @Component
// @Component 아래에 있지만 각각 수행하는 역할이 다름 @Component는 그냥 메모리에 올림.
@Service	// 서버 실행시 IoC 등록
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		System.out.println("PostService 실행됨");
		this.postRepository = postRepository;
	}
	
	public Post 글저장(Post post) {
		return postRepository.save(post);
	}
	public List<Post> 글목록(){
		return postRepository.findAll();
	}
	public Post 글상세보기(int id) {
		return postRepository.findById(id).orElse(new Post());
	}
}

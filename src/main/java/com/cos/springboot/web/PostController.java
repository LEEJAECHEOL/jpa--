package com.cos.springboot.web;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.service.PostService;

// 클라이언트 http 요청시에 @Controller, @RestController가 붙은 클래스가 메모리(IoC Container)에 로딩

@Controller // 스레드 풀이라는게 있는데 최초로 생성된 곳에서 생성된것. 이거는 한개가 아니다. 요청시마다 생김.
public class PostController {
	
	// DI (Dependency Injection)
	private PostService postService;
	
	public PostController(PostService postService) {
		System.out.println("PostController 실행됨");
		this.postService = postService;
	}
	// Model 객체 제공!!
	@GetMapping("/post")	// name : default이기 때문에 생략가능
	public String findAll(Model model) {	// 컨트롤러의 함수의 파라메터는 톰켓이 가지고 있는 객체 + IoC컨테이너가 가지고 있는 객체
		// 1. DB에 데이터 가져오기
		// 2. request 값 담기
		List<Post> posts = postService.글목록();
		System.out.println(posts);
		model.addAttribute("posts", posts);
//		request.setAttribute("posts", posts);
		
		
		return "post/list";	// 3. RequestDispatcher 사용
	}
	
	@GetMapping("/post/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.글상세보기(id));
		return "post/detail";
	}
	
	@PostMapping("/post")
	public String save(Post post) {	//x-www-form-urlencoded
		System.out.println("Post : " + post);
		
		Post postEntity = postService.글저장(post);
		System.out.println(postEntity);
		return "redirect:/post";	// response.sendRedirect
	}
	
}

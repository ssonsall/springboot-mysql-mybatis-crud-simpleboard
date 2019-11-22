package com.cos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.crud.model.Post;
import com.cos.crud.repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {	
	@Autowired //Dependency Injection
	private PostRepository postRepository;
	

	//Model은 데이터를 Controller에서 Presentation(View, 즉 jsp 파일 등) 계층까지 들고간다.
	//Model에 담기만 하면 Presentation계층까지 들고간다.
	
	//GET => http://localhost:8080/post
	//GET => http://localhost:8080/post/
	@GetMapping("")
	public String postList(Model model) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		//webapp/WEB-INF/views/post/list.jsp로 이동한다. ViewResolver가 해줄거임. 프리픽스 서픽스 세팅 필요.
		return "post/list";
	}
	
	//POST => http://localhost:8080/post/update
	//POST => http://localhost:8080/post/update/
	@PostMapping("/update")
	public String update(Post post) {
		try {
			postRepository.update(post);
			return "redirect:/post";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
	
	// GET => http://localhost:8080/post/writeForm
	@GetMapping("/writeForm")
	public String writeForm() {
		return "post/writeForm";
	}
	
	/*
	 * 알고 있어야 할 어노테이션
	 * @RequestParam("id")
	 * @RequestBody => JSON
	 * 
	 * redirect는 주소창에 주소 때리는 개념이라고 생각
	 * */
	
	//POST => http://localhost:8080/post/delete/1
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		try {
			postRepository.delete(id);
			return "redirect:/post";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
	
	//POST => http://localhost:8080/post/save
	//POST => http://localhost:8080/post/save/
	@PostMapping("/save")
	public String save(Post post) {
		try {
			postRepository.save(post);
			return "redirect:/post";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
	
	//GET => http://localhost:8080/post/1
	@GetMapping("/{id}")
	public String post(@PathVariable int id, Model model) {
		try {
			Post post = postRepository.findById(id);
			model.addAttribute("post",post);
			return "/post/detail";
		} catch (Exception e) {
			return "redirect:";
			// TODO: handle exception
		}

	}
	//file을 찾을때는 앞에 슬래쉬 필요없고
	//리다이렉트 할때는 슬래쉬 필요하다?
	//이건 잘 모르겠다 테스트 필요
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Post post = postRepository.findById(id);
		model.addAttribute("post", post);
		return "/post/updateForm";
	}
}

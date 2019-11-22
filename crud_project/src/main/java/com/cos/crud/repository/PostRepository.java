package com.cos.crud.repository;

import java.util.List;

import com.cos.crud.model.Post;

//원래 방식은 @Repository를 걸어야 메모리에 떴었는데
//그런데 DataAccessConfig에서 mapper 스캔을 할 때 로드되기 때문에
//@Repository 안써도 메모리에 뜬다.
//여기서 메모리 = 스프링컨테이너
//스프링 컨테이너에서 관리하는 방식은 무조건 싱글턴이다.
public interface PostRepository {
	//게시글 전체보기
	List<Post> findAll();
	
	//글쓰기
	void save(Post post);
	
	//수정하기
	void update(Post post);
	
	//상세보기
	Post findById(int id);
	
	//삭제하기
	void delete(int id);
}

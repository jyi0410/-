package com.youngin.sample.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youngin.sample.domain.Comment;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
						"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentServiceTest {
	
	@Autowired
	CommentService commentService;
	
//	@Test
	public void 코멘트가져오기(){
		List<Comment> commentList = commentService.getComment();
		for(Comment comment : commentList){
			System.out.println(comment.getId());
			System.out.println(comment.getComment());
		}	
	}
	
//	@Test
	public void 코멘트넣어보기(){
		 Comment comment = new Comment();
		 comment.setId(101);
		 comment.setComment("마지막이당");
		
		commentService.insertComment(comment);
		showCommentList();
	}
	
	public void showCommentList(){
		List<Comment> commentList = commentService.getComment();
		for(Comment comment : commentList){
			System.out.println(comment.getId());
			System.out.println(comment.getComment());
		}	
	}
	
//	@Test
//	public void 댓글더보기기능만들기(){
//		List<Comment> commentList = commentService.getMoreComment();
//		
//		for(Comment comment : commentList){
//			System.out.println(comment.getId());
//			System.out.println(comment.getComment());
//		}	
//		
//	}

}

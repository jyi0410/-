package com.youngin.sample.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youngin.sample.domain.Comment;
import com.youngin.sample.service.CommentService;



@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;

	//refresh버튼을 눌렀을 때 
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public List<Comment> getComment(Model model) {
		List<Comment> comments = commentService.getComment();
		for(Comment comment : comments){
			System.out.println(comment.getComment());
		}
		return comments;
	}
	
	
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public Model postComment(Model model,
							@ModelAttribute Comment comment) {
		model.addAttribute("nextId", commentService.getNextId());
		System.out.println(comment.getComment());
		comment.setId(commentService.getNextId());
		int insertedRow = commentService.insertComment(comment);
		System.out.println(insertedRow);
		if(insertedRow > 0){
			model.addAttribute("msg", "succ");
		}else{
			model.addAttribute("msg", "err");
		}
		
		return model;
	}
	
	
	//수정 버튼 눌렀을 때 
	@RequestMapping(value = "/comment", method = RequestMethod.PUT)
	public Model putComment(Model model,
									 @RequestBody  Comment comment) {             
		System.out.println(comment.getId());
		System.out.println(comment.getComment());
		commentService.updateComment(comment);
		model.addAttribute("msg", "succ");
		return model;
	}
	
	
	//삭제 버튼 눌렀을 때 
	@RequestMapping(value = "/comment", method = RequestMethod.DELETE)
	public void deleteComment(Model model,
										@RequestBody Comment comment) {
		System.out.println(comment.getId());
		System.out.println(comment.getComment());
		commentService.deleteComment(comment.getId());
	}


}

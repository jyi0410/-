package com.youngin.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youngin.sample.dao.CommentDao;
import com.youngin.sample.domain.Board;
import com.youngin.sample.domain.Comment;

@Service
public class CommentService {
	@Autowired
	CommentDao commentDao;
	
	
	public int getNextId(){
		return commentDao.findNextId() + 1;
	}
	
	public Comment findCommentById(int id){
		return commentDao.findCommentById(id);
	}
	
	public int findIdByComment(Comment comment){
		return commentDao.findIdByComment(comment);
	}
	
	public List<Comment> getComment(){
		return commentDao.findAllComments();
	}

	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}
	
	public void deleteComment(int id){
		commentDao.deleteComment(id);
	}

	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}
	
	
	
}

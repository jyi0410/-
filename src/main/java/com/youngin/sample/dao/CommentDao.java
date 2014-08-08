package com.youngin.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.youngin.sample.domain.Board;
import com.youngin.sample.domain.Comment;
@Repository
public interface CommentDao {

	List<Comment> findAllComments();
	
	int insertComment(@Param("comment") Comment comment);

	void deleteComment(@Param("id") int id);

	int findNextId();

	Comment findCommentById(@Param("id") int id);

	int findIdByComment(@Param("comment") Comment comment);

	void updateComment(@Param("comment") Comment comment);
	
}

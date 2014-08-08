
package com.youngin.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.youngin.sample.domain.Board;

@Repository
public interface BoardDao {

	List<Board> findAllBoards();
	
	Board findBoardById(@Param("id") int id);
	
	int findNextId();
	
	void insertBoard(@Param("board") Board board);
	
	void updateBoard(@Param("board") Board board);
	
	void deleteBoard(@Param("id") int id);
	
	
}

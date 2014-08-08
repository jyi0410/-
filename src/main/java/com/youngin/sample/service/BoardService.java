
package com.youngin.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youngin.sample.dao.BoardDao;
import com.youngin.sample.domain.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public int getNextId(){
		return boardDao.findNextId() + 1;
	}
	
	public List<Board> findAllBoards(){
		return boardDao.findAllBoards();
	}
	
	public Board findBoardById(int id){
		return boardDao.findBoardById(id);
	}
	
	public void insertBoard(Board board){
		boardDao.insertBoard(board);
	}
	
	public void updateBoard(Board board){
		boardDao.updateBoard(board);
	}
	
	public void deleteBoard(int id){
		boardDao.deleteBoard(id);
	}
}

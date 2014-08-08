
package com.youngin.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youngin.sample.domain.Board;
import com.youngin.sample.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String board(Model model) {
		
		model.addAttribute("boards", boardService.findAllBoards());
		model.addAttribute("id", boardService.getNextId());
		return "board";
	}

	
	@RequestMapping(value = "/updateBoardWithTemplate/{id}", method = RequestMethod.GET)
	public String updateBoardWithTemplate(Model model, @PathVariable("id") int id) {
		model.addAttribute("board", boardService.findBoardById(id));
		return "boardupdate";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable("id") int id) {
		model.addAttribute("board", boardService.findBoardById(id));
		return "view";
	}
	
	@RequestMapping(value = "/write/{id}", method = RequestMethod.GET)
	public String write(Model model, @PathVariable("id") int id) {
		model.addAttribute("nextId", boardService.getNextId());
		return "write";
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard(Model model, @ModelAttribute Board board){
		boardService.insertBoard(board);
		return "redirect:/view/" + board.getId();
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public String updateBoard(Model model, @ModelAttribute Board board) {
		boardService.updateBoard(board);	
		return "redirect:/view/" + board.getId();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(Model model, @PathVariable("id") int id) {
		model.addAttribute("board", boardService.findBoardById(id));
		return "update";
	}
	
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(Model model, int id) {
		boardService.deleteBoard(id);
		model.addAttribute("boards", boardService.findAllBoards());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/zzazzan", method = RequestMethod.GET)
	public String zzazzan(Model model, @ModelAttribute Board board) {
		boardService.updateBoard(board);
		return "zzazzan";
	}
}

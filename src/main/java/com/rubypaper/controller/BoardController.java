package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.BoardVO;
@Controller
//@RestController
//인스턴스 생성됨 /진입점 역할
//@Controller를 쓰면은 @ResponseBody를 써야함!!
public class BoardController {
	public BoardController() {
		System.out.println("=".repeat(50));
		System.out.println("BoardController가 생성됨");
		System.out.println("=".repeat(50));
	}

	@GetMapping("/hello")
	public String hello1(String name) {
		return "get Hello : " + name;
	}

	@PostMapping("/hello")
	public String hello2(String name) {
		return "post Hello : " + name;
	}

	@PutMapping("/hello")
	public String hello3(String name) {
		return "put Hello : " + name;
	}

	@DeleteMapping("/hello")
	public String hello4(String name) {
		return "delete Hello : " + name;
	}

//저장해도 바로 반영이 되는 것이 아니라 서버를 재구동해야지 반영됨
	@GetMapping("/getBoard")
	public @ResponseBody BoardVO getBoard() {
		// 객체가 넘어 갈때는 무조건 json 파일로 넘어감
		BoardVO board = new BoardVO();
		board.setCnt(1);
		board.setTitle("테스트 제목...");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다. .....");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}

	@GetMapping("/getBoard1")
	public BoardVO getBoard1() {
		BoardVO board = new BoardVO(1, "테스트 제목", "테스터", "테스트 내용입니다....", new Date(), 0);
		return board;

	}

	@GetMapping("/getBoard2")
	public BoardVO getBoard2() {
		// builder는 static 메서드
		return BoardVO.builder().seq(1).title("테스트 제목").writer("테스터").content("테스트 내용.....").createDate(new Date())
				.cnt(0).build();
	}

	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardlist = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			BoardVO board = new BoardVO();
			board.setCnt(i);
			board.setTitle("테스트 제목" + i);
			board.setWriter("테스터" + i);
			board.setContent("테스터 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(i);
			boardlist.add(board);

		}
		return boardlist;

	}
	
	@GetMapping("/board")
	public @ResponseBody BoardVO board(@RequestBody BoardVO b) {
		b.setCreateDate(new Date());
		b.setCnt(0);
		System.out.println("board:"+b);
		return b;
	}
	
}

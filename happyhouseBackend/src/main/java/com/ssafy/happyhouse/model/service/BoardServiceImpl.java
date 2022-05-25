package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> retrieveBoard() {
		return boardMapper.selectBoard();
	}

	@Override
	public boolean writeBoard(Board board) {
		changeWord(board);
		return boardMapper.insertBoard(board) == 1;
	}

	@Override
	public Board detailBoard(int articleno) {
		return boardMapper.selectBoardByNo(articleno);
	}

	@Override
	@Transactional
	public boolean updateBoard(Board board) {
		changeWord(board);
		return boardMapper.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int articleno) {
		return boardMapper.deleteBoard(articleno) == 1;
	}

	public void changeWord(Board board) {
		String str = board.getContent();
		String warning = "    (**: 금지단어 사용으로 인해 변경되었습니다.)";
		if (str.contains("금지어1") || str.contains("금지어2")) {
			str = str.replace("금지어1", "**");
			str = str.replace("금지어2", "**");
			if (!str.contains(warning)) {
				str = str + warning;
			}
		}
		board.setContent(str);

		String str2 = board.getAcontent();
		String str3 = board.getSubject();
		if (str2 != null) {
			if (str2.contains("금지어1") || str2.contains("금지어2")) {
				str2 = str2.replace("금지어1", "**");
				str2 = str2.replace("금지어2", "**");
				if (!str.contains(warning)) {
				str = str + warning;
				}
				board.setContent(str);
				board.setAcontent(str2);
			}
		}
		if (str3.contains("금지어1") || str3.contains("금지어2")) {
			str3 = str3.replace("금지어1", "**");
			str3 = str3.replace("금지어2", "**");
			if (!str.contains(warning)) {
			str = str + warning;
			}
			board.setSubject(str3);
			board.setContent(str);
		}
	}
}
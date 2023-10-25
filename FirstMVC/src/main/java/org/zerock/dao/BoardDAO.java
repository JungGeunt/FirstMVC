package org.zerock.dao;

import java.util.List;

import org.zerock.command.BoardVO;

public interface BoardDAO {

	//추상 메서드들
	public void boardInsert(String name, String title, String content);
	public List<BoardVO> boardSelect();
	public void boardDelete(String num);
	
}

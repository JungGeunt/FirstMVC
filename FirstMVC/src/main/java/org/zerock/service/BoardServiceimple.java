package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.zerock.command.BoardVO;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.BoardDAOImpl;

//@Component
//@Compoment("boardService") //"boardService"는 등록 빈의 id로 사용됨.

@Service("boardService")
public class BoardServiceimple implements BoardService {

	//1st ,
	//BoardDAO boardDAO = new BoardDAOImpl();
	
	//2nd 
	@Autowired
	private BoardDAO boardDAO;
	
	
	//3rd dao를 불러오는 3가지 방법
	
	
 
	@Override
	public void register(String name, String title, String content) {
		//boardRegister.jsp로 부터 전달받은 값 확인...
//		System.out.println("---------service 계층---------");
//		System.out.println(name);
//		System.out.println(title);
//		System.out.println(content);
		
		boardDAO.boardInsert(name, title, content);
	}

	@Override
	public List<BoardVO> getList() {		
		List<BoardVO> list = boardDAO.boardSelect();
		return list; //boardDAO.boardSelect(); 만 리턴해도됨.
	}

	@Override
	public void delete(String num) {
		boardDAO.boardDelete(num);
	}

}

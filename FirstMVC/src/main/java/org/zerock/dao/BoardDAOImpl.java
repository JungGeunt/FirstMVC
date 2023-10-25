package org.zerock.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.command.BoardVO;

//DAO의 객체 주입은 일반적으로 Component나 Repository 어노테이션을 사용
//component-scan에 꼭 추가해야 함.

@Repository
public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 ArrayList 필요함.
	List<BoardVO> DB = new ArrayList<BoardVO>();
	
	@Override
	public void boardInsert(String name, String title, String content) {
		
//		System.out.println("----- DAO 계층 ------");
//		System.out.println(name);
//		System.out.println(title);
//		System.out.println(content);
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		
		DB.add(vo);
		System.out.println("현재 게시글 수 : " + DB.size());
		
	}

	@Override
	public List<BoardVO> boardSelect() { //getList()에서 실행될 예정 ..DB모든 정보 불러서 반환...
		return DB;
	}

	@Override
	public void boardDelete(String num) {
		DB.remove(Integer.parseInt(num));
	}

}

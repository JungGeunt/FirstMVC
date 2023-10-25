package org.zerock.command;

public class JoinVO {
	
	//멤버 변수
	private String id;
	private String pw;
	private String name;
	
	//기본 생성자
	public JoinVO() {}
	
	//필드 생성자
	public JoinVO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	//게터 세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "JoinVO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}

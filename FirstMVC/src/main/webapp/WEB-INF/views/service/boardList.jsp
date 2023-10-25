<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>boardList 게시물 목록</title>
	</head>
	<body>
		<h2>게시글 목록</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>비고</th>
							<!-- varStatus  개체를 사용하여 반복 범위, 단계 및 현재 개체에 대한 정보 -->
				<c:forEach var="good" items="${boardList }" varStatus="num">												
					<tr>
						<td>${num.index +1 }</td>
						<td>${good.name }</td>
						<td>${good.title }</td>
						<td>${good.content }</td>
						<td><input type="button" value="삭제" onclick="location.href='boardDelete?num=${num.index }'"></td>
						<!-- 
						1.boardDelete로 삭제 처리하세요.
						2. 삭제 후에는 목록화면으로 리다이렉트 하세요.
						
						 -->
					</tr>
				</c:forEach>
			</tr>	
		</table>
		
		<!-- 게시글 작성 페이지로 이동 -->
		<a href="boardRegister">게시글로이동</a>
	</body>
</html>
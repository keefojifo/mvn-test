<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h4>유저리스트</h4>
		<table class="table  table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>파일</th>
				</tr>
			</thead>
			<tbody id="tBody">
				<tr>
					<td colspan="4">내용없음</td>
				</tr>
			</tbody>
		</table>
	</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/File');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				console.log(xhr.responseText);
				var filetestList = JSON.parse(xhr.responseText);
				var html ='';
				for(var filetest of filetestList){
					html += '<tr>' ;
					html += '<td>' + filetest.FT_NUM + '</td>';
					html += '<td>' + filetest.FT_ID + '</td>';
					html += '<td>' + filetest.FT_NAME + '</td>';
					html += '<td><img src="'+filetest.FT_FILE + '"/></td>';
					html += '</tr>';
				}
				document.querySelector('#tBody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>
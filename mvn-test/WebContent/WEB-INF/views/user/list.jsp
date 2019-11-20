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
	<h1>AJAX LIST</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">넘버</th>
				<th scope="col">아이디</th>
				<th scope="col">페스워드</th>
				<th scope="col">이름</th>
				<th scope="col">취미</th>
				<th scope="col">생성날짜</th>
				<th scope="col">생성시간</th>
				<th scope="col">수정날짜</th>
				<th scope="col">수정시간</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/list');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						console.log(xhr.responseText);
						var list = JSON.parse(xhr.responseText);
						var tBody = document.getElementById('tBody');
						var html = '';
						for (var i = 0; i < list.length; i++) {
							html += '<tr>';
							html += '<td><a href="/views/user/userview?biNum=' + list[i].uiNum + '">' + list[i].uiNum + '</a></td>';
							html += '<td>' + list[i].uiName + '</td>';
							html += '<td>' + list[i].uiId + '</td>';
							html += '<td>' + list[i].uiPwd + '</td>';
							html += '<td>' + list[i].credat + '</td>';
							html += '<td>' + list[i].cretim + '</td>';
							html += '<td>' + list[i].moddat + '</td>';
							html += '<td>' + list[i].modtim + '</td>';
							html += '<td>' + list[i].active + '</td>';
							html += '</tr>';
						}
						tBody.innerHTML = html;
						//document.write(xhr.responseText);
					}
				}
			}
			xhr.send();
		}
	</script>
</body>
</html>
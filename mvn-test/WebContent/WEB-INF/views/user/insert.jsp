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
		<h3>사용자 정보 등록</h3>
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName" placeholder="이름을 작성해주세요"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId" placeholder="아이디 작성해주세요"></td>
			</tr>
			<tr>
				<th>페스워드</th>
				<td><input type="text" id="uiPwd"placeholder="페스워드 작성해주세요"></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="save()">저장</button></th>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		function save() {
			var xhr = new XMLHttpRequest();
	       
			xhr.open('POST','/user/insert');
			xhr.setRequestHeader('Content-Type','application/json');
			xhr.onreadystatechange = function()
			{
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						/* console.log(xhr.responseText);
						var res =JSON.parse(xhr.responseText); */						
					}
				}
			}
			//구조체
			var param = {
					uiName : document.getElementById('uiName').value,
					uiId : document.getElementById('uiId').value,
					uiPwd : document.getElementById('uiPwd').value
			}  
		
			console.log(param);
			//무슨정보가 있는지 나옴 주목적이 어떻게 구성되어있는지를 보여주기 위함			
			param =JSON.stringify(param);
			xhr.send(param);
		}
	</script>
</body>
</html>
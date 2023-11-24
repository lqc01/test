<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/transfer" method="post">
	<table border=1>
			<tr>
				<td>入账：</td>
				<td>
					<input type="text" name="uname" >
				</td>
			</tr>
			<tr>
				<td>转账金额：</td>
			<td><input type="text"  name="money"/></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<input type="submit" value="转账" />
			</td>
			</tr>
		</table>

	</form>
</body>
</html>
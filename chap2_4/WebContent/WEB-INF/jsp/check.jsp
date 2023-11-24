<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/index/check" method="post">
	<table>
		<tr>
			<td align="center" colspan="2">查询账户金额</td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="查询">
				<input type="reset" value="重置">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>

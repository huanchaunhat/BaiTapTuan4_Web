<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.account == null}">
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a href="/BaiTapTuan4/login">Đăng nhập</a> 
					| <a href="/BaiTapTuan4/register">Đăng ký</a></li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li><a
						href="/BaiTapTuan4/member/myaccount">${sessionScope.account.fullName}</a>
						| <a href="/BaiTapTuan4/logout">Đăng Xuất</a></li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>
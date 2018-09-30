<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Counten-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UserManagement画面</title>

<style type="text/css">
/*========TAG LAYOUT========*/
body{
	margin:0;
	padding:0;
	line-height:1.6;
	letter-spacing:1px;
	font-family:verdana,Helvetica,sans-serif;
	font-size:12px;
	color:#333;
	back-ground:#fff;
}
table{
	text-align:center;
	margin:0 auto;
}
/*========ID LAYOUT========*/
#top{
	width:780px;
	margin:30px auto;
	border:1px solid #333;
}
#header{
	width:100%;
	height:80px;
	background-color:black;
}
#main{
	width:100%;
	height:500px;
	text-align:center;
}
#footer{
	width:100%;
	height:80px;
	background-color:black;
	clear:both;
}
</style>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>
</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserManagement</p>
		</div>
		<div>
			<s:form>
			<p>ユーザー関係画面です。</p>
			<p>どちらの処理を行いますか？</p>
			<tr>
				<td><input type="button" value="ユーザー登録" onclick="submitAction('UserCreateAction')"/></td>
				<td><br/><br/></td>
				<td><input type="button" value="ユーザー一覧" onclick="submitAction('UserListAction')"/></td>
			</tr>
			</s:form>
		<div>
			<p>管理者TOPへ戻る場合は<a href='<s:url action="ManageAction"/>'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
		</div>
		</div>
	</div>


	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
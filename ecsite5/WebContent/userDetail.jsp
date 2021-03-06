<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserDetail画面</title>

<style type="text/css">
/*========TAG LAYOUT========*/
body{
	margin:0;
	padding:0;
	line-height:1.6;
	letter-spacing:1px;
	font-family:Verdana,Helvetica,sans-serif;
	font-size:12px;
	color:#333;
	background:#fff;
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
#text-right{
	display:inline-block;
	text-align:right;
}
</style>
</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserDetail</p>
		</div>
		<div>
		<s:if test="userList==null">
			<h3>ユーザー情報はありません。</h3>
		</s:if>
		<s:elseif test="message==null">
			<h3>詳細情報は以下になります。</h3>
			<table>
			<s:form action="UserDetailAction">
			<tr>
				<td>
					<label>ユーザー名:</label>
				</td>
				<td>
					<s:property value="#session.userName"/><span>様</span>
				</td>
			</tr>
			<tr>
				<td>
					<label>ログインID:</label>
				</td>
				<td>
					<s:property value="#session.loginId"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>ログインPASS:</label>
				</td>
				<td>
					<s:property value="#session.loginPass"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>登録日:</label>
				</td>
				<td>
					<s:property value="#session.insertDate"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>更新日:</label>
				</td>
				<td>
					<s:property value="#session.updatedDate"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>管理者権限の有無:</label>
				</td>
				<td>
					<s:property value="#session.admin"/>
				</td>
			</tr>
			</s:form>
			</table>



			<s:form action="UserDeleteAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="一件削除" method="delete"/>
			</s:form>

			<s:form action="UserUpdateAction">
				<s:submit value="一件更新" method="execute"/>
			</s:form>




		</s:elseif>
		<s:if test="message !=null">
			<h3><s:property value="message"/></h3>
		</s:if>
		<div id="text-right">
			<p>管理画面へ戻る場合は<a href='<s:url action="ManageAction"/>'>こちら</a></p>
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		</div>
	</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
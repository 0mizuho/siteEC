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
<title>ItemUpdate画面</title>

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

</style>
</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemUpdate</p>
		</div>
		<div>
			<table>
			<s:form action="ItemUpdateConfirmAction">
				<p>更新する内容を入力してください。</p>
				<tr>
					<td>
						<s:textfield name="itemName" value='%{#session.itemName}' label="商品名"/>
					</td>
				<tr>
					<td>
						<s:textfield name="itemPrice" value="%{#session.itemPrice}" label="単　価"/>
					</td>

				</tr>
				<tr>
					<td>
						<s:textfield name="itemStock" value='%{#session.itemStock}' label="在庫数"/>
					</td>
				</tr>
				<s:submit value="更新内容確認"/>
			</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span>
					<a href='<s:url action="ItemDetailAction"/>'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>
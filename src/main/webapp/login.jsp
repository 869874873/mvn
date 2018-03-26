<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>****管理系统</title>
<link href="jquery-easyui-1.5.4.2/themes/default/easyui.css" rel="stylesheet" />
<link href="jquery-easyui-1.5.4.2/themes/icon.css" rel="stylesheet" />
<link href="css/demo.css" rel="stylesheet" />
<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/loginController.js"></script>
</head>
<body>
<form id = "login" method = "post" onsubmit='return false;'>
	<input name = "username" class = "easyui-textbox" data-options = "label:'账号:',required:true" style = "width:200px;">
	<br />
	<input name = "password" class = "easyui-textbox" type = "password" data-options = "label:'密码:',required:true" style = "width:200px;">
	<br />
	<input type = "submit" value = "登录" onclick = "login()">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="jquery-easyui-1.5.4.2/themes/default/easyui.css" rel="stylesheet" />
<link href="jquery-easyui-1.5.4.2/themes/icon.css" rel="stylesheet" />
<link href="css/demo.css" rel="stylesheet" />
<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/userController.js"></script>
<script type="text/javascript" src="js/managerController.js"></script>
<script type="text/javascript" src="js/loginController.js"></script>
<title>****管理系统</title>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height: 100px; background: #900; padding: 10px">
        <img src="images/20180110132402.gif" style = "width: 80px;height: 80px;float: left"/>
        <h2 style = "color : #fff">****管理系统</h2>
        <!-- 强行登陆 -->
        <% HttpSession s = request.getSession();
	       /* if(s.getAttribute("loginr") == null){
	    	   response.sendRedirect("login.jsp");
	       } */
        %>
        <span style = "float: right;color : #fff;cursor: pointer;"><%=s.getAttribute("loginr")%>
	        <span id = "token" style = "display : none;"><%=s.getAttribute("token")%></span>
		    <span>
		    	<a onclick = "logout()">[注销]</a>
			</span>
	    </span>
    </div>
   <!--  <div data-options="region:'south',border:false" style="height: 23px;">
        <div class="footer">EasyUIDemo</div>
    </div> -->
    <div data-options="region:'west',split:true" title="系统操作" style="width: 170px;">
    	<div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="系统设置1" data-options="selected:true">
                <div style="margin: 5px">
                    <ul id= "contentCategory" class="tree easyui-tree" data-options="animate:true,lines:true">
                        <li data-options="iconCls:'icon-group'">
                            <span>基本操作</span>
                            <ul>
                                <li id = "li_1" data-options="iconCls:'icon-application'">
                                    <span><a onclick = "users()">用户信息</a></span>
                                </li>
                                <li id = "li_2" data-options="iconCls:'icon-application'" style = "display : none;">
                                    <span><a onclick = "managers()">管理员信息</a></span>
                                </li>
                                <!-- <li data-options="iconCls:'icon-group_edit'">
                                    <span>test3</span>
                                </li> -->
                            </ul>
                        </li>
                        <!-- <li data-options="state:'closed',iconCls:'icon-joystick'">
                            <span>系统设置</span>
                            <ul>
                                <li data-options="iconCls:'icon-joystick_add'">
                                    <span>test4</span>
                                </li>
                            </ul>
                        </li> -->
                    </ul>
                </div>
            </div>
            <div title="系统设置2" style="padding: 10px;">
                content2
            </div>
            <div title="系统设置3" style="padding: 10px">
                content3
            </div>
        </div>
    </div>
    <div id = "pageContent" data-options="region:'center',title:'用户信息',iconCls:'icon-house'">
        
    </div>
</body>
</html>
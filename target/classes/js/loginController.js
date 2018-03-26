//登录方法
function login() {
	$('#login').form('submit', {
		url: 'login',
		onSubmit: function () {
			if ($("#login").form("validate"))
				return true 
			else
				return false;
		},
		success: function (data) {
			data = JSON.parse(data)
				if (data.success) {
					location.href = 'index.jsp';
				} else {
					$.messager.alert("提示", "您的账号密码有误，请核对后输入！")
				}
		}
	});
}
// 登出 方法
function logout() {
	$.messager.confirm('提示', "是否注销系统？", function (r) {
		if (r) {
			$.ajax({
				url: 'logout',
				success: function (data) {
					console.log(data)
					$.messager.alert("提示", data.msg, "info", function () {
						location.href = 'login.jsp';
					});
				}
			})
		}
	});
}

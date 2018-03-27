//进入系统自动跳转到信息展示页面
$(function () {
	$("#pageContent").panel({
		title: '用户信息',
		href: 'user.html',
		onLoad: function () { // 页面加载完成调用事件
			var p = $('#datagrid').datagrid('getPager');
			p.pagination({
				pageSize: 20, // 每页显示的记录条数，默认为10
				pageList: [20, 25, 30], // 可以设置每页记录条数的列表
				beforePageText: '第', // 页数文本框前显示的汉字
				afterPageText: '页 共 {pages} 页',
				displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
			});
		}
	});
	var tree = $("#contentCategory");
	var node = tree.tree('find', "li_2");
	if ($("#token").html() == 1) {
		tree.tree("remove", node.target)
	}
});
// 页面跳转
function openDialog(data) {
	if (data == "add") {
		$("#pageContent").panel({
			title: '操作-添加用户',
			href: 'form.html'
		});
	} else if (data == "edit") {
		var rows = $('#datagrid').datagrid('getSelected');
		if (rows == null) {
			$.messager.alert('提示', '请选择一条数据进行操作！');
			return;
		};
		$("#pageContent").panel({
			title: '操作-修改用户',
			href: 'form.html',
			onLoad: function () { // 页面加载完成调用事件
				$.ajax({
					url: 'ctrl/user/selectUserById',
					data: {
						id: rows.id
					},
					success: function (data) {
						$('#form').form('load', {
							id: data.rows[0].id,
							name: data.rows[0].name,
							pwd: data.rows[0].pwd
						});
					}
				})
			}
		});
	}
}
// 删除方法
function delAppInfo() {
	var rows = $('#datagrid').datagrid('getSelected');
	if (rows == null) {
		$.messager.alert('提示', '请选择一条数据进行操作！');
		return;
	};
	$.messager.confirm('提示', "是否确定删除？", function (r) {
		if (r) {
			$.ajax({
				url: 'ctrl/user/deleteUser',
				data: {
					id: rows.id
				},
				success: function (data) {
					$.messager.alert('提示', data.msg);
					// 删除之后，页面局部刷新
					$('#datagrid').datagrid('reload');
				}
			})
		}
	});
}
// 保存用户信息
function saveUser() {
	$('#form').form('submit', {
		url: 'ctrl/user/saveOrUpdateUser',
		onSubmit: function () {
			if ($("#form").form("validate"))
				return true 
			else
				return false;
		},
		success: function (data) {
			data = JSON.parse(data)
				if (data.success) {
					$.messager.alert('消息', data.msg);
					$("#pageContent").panel({
						title: '用户信息',
						href: 'user.html',
					});
					$("#form").form("clear");
				} else {
					$.messager.alert('消息', data.msg);
				}
		}
	});
}
// 清空用户信息
function clearForm() {
	// 清空方法
	$('#form').form('clear');
}
// 返回主页
function returnHome() {
	if ($("#returnHome")[0].style.display == "") {
		$("#pageContent").panel({
			title: '用户信息',
			href: 'user.html',
		});
	} else {
		$.messager.confirm('提示', "您有未保存的信息，是否离开", function (r) {
			if (r) {
				$("#pageContent").panel({
					title: '用户信息',
					href: 'user.html',
				});
			}
		});
	}
}
// 查看用户相信信息
function userInformation() {
	var rows = $('#datagrid').datagrid('getSelected');
	if (rows == null) {
		$.messager.alert('提示', '请选择一条数据进行操作！');
		return;
	};
	$("#pageContent").panel({
		title: '操作-详细信息',
		href: 'info.html',
		onLoad: function () { // 页面加载完成调用事件
			$.ajax({
				url: 'ctrl/user/selectUserById',
				data: {
					id: rows.id
				},
				success: function (data) {
					$('#form').form('load', {
						id: data.rows[0].id,
						name: data.rows[0].name,
						pwd: data.rows[0].pwd
					});
				}
			})
		}
	});
}
//条件查询
function findUser(value) {
	$('#datagrid').datagrid('load', {
		name: value
	});
}
//清空
function reset() {
	$('#datagrid').datagrid('load', {
		name: ''
	});
	$('#searchName').textbox('setValue', '')
}

function users() {
	$("#pageContent").panel({
		title: '用户信息',
		href: 'user.html',
		onLoad: function () { // 页面加载完成调用事件
			var p = $('#datagrid').datagrid('getPager');
			p.pagination({
				pageSize: 20, // 每页显示的记录条数，默认为10
				pageList: [20, 25, 30], // 可以设置每页记录条数的列表
				beforePageText: '第', // 页数文本框前显示的汉字
				afterPageText: '页 共 {pages} 页',
				displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
			});
		}
	});
}

function managers() {
	$("#pageContent").panel({
		title: '管理员信息',
		href: 'manager.html',
		onLoad: function () { // 页面加载完成调用事件
			var p = $('#datagrid').datagrid('getPager');
			p.pagination({
				pageSize: 20, // 每页显示的记录条数，默认为10
				pageList: [20, 25, 30], // 可以设置每页记录条数的列表
				beforePageText: '第', // 页数文本框前显示的汉字
				afterPageText: '页 共 {pages} 页',
				displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
			});
		}
	});
}

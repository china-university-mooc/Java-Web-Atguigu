<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script type="text/javascript">
		// 验证用户名:必须由字母，数字下划线组成，并且长度为 5 到 12 位
		// 验证密码:必须由字母，数字下划线组成，并且长度为 5 到 12 位
		// 验证确认密码:和密码相同
		// 邮箱验证:xxxxx@xxx.com
		// 验证码:现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。

		$(function () {
			$('#sub_btn').click(function () {
				var usernameText = $('#username').val();
				var pattern = /^\w{5,12}$/;
				if (!pattern.test(usernameText)) {
					$('.errorMsg').text('用户名不合法');
					return false;
				}

				var passwordText = $('#password').val();
				if (!pattern.test(passwordText)) {
					$('.errorMsg').text('密码不合法');
					return false;
				}

				var repwdText = $('#repwd').val();
				if (repwdText !== passwordText) {
					$('.errorMsg').text('确认密码与密码不一致');
					return false;
				}

				var emailText = $('#email').val();
				var emailPattern =/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailPattern.test(emailText)) {
					$('.errorMsg').text('邮箱不合法');
					return false;
				}

				var codeText = $('#code').val();
				if (codeText == null || codeText === '') {
					$('.errorMsg').text('验证码不能为空');
					return false;
				}

				$('.errorMsg').text('');
			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("errMsg") == null ? "" : request.getAttribute("errMsg")%>
								</span>
							</div>
							<div class="form">
								<form action="register" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password"  placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password"  placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" value="<%=request.getAttribute("email") == null ? "" : request.getAttribute("email")%>" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>

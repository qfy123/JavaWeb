<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        $(function () {
            $("#username").blur(function () {
                //1、获取用户名
                var name = this.value;
                $.getJSON("http://localhost:8080/book/userServlet", "action=ajaxExistUsername&username=" + name, function (data) {
                    if (data.existUsername){
                        $("span.errorMsg").text("用户名已存在！")
                    }else {
                        $("span.errorMsg").text("用户名可用！")
                    }
                });
            })
            //给注册绑定单击事件
            $("#sub_btn").click(function () {
                /*
                验证用户名：必须由字母、数字、下划线组成，长度5到12
                验证密码：必须由字母、数字、下划线组成，长度5到12
                验证确认密码：跟密码一样
                邮箱验证：xxx@xx.com
                验证码：现在只需要验证用户已输入，还没讲到服务器，验证码暂时无法生成

                如何验证：1、获取输入框内容；2、创建正则表达式；3、使用test方法验证；4、提示用户输入结果
                 */
                var username = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(username)) {
                    $("span.errorMsg").text("用户名不合法")
                    return false;
                }
                var password = $("#password").val();

                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    $("span.errorMsg").text("密码不合法")
                    return false;
                }
                var repwd = $("#repwd").val();
                if (!repwd == password) {
                    $("span.errorMsg").text("密码不一致")
                    return false
                }
                var email = $("#email").val();
                var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!emailPatt.test(email)) {
                    $("span.errorMsg").text("邮箱不合法")
                    return false;
                }
                var code = $("#code").val();
                code = $.trim(code);
                if (code == null || code == "") {
                    $("span.errorMsg").text("验证码不能为空")
                    return false
                }
                $("span.errorMsg").text("")
            })
            //给验证码图片绑定单击事件
            $(function () {
                $("#code_img").click(function () {
                    this.src = "${base}/kaptcha.jpg?d=" + new Date()
                    ;
                })
            })
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
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
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px;width: 110px;height: 30px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>
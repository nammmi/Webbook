<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css"/>
<title>Login</title>
<%
        String str = (String)request.getSession().getAttribute("username");

        if(str == null)
        {
            str="<a href=\"/Webbook/login\">请登录</a>";
        }else
        {
           //【" + username + "】
        	str="【"+str+"】,你好     "+"<a href=\"/Webbook/loginout\">退出登录</a>";
        }
%>
<%=str %> 
<style type="text/css">
.divcss5{width:500px; height:100px; margin-left: auto; margin-right: auto;} 
</style>

<script>
function validateForm(){
var x=document.forms["form1"]["username"].value;

var x3=document.forms["form1"]["password"].value;

if (x==null || x==""){
  alert("请填写用户名！");
  return false;
  }

if (x3==null || x3==""){
	  alert("请填写密码!");
	  return false;
	  }

}
</script>

</head>
<body><br><br><br><br><br><br><div class="divcss5" align="center">
<form class="form-horizontal" role="form" name="form1" action="login" method="post" onsubmit="return validateForm()">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">user name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="user name" name="username">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
      <a class="btn btn-default" href="/Webbook/register">Register</a>
      <a class="btn btn-primary" href="/Webbook">Cancel</a>
    </div>
  </div>

</form>
<br></div>

</body>
</html>
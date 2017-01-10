<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css"/>
<title>Register</title>
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
.divcss5{margin:0 auto; width:500px; height:100px} 
</style>
<script>
function validateForm(){
var x=document.forms["form1"]["username"].value;
var x2=document.forms["form1"]["password"].value;
var x3=document.forms["form1"]["password2"].value;
var x4=document.forms["form1"]["email"].value;

if (x==null || x==""){
  alert("请填写用户名！");
  return false;
  }
if (x2==null || x2==""){
	  alert("请填写密码!");
	  return false;
	  }
if (x3==null || x3==""){
	  alert("请填写密码!");
	  return false;
	  }
if (x4==null || x4==""){
	  alert("请填写email!");
	  return false;
	  }

}
</script>
</head>
<body><br><br><br><br><br><br><div class="divcss5" align="center">
<form class="form-horizontal" role="form" name="form1" action="register" method="post" onsubmit="return validateForm()">
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
    <label for="inputPassword4" class="col-sm-2 control-label">Reinput Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="password2">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail4" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail4" placeholder="email" name="email">
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
      <button type="submit" class="btn btn-default">Register</button>
      
      <a class="btn btn-primary" href="/Webbook/login">Cancel</a>
    </div>
  </div>

</form>
<br>
</div>

</body>



</html>
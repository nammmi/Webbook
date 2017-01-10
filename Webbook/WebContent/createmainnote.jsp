<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css" />
<script type="text/javascript"src="WebRoot/ueditor/ueditor.config.js"></script>  
<script type="text/javascript"src="WebRoot/ueditor/ueditor.all.js"></script>

<title>编写主题留言</title>
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
var x=document.forms["form1"]["title"].value;
var x2=document.forms["form1"]["type"].value;
var x3=document.forms["form1"]["content"].value;

if (x==null || x==""){
  alert("请填写标题！");
  return false;
  }
if (x2==null || x2==""){
	  alert("请选择类型!");
	  return false;
	  }
if (x3==null || x3==""){
	  alert("请填写主题内容!");
	  return false;
	  }

}
</script>



</head>
<body><br><br><br><br><br><br>
<div align="center">
<form action="submitNote" method="post" name="form1" id="form1" class="form-horizontal" role="form" onsubmit="return validateForm()">
 <div align="center" class="divcss5">
 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="标题" name="title">
    </div>
  </div>
  <div class="form-group">
    <label for="selecttype" class="col-sm-2 control-label">类别</label>
    <div class="col-sm-10">
      <select class="form-control" name="type" id="selecttype">
  <option>question</option>
  <option>discuss</option>
  <option>share</option>
  <option>4</option>
  <option>5</option>
</select>
    </div>
  </div>
 </div>
<br>
<div class="form-group">
<label class="col-sm-2 control-label">内容</label><div class="col-sm-10">
<textarea id="myEditor" name="content" cols="70" rows="8" class="myEditor"></textarea><br>
<script type="text/javascript">
UE.getEditor('myEditor');  
    
</script> <br></div></div>
<input type="submit" name="submitNote" value="提交" class="btn btn-primary">
	

</form>
</div><br><div align="center"><a class="btn btn-primary" href="/Webbook">返回首页</a></div>


</body>
</html>
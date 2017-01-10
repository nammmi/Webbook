<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css" />
<script type="text/javascript"src="WebRoot/ueditor/ueditor.config.js"></script>  
<script type="text/javascript"src="WebRoot/ueditor/ueditor.all.js"></script>
<title>answer</title>
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

<script>
function validateForm(){
var x=document.forms["form1"]["replycontent2"].value;


if (x==null || x==""){
  alert("请填写内容！");
  return false;
  }


}
</script>

</head>
<body>
<div align="center">

<form action="submitReplyServlet" method="post" name="form1" id="form1" onsubmit="return validateForm()"><br>
<blockquote><b><textarea rows="3" cols="30" name="replycontent1">引用${map.Replynote.floorid}楼${map.Replynote.username}发表的:${map.Replynote.floorcontent}</textarea></b></blockquote><br>
内容：<textarea id="myEditor" name="replycontent2" cols="70" rows="8" class="myEditor"></textarea>
<script type="text/javascript">
UE.getEditor('myEditor');  
    
</script> 
<input type="submit" name="submitNote" value="提交" class="btn btn-primary">
	
<input name="id" type="hidden" value="${map.mainid}">
</form>

</div><div align="center">
<a class="btn btn-primary" href="/Webbook">返回首页</a>
<a class="btn btn-primary" href="/Webbook/details?id=${map.mainid}">返回回复列表</a></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.Replynote"%>
    <%@ page import="model.PageBean"%>
    <%@ page import="java.util.ArrayList"%> 
    <%@ page import="java.util.HashMap"%> 
    <%@ page import="java.util.Map"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css"/>
<script type="text/javascript"src="WebRoot/ueditor/ueditor.config.js"></script>  
<script type="text/javascript"src="WebRoot/ueditor/ueditor.all.js"></script>
<title>details</title>
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
<%
        String power = (String)request.getSession().getAttribute("power");
        String link1="";
        String link2="";
        String link3="";
        String see="none";

        if(power == null)
        {
            power="";
        }else
        {
           //【" + username + "】
           power="delete";
           link1 = "<a href=\"/Webbook/deletereplynote?id=";
           link2 = "\">";
           link3 = "</a>";
           see="";
        }
%>

<script>
function validateForm(){
var x=document.forms["form1"]["floorcontent"].value;


if (x==null || x==""){
  alert("请填写内容！");
  return false;
  }


}
</script>

<style type="text/css">
blockquote {
background:#f9f9f9;
border-left:10px solid #ccc;
margin:1.5em 10px;
padding:.5em 10px;
quotes:"\201C""\201D""\2018""\2019";
}
blockquote:before {
color:#ccc;
content:open-quote;
font-size:4em;
line-height:.1em;
margin-right:.25em;
vertical-align:-.4em;
}
blockquote p {
display:inline;
}


</style>
</head>
<body>


<table class="table table-striped table-hover" width="800"> 
<thead>
 
  <tr>  
  
                     <td><h2><b>标题：${map.main.mainnotetitle }</b></h2></td>  
  

              </tr> 
              </thead> 
    

</table><br><br><a href="#reply" class="btn btn-primary">编写回复</a> 
<br>
<%@ include file="/tab2.jsp"%><br><br><div>
<table align="center" class="table table-striped table-hover" width="800">  

<caption></caption>
 <thead>
 
  <tr align="center">  
  
                     <td><b>楼层</b></td>  
  
                     <td><b>回帖人</b></td>  
  
                      
  
                     <td><b>时间</b></td>
                     
                     <td width="70%"><b>回复内容</b></td>
                     
                     <td><b></b></td>
                     <td><b></b></td>
                     
                     


              </tr> 
              </thead> 
 <%
    //ArrayList<Note> list = new ArrayList<Note>();
    //PageBean<Note> pb = new PageBean<Note>();

    Map<String, Object> map = new HashMap<String, Object>();
    PageBean<Replynote> pb = new PageBean<Replynote>();
    
    map = (HashMap<String, Object>)request. getAttribute("map");
    pb = (PageBean<Replynote>)map.get("pb");
    System.out.println(pb.getPc()+"8888888888888");
    //pb = (PageBean<Replynote>)request.getAttribute("pb");
 if(pb == null || pb.getBeanList().size() < 1)  
	  
     out.print("没有数据!");  

else{  
    for (int i = 0; i < pb.getBeanList().size(); i++){
    %>
        
           <tr>  
   <td><%= pb.getBeanList().get(i).getFloorid() %></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getUsername() %></a></td>
   <td><%= pb.getBeanList().get(i).getCreatetime().toString() %></td>
   <td height="150px"><%= pb.getBeanList().get(i).getFloorcontent() %></td>
   <td><a href="/Webbook/ReplyServlet?id=<%= pb.getBeanList().get(i).getId() %>&mainid=${map.main.id}">回复</a></td>
   <td style="display:<%=see%>"><a href="/Webbook/DeleteReplyServlet?id=<%= pb.getBeanList().get(i).getId() %>&mainid=${map.main.id}">删除</a></td>
  
   </tr>  
    <%   
    }
  
    }
   %>
</table></div>
<%@ include file="/tab2.jsp"%><br><br>
<a name="reply"></a> 
<div align="center">
<form action="Replymainnote" method="post" name="form1" id="form1" onsubmit="return validateForm()">
<input name="id" type="hidden" value="${map.main.id}">
内容：<textarea id="myEditor" name="floorcontent" cols="70" rows="8" class="myEditor"></textarea>
<script type="text/javascript">
UE.getEditor('myEditor');  
    
</script> 
<input type="submit" name="submitNote" value="提交" class="btn btn-primary">
	

</form><br>
</div>

<a class="btn btn-primary" href="/Webbook">返回首页</a>


</body>
</html>
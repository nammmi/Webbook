<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.ArrayList"%>  
    <%@ page import="model.Note"%>
    <%@ page import="model.PageBean"%>
    <%@ page import="model.Listofnotes"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css" />
<title>index</title>

<%
       String str = (String)request.getSession().getAttribute("username");


        if(str == null)
        {
            str="<a href=\"/Webbook/login\">登录</a>";
        }else
        {
           //【" + username + "】
           str="【"+str+"】,你好     "+"<a href=\"/Webbook/loginout\">退出登录</a>";
        }
%>
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
           link1 = "<a href=\"/Webbook/deletemainnote?id=";
           link2 = "\">";
           link3 = "</a>";
           see="";
        }
%>
<%=str %> 
<style type="text/css">
.divcss5{margin:0 auto; width:500px; height:100px} 
</style>
</head>
<body>

<div align="center" class="divcss5">
<form class="form-horizontal" role="form" name="form1" action="Listofnote" method="get">

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">关键词</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="请输入搜索关键词" name="like">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">搜索</button>
      <a class="btn btn-primary" href="/Webbook/createmainnote">编写主题帖</a><br>
    </div>
  </div>
</form>
</div>

<table align="center" class="table table-striped table-hover" width="800">  
 <thead>
 
  <tr align="center">  
  
                     <td><b>类型</b></td>  
  
                     <td width="50%"><b>标题</b></td>  
  
                     <td><b>发帖人</b></td>  
  
                     <td><b>发帖时间</b></td>
                     
                     <td><b>回复数</b></td>
                     
                     <td><b>浏览次数</b></td>  
                     
                     <td><b>最近回帖人</b></td> 
                     
                     <td><b>最后回复时间</b></td> 
                     <td><b></b></td>    

              </tr> 
              </thead> 
 <%
    //ArrayList<Note> list = new ArrayList<Note>();
    //PageBean<Note> pb = new PageBean<Note>();
    PageBean<Listofnotes> pb = new PageBean<Listofnotes>();
    pb = (PageBean<Listofnotes>)request.getAttribute("pb");
 if(pb == null || pb.getBeanList().size() < 1)  
	  
     out.print("没有数据!");  

else{  
    for (int i = 0; i < pb.getBeanList().size(); i++){
    %>
        
           <tr align="center">  
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getMainnotetype() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getMainnotetitle() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getUsername() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getCreatetime().toString() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getQuotecount() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getViewcount() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getReplynotename() %></a></td>
   <td><a href="/Webbook/details?id=<%= pb.getBeanList().get(i).getMainnoteid() %>"><%= pb.getBeanList().get(i).getMaxcreatetime().toString() %></a></td>
   <td style="display:<%=see%>"><%=link1%><%=pb.getBeanList().get(i).getMainnoteid()%><%=link2%><%=power %><%=link3%></td>
   </tr>  
    <%   
    }
  
    }
   %>
</table><br>
<%@ include file="/tab.jsp"%>
</body>
</html>
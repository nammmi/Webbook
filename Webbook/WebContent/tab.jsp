<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="WebRoot/bootstrap/css/bootstrap.css"/>
<title>Insert title here</title>
</head>
<body><div align="center">
<c:choose>
<c:when test="${ pb.pc eq null or pb.pc eq 1}">last page</c:when>
<c:otherwise><a href="${pb.url}&pc=${pb.pc-1 } " class="btn btn-default">last page</a></c:otherwise>
</c:choose>

<c:choose>
<c:when test="${pb.tp<6 }">
<c:set value="1" var="begin"></c:set>
<c:set value="${pb.tp }" var="end"></c:set>
</c:when>

<c:otherwise>
<c:set value="${pb.pc-2 }" var="begin"></c:set>
<c:set value="${pb.pc+3 }" var="end"></c:set>

<c:if test="${pb.pc<3 }">
<c:set value="1" var="begin"></c:set>
<c:set value="6" var="end"></c:set>
</c:if>

<c:if test="${pb.pc+3>pb.tp}">
<c:set value="${pb.tp-5}" var="begin"></c:set>
<c:set value="${pb.tp }" var="end"></c:set>
</c:if>
</c:otherwise>
</c:choose>

<c:forEach begin="${begin }" end="${end }" var="page">
<c:choose>
<c:when test="${pb.pc eq page }">${page }</c:when>
<c:otherwise><a href="${pb.url }&pc=${page}" class="btn btn-default">${page}</a></c:otherwise>
</c:choose>
</c:forEach>

<c:choose>
<c:when test="${pb.pc eq pb.tp or pb.pc eq null }">next page</c:when>
<c:otherwise><a href="${pb.url }&pc=${pb.pc+1}" class="btn btn-default">next page</a></c:otherwise>
</c:choose>



</div>
</body>
</html>
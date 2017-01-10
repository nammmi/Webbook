<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body><div align="center">
<c:choose>
<c:when test="${ map.pb.pc eq null or map.pb.pc eq 1}">last page</c:when>
<c:otherwise><a href="${map.pb.url}&pc=${map.pb.pc-1 } " class="btn btn-default">last page</a></c:otherwise>
</c:choose>

<c:choose>
<c:when test="${map.pb.tp<6 }">
<c:set value="1" var="begin"></c:set>
<c:set value="${map.pb.tp }" var="end"></c:set>
</c:when>

<c:otherwise>
<c:set value="${map.pb.pc-2 }" var="begin"></c:set>
<c:set value="${map.pb.pc+3 }" var="end"></c:set>

<c:if test="${map.pb.pc<3 }">
<c:set value="1" var="begin"></c:set>
<c:set value="6" var="end"></c:set>
</c:if>

<c:if test="${map.pb.pc+3>map.pb.tp}">
<c:set value="${map.pb.tp-5}" var="begin"></c:set>
<c:set value="${map.pb.tp }" var="end"></c:set>
</c:if>
</c:otherwise>
</c:choose>

<c:forEach begin="${begin }" end="${end }" var="page">
<c:choose>
<c:when test="${map.pb.pc eq page }">${page }</c:when>
<c:otherwise><a href="${map.pb.url }&pc=${page}" class="btn btn-default">${page}</a></c:otherwise>
</c:choose>
</c:forEach>

<c:choose>
<c:when test="${map.pb.pc eq map.pb.tp or map.pb.pc eq null }">next page</c:when>
<c:otherwise><a href="${map.pb.url }&pc=${map.pb.pc+1}" class="btn btn-default">next page</a></c:otherwise>
</c:choose>
</div>



</body>
</html>
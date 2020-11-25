<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user.state le 1}">
    <c:redirect url="index.jsp"/>
</c:if>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<h3 style="color:red">${msg}</h3>
    <table width="700" border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Oper</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.age}</td>
                <td>${u.email}</td>
                <td>${u.gender eq 'F'?'女':'男'}</td>
                <td>
                    <c:if test="${u.state eq 3}">超级管理员</c:if>
                    <c:if test="${u.state eq 0}">
                        <c:url var="url" value="useradmin.do">
                            <c:param name="op" value="rec"/>
                            <c:param name="id" value="${u.id}"/>
                            <c:param name="pno" value="${pg.pageNo}"/>
                            <c:param name="psize" value="${pg.pageSize}"/>
                        </c:url>
                        <button onclick="location='${url}'">恢复</button>
                    </c:if>
                    <c:if test="${u.state eq 1}">
                        <c:if test="${user.state eq 3}">
                            <c:url var="url" value="useradmin.do">
                                <c:param name="op" value="upg"/>
                                <c:param name="id" value="${u.id}"/>
                                <c:param name="pno" value="${pg.pageNo}"/>
                                <c:param name="psize" value="${pg.pageSize}"/>
                            </c:url>
                            <button onclick="location='${url}'">升级</button>
                        </c:if>
                        <c:url var="url" value="useradmin.do">
                            <c:param name="op" value="del"/>
                            <c:param name="id" value="${u.id}"/>
                            <c:param name="pno" value="${pg.pageNo}"/>
                            <c:param name="psize" value="${pg.pageSize}"/>
                        </c:url>
                        <button onclick="location='${url}'">删除</button>
                    </c:if>
                    <c:if test="${u.state eq 2}">
                        <c:if test="${user.state eq 3}" var="rt">
                            <c:url var="url" value="useradmin.do">
                                <c:param name="op" value="deg"/>
                                <c:param name="id" value="${u.id}"/>
                                <c:param name="pno" value="${pg.pageNo}"/>
                                <c:param name="psize" value="${pg.pageSize}"/>
                            </c:url>
                            <button onclick="location='${url}'">降级</button>
                        </c:if>
                        <c:if test="${not rt}">
                            管理员
                        </c:if>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="6">
                <form action="useradmin.do">
                第<select name="pno">
                    <c:forEach var="i" begin="1" end="${pg.pages}">
                        <option value="${i}" ${i eq pg.pageNo?'selected':''}>${i}</option>
                    </c:forEach>
                </select>页/共${pg.pages}页
                每页<input size="3" name="psize" value="${pg.pageSize}">条记录/共${pg.records}条记录
                    <button>GO</button>
                </form>
        </tr>
        </tfoot>
    </table>
</body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/11/19
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>已订阅公众号信息</title>
</head>
<body>
<table width="100%" border="1">
    <thead>
    <th>公众号名称</th>
    <th>功能介绍</th>
    <th>查看</th>
    <th>取关</th>
    </thead>
    <tbody>
    <s:iterator value="userSubList" var="subList">
        <tr>
            <td align="center">
                <s:property value="#subList.getNickname()"/>
            </td>
            <td align="center">
                <s:property value="#subList.getSignature()"/>
            </td>
            <td align="center">
              <s:url action="../puserAction/viewAllEssayAction.action" var="getAllEssay">
                <s:param name="puserId" value="#subList.getId()"></s:param>
            </s:url>
                <s:a href="%{getAllEssay}">查阅</s:a>
            </td>
            <td align="center">
               取关
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>

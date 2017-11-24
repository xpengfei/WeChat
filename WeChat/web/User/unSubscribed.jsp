<%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/11/17
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>未订阅公众号信息</title>
</head>
<body>
        <table width="100%" border="1">
            <thead>
                <th>公众号名称</th>
                <th>功能介绍</th>
                <th>查看</th>
                <th>关注</th>
            </thead>
            <tbody>
                <s:iterator value="userUnSubList" var="unSubList">
                    <tr >
                        <td align="center">
                            <s:property value="#unSubList.getNickname()"/>
                        </td>
                        <td align="center">
                            <s:property value="#unSubList.getSignature()"/>
                        </td>
                        <td align="center">
                           查看
                        </td>
                        <td align="center">
                            关注
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/11/17
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>公众号详情</title>
</head>
<body>
    <!--将该公众号所发布的所有文章显示出来-->
    <form action="" onsubmit="true">
        <table width="100%" border="1">
            <thead>
                <th>文章标题</th>
                <th>阅读量</th>
                <th>查看文章</th>
            </thead>
            <tbody>
            <s:iterator value="essayList" var="essayList">
                <tr>
                    <td align="center">
                        <s:property value="#essayList.getTitle()"/>
                    </td>
                    <td align="center">
                        <s:property value="#essayList.getBrowse()"/>
                    </td>
                    <td align="center">
                        <s:url action="../puserAction/viewEssayAction.action" var="getEssay">
                            <s:param name="essayId" value="#essayList.getId()"></s:param>
                        </s:url>
                        <s:a href="%{getEssay}">查阅</s:a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </form>
</body>
</html>

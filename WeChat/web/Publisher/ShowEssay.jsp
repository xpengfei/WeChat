<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示文章内容</title>
</head>
<body>
    <table width="100%">
        <tr align="center">
            <td>
                ${essayInfo.getTitle()}
            </td>
        </tr>
        <tr>
            <td>
                ${essayInfo.getContent()}
            </td>
        </tr>
        <tr>
            <td align="left">
                阅读${essayInfo.getBrowse()}
            </td>
            <td align="right">
                <a href="../commentAction/add_essay_id.action?essay_id=${essayInfo.getId()}">评论</a>
            </td>
        </tr>
    </table>
</body>
</html>

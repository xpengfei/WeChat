<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/11/23
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
    <form action="../commentAction/addComment" method="post" id="commentForm" name="commentForm"
            onsubmit="return checkContent(this)">
        <table width="100%">
            <tr>
                <td>
                    <textarea name="UserComment" id="UserComment" rows="20" cols="100%"></textarea>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <input hidden id="essay_id" name="essay_id" type="text" value="${essay_id}">
                    <input width="100%" type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
<script>
    function checkContent() {
        //正则表达式形式，特殊字符除外，0-300位
        var reg=/[0-9a-zA-Z,，\u4e00-\u9fa5\w\.]{1,300}/;
        //判断
        if(reg.test(inp.value)){
           return true;
        }else{
            alert("输入内容不合法!(300字以内,特殊符号除外.)");
            return false;
        }
    }
</script>
</html>

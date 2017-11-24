<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/10/12
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑文章</title>
    <style>
        body{
            background-image: url(/image/edit.jpg);
            background-size: cover;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
<form id="editEssay" method="post" action="/puserAction/addEssayAction!add_essay"
      onsubmit="return checkAll(this)">
    <table align="center" width="1000">
        <tr>
            <td align="center" width="800">
                标题:
                <input id="title" name="title" type="text"
                       onblur="check_Title(this)">
            </td>
            <td width="200">
                <span class="error"></span>
            </td>
        </tr>
        <tr>
            <td align="center" width="800">
                <textarea id="content" name="content" rows="16" cols="60" onblur="check_Content(this)"></textarea>
            </td>
            <td width="200">
                <span class="error"></span>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="reset" id="reset" value="清空">
                <input type="submit" id="submit" value="发布">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input id="userId" name="userId" type="hidden" value="${sessionScope.user.id}">
            </td>
        </tr>
    </table>
</form>
<script>
    function check_Title(inp) {
        //正则表达式形式，特殊字符除外，1-10位
        var reg=/[0-9a-zA-Z,，\u4e00-\u9fa5\w\.]{1,10}/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
            console.log(inp.value);
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            console.log(inp.value);
            sp.innerHTML='请输入1-10位标题！';
            sp.style.color="#FF0000";
        }
    }
    function check_Content(inp) {
        //正则表达式形式，特殊字符除外，1-1000位
        var reg=/[0-9a-zA-Z,，\u4e00-\u9fa5\w\.]{1,1000}/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
            console.log(inp.value);
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            console.log(inp.value);
            sp.innerHTML='最多1000字！';
            sp.style.color="#FF0000";
        }
    }
    function checkAll(EditForm) {
        check_Title(EditForm.title);
        check_Content(EditForm.content);
        var spans=document.getElementsByClassName('error');
        for (var i=0;i<spans.length-1;i++){
            if (spans[i].innerHTML!='√'){
                alert("信息输入有误！");
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>

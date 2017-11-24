<%--
  Created by IntelliJ IDEA.
  User: xpengfei
  Date: 2017/9/22
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
    <style>
        body{
            background-image: url(/image/register.jpg);
            background-size: cover;
            background-attachment: fixed;
        }
        #DivregTable{
            position: absolute;
            top: 100px;
            right: 0px;
        }
        textarea{
            resize: none;
        }
    </style>
</head>
<body>
<!--需要将span的宽度固定，不然会跳动,action改为连接数据库的Java后台，进行存储注册信息   -->
<form id="regForm" name="regForm" method="post"
      action="/userAction/registerAction"
      onsubmit="return check_All(this)"
      enctype="multipart/form-data">
    <div id="DivregTable">
        <table id="regTable" name="regTable"
               border="0" align="center" width="900">
            <tr>
                <td width="300" align="right">账号类型：</td>
                <td width="300" align="left">
                    <select name="accountType" id="accountType">
                        <option name="cuser" value="common">普通用户</option>
                        <option name="puser" value="puser">公众号用户</option>
                    </select>
                </td>
                <td width="300"><span class="error"></span></td>
            </tr>
            <tr>
                <td align="right" width="300">昵称:</td>
                <td width="300">
                    <input type="text" name="nickname" id="nickname"
                           onblur="check_nick_name(this)">
                </td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td align="right" width="300">账号:</td>
                <td width="300">
                    <input type="text" name="account" id="account"
                           value="数字、字母组成的账号"
                           style="color: #C9C9C9"
                           onfocus='if (this.value=="数字、字母组成的账号"){this.value=""; this.style.color="#0A0A0A"}'
                           onblur="check_account(this)">
                </td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td width="300" align="right">性别：</td>
                <td width="300" align="left">
                    <select name="sex" id="sex">
                        <option name="man" value="man">男</option>
                        <option name="women" value="women">女</option>
                    </select>
                </td>
                <td width="300"><span class="error"></span></td>
            </tr>
            <tr>
                <td align="right" width="300">密码:</td>
                <td width="300">
                    <input type="password" name="password" id="password"
                           onblur="check_user_password(this)">
                </td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td align="right" width="300">确认密码：</td>
                <td width="300">
                    <input type="password" name="repassword" id="repassword"
                           onblur="check_re_password(this)"></td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td align="right" width="300">手机号:</td>
                <td width="300">
                    <input type="text" name="phone" id="phone"
                           value="请输入11位电话号码"
                           style="color: #C9C9C9"
                           onfocus='if (this.value=="请输入11位电话号码"){this.value=""; this.style.color="#0A0A0A"}'
                           onblur="check_Phone(this)">
                </td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td align="right" width="300">头像:</td>
                <td width="300">
                    <input type="file" name="image" id="image"
                           onblur="check_user_Img(this)">
                </td>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td align="right" width="300">签名：</td>
                <td width="300">
                    <textarea rows="2" cols="20"
                              maxlength="20"
                              name="signature" id="signature" onblur="check_signature(this)"></textarea>
                <td width="300" align="left"><span class='error'></span></td>
            </tr>
            <tr>
                <td width="300" align="left"></td>
                <td align="left" width="300">
                    <input type="submit" name="regist_btn" id="regist_btn" value="注册">
                    <input type="reset" name="reset_btn" id="reset_btn" value="重置">
                </td>
                <td width="300" align="left"></td>
            </tr>
        </table>
    </div>
</form>
<script>
    function check_account(inp) {
        //正则表达式形式，3-16位
        var reg=/^[0-9a-zA-Z,，\.]{3,16}$/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML="3-16位数字、字母组成";
            sp.style.color="#FF0000";
        }
    }
    function check_nick_name(inp) {
        //正则表达式形式，特殊字符除外1-8位
        var reg=/^[\u4e00-\u9fa5\w]{1,8}$/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='字数1-8个！';
            sp.style.color="#FF0000";
        }
    }
    function check_user_Img(inp) {

        //判断
        if(inp.value!=""){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='请选择头像！';
            sp.style.color="#FF0000";
        }
    }
    function check_Phone(inp) {
        //正则表达式形式，要求纯数字且11位，以1开头
        var reg=/^1[0-9]{10}$/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='电话号码格式有误！';
            sp.style.color="#FF0000";
        }

    }
    function check_user_password(inp) {
        //正则表达式形式，6-16位
        var reg=/^[0-9a-zA-Z,，\.]{6,16}$/;
        //判断
        if(reg.test(inp.value)){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML="6-16位数字、字母（允许存在英文 , .）";
            sp.style.color="#FF0000";
        }
    }
    function check_re_password(inp) {
        //判断
        var re_pwd=inp.value;
        var sellerPwd=inp.parentNode.parentNode.parentNode.getElementsByTagName('input')["user_password"].value;
        if(sellerPwd==re_pwd & re_pwd!=''){
            //符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='√';
            sp.style.color="#00EE00";
        }else{
            //不符合输入要求
            var sp=inp.parentNode.parentNode.getElementsByTagName('span')[0];
            sp.innerHTML='两次密码输入不一致！';
            sp.style.color="#FF0000";
        }
    }
    function check_signature(inp) {
        //正则表达式形式，特殊字符除外，0-30位
        var reg=/[0-9a-zA-Z,，\u4e00-\u9fa5\w\.]{1,30}/;
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
            sp.innerHTML='最多30字！';
            sp.style.color="#FF0000";
        }
    }
    function check_All(reg_fm) {
        check_nick_name(reg_fm.nickname);
        check_user_Img(reg_fm.image);
        check_Phone(reg_fm.phone);
        check_user_password(reg_fm.user_password);
        check_re_password(reg_fm.re_user_password);
        check_signature(reg_fm.signature);
        var spans=document.getElementsByClassName('error');
        for(var i=0;i<spans.length-1;i++){
            if (spans[i].innerHTML!='√'){
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>

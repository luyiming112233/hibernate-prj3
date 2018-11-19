<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<s:property value="#request.tip"/>
<table>
    <tr>
        <td>个人信息：<p></td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><s:property value="#request.loginUser.account"/></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><s:property value="#request.loginUser.password"/></td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td><s:property value="#request.loginUser.name"/></td>
    </tr>
    <tr>
        <td>性别：</td>
        <s:if test="%{loginUser.sex==1}">
            <td>男</td>
        </s:if>
        <s:else>
            <td>女</td>
        </s:else>
    </tr>
    <tr>
        <td>生日：</td>
        <td><s:property value="loginUser.birthday"/></td>
    </tr>
    <tr>
        <td>邮箱：</td>
        <td><s:property value="loginUser.email"/></td>
    </tr>
    <s:iterator value="#request.loginUser.addresses" status="st">
    <s:form action="UserdelAddr" method="post">
    <s:hidden name="loginUser.customerId"
              value="%{#request.loginUser.customerId}"/>
    <s:hidden name="address.addressId" value="%{addressId}"/>
    <tr>
        <td>地址<s:property value="#st.count"/>：</td>
    <tr>
    <tr>
        <td>详细地址：</td>
        <td><s:property value="detail"/></td>
    <tr>
    <tr>
        <td>邮政编码：</td>
        <td><s:property value="zipcode"/></td>
    <tr>
    <tr>
        <td>联系电话：</td>
        <td><s:property value="phone"/></td>
    <tr>
    <tr>
        <td>地址类型（office,home,etc.）：</td>
        <td><s:property value="type"/></td>
    <tr>
    <tr>
        <td><s:submit value="删除"/></td>
    <tr>
        </s:form>
        </s:iterator>
</table>
<hr>
添加新地址：<p>
    <s:form action="UseraddAddr" method="post">
        <s:hidden name="loginUser.customerId"
                  value="%{#request.loginUser.customerId}"/>
        <s:textfield name="address.detail" label="详细地址"/>
        <s:textfield name="address.zipcode" label="邮政编码"/>
        <s:textfield name="address.phone" label="联系电话"/>
        <s:textfield name="address.type"
                     label="地址类型（office,home,etc.）"/>
        <s:submit value="添加"/>
    </s:form>
</body>
</html>

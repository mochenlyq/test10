<%@ page import="action.Stu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>查询结果</title>
</head>
<body> <a href="pageAction.action">返回首页</a>
<table border="1" align="center" width="70%">
    <caption>学生ID：<s:property value="#request.stu.id"/></caption>

    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>操作</th>
    </tr>

    <s:iterator value="#request.list" id="course">

        <tr>
            <th><s:property value="#course.courseNo"/></th>
            <th><s:property value="#course.courseName"/></th>
            <th><s:a action="deleteCourse">删除
                <s:param name="courseNo" value="#course.courseNo"/>
                <s:param name="stu.id" value="#request.stu.id"/>
                <s:param name="stu.name" value="#request.stu.name"/>
                <s:param name="stu.sex" value="#request.stu.sex"/></s:a> </th>
<%--            <th><a href="deleteCourse.action?courseNo=<s:property value="#course.courseNo"/>&stu=<s:property value="#request.stu"/>">删除</a></th>--%>
        </tr>
    </s:iterator>
    <center>
        <s:form action="alterStudent" method="POST">输入你想修改的信息
            <s:set name="pageStuId" value="#request.stu.id"/>
            <s:hidden name="stu.id" value="%{pageStuId}"/>
            <s:textfield name="stu.name" label="姓名"/>
            <s:textfield name="stu.sex" label="姓别"/>
            <s:submit value="提交"/>
        </s:form>

        <s:form action="addCourse">
            <font size="4">输入你想添加的课程号</font>
            <s:set name="pageStuId" value="#request.stu.id"/>
            <s:hidden name="stu.id" value="%{pageStuId}"/>
            <s:textfield name="courseNo" label="课程号"/>
            <s:submit label="提交"/>
        </s:form>

    </center>
</table>
</body>
</html>

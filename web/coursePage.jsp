<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<table border="1" align="center" width="70%">
    <caption>学生ID：<s:property value="#request.stuId"></s:property></caption>

    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>操作</th>
    </tr>

    <s:iterator value="#request.list" id="course">

        <tr>
            <th><s:property value="#course.courseNo"/></th>
            <th><s:property value="#course.courseName"/></th>
            <th><a href="deleteCourse.action?courseNo=<s:property value="#course.courseNo"/>&studentId=<s:property value="#request.stuId"/>">删除</a></th>
        </tr>
    </s:iterator>

    <a href="pageAction.action">返回首页</a>

</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

  <head>
    <title>首页</title>
      <script type="text/javascript">

          function validate()
          {
              var page = document.getElementsByName("page")[0].value;
              if(page > <s:property value="#request.pageBean.totalPage"/>)
              {
                  alert("你输入的页数大于最大页数，页面将跳转到首页！");
                  window.document.location.href = "pageAction";
                  return false;
              }
              return true;
          }
      </script>
  </head>

  <body>

  <table border="1" align="center" width="70%">
      <caption>当前页数为&nbsp;&nbsp;&nbsp;<s:property value="#request.pageBean.currentPage"/></caption>

      <tr>
          <th>学号</th>
          <th>姓名</th>
          <th>性别</th>
          <th>查询课程</th>
      </tr>

      <s:iterator value="#request.pageBean.list" id="student">
          <tr>
              <th><s:property value="#student.id"/></th>
              <th><s:property value="#student.name"/></th>
              <th><s:property value="#student.sex"/></th>
              <th><s:a action="selectCourse">查询
                  <s:param name="stu.id" value="#student.id"/>
                  <s:param name="stu.name" value="#student.name"/>
                  <s:param name="stu.sex" value="#student.sex"/></s:a> </th>
<%--              <th><a href="selectCourse.action?studentId=<s:property value="#student.id"/>">查询</a></th>--%>
          </tr>
      </s:iterator>

  </table>

  <center>

      <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
      <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>

      <%-- 如果 当前页数 等于 1 --%>
      <s:if test="#request.pageBean.currentPage == 1">

          首页&nbsp;&nbsp;&nbsp;上一页

      </s:if>
      <s:else>

          <a href="pageAction.action">首页</a>
          &nbsp;&nbsp;&nbsp;
          <a href="pageAction.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>

      </s:else>

      <%-- 如果 前页数 不等于 总页数 --%>
      <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">

          <a href="pageAction.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
          &nbsp;&nbsp;&nbsp;
          <a href="pageAction.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>

      </s:if>
      <s:else>

          下一页&nbsp;&nbsp;&nbsp;尾页

      </s:else>

  </center>

  <br>

  <center>

      <form action="pageAction" onsubmit="return validate();">

          <font size="4">跳转至</font>
          <input type="text" size="2" name="page">页
          <input type="submit" value="跳转">

      </form>

  </center>

  </body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: HuanyuLee
  Date: 2022/4/4
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>Hello World!</h2>
    <p>这是一位美女！！！</p>
    <div>
        <form action="${pageContext.request.contextPath}/request" method="get">    <%--get请求才可以正常跳转--%>
            <input type="submit" value="提交">
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/params">
            <label>
                username: <input type="text" name="username"><br>
                password: <input type="text" name="password"><br><br>
            </label>
            <input type="submit" value="测试params">
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/headers" method="get">
            <input type="submit" value="测试headers">
        </form>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}/rest/1" method="get">
            <input type="submit" value="GET">
        </form>
    </div>

    <img src="static/img/yss0136.jpg" alt="美女">
</body>
</html>

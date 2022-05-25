<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css"  rel="stylesheet">
<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <form  method="post" action="${pageContext.request.contextPath}/emp/emp">
                <div class="form-group">
                    <label>姓名</label>
                    <input name="name" type="text" class="form-control" placeholder="请输入昵称" >
                </div>
                <div class="form-group">
                    <label>性别</label><br/>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="1" >
                        <label class="form-check-label">男</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="0" >
                        <label class="form-check-label">女</label>
                    </div>
                </div>
                <div class="form-group">
                    <label>部门</label>

                    <select class="form-control" name="dept.id">
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.id}">${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" >添加</button>
            </form>
        </main>

    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/jquery-3.2.1.slim.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/popper.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/bootstrap.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css"  rel="stylesheet">

<form  method="post" action="${pageContext.request.contextPath}/emp/edit">
    <div class="form-group">
        <input type="hidden" value="${emp.id}" name="id">
        <input type="hidden" value="put" name="_method">
        <label>姓名</label>
        <input name="name" value="${emp.name}" type="text" class="form-control" placeholder="zhangsan" >
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

        <select class="form-control" name="dept.id" >
            <c:forEach items="${depts}" var="dept">
                <option value="${dept.id}">${dept.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary" >修改</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/jquery-3.2.1.slim.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/popper.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
       var deptId = "${emp.dept.id}";
        $("select[name='dept.id']").val(deptId);

        var gender = "${emp.gender}";
        $("input[name='gender'][value=${emp.gender}]").attr("checked",true);

    })
</script>
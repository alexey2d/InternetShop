<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" body">
<form action="/product/add" method="POST">
  <b>Title:</b><br><input type="text" name="title" size="50" value=""><br>
  <b>Description:</b><br><input type="text" name="description" size="200" value=""><br>
  <%--<b>Price:</b><br><input type="" size="10"><br>--%>
  <input type="submit" class="btnBody" value="add" >
</form>
</div>
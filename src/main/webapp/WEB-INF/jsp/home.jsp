<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>



<br>
<br>
<br>
<br>



    <div class="container mt-3">
<div class="row">

</div>

<div class="row">

</div>

</div>
<table class="table table-bordered table-hover table-striped">
	<div class="row">
	<tbody>
		<c:forEach items="${tech}" var="item">
			<tr>
				<td>
					<a href="<spring:url value="/language/${sessionScope.lang}/common-issues/${item}.html" />"
                                    class="fa fa-trash-o" style="font-size:32px;color:red">item</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ include file="../layout/taglib.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css">
<link href="/resources/css/jquery/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<link href="/resources/css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/fontawesome.min.css" type="text/css">
<link href="/resources/css/jquery/sidebar.css" rel="stylesheet" type="text/css">
<script src="/resources/js/jquery/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap/bootstrap.bundle.min.js"></script>
<script src="/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="/resources/js/bootstrap/bootstrap-4-navbar.js"></script>
<script src="/resources/js/jquery/jquery-ui.js"></script>
<tilesx:useAttribute name="current" />
<!--    <link href="/resources/css/css5/magnific-popup.css" rel="stylesheet">
	<link href="/resources/css/css5/creative.min.css" rel="stylesheet"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="/language/${sessionScope.lang}/home.html">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarNavDropdown" class="navbar-collapse collapse">
                <ul class="navbar-nav mr-auto">
                    <c:forEach items="${sessionScope.navBars}" var="navBar">
                    <c:if test="${navBar.type eq 'single'}">
                        <li class="nav-item"><a class="nav-link" href="<spring:url value="/language/${sessionScope.lang}/common-issues/${navBar.FLevel}.html" />">${navBar.FLevel}</a></li>
                    </c:if>
                    
                    <c:if test="${navBar.type eq 'multi'}">
                   
                   <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="${navBar.FLevel}" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false"
                        > ${navBar.FLevel} </a>
                        <div class="dropdown-menu" aria-labelledby="${navBar.FLevel}">
                         <c:forEach items="${navBar.SLevel}" var="s">
                         <a class="dropdown-item" href="#">${s}</a>
                         </c:forEach>
                            
                        </div></li>
                   
                    </c:if>
                    
                    </c:forEach>

                    <li class="nav-item ${current == 'admin' ? 'active' : ''}"><a class="nav-link" href="<spring:url value="/language/${sessionScope.lang}/admin.html" />">admin</a></li>
                </ul>
            </div>
        </nav>
        
        <!-- Fixed navbar 
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link  ${current == 'nutritionSearch' ? 'active' : ''}" href="<spring:url value="/language/en/nutritionSearch.html" />"><spring:message code="label.nutritionSearch"/></a></li>
            <li class="nav-item"><a class="nav-link  ${current == 'bmiCalculator' ? 'active' : ''}" href="<spring:url value="/language/en/bmiCalculator.html" />"><spring:message code="label.bmi"/></a></li>
            <li class="nav-item"><a class="nav-link" href="<spring:url value="/language/en/calorieBurnCalculator.html" />"><spring:message code="label.calorieBurner"/></a></li>
            <li class="nav-item ${current == 'easternMedicines' ? 'active' : ''}"><a class="nav-link" href="<spring:url value="/language/en/easternMedicines.html" />"><spring:message code="label.naturopathicMedicine"/></a></li>
          </ul>
          
         
      </nav> -->
    </header>
    <tiles:insertAttribute name="body" />
    <center>
        <tiles:insertAttribute name="footer" />
    </center>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
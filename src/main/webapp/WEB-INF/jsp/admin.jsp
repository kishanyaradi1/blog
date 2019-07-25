<%@ include file="../layout/taglib.jsp"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>
<br>
<br>
<div class="container-fluid">
    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>
                    <spring:message code="label.startSearch" />
                </h3>
            </div>
            <ul class="list-unstyled components">
                <li class="active"><a href="<spring:url value="/language/${sessionScope.lang}/admin/create-blog.html"/>">Create Blog</a></li>
                <li class="active"><a href="<spring:url value="/language/${sessionScope.lang}/admin/edit-blog.html"/>">Edit Blog</a></li>
                <li class="active"><a href="<spring:url value="/language/${sessionScope.lang}/admin/add-navigation.html"/>">Add Navigation</a></li>
            </ul>
        </nav>
        <!-- Page Content Holder -->
        <div class="col-lg-10">
            <div id="content">
                <nav class="navbar navbar-default col-sm-4">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                                <i class="glyphicon glyphicon-align-left"></i> <span>Toggle Search</span>
                            </button>
                        </div>
                    </div>
                </nav>
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <c:choose>
                            <c:when test="${selectedTab=='create'}">
                                <jsp:include page="adminCreate.jsp" />
                            </c:when>
                            <c:when test="${selectedTab=='edit'}">
                                <jsp:include page="adminEdit.jsp" />
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
             $(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                 });
             });
         </script>
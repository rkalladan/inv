<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 	<sec:authorize access="hasRole('admin')" />
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<c:set var="adminName" value="${pageContext.request.userPrincipal.name}"/>
 
	<!-- csrt for log out -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
 
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
				Welcome : ${adminName} |
				<a href="javascript:formSubmit()" > Logout</a>
		</h2>
	</c:if>
 
			
</body>
</html>
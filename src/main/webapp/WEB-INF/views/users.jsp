<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<section class="login-page">
    <ul class="help--slides-items">

        <c:forEach  var="user" items="${users}" varStatus="theCount">
            <c:if test="${theCount.index%2==0}">
                <li>
            </c:if>

            <div class="col">
                <div class="title">Imię: ${user.name}</div>
                <div class="title">Nazwisko: ${user.surname}</div>
                <div class="title">Email: ${user.email}</div>
                <div class="subtitle"><a href="/deleteusers/${user.id}" class="btn btn--without-border active">Usuń</a></div>
                <div class="subtitle"><a href="/edituser/${user.id}" class="btn btn--without-border active">Edytuj</a></div>
                <div class="subtitle"><a href="/deactive/${user.id}" class="btn btn--without-border active">Dezaktywuj konto</a></div>
            </div>
            <c:if test="${theCount.index%2==1}">
                </li>
            </c:if>

        </c:forEach>
    </ul>
</section>

<%@ include file="footer.jsp" %>
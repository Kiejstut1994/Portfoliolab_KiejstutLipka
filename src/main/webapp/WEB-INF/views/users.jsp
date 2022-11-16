<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <ul class="help--slides-items">

        <c:forEach  var="user" items="${users}" varStatus="theCount">
            <c:if test="${theCount.index%2==0}">
                <li>
            </c:if>

            <div class="col">
                <div class="title">Imię: ${user.name}</div>
                <div class="title">Nazwisko: ${user.surname}</div>
                <div class="title">Email: ${user.username}</div>
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
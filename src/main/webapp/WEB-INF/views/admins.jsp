<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <ul class="help--slides-items">

        <c:forEach  var="admin" items="${admins}" varStatus="theCount">
            <c:if test="${theCount.index%2==0}">
                <li>
            </c:if>

            <div class="col">
                <div class="title">Imię: ${admin.name}</div>
                <div class="title">Nazwisko: ${admin.surname}</div>
                <div class="title">Email: ${admin.username}</div>
                <div class="subtitle"><a href="/edituser/${admin.id}" class="btn btn--without-border active">Edytuj</a></div>
                <c:if test="${myid!=admin.id}">
                <div class="subtitle"><a href="/deleteusers/${admin.id}" class="btn btn--without-border active">Usuń</a></div>
                <div class="subtitle"><a href="/deactive/${admin.id}" class="btn btn--without-border active">Dezaktywuj konto</a></div>
                </c:if>
            </div>
            <c:if test="${theCount.index%2==1}">
                </li>
            </c:if>

        </c:forEach>
    </ul>
</section>

<%@ include file="footer.jsp" %>
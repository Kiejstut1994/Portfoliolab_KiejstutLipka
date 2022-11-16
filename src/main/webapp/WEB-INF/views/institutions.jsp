<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header class="header--main-page" >
    <%@ include file="main.jsp" %>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>

<section class="login-page">
    <ul class="help--slides-items">

        <c:forEach  var="institution" items="${institutions}" varStatus="theCount">
            <c:if test="${theCount.index%2==0}">
                <li>
            </c:if>

            <div class="col">
                <div class="title">${institution.name}</div>
                <div class="subtitle">Cel i misja: ${institution.description}</div>
                <div class="subtitle"><a href="/deleteinstitutions/${institution.id}" class="btn btn--without-border active">Usuń</a></div>
                <div class="subtitle"><a href="/editinstitutions/${institution.id}" class="btn btn--without-border active">Edytuj</a></div>
            </div>
            <c:if test="${theCount.index%2==1}">
                </li>
            </c:if>

        </c:forEach>
    </ul>
</section>

<%@ include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="text" name="name" placeholder="Imię" path="name"/>
            <form:errors path="name" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="surname" placeholder="Nazwisko" path="surname" />
            <form:errors path="surname" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <form:input type="email" name="username" placeholder="Podaj email" path="username"/>
            <form:errors path="username" cssClass="errorclass"/>
            <c:if test="${emailrepeat==1}">
                <span cssClass="errorclass">Osoba o takim emailu już istnieje</span>
            </c:if>
        </div>
        <div class="form-group">
            <form:input type="password" name="password" placeholder="Hasło" path="password"/>
            <form:errors path="password" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>
        <c:if test="${notrepeat==1}">
            <span cssClass="errorclass">Hasła nie są takie same</span>
        </c:if>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Wprowadź nowe dane</h2>
    <form:form action="/edituser" method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="text" name="name" placeholder="Imię" path="name"/>
            <form:errors path="name" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="surname" placeholder="Nazwisko" path="surname" />
            <form:errors path="surname" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <form:input type="email" name="email" placeholder="Podaj email" path="email"/>
            <form:errors path="email" cssClass="errorclass"/>
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
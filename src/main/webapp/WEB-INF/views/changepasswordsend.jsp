<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <h2>Podaj nowe hasło</h2>
    <form method="post" action="/changepasswordsend">

        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>
        <c:if test="${nosamepassword==1}">
            <h3>Hasła muszą być takie same</h3>
        </c:if>
        </br>
        <c:if test="${tooshort==1}">
            <h3>Hasło musi mieć conajmniej 8 znaków</h3>
        </c:if>
        </br>
        <c:if test="${nonumbers==1}">
            <h3>Hasło musi mieć conajmniej 1 cyfrę</h3>
        </c:if>
        </br>
        <c:if test="${nolowletters==1}">
            <h3>Hasło musi mieć conajmniej 1 literę małą</h3>
        </c:if>
        </br>
        <c:if test="${nobigletters==1}">
            <h3>Hasło musi mieć conajmniej 1 literę dużą</h3>
        </c:if>


        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zmień hasło</button>
        </div>
    </form>
</section>
<%@ include file="footer.jsp" %>
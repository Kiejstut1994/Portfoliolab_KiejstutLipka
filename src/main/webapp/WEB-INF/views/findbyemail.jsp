<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <h2>Podaj maila na którego ma zostać wysłane hasło zresetowane</h2>
    <form method="post" action="/findbyemail">
        <div class="form-group">
            <input type="email" name="username" placeholder="Email" />
            <c:if test="${nouser==1}">
                <h3>Nie ma użytkownika o takim mailu</h3>
            </c:if>
        </div>
        <div class="form-group form-group--buttons">
                   <button class="btn" type="submit">Wyślij maila resetującego hasło</button>
        </div>
    </form>
</section>
<%@ include file="footer.jsp" %>
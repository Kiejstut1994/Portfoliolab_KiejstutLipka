<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>
<section class="login-page">
    <h2>Moje dane</h2>

        <div class="form-group">
            Imię: ${user.name}
        </div>
        <div class="form-group">
            Nazwisko: ${user.surname}
        </div>
    <div class="form-group">
       Email ${user.username}
    </div>

</section>

<%@ include file="footer.jsp" %>
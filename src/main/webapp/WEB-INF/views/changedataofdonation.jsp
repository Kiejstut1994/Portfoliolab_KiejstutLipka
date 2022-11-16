<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>
<section class="login-page">
    <h2>Zmień dane</h2>
    <form method="post" action="/changedataofdonation">
        <div class="form-group">
            Data odebrania <input  type="date" name="pickUpDate"  placeholder="Data wprowadzenia" required>
        </div>
        <div class="form-group">
            Godzina odebrania <input  type="time" name="pickUpTime" placeholder="Czas wprowadzenia"  required>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wprowadź dane</button>
        </div>
    </form>
</section>

<%@ include file="footer.jsp" %>
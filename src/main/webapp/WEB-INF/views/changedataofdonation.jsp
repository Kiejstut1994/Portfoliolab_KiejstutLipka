<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Zmień dane</h2>
    <form method="post" action="/changedataofdonation">
        <div class="form-group">
            Data odebrania <input  type="date" name="pickUpDate" pattern = "yyyy-MM-dd" placeholder="Data wprowadzenia" required>
        </div>
        <div class="form-group">
            Godzina odebrania <input  type="time" pattern = "HH:mm" name="pickUpTime" placeholder="Czas wprowadzenia"  required>
        </div>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wprowadź dane</button>
        </div>
    </form>
</section>

<%@ include file="footer.jsp" %>
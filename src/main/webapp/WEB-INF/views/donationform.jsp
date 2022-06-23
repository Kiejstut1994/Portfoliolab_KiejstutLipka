<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Wprowadź donację</h2>
    <form:form action="/donationform" method="post" modelAttribute="donation">
        <div class="form-group">
            <form:input type="number" name="quantity" placeholder="Liczba worków"  path="quantity"/>
            <form:errors path="quantity"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="street" placeholder="Ulica"  path="street"/>
            <form:errors path="street"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="city" placeholder="Miasto"  path="city"/>
            <form:errors path="city"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="zipCode" placeholder="Kod Zip"  path="zipCode"/>
            <form:errors path="zipCode"/>
        </div>
        <div class="form-group">
            <form:input type="date" name="pickUpDate" placeholder="Data wprowadzenia"  path="pickUpDate"/>
            <form:errors path="pickUpDate"/>
        </div>
        <div class="form-group">
            <form:input type="time" name="pickUpTime" placeholder="Czas wprowadzenia"  path="pickUpTime"/>
            <form:errors path="pickUpTime"/>
        </div>
        <div class="form-group">
            <form:input type="text" name="pickUpComment" placeholder="Komentarz"  path="pickUpComment"/>
            <form:errors path="pickUpComment"/>
        </div>
        <div class="form-group">
            <form:checkboxes type="checkbox" path="categories" items="${categories}" var="category"/>
            <c:forEach  var="category" items="${categories}" >
            <form:checkbox type="checkbox" name="type" value="${category.name}" path="${category.name}"/>
            </c:forEach>
        </div>
        <div class="form-group">
            <form:select type="select" name="instution" path="institution" items="${institutions}" var="institution"/>
            <c:forEach  var="institution" items="${institutions}" >
                <form:option value="${institution}">"${institution.name}"</form:option>
            </c:forEach>
        </div>
        <div class="form-group form-group--buttons">
<%--            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>--%>
            <button class="btn" type="submit">Wprowadź</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>





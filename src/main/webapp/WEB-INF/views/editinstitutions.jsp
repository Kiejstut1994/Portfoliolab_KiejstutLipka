<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Wprowadź dane o instytucji</h2>

    <form:form action="/editinstitutions" method="post" modelAttribute="institution">
        <div class="form-group">
            <form:input type="name" name="name" placeholder="Nazwa"  path="name"/>
            <form:errors path="name" cssClass="errorclass"/>
        </div>
        <div class="form-group">
            <form:input type="description" name="description" placeholder="Opis"  path="description"/>
            <form:errors path="description" cssClass="errorclass"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wprowadź dane</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

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
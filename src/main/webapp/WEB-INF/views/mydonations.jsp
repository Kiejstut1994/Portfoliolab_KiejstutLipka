<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>

<section class="login-page">
    <ul class="help--slides-items">
        <div class="title">Moje donacje:</div>
        <c:forEach  var="mydonation" items="${mydonations}" >

                <li>
                    <div class="col">
                <div class="title">${mydonation.id}</div>
                        <div class="subtitle">Miasto: ${mydonation.city}</div>
                        <div class="subtitle">Telefon: ${mydonation.phone}</div>
                        <div class="subtitle">Dzień odebrania: ${mydonation.pickUpDate}</div>
                        <div class="subtitle">Godzina odebrania: ${mydonation.pickUpTime}</div>
                        <div class="subtitle">Ilość worków: ${mydonation.quantity}</div>
                        <div class="subtitle">Ulica ${mydonation.street}</div>
                        <div class="subtitle">Kod pocztowy ${mydonation.zipCode}</div>
                        <div class="subtitle">Instytucja odbierająca: ${mydonation.institution.name}</div>
                        <c:forEach items="${mydonation.categories}" var="category">
                            <div class="subtitle">Kategorie: ${category.name}</div>
                        </c:forEach>
            </div>
                </li>
        </c:forEach>
    </ul>
    <ul class="help--slides-items">
        <div class="title">Moje donacje które już zostały odebrane:</div>
        <c:forEach  var="mypiceddonation" items="${mypiceddonations}" >

            <li>
                <div class="col">
                    <div class="title">${mypiceddonation.id}</div>
                    <div class="subtitle">Miasto: ${mypiceddonation.city}</div>
                    <div class="subtitle">Telefon: ${mypiceddonation.phone}</div>
                    <div class="subtitle">Dzień odebrania: ${mypiceddonation.pickUpDate}</div>
                    <div class="subtitle">Godzina odebrania: ${mypiceddonation.pickUpTime}</div>
                    <div class="subtitle">Ilość worków: ${mypiceddonation.quantity}</div>
                    <div class="subtitle">Ulica ${mypiceddonation.street}</div>
                    <div class="subtitle">Kod pocztowy ${mypiceddonation.zipCode}</div>
                    <div class="subtitle">Instytucja odbierająca: ${mypiceddonation.institution.name}</div>
                    <c:forEach items="${mypiceddonation.categories}" var="category">
                        <div class="subtitle">Kategorie: ${category.name}</div>
                    </c:forEach>
                </div>
            </li>
        </c:forEach>
    </ul>
    <ul class="help--slides-items">
        <div class="title">Moje donacje które nie zostały odebrane:</div>
        <c:forEach  var="mynotpickeddonation" items="${mynotpickeddonations}" >

            <li>
                <div class="col">
                    <div class="title">${mynotpickeddonation.id}</div>
                    <div class="subtitle">Miasto: ${mynotpickeddonation.city}</div>
                    <div class="subtitle">Telefon: ${mynotpickeddonation.phone}</div>
                    <div class="subtitle">Dzień odebrania: ${mynotpickeddonation.pickUpDate}</div>
                    <div class="subtitle">Godzina odebrania: ${mynotpickeddonation.pickUpTime}</div>
                    <div class="subtitle">Ilość worków: ${mynotpickeddonation.quantity}</div>
                    <div class="subtitle">Ulica ${mynotpickeddonation.street}</div>
                    <div class="subtitle">Kod pocztowy ${mynotpickeddonation.zipCode}</div>
                    <div class="subtitle">Instytucja odbierająca: ${mynotpickeddonation.institution.name}</div>
                    <c:forEach items="${mynotpickeddonation.categories}" var="category">
                        <div class="subtitle">Kategorie: ${category.name}</div>
                    </c:forEach>
                    <div class="subtitle"><a href="/changedataofdonation/${mynotpickeddonation.id}">Ustal datę odbioru</a></div>
                </div>
            </li>
        </c:forEach>
    </ul>



</section>

<%@ include file="footer.jsp" %>
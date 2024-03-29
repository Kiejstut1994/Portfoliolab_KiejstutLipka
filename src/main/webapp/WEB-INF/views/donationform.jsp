<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="headernew.jsp" %>
<header>
    <%@ include file="main.jsp" %>
</header>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/donationform" method="post" modelAttribute="donation" >
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox cssClass="category" title="${category.name}" path="categories"
                                       value="${category.id}" />
                        <span class="checkbox"></span>
                        <span class="description"
                        >${category.name}</span
                        >
                    </label>
                </div>
                </c:forEach>
                <form:errors path="categories" cssClass="errorclass"/>


                <div class="form-group form-group--buttons">
                    <button type="button"  class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input id="quantity"  type="number" name="quantity" placeholder="Liczba worków" step="1" path="quantity"/>
                        <form:errors path="quantity" cssClass="errorclass"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button"  class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
<%--                <form:select path="institution" items="${institutions}"/>--%>
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton cssClass="institution" title="${institution.name}" value="${institution.id}" path="institution"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">"${institution.name}"</div>
                  <div class="subtitle">
                    Cel i misja: "${institution.description}"
                  </div>
                </span>
                    </label>
                </div>
                </c:forEach>
                    <form:errors path="institution" cssClass="errorclass"/>



                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button"  class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input id="street" type="text" name="street" placeholder="Ulica"  path="street"/>
                                <form:errors path="street" cssClass="errorclass"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input id="city" type="text" name="city" placeholder="Miasto"  path="city"/>
                                <form:errors path="city" cssClass="errorclass"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input id="zipcod" type="text" name="zipCode" placeholder="Kod Pocztowy"  path="zipCode"/>
                                <form:errors path="zipCode" cssClass="errorclass"/>
                            </label>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input id="phone" type="number" step="1" name="phone" placeholder="Telefon"  path="phone"/>
                                <form:errors path="phone" cssClass="errorclass"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input id="date" type="date" name="pickUpDate" placeholder="Data wprowadzenia"  path="pickUpDate"/>
                                <form:errors path="pickUpDate" cssClass="errorclass"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input id="time" type="time" name="pickUpTime" placeholder="Czas wprowadzenia"  path="pickUpTime"/>
                                <form:errors path="pickUpTime" cssClass="errorclass"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea id="pickUpComment"  name="pickUpComment" placeholder="Komentarz"  path="pickUpComment" rows="5"></form:textarea>
                                <form:errors path="pickUpComment" cssClass="errorclass"/>
                            </label>


                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" id="wyniki" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="worki"
                                ></span
                                >
<%--                                <span class="icon icon-bag"></span>--%>
<%--                                <span class="summary--text"--%>
<%--                                >4 worki ubrań w dobrym stanie dla dzieci</span--%>
<%--                                >--%>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span id="instytucja" class="summary--text"
                                ></span
                                >
<%--                                <span class="icon icon-hand"></span>--%>
<%--                                <span class="summary--text"--%>
<%--                                >Dla fundacji "Mam marzenie" w Warszawie</span--%>
<%--                                >--%>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul id="adress">
<%--                                <li id="adres"></li>--%>
<%--                                <li id="miasto"></li>--%>
<%--                                <li id="kodpocz"></li>--%>
<%--                                <li id="telefon"></li>--%>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul id="termin">
<%--                                <li id="data"></li>--%>
<%--                                <li id="godzina"></li>--%>
<%--                                <li id="koment"></li>--%>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@ include file="footer.jsp" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="container container--70">
  <sec:authorize access="!isAuthenticated()">
    <ul class="nav--actions">
      <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
      <li><a href="/register/1" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <ul class="nav--actions">
      <li class="logged-user">
        Witaj <sec:authentication property="name"/>
        <ul class="dropdown">
          <li><a href="/profile">Profil</a></li>
          <li><a href="/institutions">Instytucje</a></li>
          <li><a href="/mydonations">Moje zbiórki</a></li>
          <sec:authorize access="hasAuthority('ADMIN')">
          <li><a href="/institutionform" class="btn btn--without-border">Dodaj fundacje i organizacje</a></li>
            <li><a href="/register/2" class="btn btn--without-border">Załóż konto dla administratora</a></li>
          <li><a href="/users" class="btn btn--without-border">Użytkownicy</a></li>
            <li><a href="/admins" class="btn btn--without-border">Administratorzy</a></li>
          </sec:authorize>
          <li><a href="/logout">Wyloguj</a></li>
        </ul>
      </li>
    </ul>
  </sec:authorize>

  <ul>
    <li><a href="/" class="btn btn--without-border active">Start</a></li>
    <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
    <li><a href="/#aboutus" class="btn btn--without-border">O nas</a></li>
    <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
<sec:authorize access="hasAuthority('USER')">
    <li><a href="/donationform" class="btn btn--without-border">Przekaż dary</a></li>
</sec:authorize>
    <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
  </ul>
</nav>

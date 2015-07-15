<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/registration.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<form action="hello">
    <input type="submit">
</form>

<form name="registration" action="/authorization">
    <table>
        <tr>
            <td colspan="2"><spring:message code="messages.welcomeToApplication" />  </td>
        </tr>
        <tr>
            <td>
                <spring:message code="messages.login"/>
            </td>
            <td>
                <input id="login" type="text">
            </td>
        </tr>

        <tr>
            <td>
                <spring:message code="messages.password"/>
            </td>
            <td>
                <input id="password" type="text">
            </td>
        </tr>

        <tr>
            <td>
                <spring:message code="messages.lang"/>
            </td>
            <td>
                <select id="language">
                    <option value="EN">English</option>
                    <option value="RU">Russian</option>
                    <option value="DE">Deutch</option>
                    <option value="empty"></option>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                <spring:message code="messages.remember"/>
            </td>
            <td>
                <input type="checkbox" id="remember">
            </td>
        </tr>

        <tr>
            <td colspan="2"><input id="sendButton" type="button" value= <spring:message code="messages.login"/>></td>
        </tr>

    </table>
</form>

<spring:message code="messages.welcomeToApplication"/>
<spring:message code="messages.welcome"/>
</body>
</html>
